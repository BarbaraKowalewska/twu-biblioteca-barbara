package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(books(),System.out);
        biblioteca.displayWelcomeMessage();
        biblioteca.displayAllBooks();

    }

    private static ArrayList<Book> books() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java"));
        books.add(new Book ("Test Driven Development by Example"));
        books.add(new Book ("The Agile Samurai"));
        return books;
    }
}
