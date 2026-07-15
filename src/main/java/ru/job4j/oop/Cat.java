package ru.job4j.oop;

public class Cat {

    private String food;
    private String name;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("Cat " + this.name + " eat's " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        System.out.println("There is gav's food.");
        Cat gav = new Cat();
        gav.eat("cutlet");
        gav.giveNick("Igor");
        gav.show();
        System.out.println("There is black's food.");
        Cat black = new Cat();
        black.eat("fish");
        black.giveNick("Max");
        black.show();
    }
}