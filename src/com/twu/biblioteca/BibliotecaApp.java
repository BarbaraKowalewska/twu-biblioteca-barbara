package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(books(),System.out, new BufferedReader(new InputStreamReader(System.in)));
        Menu menu = new Menu(new BufferedReader(new InputStreamReader(System.in)),biblioteca,System.out);
        biblioteca.displayWelcomeMessage();
        while(true) {
            menu.display();
        }
    }


    private static Map<Book, Boolean> books() {
        Map <Book, Boolean> books = new LinkedHashMap<Book, Boolean>();
        books.put(new Book("Head First Java", "Jim", "1999"), true);
        books.put(new Book ("Test Driven Development by Example", "Kate", "2010"),true);
        books.put(new Book ("The Agile Samurai", "Jose", "2016"),true);
        return books;
    }
}
