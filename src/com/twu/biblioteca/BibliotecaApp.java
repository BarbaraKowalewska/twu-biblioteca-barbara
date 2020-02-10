package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        Display display = new Display(System.out);
        Biblioteca biblioteca = new Biblioteca(books(),System.out, new BufferedReader(new InputStreamReader(System.in)),movies(), display,users());
        CheckOutBookController checkOutBookController = new CheckOutBookController(biblioteca, display);
        Menu menu = new Menu(new BufferedReader(new InputStreamReader(System.in)),biblioteca,System.out, checkOutBookController);
        biblioteca.displayWelcomeMessage();
        while(Biblioteca.currentUser == null){
            menu.displayShorterMenu();
        }
        while(true){
            if(Biblioteca.currentUser.getName().equals("Librarian")){
                menu.displayLibrarianMenu();
            }else{
                menu.display();
            }
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

    private static List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User("11-1234","kot","Kate", "kate@gmail.com",765234987));
        users.add(new User("22-2345","pies","Tom", "tom@gmail.com",765876871));
        users.add(new User("33-3456","ryba","Jose", "jose@gmail.com",635412987));
        users.add(new User("11-111","secret","Librarian", "lib@gmail.com",635412987));
        return users;
    }


}
