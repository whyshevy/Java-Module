import java.awt.geom.Point2D;

public class Point {
    private int X = 0;
    private int Y = 0;

    public Point(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public Point() {

    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    public int getX() {
        return this.X;
    }

    public int getY() {
        return this.Y;
    }

    public int[] getXY() {
        int[] result = new int[2];
        result[0] = this.X;
        result[1] = this.Y;
        return result;
    }

    @Override
    public String toString() {
        return "X = " + X + ", Y = " + Y;
    }

    public double distance(Point pt) {
        double px = pt.getX() - this.getX();
        double py = pt.getY() - this.getY();
        return Math.sqrt(px * px + py * py);
    }

    @Override
    public boolean equals(Object o) {

        Point point = (Point) o;

        if (this.X != point.X && this.Y != point.Y) return false;
        else return true;
    }
}