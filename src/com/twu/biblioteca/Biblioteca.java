package com.twu.biblioteca;


import com.sun.codemodel.internal.JForEach;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;


public class Biblioteca {

    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Map<Book, Boolean> allBooks;


    public Biblioteca(Map<Book,Boolean> books, PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.allBooks = books;
        this.bufferedReader = bufferedReader;

    }

    public void displayWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!";
        printStream.println(message);

    }

    public Map <Book, Boolean> getAllBooks() {
        return allBooks;
    }


    public void displayAllBooks() {

        String booksTitles = "";

        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = allBooks.entrySet().iterator();
        while (allBooksIterator.hasNext()) {
            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
            booksTitles += entry.getKey().getTitle() + " - " + entry.getKey().getAuthor()+ ", " + entry.getKey().getPublicationDate() +"\n";

                    }
        printStream.println(booksTitles);
    }

    }




