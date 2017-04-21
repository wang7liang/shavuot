package com.ws.shavuot.controller;

import com.ws.shavuot.common.entity.ReturnMessage;
import com.ws.shavuot.common.utils.ResponseUtils;
import com.ws.shavuot.model.security.AuthenticationRequest;
import com.ws.shavuot.model.security.AuthenticationResponse;
import com.ws.shavuot.model.security.ItslawUser;
import com.ws.shavuot.security.TokenUtils;
import com.ws.shavuot.security.auth.LoginUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("${itslaw.route.authentication}")
public class AuthenticationController {

  @Value("${itslaw.token.header}")
  private String tokenHeader;

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenUtils tokenUtils;

  @Autowired
  private LoginUserDetailsService userDetailsService;


  @RequestMapping(method = RequestMethod.POST)
  public ResponseEntity<?> authenticationRequest(@RequestBody AuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

    // Perform the authentication
    Authentication authentication = this.authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(
        authenticationRequest.getUsername(),
        authenticationRequest.getPassword()
      )
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);

    // Reload password post-authentication so we can generate token
    // For sso
    ItslawUser userDetails = (ItslawUser)authentication.getPrincipal();
    String token = this.tokenUtils.generateToken(userDetails, device);
        // Return the token
    return ResponseUtils.OK(new ReturnMessage(new AuthenticationResponse(token,
            userDetails.getUserId(),
            userDetails.getIdentifier(),
            userDetails.getPersistenceId())));
  }

  @RequestMapping(value = "${itslaw.route.authentication.refresh}", method = RequestMethod.GET)
  public ResponseEntity<?> authenticationRequest(HttpServletRequest request) {
    Cookie[] cookies = request.getCookies();
    String userId = "";
    String identifier = "";
    String persistenceId = "";
    if(cookies != null)
    {
      for (int i = 0; i < cookies.length; i++)
      {
        Cookie c = cookies[i];
        if(c.getName().equalsIgnoreCase("userId"))
        {
          userId = c.getValue();
        }
        else if(c.getName().equalsIgnoreCase("identifier"))
        {
          identifier = c.getValue();
        }
        else if(c.getName().equalsIgnoreCase("persistenceId"))
        {
          persistenceId = c.getValue();
        }
      }
    }
    String token = request.getHeader(this.tokenHeader);
    String username = this.tokenUtils.getUsernameFromToken(token);
    ItslawUser user = (ItslawUser) this.userDetailsService.loadUserByUsername(username);
    if (this.tokenUtils.canTokenBeRefreshed(token, user.getLastPasswordReset())) {
      String refreshedToken = this.tokenUtils.refreshToken(token);
      return ResponseUtils.OK(new ReturnMessage(new AuthenticationResponse(
              refreshedToken,
              userId,
              identifier,
              persistenceId)));
    } else {
      return ResponseUtils.ERROR(null, HttpStatus.BAD_REQUEST);
    }
  }

}
