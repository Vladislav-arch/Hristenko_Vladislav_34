import java.util.Arrays;


/**
 * The class Cell survival problem solver parallel
 */
public class CellSurvivalProblemSolverParallel {

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
    public CellSurvivalProblemSolverParallel(int startingCells, int favorableMin, int favorableMax, int unfavorableMin, int unfavorableMax, int cycles) {

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


    /**
     *
     * Print results
     *
     */
    public void printResults() {

        System.out.println("Стартові клітини: " + calculation.getStartingCells());
        System.out.println("Діапазон сприятливої ймовірності виживання: " + calculation.getFavorableMin() + "-" + calculation.getFavorableMax() + "%");
        System.out.println("Діапазон невигідної імовірності виживання: " + calculation.getUnfavorableMin() + "-" + calculation.getUnfavorableMax() + "%");
        System.out.println("Виживші клітини за цикл: ");
        Arrays.stream(calculation.getSurvivingCellsPerCycle())
                .parallel()
                .forEach(survivingCells -> System.out.println("Цикл: " + survivingCells));
    }


    /**
     *
     * Main
     *
     * @param args  the args.
     */
    public static void main(String[] args) {

        CellSurvivalProblemSolverParallel solver = new CellSurvivalProblemSolverParallel(100, 10, 50, 50, 90, 4);
        solver.printResults();
    }
}
