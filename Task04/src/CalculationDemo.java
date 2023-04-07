import java.io.*;


/**
 * The class Calculation demo
 */
public class CalculationDemo {

    /**
     *
     * Main
     *
     * @param args  the args.
     */
    public static void main(String[] args) {

        // створення об'єкту Calculation
        Calculation calculation = new Calculation(100, 10, 50, 50, 90, new int[]{60, 25, 5, 3});

        // збереження об'єкту у файл
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("calculation.ser"))) {
            oos.writeObject(calculation);
            System.out.println("Об'єкт було збережено у файл.");
        } catch (IOException e) {
            System.err.println("Помилка збереження об'єкту у файл: " + e.getMessage());
        }

        // відновлення об'єкту з файлу
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("calculation.ser"))) {
            Calculation restoredCalculation = (Calculation) ois.readObject();
            System.out.println("Об'єкт було успішно відновлено з файлу.");
            System.out.println("Початкова кількість клітин: " + restoredCalculation.getStartingCells());
            System.out.println("Мінімальний відсоток виживання за сприятливих умов: " + restoredCalculation.getFavorableMin());
            System.out.println("Максимальний відсоток виживання за сприятливих умов: " + restoredCalculation.getFavorableMax());
            System.out.println("Мінімальний відсоток виживання за несприятливих умов: " + restoredCalculation.getUnfavorableMin());
            System.out.println("Максимальний відсоток виживання за несприятливих умов: " + restoredCalculation.getUnfavorableMax());
            System.out.println("Кількість виживших клітин на кожному циклі: ");
            for (int i = 0; i < restoredCalculation.getSurvivingCellsPerCycle().length; i++) {
                System.out.println("Цикл " + (i + 1) + ": " + restoredCalculation.getSurvivingCellsPerCycle()[i]);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка відновлення об'єкту з файлу: " + e.getMessage());
        }
    }
}
