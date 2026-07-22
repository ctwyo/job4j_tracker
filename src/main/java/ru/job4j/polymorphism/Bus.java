package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("viy viy move move");
    }

    @Override
    public void passengers(int count) {
        System.out.println(count + " passengers");
    }

    @Override
    public int refuel(int fuel) {
        return fuel * 62;
    }
}
