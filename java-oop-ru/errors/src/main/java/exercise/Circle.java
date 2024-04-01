package exercise;

// BEGIN
public class Circle {
    private Point center;
    private Integer radius;
    private final static Double PI = 3.14159;

    public Circle(Point center, Integer radius) {
        this.center = center;
        this.radius = radius;
    }

    public Integer getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if(radius < 0) {
            throw new NegativeRadiusException("Не удалось посчитать площадь");
        }
        return PI * radius * radius;
    }
}
// END
