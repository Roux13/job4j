package ru.job4j.poly;

public class Bus implements Transport {

    private int passengers;
    private double fuel;

    @Override
    public void drive() {
        System.out.println("Bus is driving");
    }

    @Override
    public void passengers(int count) {
        this.passengers = count;
    }

    @Override
    public double fill(double litres) {
        this.fuel = litres;
        double price = 45.3;
        return litres * price;
    }
}
