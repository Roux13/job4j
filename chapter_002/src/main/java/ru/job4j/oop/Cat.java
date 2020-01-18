package ru.job4j.oop;

public class Cat {

    private String name;
    private String food;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.format("Cat's name is %s. Its food is %s%n", this.name, this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta");
        gav.show();

        System.out.println();

        Cat black = new Cat();
        black.giveNick("Black");
        black.eat("fish");
        black.show();
    }
}
