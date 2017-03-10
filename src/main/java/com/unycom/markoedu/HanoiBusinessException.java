package com.unycom.markoedu;

public class HanoiBusinessException extends RuntimeException {

    private HanoiBusinessErrorCodes hanoiBusinessErrorCode;
    private String message;

    public HanoiBusinessException(HanoiBusinessErrorCodes hanoiBusinessErrorCode, String message) {
        this.hanoiBusinessErrorCode = hanoiBusinessErrorCode;
        this.message = message;
    }

    public HanoiBusinessException(String message, Throwable cause, HanoiBusinessErrorCodes hanoiBusinessErrorCodes) {
        super(cause);
        this.hanoiBusinessErrorCode = hanoiBusinessErrorCodes;
        this.message = message;
    }

    public HanoiBusinessErrorCodes getHanoiBusinessErrorCodes() {
        return hanoiBusinessErrorCode;
    }

    @Override
    public String toString() {
        return "HanoiBusinessException{" +
                "hanoiBusinessErrorCode=" + hanoiBusinessErrorCode +
                ", message='" + message + '\'' +
                "} " + super.toString();
    }
}