package com.unycom.markoedu;

public final class HanoiMoveDTO {

    private final int diskNumber;
    private final char fromPole;
    private final char toPole;

    public HanoiMoveDTO(int diskNumber, char fromPole, char toPole) {
        this.diskNumber = diskNumber;
        this.fromPole = fromPole;
        this.toPole = toPole;
    }

    public int getDiskNumber() {
        return diskNumber;
    }

    public char getFromPole() {
        return fromPole;
    }

    public char getToPole() {
        return toPole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HanoiMoveDTO that = (HanoiMoveDTO) o;

        if (diskNumber != that.diskNumber) return false;
        if (fromPole != that.fromPole) return false;
        return toPole == that.toPole;
    }

    @Override
    public int hashCode() {
        int result = diskNumber;
        result = 31 * result + (int) fromPole;
        result = 31 * result + (int) toPole;
        return result;
    }

    @Override
    public String toString() {
        return "HanoiMoveDTO{" +
                "diskNumber=" + diskNumber +
                ", fromPole=" + fromPole +
                ", toPole=" + toPole +
                '}';
    }
}
