package com.ws.shavuot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {

    private static final long serialVersionUID = 6624726180748515507L;

    /**
     *
     */
    private String username;

    /**
     *
     */
    private String password;



}
