package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Menu {

    private final BufferedReader reader;
    private final Biblioteca biblioteca;
    private PrintStream printStream;


    public Menu(BufferedReader reader, Biblioteca biblioteca, PrintStream printStream ){

        this.reader = reader;
        this.printStream = printStream;
        this.biblioteca = biblioteca;
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
            System.out.println("Press number for the option you want");
            System.out.println ( "1) List of books\n2) Quit\n3) Checkout the book\n4) Return the book\n5) Display Movies\n6) Checkout Movie" );
            String userChoice = readLine();
            int choice = Integer.parseInt(userChoice);
            switch (choice) {
                case 1:
                    this.biblioteca.displayAllBooks();;
                    break;
                case 2:
                    System.out.println("Byeee");
                    System.exit(0);
                    break;
                case 3:
                    this.biblioteca.checkoutBook();
                    break;
                case 4:
                    this.biblioteca.returnBook();
                    break;
                case 5:
                    this.biblioteca.displayAllMovies();
                    break;
                case 6:
                    this.biblioteca.checkoutMovie();
                    break;
                default:
                    String errorMessage = "Please select a valid option!";
                    printStream.println(errorMessage);
                    break;

        } }catch (Exception e) {
                System.out.println("Please select a valid option");
            }


        }

    }

