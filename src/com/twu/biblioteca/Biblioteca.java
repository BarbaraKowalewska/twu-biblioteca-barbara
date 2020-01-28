package com.twu.biblioteca;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


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
            if (entry.getValue().equals(true)){
                booksTitles += entry.getKey().getTitle() + " - " + entry.getKey().getAuthor()+ ", " + entry.getKey().getPublicationDate() +"\n";
            }
                    }
        printStream.println(booksTitles);
    }

    public void checkoutBook() {

        System.out.println("Which book do you want to checkout?");
        Scanner in = new Scanner(System.in);
        String bookToCheckout = in.nextLine();

        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = getAllBooks().entrySet().iterator();
        Boolean bookNotAvailable = true;
        while (allBooksIterator.hasNext()) {
            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
            if (entry.getKey().getTitle().equals(bookToCheckout) && entry.getValue().equals(true)) {
                System.out.println("Thank you! Enjoy the book");
                allBooks.put(entry.getKey(),false);
                bookNotAvailable = false;
            }
        }
        if (bookNotAvailable.equals(true)){
            printStream.println("Sorry this book is not available");
        }
    }

    public void returnBook() {
        System.out.println("Which book do you want to return?");
        Scanner in = new Scanner(System.in);
        String bookToReturn = in.nextLine();

        Boolean bookCannotBeReturned = true;
        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = getAllBooks().entrySet().iterator();
        while (allBooksIterator.hasNext()) {
            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
            if (entry.getKey().getTitle().equals(bookToReturn) && entry.getValue().equals(false)) {
                System.out.println("Thank you for returning the book!");
                allBooks.put(entry.getKey(),true);
                bookCannotBeReturned = false;

            }
        }
        if (bookCannotBeReturned.equals(true)){
            printStream.println("This is not a valid book to return");
        }

    }
}




