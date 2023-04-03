/**
 * Клас для тестування коректності результатів обчислень та серіалізації/десеріалізації.
 */
public class Test {

    /**
     * Головний метод класу Test. Запускає тести.
     *
     * @param args аргументи командного рядка (не використовуються в цьому класі)
     */
    public static void main(String[] args) {
        // Test calculation
        Calculation calculation = new Calculation(2, 3);
        calculation.calculate();
        assert calculation.getResult() == 5;

        // Test serialization and deserialization
        Demo demo = new Demo(2, 3);
        demo.serialize();
        demo.deserialize();
        assert demo.getResult() == 5;
    }
}