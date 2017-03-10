package com.unycom.markoedu;

public enum NumberErrorCodes implements NumberError {

    FILE_DOESNT_EXIST(1),
    FILE_PERMISSION(2),
    WRONG_INPUT_TYPE(3),
    FILE_IS_EMPTY(4),
    MULTIPLE_INPUTS(5),
    INPUT_HIGHER_THAN_0(6);

    private int id;

    private NumberErrorCodes(int id) {
        this.id = id;
    }

    @Override
    public int getNumber() {
        return id;
    }

}
