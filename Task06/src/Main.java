import java.util.Scanner;
import java.util.Stack;


/**
 * The class Main
 */
public class Main {
    private static final int COMMAND_ADD = 1;
    private static final int COMMAND_REMOVE = 2;
    private static final int COMMAND_PRINT = 3;
    private static final int COMMAND_UNDO = 4;

    private static Stack<CellSurvivalProblemSolver> history = new Stack<>();


    /**
     *
     * Main
     *
     * @param args  the args.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int startingCells = 0;
        int favorableMin = 0;
        int favorableMax = 0;
        int unfavorableMin = 0;
        int unfavorableMax = 0;
        int cycles = 0;

        while (true) {
            System.out.println("Введіть команду:");
            System.out.println("1 - Додати новий розрахунок");
            System.out.println("2 - Видалити останній розрахунок");
            System.out.println("3 - Роздрукувати всі розрахунки");
            System.out.println("4 - Скасувати останню команду");

            int command = scanner.nextInt();

            switch (command) {
                case COMMAND_ADD:
                    System.out.println("Введіть початкову кількість клітин:");
                    startingCells = scanner.nextInt();

                    System.out.println("Введіть несприятливий діапазон ймовірності виживання (min max): ");
                    favorableMin = scanner.nextInt();
                    favorableMax = scanner.nextInt();

                    System.out.println("Введіть несприятливий діапазон ймовірності виживання (min max): ");
                    unfavorableMin = scanner.nextInt();
                    unfavorableMax = scanner.nextInt();

                    System.out.println("Введіть кількість циклів: ");
                    cycles = scanner.nextInt();

                    CellSurvivalProblemSolver solver = new CellSurvivalProblemSolver(startingCells, favorableMin, favorableMax, unfavorableMin, unfavorableMax, cycles);
                    history.push(solver);

                    System.out.println("Розрахунок додано.");
                    break;

                case COMMAND_REMOVE:
                    if (!history.isEmpty()) {
                        history.pop();
                        System.out.println("Останній розрахунок видалено.");
                    } else {
                        System.out.println("Помилка: немає обчислень для видалення.");
                    }
                    break;

                case COMMAND_PRINT:
                    if (!history.isEmpty()) {
                        for (CellSurvivalProblemSolver solverToPrint : history) {
                            solverToPrint.printResults();
                        }
                    } else {
                        System.out.println("Помилка: немає обчислень для друку.");
                    }
                    break;

                case COMMAND_UNDO:
                    if (!history.isEmpty()) {
                        CellSurvivalProblemSolver lastSolver = history.pop();
                        System.out.println("Скасування останнього обчислення: початкові клітинки -" + lastSolver.getCalculation().getStartingCells());
                    } else {
                        System.out.println("Помилка: немає обчислень для скасування.");
                    }
                    break;

                default:
                    System.out.println("Недійсна команда.");
            }
        }
    }
}
