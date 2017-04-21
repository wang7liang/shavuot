package com.ws.shavuot.common.entity;

/**
 * Created by chenqian on 2016/5/18.
 */
public class ReturnMessage {
    private boolean isSuccess;
    private Object content;
    private String errorCode;
    private String errorMsg;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ReturnMessage() {
    }

    public ReturnMessage(Object content) {
        this.isSuccess = true;
        this.content = content;
    }

    public ReturnMessage(boolean isSuccess, String content) {
        this.isSuccess = isSuccess;
        this.content = content;
    }

    public ReturnMessage(String errorCode, String errorMsg) {
        this.isSuccess = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(boolean isSuccess) {
        isSuccess = isSuccess;
    }


    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReturnMessage{" +
                "isSuccess=" + isSuccess +
                ", content='" + content + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}