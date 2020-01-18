package ru.job4j.condition;

public class TrgArea {

    private Point first;
    private Point second;
    private Point third;

    public TrgArea(Point first, Point second, Point third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * The method computes the area of the triangle.
     * @return - the value of the area.
     */
    public double area() {
        double a = first.distance(second);
        double b = second.distance(third);
        double c = third.distance(first);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public static void main(String[] args) {
        Point first = new Point(0, 0);
        Point second = new Point(2, 0);
        Point third = new Point(0, 2);
        double rsl = new TrgArea(first, second, third).area();
        System.out.println("area (2, 2, 2) = " + rsl);
    }

}
