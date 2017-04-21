package com.ws.shavuot.common.exception;

import java.io.Serializable;

/**
 * Created by wghxynn on 16/4/20.
 */
public class ExceptionDTO implements Serializable {
    private Integer code;
    private String message;

    public ExceptionDTO(Integer statusCode, String statusMsg) {
        this.code = statusCode;
        this.message = statusMsg;
    }
    public ExceptionDTO(ExceptionStatus exceptionStatus) {
        this.code = exceptionStatus.getIndex();
        this.message = exceptionStatus.getTitle();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ExceptionDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
