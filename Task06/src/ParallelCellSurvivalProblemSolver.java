import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelCellSurvivalProblemSolver {
    private Calculation calculation;

    public ParallelCellSurvivalProblemSolver(int startingCells, int favorableMin, int favorableMax, int unfavorableMin, int unfavorableMax, int cycles) {
        int[] survivingCellsPerCycle = new int[cycles];
        AtomicInteger currentCells = new AtomicInteger(startingCells);

        // Створюємо стрім для обробки елементів колекції в паралельному режимі
        Arrays.parallelSetAll(survivingCellsPerCycle, i -> {
            double survivalProbability = Math.random() * (unfavorableMax - unfavorableMin) + unfavorableMin;
            if (i % 2 == 0) {
                survivalProbability = Math.random() * (favorableMax - favorableMin) + favorableMin;
            }
            int survivingCells = (int) Math.round(currentCells.get() * survivalProbability / 100);
            currentCells.set(survivingCells);
            return survivingCells;
        });

        calculation = new Calculation(startingCells, favorableMin, favorableMax, unfavorableMin, unfavorableMax, survivingCellsPerCycle);
    }

    public Calculation getCalculation() {
        return calculation;
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
}
