package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private final BufferedReader reader;
    private final Biblioteca biblioteca;
    private PrintStream printStream;
    private CheckOutBookController checkOutBookController;


    public Menu(BufferedReader reader, Biblioteca biblioteca, PrintStream printStream, CheckOutBookController checkOutBookController){

        this.reader = reader;
        this.printStream = printStream;
        this.biblioteca = biblioteca;
        this.checkOutBookController = checkOutBookController;

    }

    private String readLine() {
        String book = null;
        try {
            book = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }

    public void display() {
        try {
            this.printStream.println("Press number for the option you want");
            this.printStream.println ( "1) List of books\n2) Display Movies\n3) Log in\n4) Quit\n5) Checkout the book\n6) Checkout Movie\n7) Return the book\n8) Show user information" );
            String userChoice = readLine();
            int choice = Integer.parseInt(userChoice);
            switch (choice) {
                case 1:
                    this.biblioteca.displayAllBooks();;
                    break;
                case 2:
                    this.biblioteca.displayAllMovies();
                    break;
                case 3:
                    this.biblioteca.login();
                    break;
                case 4:
                    this.printStream.println("Byeee");
                    System.exit(0);
                    break;
                case 5:
                    this.checkOutBookController.start();
                    break;
                case 6:
                    this.biblioteca.assignRentedItemToUser(this.biblioteca.checkoutMovie());
                    break;
                case 7:
                    this.biblioteca.deleteReturnedItemFromUser(this.biblioteca.returnBook());
                    break;
                case 8:
                    this.biblioteca.userInformation();
                    break;
                default:
                    String errorMessage = "Please select a valid option!";
                    this.printStream.println(errorMessage);
                    break;

        } }catch (Exception e) {
                this.printStream.println("Please select a valid option");
            }

        }

        public void displayShorterMenu(){
            try {
                this.printStream.println("Press number for the option you want");
                this.printStream.println ( "1) List of books\n2) Display Movies\n3) Log in\n4) Quit\n" );
                String userChoice = readLine();
                int choice = Integer.parseInt(userChoice);
                switch (choice) {
                    case 1:
                        this.biblioteca.displayAllBooks();;
                        break;
                    case 2:
                        this.biblioteca.displayAllMovies();
                        break;
                    case 3:
                        this.biblioteca.login();
                        break;
                    case 4:
                        this.printStream.println("Byeee");
                        System.exit(0);
                        break;
                    default:
                        String errorMessage = "Please select a valid option!";
                        this.printStream.println(errorMessage);
                        break;

                } }catch (Exception e) {
                this.printStream.println("Please select a valid option");
            }

        }

    public void displayLibrarianMenu(){
        try {
            this.printStream.println("Press number for the option you want");
            this.printStream.println ( "1) List of books\n2) Display Movies\n3) Log in\n4) Quit\n5) Display Rented Items" );
            String userChoice = readLine();
            int choice = Integer.parseInt(userChoice);
            switch (choice) {
                case 1:
                    this.biblioteca.displayAllBooks();;
                    break;
                case 2:
                    this.biblioteca.displayAllMovies();
                    break;
                case 3:
                    this.biblioteca.login();
                    break;
                case 4:
                    this.printStream.println("Byeee");
                    System.exit(0);
                    break;
                case 5:
                    this.biblioteca.displayRentedItems();
                    break;
                default:
                    String errorMessage = "Please select a valid option!";
                    this.printStream.println(errorMessage);
                    break;

            } }catch (Exception e) {
            this.printStream.println("Please select a valid option");
        }

    }

        }

