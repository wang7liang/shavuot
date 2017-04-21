package com.ws.shavuot.common.exception;

/**
 * <p>Description：自定义业务性异常</p>
 * <p>Author：FranklinD</p>
 * <p>Date：2016年03月26日 9:57</p>
 * <p>Version 1.0</p>
 */
public class ProcessorException extends RuntimeException {

    private static final long serialVersionUID = -6483839307737450284L;
    /**
     * 操作状态
     */
    private Integer statusCode;
    /**
     * 操作状态详细细信息
     */
    private String statusMsg;

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public ProcessorException(ExceptionStatus exceptionStatus){
        super(exceptionStatus.getIndex()+":"+ exceptionStatus.getTitle());
        _errorMsgInit(exceptionStatus,null);
    }

    public ProcessorException(ExceptionStatus exceptionStatus, String diyMsg){
        super(exceptionStatus.getIndex()+":"+ exceptionStatus.getTitle()+":"+diyMsg);
        _errorMsgInit(exceptionStatus,diyMsg);
    }

    public ProcessorException(ExceptionStatus exceptionStatus, Throwable throwable){
        super(exceptionStatus.getIndex()+":"+ exceptionStatus.getTitle(),throwable);
        _errorMsgInit(exceptionStatus,null);
    }
    public ProcessorException(ExceptionStatus exceptionStatus, String diyMsg, Throwable throwable){
        super(exceptionStatus.getIndex()+":"+ exceptionStatus.getTitle()+":"+diyMsg,throwable);
        _errorMsgInit(exceptionStatus,diyMsg);
    }
    private void _errorMsgInit(ExceptionStatus exceptionStatus, String diyMsg){
        setStatusCode(exceptionStatus.getIndex());
        setStatusMsg(diyMsg == null ? exceptionStatus.getTitle() : diyMsg);
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public ProcessorException(String message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with the specified detail message and
     * cause.  <p>Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this runtime exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *                by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the
     *                {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted, and indicates that the cause is nonexistent or
     *                unknown.)
     * @since 1.4
     */
    public ProcessorException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new runtime exception with the specified cause and a
     * detail message of <tt>(cause==null ? null : cause.toString())</tt>
     * (which typically contains the class and detail message of
     * <tt>cause</tt>).  This constructor is useful for runtime exceptions
     * that are little more than wrappers for other throwables.
     *
     * @param cause the cause (which is saved for later retrieval by the
     *              {@link #getCause()} method).  (A <tt>null</tt> value is
     *              permitted, and indicates that the cause is nonexistent or
     *              unknown.)
     * @since 1.4
     */
    public ProcessorException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new runtime exception with the specified detail
     * message, cause, suppression enabled or disabled, and writable
     * stack trace enabled or disabled.
     *
     * @param message            the detail message.
     * @param cause              the cause.  (A {@code null} value is permitted,
     *                           and indicates that the cause is nonexistent or unknown.)
     * @param enableSuppression  whether or not suppression is enabled
     *                           or disabled
     * @param writableStackTrace whether or not the stack trace should
     *                           be writable
     * @since 1.7
     */
    protected ProcessorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
