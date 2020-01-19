package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book[] books = new Book[4];
        Book javaFull = new Book("Java. Полное руководство", 1488);
        Book warAndPeace = new Book("Война и мир.", 999);
        Book buratino = new Book("Буратино", 145);
        Book cleanCode = new Book("Clean code", 545);

        books[0] = javaFull;
        books[1] = warAndPeace;
        books[2] = buratino;
        books[3] = cleanCode;

        for (int index = 0; index < books.length; index++) {
            Book curBook = books[index];
            System.out.println(curBook.getName() + " - " + curBook.getPages() + " страниц.");
        }
        System.out.println();

        Book tmp = books[0];
        books[0] = books[3];
        books[3] = tmp;

        for (int index = 0; index < books.length; index++) {
            Book curBook = books[index];
            System.out.println(curBook.getName() + " - " + curBook.getPages() + " страниц.");
        }
        System.out.println();

        for (int index = 0; index < books.length; index++) {
            Book curBook = books[index];
            if (curBook.getName().equals("Clean code")) {
                System.out.println(curBook.getName() + " - " + curBook.getPages() + " страниц.");
            }
        }
    }

}
