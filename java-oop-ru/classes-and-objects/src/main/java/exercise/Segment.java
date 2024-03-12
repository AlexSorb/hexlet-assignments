package exercise;

// BEGIN
public class Segment {
    private Point start;
    private Point end;

    public Segment (Point addStart, Point addEnd) {
        this.start = addStart;
        this.end = addEnd;
    }

    public Point getBeginPoint() {
        return this.start;
    }

    public Point getEndPoint() {
        return this.end;
    }

    public Point getMidPoint() {
        Integer middleX = (end.getX() + start.getX()) / 2;
        Integer middleY = (end.getY() + start.getY()) / 2;
        return new Point(middleX, middleY);
    }
}
// END
