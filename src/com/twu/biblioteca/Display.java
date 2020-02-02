package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Display {

    private PrintStream printStream;

    public Display(PrintStream printStream){
        this.printStream = printStream;
    }

    public void welcomeMessage() {
            String message = "Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!";
            printStream.println(message);
    }

    public void showBooks(List<Book> availableBooks) {
        List<String> descriptions = new ArrayList();
        String booksTitles = "";
        for (Book book : availableBooks) {
            booksTitles += book.getTitle() + " - " + book.getAuthor()+ ", " + book.getPublicationDate() +"\n";
        }

         printStream.println(booksTitles);
        }

    }
