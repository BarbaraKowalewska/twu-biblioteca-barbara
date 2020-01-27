package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(books(),System.out, new BufferedReader(new InputStreamReader(System.in)));
        Menu menu = new Menu(new BufferedReader(new InputStreamReader(System.in)),biblioteca,System.out);
        biblioteca.displayWelcomeMessage();
        while(true) {
            menu.display();
        }
    }


    private static ArrayList<Book> books() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Head First Java", "Jim", "1999"));
        books.add(new Book ("Test Driven Development by Example", "Kate", "2010"));
        books.add(new Book ("The Agile Samurai", "Jose", "2016"));
        return books;
    }
}
