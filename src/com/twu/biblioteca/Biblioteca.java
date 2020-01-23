package com.twu.biblioteca;

import java.io.PrintStream;

public class Biblioteca {

    private PrintStream printStream;

    public Biblioteca(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void displayWelcomeMessage() {
        String message = "Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!";
        printStream.println(message);

    }

}
