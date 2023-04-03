import java.io.Serializable;

/**
 * Клас для обчислення суми двох чисел.
 */
public class Calculation implements Serializable {
    private int number1; // Перше число
    private int number2; // Друге число
    private int result;  // Результат обчислення

    /**
     * Конструктор класу.
     *
     * @param number1 Перше число
     * @param number2 Друге число
     */
    public Calculation(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    /**
     * Обчислити суму двох чисел.
     */
    public void calculate() {
        result = number1 + number2;
    }

    /**
     * Отримати результат обчислення.
     *
     * @return Результат обчислення
     */
    public int getResult() {
        return result;
    }
}
