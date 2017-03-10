package com.unycom.markoedu;

public final class HanoiInputDataDTO {

    private final int diskCount;

    public HanoiInputDataDTO(int diskCount) {
        this.diskCount = diskCount;
    }

    public int getDiskCount() {
        return diskCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HanoiInputDataDTO that = (HanoiInputDataDTO) o;

        return diskCount == that.diskCount;
    }

    @Override
    public int hashCode() {
        return diskCount;
    }

    @Override
    public String toString() {
        return "HanoiInputDataDTO{" +
                "diskCount=" + diskCount +
                '}';
    }
}
