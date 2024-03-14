package exercise;

// BEGIN
public class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double currentArea, int currentFloorCount) {
        area = currentArea;
        floorCount = currentFloorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home anotherHouse) {
        if (anotherHouse.getArea() == this.getArea()) {
            return 0;
        }
        return anotherHouse.getArea() > this.getArea() ? -1 : 1;
    }

    @Override
    public String toString() {
        String result = floorCount
                + " этажный коттедж площадью "
                + this.getArea()
                + " метров";
        return result;
    }
}
// END
