package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.mock;

import java.io.*;
import java.util.*;

public class BibliotecaTests {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private BufferedReader bufferedReader;

    @Test
    public void shouldPrintWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        Map<Book, Boolean> books = new LinkedHashMap<Book, Boolean>();
        BufferedReader bufferedReader;
        bufferedReader = mock(BufferedReader.class);
        Biblioteca biblioteca = new Biblioteca(books,printStream,bufferedReader);

        biblioteca.displayWelcomeMessage();
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!");
    }

    @Test
    public void shouldPrintAllAvailableBooks() {
        PrintStream printStream = mock(PrintStream.class);
        Map<Book, Boolean> books = new LinkedHashMap<Book, Boolean>();
        books.put(new Book("Harry Potter", "Jim", "1999"), true);
        books.put(new Book ("Java Master", "Kate", "2010"),false);
        books.put(new Book ("Barcelona Guide", "Jose", "2016"),true);
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Biblioteca biblioteca = new Biblioteca(books,printStream,bufferedReader);

       biblioteca.displayAllBooks();
       verify(printStream).println("Harry Potter - Jim, 1999\nBarcelona Guide - Jose, 2016\n");
    }

    @Test
    public void shouldCheckoutBook()  throws IOException{

        Map<Book, Boolean> books = new LinkedHashMap<Book, Boolean>();
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        books.put(newBook, true);
        Biblioteca biblioteca = new Biblioteca(books, printStream, bufferedReader);

        String input = "Harry Potter";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        biblioteca.checkoutBook();

        assertEquals(false, books.get(newBook));

    }

    @Test
    public void shouldShowErrorMessageWhenBookCannotBeCheckout() {
        PrintStream printStream = mock(PrintStream.class);
        Map<Book, Boolean> books = new LinkedHashMap<Book, Boolean>();
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        books.put(newBook, true);
        Biblioteca biblioteca = new Biblioteca(books, printStream, bufferedReader);

        String input = "Clean Code";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        biblioteca.checkoutBook();
        verify(printStream).println("Sorry this book is not available");
    }

    @Test
    public void shouldReturnBook() {
        PrintStream printStream = mock(PrintStream.class);
        Map<Book, Boolean> books = new LinkedHashMap<Book, Boolean>();
        Book newBook = new Book ("Java Master", "Kate", "2010");
        books.put(new Book("Harry Potter", "Jim", "1999"), true);
        books.put(newBook, false);
        Biblioteca biblioteca = new Biblioteca(books, printStream, bufferedReader);

        String input = "Java Master";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        biblioteca.returnBook();
        assertEquals(true, books.get(newBook));

    }

    @Test
    public void shouldShowErrorMessageWhenBookCannotBeReturned() {
        PrintStream printStream = mock(PrintStream.class);
        Map<Book, Boolean> books = new LinkedHashMap<Book, Boolean>();
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        books.put(newBook, false);
        Biblioteca biblioteca = new Biblioteca(books, printStream, bufferedReader);

        String input = "Agile";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        biblioteca.returnBook();
        verify(printStream).println("This is not a valid book to return");

    }

}
