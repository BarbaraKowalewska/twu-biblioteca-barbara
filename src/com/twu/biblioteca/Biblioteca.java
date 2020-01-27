package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;


public class Biblioteca {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private ArrayList allBooks;


    public Biblioteca(ArrayList<Book> books, PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.allBooks = books;
        this.bufferedReader = bufferedReader;

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
            booksTitles += getAllBooks().get(i).getTitle() +" - " + getAllBooks().get(i).getAuthor() + ", " + getAllBooks().get(i).getPublicationDate() +"\n";;
        }
        printStream.println(booksTitles);
    }

}



