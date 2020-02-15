package ru.job4j.stream.school;

public class Student {

    private String lastName;

    private int score;

    public Student(String lastName, int score) {
        this.lastName = lastName;
        this.score = score;
    }

    public String getLastName() {
        return lastName;
    }

    public int getScore() {
        return score;
    }
}
