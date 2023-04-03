/**
 * Цей клас моделює процес поділу клітин при бінарному розподілі.
 */
import java.util.Random;

public class CellDivision {

    /**
     * Метод main - вхідна точка програми.
     * Виводить кількість виживших клітин на кожному циклі поділу.
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        int numCells = 1000; // початкова кількість клітин
        int numCycles = 10; // кількість циклів поділу
        int minSurvivalRate = 10; // мінімальна ймовірність виживання за сприятливих умов
        int maxSurvivalRate = 50; // максимальна ймовірність виживання за сприятливих умов
        int minDeathRate = 50; // мінімальна ймовірність виживання за несприятливих умов
        int maxDeathRate = 90; // максимальна ймовірність виживання за несприятливих умов

        Random random = new Random();

        for (int i = 1; i <= numCycles; i++) {
            int numSurvivingCells = 0;
            for (int j = 0; j < numCells; j++) {
                int survivalRate;
                if (random.nextBoolean()) { // сприятливі умови
                    survivalRate = random.nextInt(maxSurvivalRate - minSurvivalRate + 1) + minSurvivalRate;
                } else { // несприятливі умови
                    survivalRate = random.nextInt(maxDeathRate - minDeathRate + 1) + minDeathRate;
                }
                if (random.nextInt(100) < survivalRate) {
                    numSurvivingCells++;
                }
            }
            System.out.println("Цикл " + i + ": " + numSurvivingCells + " клітин вижили");
            numCells = numSurvivingCells; // кількість клітин наступного циклу буде рівна кількості виживших клітин поточного циклу
        }
    }
}
