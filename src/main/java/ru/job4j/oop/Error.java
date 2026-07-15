package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() { }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Ошибка активна: " + active);
        System.out.println("Номер ошибки: " + status);
        System.out.println("Текст ошибки: " + message);
    }

    public static void main(String[] args) {
        Error error = new Error();
        Error newError = new Error(true, 7, "Too much beer");
        newError.printInfo();
        System.out.println();
        error.printInfo();
    }
}
