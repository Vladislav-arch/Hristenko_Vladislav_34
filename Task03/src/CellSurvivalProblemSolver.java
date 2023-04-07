public class CellSurvivalProblemSolver {
    private Calculation calculation;


    /**
     *
     * It is a constructor.
     *
     * @param startingCells  the starting cells.
     * @param favorableMin  the favorable min.
     * @param favorableMax  the favorable max.
     * @param unfavorableMin  the unfavorable min.
     * @param unfavorableMax  the unfavorable max.
     * @param cycles  the cycles.
     */
    public CellSurvivalProblemSolver(int startingCells, int favorableMin, int favorableMax, int unfavorableMin, int unfavorableMax, int cycles) {

        int[] survivingCellsPerCycle = new int[cycles];
        int currentCells = startingCells;
        for (int i = 0; i < cycles; i++) {
            double survivalProbability = Math.random() * (unfavorableMax - unfavorableMin) + unfavorableMin;
            if (i % 2 == 0) {
                survivalProbability = Math.random() * (favorableMax - favorableMin) + favorableMin;
            }
            int survivingCells = (int) Math.round(currentCells * survivalProbability / 100);
            survivingCellsPerCycle[i] = survivingCells;
            currentCells = survivingCells;
        }
        calculation = new Calculation(startingCells, favorableMin, favorableMax, unfavorableMin, unfavorableMax, survivingCellsPerCycle);
    }


    /**
     *
     * Gets the calculation
     *
     * @return the calculation
     */
    public Calculation getCalculation() {

        return calculation;
    }
}
