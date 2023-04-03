import java.io.Serializable;

/**
 * Клас для знаходження суми двох чисел.
 * Використовується агрегуванням класу Calculation для обчислення суми.
 * Цей клас серіалізується.
 */
public class Summation implements Serializable {

    /**
     * Об'єкт класу Calculation для обчислення суми.
     */
    private Calculation calculation;

    /**
     * Конструктор класу Summation.
     *
     * @param a перше число
     * @param b друге число
     */
    public Summation(int a, int b) {
        calculation = new Calculation(a, b);
    }

    /**
     * Метод для обчислення суми.
     *
     * @return сума двох чисел
     */
    public int sum() {
        calculation.calculate();
        return calculation.getResult();
    }
}
