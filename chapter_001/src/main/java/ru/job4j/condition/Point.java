package ru.job4j.condition;

public class Point {

    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }

    /**
     * The method computes the distance between two points.
     * @param that - another point, the distance to which we compute from the current point.
     * @return - distance between the points.
     */
    public double distance(Point that) {
        return Math.sqrt(Math.pow((that.x - this.x), 2) + Math.pow((that.y - this.y), 2));
    }

    /**
     * The method computes the distance between two points in 3D.
     * @param that - another point, the distance to which we compute from the current point.
     * @return - distance between the points in 3D.
     */
    public double distance3d(Point that) {
        return Math.sqrt(Math.pow((that.x - this.x), 2) + Math.pow((that.y - this.y), 2) + Math.pow((that.z - this.z), 2));
    }

}
