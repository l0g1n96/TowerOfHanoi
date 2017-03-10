package com.unycom.markoedu;

import java.util.List;
import java.util.Map;

public final class HanoiOutputDataDTO {

    private final List<HanoiMoveDTO> lines;
    private final Map<Character, List<Integer>> poles;

    public HanoiOutputDataDTO(List<HanoiMoveDTO> lines, Map<Character, List<Integer>> poles) {
        this.lines = lines;
        this.poles = poles;
    }

    public Map<Character, List<Integer>> getPoles() {
        return poles;
    }

    public List<HanoiMoveDTO> getLines() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HanoiOutputDataDTO that = (HanoiOutputDataDTO) o;

        if (lines != null ? !lines.equals(that.lines) : that.lines != null) return false;
        return poles != null ? poles.equals(that.poles) : that.poles == null;
    }

    @Override
    public int hashCode() {
        int result = lines != null ? lines.hashCode() : 0;
        result = 31 * result + (poles != null ? poles.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HanoiOutputDataDTO{" +
                "lines=" + lines +
                ", poles=" + poles +
                '}';
    }
}
