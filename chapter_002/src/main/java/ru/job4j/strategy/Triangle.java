package ru.job4j.strategy;

public class Triangle implements Shape {

    /**
     * The method forms a triangle of stars.
     * @return
     */
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        int height = 5;
        int base = (height * 2) - 1;
        for (int i = 0; i < height; i++) {
            StringBuilder empty = new StringBuilder();
            for (int j = 0; j < (base / 2) - i; j++) {
                empty.append(" ");
            }
            StringBuilder stars = new StringBuilder();
            for (int k = 0; k < 1 + i * 2; k++) {
                stars.append("*");
            }
            sb.append(empty).append(stars).append(empty);
            sb.append("\n");
        }
        return sb.toString();
    }
}
