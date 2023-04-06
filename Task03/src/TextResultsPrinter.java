public class TextResultsPrinter {
    private CellSurvivalProblemSolver solver;

    public TextResultsPrinter(CellSurvivalProblemSolver solver) {
        this.solver = solver;
    }

    public void PrintInfo() {
        Calculation calculation = solver.getCalculation();
        System.out.println("Starting cells: " + calculation.getStartingCells());
        System.out.println("Favorable survival probability range: " + calculation.getFavorableMin() + "-" + calculation.getFavorableMax() + "%");
        System.out.println("Unfavorable survival probability range: " + calculation.getUnfavorableMin() + "-" + calculation.getUnfavorableMax() + "%");
        System.out.println("Surviving cells per cycle: ");
        for (int i = 0; i < calculation.getSurvivingCellsPerCycle().length; i++) {
            System.out.println("Cycle " + (i+1) + ": " + calculation.getSurvivingCellsPerCycle()[i]);
        }
    }
}