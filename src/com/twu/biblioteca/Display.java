package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.*;

public class Display {

    private PrintStream printStream;

    public Display(PrintStream printStream){
        this.printStream = printStream;
    }

    public void welcomeMessage() {
            String message = "Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!";
            printStream.println(message);
    }

    public String askForBookTitleToCheckOut() {
        printStream.println("Which book do you want to checkout?");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void tellBookUnavailable() {
        printStream.println("Sorry this book is not available");
    }

    public void confirmBookRental() {
        printStream.println("Thank you! Enjoy the book");
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
        public String showRentedItems(Map<User, ArrayList<Item>> rentedItems) {
            Iterator<Map.Entry<User, ArrayList<Item>>> rented = rentedItems.entrySet().iterator();
            String test = "";
            while (rented.hasNext()) {
                Map.Entry<User, ArrayList<Item>> entry = rented.next();
                String name = entry.getKey().getName();
                ArrayList<Item> rentedItemsList = entry.getValue();
                String rentedItemsTitles = "";
                for (Item item: rentedItemsList){
                    rentedItemsTitles += item.title + ", ";
                }


                test += name + " rented: " + rentedItemsTitles +"\n";
//                rentedItemsTitles = rentedItemsTitles.substring(0,rentedItemsTitles.length()-2);
                System.out.println(name + " rented: " + rentedItemsTitles);

            }

            return test;
        }}
