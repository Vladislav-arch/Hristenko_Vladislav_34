import java.io.*;


/**
 * The class Calculation test
 */
public class CalculationTest {

    /**
     *
     * Main
     *
     * @param args  the args.
     */
    public static void main(String[] args) {

        // створення об'єкту Calculation
        Calculation calculation = new Calculation(100, 10, 50, 50, 90, new int[]{60, 25, 5, 3});

        // перевірка коректності результатів обчислень
        int expectedStartingCells = 100;
        int actualStartingCells = calculation.getStartingCells();
        if (actualStartingCells != expectedStartingCells) {
            System.err.println("Помилка: очікувана початкова кількість клітин - " + expectedStartingCells + ", отримана - " + actualStartingCells);
        }

        int[] expectedSurvivingCells = {60, 25, 5, 3};
        int[] actualSurvivingCells = calculation.getSurvivingCellsPerCycle();
        for (int i = 0; i < expectedSurvivingCells.length; i++) {
            if (actualSurvivingCells[i] != expectedSurvivingCells[i]) {
                System.err.println("Помилка: очікувана кількість виживших клітин на циклі " + (i + 1) + " - " + expectedSurvivingCells[i] + ", отримана - " + actualSurvivingCells[i]);
            }
        }

        // перевірка коректності серіалізації та десеріалізації
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(calculation);

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Calculation restoredCalculation = (Calculation) ois.readObject();

            if (!restoredCalculation.equals(calculation)) {
                System.err.println("Помилка: серіалізований та десеріалізований об'єкти не співпадають");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}
