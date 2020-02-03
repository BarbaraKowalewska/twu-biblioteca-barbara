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
        String booksTitles = "";
        for (Book book : availableBooks) {
            booksTitles += book.getTitle() + " - " + book.getAuthor()+ ", " + book.getPublicationDate() +"\n";
        }
         printStream.println(booksTitles);
        }

        public void showMovies(List<Movie> availableMovies){
            String moviesTitles = "";
            for(Movie movie : availableMovies){
                moviesTitles += movie.getTitle() + " - " + movie.getDirector()+ ", " + movie.getYear() + " rating: " + movie.getRating() +"\n";

            }
            printStream.println(moviesTitles);
        }

    }
