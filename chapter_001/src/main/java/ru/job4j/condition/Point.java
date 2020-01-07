package ru.job4j.condition;

public class Point {

    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
    }

    public static void main(String[] args) {
        double result = distance(0, 0, 2, 0);
        System.out.println("result (0, 0) to (2, 0) " + result);

        double result2 = distance(2, 0, 2, 0);
        System.out.println("result (2, 0) to (2, 0) " + result2);

        double result3 = distance(0, 1, 0, 0);
        System.out.println("result (0, 1) to (0, 0) " + result3);

        double result4 = distance(0, 0, 0, 0);
        System.out.println("result (0, 0) to (0, 0) " + result4);

        double result5 = distance(0, 0, 0, 2);
        System.out.println("result (0, 0) to (0, 2) " + result5);

        double result6 = distance(-1, 1, 1, -1);
        System.out.println("result (-1, 1) to (1, -1) " + result6);
    }

}
