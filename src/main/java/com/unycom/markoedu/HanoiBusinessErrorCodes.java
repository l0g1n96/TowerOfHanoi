package com.unycom.markoedu;

public enum HanoiBusinessErrorCodes {

    FILE_PROBLEM(124),
    INPUT_PROBLEM(356);

    private int numberId;

    HanoiBusinessErrorCodes(int numberId) {
        this.numberId = numberId;
    }

    public int getNumberId() {
        return numberId;
    }
}
