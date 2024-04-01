package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle square) {
        try {
            System.out.println(Math.round(square.getSquare()));
        } catch (NegativeRadiusException exp) {
            System.out.println(exp.getMessage());
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
