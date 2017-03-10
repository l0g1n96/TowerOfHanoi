package com.unycom.markoedu;

public class HanoiException extends RuntimeException {

    private NumberErrorCodes error;
    private String msg;

    public HanoiException(Throwable cause, NumberErrorCodes error, String msg) {
        super(cause);
        this.error = error;
        this.msg = msg;
    }

    public HanoiException(NumberErrorCodes error, String msg) {
        this.error = error;
        this.msg = msg;
    }

    public NumberErrorCodes getError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }

    public void setError(NumberErrorCodes error) {
        this.error = error;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "HanoiException{" +
                "error=" + error +
                ", msg='" + msg + '\'' +
                "} " + super.toString();
    }
}
