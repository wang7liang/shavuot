package com.ws.shavuot.common.exception;

import com.ws.shavuot.common.entity.ReturnMessage;
import com.ws.shavuot.common.utils.ResponseUtils;
import com.ws.shavuot.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Locale;

/**
 * 全局异常处理
 * Created by FranklinD on 2016/3/27.
 */
@ControllerAdvice
public class GlobalExceptionHandler{
    /**
     * slf4j日志记录器
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private MessageSource messageSource;

    @Autowired
    public GlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity<ReturnMessage> processValidationError(MethodArgumentNotValidException ex) {

        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();

        return ResponseUtils.ERROR(new ReturnMessage(false,fieldErrors.get(0).getDefaultMessage()), HttpStatus.BAD_REQUEST);
    }


    private String resolveLocalizedErrorMessage(FieldError fieldError) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String localizedErrorMessage = messageSource.getMessage(fieldError, currentLocale);

        //If a message was not found, return the most accurate field error code instead.
        //You can remove this check if you prefer to get the default error message.
//        if (localizedErrorMessage.equals(fieldError.getDefaultMessage())) {
//            String[] fieldErrorCodes = fieldError.getCodes();
//            localizedErrorMessage = fieldErrorCodes[0];
//        }

        return localizedErrorMessage;
    }

    /**
     * 业务性异常统一处理
     * @param e
     * @return
     */
    @ExceptionHandler(ProcessorException.class)
    @ResponseBody
    public ResponseEntity<ReturnMessage> processExceptionHandle(ProcessorException e){
        LOGGER.info(e.getMessage(), e);
        Integer statusCode = e.getStatusCode();
        if(statusCode != null){
            String message = StringUtils.isEmpty(e.getStatusMsg()) ? ExceptionStatus.getTitle(e.getStatusCode()) : e.getStatusMsg();
            if(e.getStatusCode() == ExceptionStatus.EX_2002.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_1003.getIndex()){
                return ResponseUtils.ERROR( new ReturnMessage(false, message), HttpStatus.FORBIDDEN);
            }
            if(e.getStatusCode() == ExceptionStatus.EX_1001.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_1002.getIndex()){
                return ResponseUtils.ERROR( new ReturnMessage(false, message), HttpStatus.BAD_REQUEST);
            }
//            if(e.getStatusCode() == ExceptionStatus.EX_1004.getIndex()){
//                return ResponseUtils.ERROR( new ReturnMessage(false, message), HttpStatus.NOT_FOUND);
//            }
            if(e.getStatusCode() == ExceptionStatus.EX_3001.getIndex()){
                return ResponseUtils.ERROR( new ReturnMessage(false, message), HttpStatus.PAYLOAD_TOO_LARGE);
            }
            //应用服务器内部异常
            if(e.getStatusCode() == ExceptionStatus.EX_2001.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_1009.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_1010.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_1011.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_3002.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_3003.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_3004.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_3005.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_3006.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_3007.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_3008.getIndex()){
                return ResponseUtils.ERROR( new ReturnMessage(false, message), HttpStatus.INTERNAL_SERVER_ERROR);
            }
            if(e.getStatusCode() == ExceptionStatus.EX_2004.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_2005.getIndex()
                    ||e.getStatusCode() == ExceptionStatus.EX_2006.getIndex()){
                return ResponseUtils.ERROR( new ReturnMessage(false, message), HttpStatus.SERVICE_UNAVAILABLE);
            }
        }
        return exceptionHandle(e);
    }
    /**
     * 参数不正确，无法自动转换
     * @param e
     * @return
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity<String> httpMessageNotReadableExceptionHandle(HttpMessageNotReadableException e){
        return ResponseUtils.ERROR(new ReturnMessage(false, "请求参数异常"), HttpStatus.BAD_REQUEST);
    }

    /**
     * 请求头参数异常
     * @param e
     * @return
     */
    @ExceptionHandler(ServletRequestBindingException.class)
    @ResponseBody
    public ResponseEntity<String> servletRequestBindingExceptionHandler(ServletRequestBindingException e){
        return ResponseUtils.ERROR(new ReturnMessage(false, "请求head参数异常"), HttpStatus.BAD_REQUEST);
    }
//
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    @RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseBody
//    public ResponseEntity<String> httpRequestMethodNotSupportedExceptionHandle(HttpRequestMethodNotSupportedException e){
//        return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
//    }


    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    @ResponseBody
    public ResponseEntity<String> httpMediaTypeNotSupportedExceptionHandle(HttpMediaTypeNotSupportedException e){
        return ResponseUtils.ERROR(new ReturnMessage(false, "请求方法的MediaType不支持"), HttpStatus.UNSUPPORTED_MEDIA_TYPE);
    }
    /**
     * 未经捕获的Exception处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<ReturnMessage> exceptionHandle(Exception e){
        return ResponseUtils.ERROR(new ReturnMessage(false,"系统异常,请联系管理员!"), HttpStatus.SERVICE_UNAVAILABLE);
    }
}
