package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;

    public Flat(double currentArea, double currentBalconyArea, int currentFloor) {
        this.area = currentArea;
        this.balconyArea = currentBalconyArea;
        this.floor = currentFloor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
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
        var result = "Квартира площадью "
                + this.getArea()
                + " метров на "
                + this.floor
                +" этаже";
        return result;
    }
}
// END
