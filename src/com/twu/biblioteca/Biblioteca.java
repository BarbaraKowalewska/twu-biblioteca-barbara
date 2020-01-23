package com.twu.biblioteca;

import com.sun.deploy.uitoolkit.ui.ConsoleWindow;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    private PrintStream printStream;
    private ArrayList allBooks;

    public Biblioteca(ArrayList<Book> books, PrintStream printStream) {
        this.printStream = printStream;
        this.allBooks = books;

    }

    public void displayWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!";
        printStream.println(message);

    }

    public ArrayList<Book> getAllBooks() {
        return allBooks;
    }


    public void displayAllBooks() {

        String booksTitles = "";
        for (int i = 0; i < getAllBooks().size(); i ++) {
//            System.out.println(getAllBooks().get(i).getTitle());
            booksTitles += getAllBooks().get(i).getTitle() + "\n";;
        }
        printStream.println(booksTitles);

    }


}
