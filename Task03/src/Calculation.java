import java.io.Serializable;
import java.util.Arrays;


/**
 * The class Calculation implements serializable
 */
public class Calculation implements Serializable {
    private int startingCells;
    private int favorableMin;
    private int favorableMax;
    private int unfavorableMin;
    private int unfavorableMax;
    private int[] survivingCellsPerCycle;


    /**
     *
     * Calculation
     *
     * @param startingCells  the starting cells.
     * @param favorableMin  the favorable min.
     * @param favorableMax  the favorable max.
     * @param unfavorableMin  the unfavorable min.
     * @param unfavorableMax  the unfavorable max.
     * @param survivingCellsPerCycle  the surviving cells per cycle.
     * @return public
     */
    public Calculation(int startingCells, int favorableMin, int favorableMax, int unfavorableMin, int unfavorableMax, int[] survivingCellsPerCycle) {

        this.startingCells = startingCells;
        this.favorableMin = favorableMin;
        this.favorableMax = favorableMax;
        this.unfavorableMin = unfavorableMin;
        this.unfavorableMax = unfavorableMax;
        this.survivingCellsPerCycle = survivingCellsPerCycle;
    }


    /**
     *
     * Gets the starting cells
     *
     * @return the starting cells
     */
    public int getStartingCells() {

        return startingCells;
    }


    /**
     *
     * Gets the favorable min
     *
     * @return the favorable min
     */
    public int getFavorableMin() {

        return favorableMin;
    }


    /**
     *
     * Gets the favorable max
     *
     * @return the favorable max
     */
    public int getFavorableMax() {

        return favorableMax;
    }


    /**
     *
     * Gets the unfavorable min
     *
     * @return the unfavorable min
     */
    public int getUnfavorableMin() {

        return unfavorableMin;
    }


    /**
     *
     * Gets the unfavorable max
     *
     * @return the unfavorable max
     */
    public int getUnfavorableMax() {

        return unfavorableMax;
    }


    /**
     *
     * Gets the surviving cells per cycle
     *
     * @return the surviving cells per cycle
     */
    public int[] getSurvivingCellsPerCycle() {

        return survivingCellsPerCycle;
    }

    @Override

/**
 *
 * Equals
 *
 * @param o  the o.
 * @return boolean
 */
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

/**
 *
 * Hash code
 *
 * @return int
 */
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

