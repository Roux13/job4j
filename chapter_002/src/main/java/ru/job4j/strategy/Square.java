package ru.job4j.strategy;

public class Square implements Shape {

    /**
     * The method forms a size by size square of "stars".
     * @return String contains the square.
     */
    @Override
    public String draw() {
        StringBuilder sb = new StringBuilder();
        int size = 7;
        for (int i = 0; i < size; i++) {
            sb.append("*");
            if (i == 0 || i == size - 1) {
                for (int j = 1; j < size; j++) {
                    sb.append("  *");
                }
            } else {
                for (int j = 1; j < size - 1; j++) {
                    sb.append("   ");
                }
                sb.append("  *");
            }
            sb.append(("\n"));
        }
        return sb.toString();
    }
}
