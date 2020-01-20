package ru.job4j.io;

import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 11;
        int move = -1;
        boolean run = true;


        while (run) {
            int userInput = 0;
            move++;
            System.out.printf("Количество спичек на столе: %d%n", count);
            boolean wrongAnswer = true;
            while (wrongAnswer) {
                System.out.printf("Ход игрока %d. Введите число от 1-го до 3-х и меньше/равно, чем оставшееся число спичек на столе:%n", move % 2 == 0 ? 1 : 2);
                //добавить проверку количества введенных спичек.
                userInput = Integer.valueOf(sc.nextLine());
                if (userInput >= 1 && userInput <= 3 && userInput <= count) {
                    wrongAnswer = false;
                } else {
                    System.out.printf("Неверное число спичек.%n");
                }
            }
            count -= userInput;
            if (count < 1) {
                run = false;
            }

        }
        System.out.printf("Игрок %d победил%n", move % 2 == 0 ? 1 : 2);
    }

}
