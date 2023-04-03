import java.io.*;
/**

 Клас Demo для зберігання та відновлення стану об'єкта, використовуючи серіалізацію.

 Об'єкт класу містить параметри a та b, результат result, та транзитний об'єкт Summation, який містить

 метод для обчислення суми параметрів a та b.
 */
public class Demo implements Serializable {
    private transient Summation summation; // транзитне поле, не серіалізується
    private int a;
    private int b;
    private int result;

    /**

     Конструктор класу Demo
     @param a перший параметр
     @param b другий параметр
     */
    public Demo(int a, int b) {
        this.a = a;
        this.b = b;
        summation = new Summation(a, b);
        result = summation.sum();
    }
    /**

     Метод для серіалізації об'єкту у файл demo.ser
     */
    public void serialize() {
        try {
            FileOutputStream fileOut = new FileOutputStream("demo.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
            System.out.println("Серіалізовані дані збережені у файл demo.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**

     Метод для десеріалізації об'єкту з файлу demo.ser та відновлення стану об'єкту
     */
    public void deserialize() {
        try {
            FileInputStream fileIn = new FileInputStream("demo.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Demo demo = (Demo) in.readObject();
            in.close();
            fileIn.close();
            this.a = demo.a;
            this.b = demo.b;
            this.result = demo.result;
            this.summation = new Summation(a, b);
            System.out.println("Десеріалізовані дані завантажені з файлу demo.ser");
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Клас Demo не знайдено");
            c.printStackTrace();
            return;
        }
    }
    /**

     Метод, який повертає результат обчислення суми параметрів a та b
     @return результат обчислення суми параметрів a та b
     */
    public int getResult() {
        return result;
    }
}
