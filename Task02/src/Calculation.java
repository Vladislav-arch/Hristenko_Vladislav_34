import java.io.Serializable;

import java.util.Arrays;

public class Calculation implements Serializable {
    private int startingCells;
    private int favorableMin;
    private int favorableMax;
    private int unfavorableMin;
    private int unfavorableMax;
    private int[] survivingCellsPerCycle;

    public Calculation(int startingCells, int favorableMin, int favorableMax, int unfavorableMin, int unfavorableMax, int[] survivingCellsPerCycle) {
        this.startingCells = startingCells;
        this.favorableMin = favorableMin;
        this.favorableMax = favorableMax;
        this.unfavorableMin = unfavorableMin;
        this.unfavorableMax = unfavorableMax;
        this.survivingCellsPerCycle = survivingCellsPerCycle;
    }

    public int getStartingCells() {
        return startingCells;
    }

    public int getFavorableMin() {
        return favorableMin;
    }

    public int getFavorableMax() {
        return favorableMax;
    }

    public int getUnfavorableMin() {
        return unfavorableMin;
    }

    public int getUnfavorableMax() {
        return unfavorableMax;
    }

    public int[] getSurvivingCellsPerCycle() {
        return survivingCellsPerCycle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Calculation that = (Calculation) o;

        if (startingCells != that.startingCells) return false;
        if (favorableMin != that.favorableMin) return false;
        if (favorableMax != that.favorableMax) return false;
        if (unfavorableMin != that.unfavorableMin) return false;
        if (unfavorableMax != that.unfavorableMax) return false;
        return Arrays.equals(survivingCellsPerCycle, that.survivingCellsPerCycle);
    }

    @Override
    public int hashCode() {
        int result = startingCells;
        result = 31 * result + favorableMin;
        result = 31 * result + favorableMax;
        result = 31 * result + unfavorableMin;
        result = 31 * result + unfavorableMax;
        result = 31 * result + Arrays.hashCode(survivingCellsPerCycle);
        return result;
    }
}

