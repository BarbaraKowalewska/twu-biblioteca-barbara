package com.twu.biblioteca;

import org.junit.Test;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaTests {



    @Test
    public void shouldPrintWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        ArrayList<Book> books = new ArrayList<Book>();
        BufferedReader bufferedReader;
        bufferedReader = mock(BufferedReader.class);
        Biblioteca biblioteca = new Biblioteca(books,printStream,bufferedReader);

        biblioteca.displayWelcomeMessage();
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!");
    }

    @Test
    public void shouldPrintAllBooks() {
        PrintStream printStream = mock(PrintStream.class);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter", "Jim", "1999"));
        books.add(new Book ("Java Master", "Kate", "2010"));
        books.add(new Book ("Barcelona Guide", "Jose", "2016"));
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Biblioteca biblioteca = new Biblioteca(books,printStream,bufferedReader);


       biblioteca.displayAllBooks();
       verify(printStream).println("Harry Potter\nJava Master\nBarcelona Guide\n");
    }



}
