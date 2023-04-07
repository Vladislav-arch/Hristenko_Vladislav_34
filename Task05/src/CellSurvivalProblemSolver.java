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

    public void printResults() {
        System.out.println("Starting cells: " + calculation.getStartingCells());
        System.out.println("Favorable survival probability range: " + calculation.getFavorableMin() + "-" + calculation.getFavorableMax() + "%");
        System.out.println("Unfavorable survival probability range: " + calculation.getUnfavorableMin() + "-" + calculation.getUnfavorableMax() + "%");
        System.out.println("Surviving cells per cycle: ");
        for (int i = 0; i < calculation.getSurvivingCellsPerCycle().length; i++) {
            System.out.println("Cycle " + (i+1) + ": " + calculation.getSurvivingCellsPerCycle()[i]);
        }
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
