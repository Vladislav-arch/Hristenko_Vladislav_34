import java.util.Scanner;

/**
 * The class Cell survival problem solver dialog
 */
public class CellSurvivalProblemSolverDialog {
    static void main() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть початкову кількість клітин:");
        int startingCells = scanner.nextInt();

        System.out.println("Введіть мінімальний і максимальний діапазон вірогідності виживання клітин у невигідних умовах, через пробіл:");
        int unfavorableMin = scanner.nextInt();
        int unfavorableMax = scanner.nextInt();

        System.out.println("Введіть мінімальний і максимальний діапазон вірогідності виживання клітин у вигідних умовах, через пробіл:");
        int favorableMin = scanner.nextInt();
        int favorableMax = scanner.nextInt();

        System.out.println("Введіть кількість циклів:");
        int cycles = scanner.nextInt();

        CellSurvivalProblemSolver solver = new CellSurvivalProblemSolver(startingCells, favorableMin, favorableMax, unfavorableMin, unfavorableMax, cycles);
        TextResultsPrinter Info = new TextResultsPrinter(solver);
        Info.PrintInfo();
    }
}
