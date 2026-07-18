package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanBook = new Book("Clean code", 10);
        Book cookBook = new Book("Cook chinazes", 13);
        Book javaBook = new Book("How study java", 1);
        Book phisicsBook = new Book("What is the phisics", 15);
        Book[] books = {
                cleanBook,
                cookBook,
                javaBook,
                phisicsBook
        };
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Book: " + book.getName() + ", pages: " + book.getPagesCount());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getName());
        }
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName());
            }
        }
    }
}
