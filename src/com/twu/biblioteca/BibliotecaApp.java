package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class BibliotecaApp {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(books(),System.out, new BufferedReader(new InputStreamReader(System.in)),movies());
        Menu menu = new Menu(new BufferedReader(new InputStreamReader(System.in)),biblioteca,System.out);
        biblioteca.displayWelcomeMessage();
        while(true) {
            menu.display();
        }
    }


    private static Map<Book, Boolean> books() {
        Map <Book, Boolean> books = new LinkedHashMap<Book, Boolean>();
        books.put(new Book("Harry Potter", "Jim", "1999"), true);
        books.put(new Book ("Hello", "Kate", "2010"),true);
        books.put(new Book ("Agile", "Jose", "2016"),true);
        return books;
    }

    private static Map<Movie, Boolean> movies() {
        Map<Movie,Boolean> movies = new LinkedHashMap<Movie, Boolean>();
        movies.put(new Movie("Sabrina","John","1995",8),true);
        movies.put(new Movie("Shrek","Alla","2015",10),true);
        movies.put(new Movie("Magic Castle","Tom","1875",8),true);
        return movies;
    }

}
