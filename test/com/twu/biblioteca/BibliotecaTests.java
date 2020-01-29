package com.twu.biblioteca;

import org.junit.Before;
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
    private Map<Book, Boolean> books;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        books = new LinkedHashMap<Book, Boolean>();
        biblioteca = new Biblioteca(books,printStream,bufferedReader);

    }


    @Test
    public void shouldPrintWelcomeMessage() {
        biblioteca.displayWelcomeMessage();
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!");
    }

    @Test
    public void shouldPrintAllAvailableBooks() {
        books.put(new Book("Harry Potter", "Jim", "1999"), true);
        books.put(new Book ("Java Master", "Kate", "2010"),false);
        books.put(new Book ("Barcelona Guide", "Jose", "2016"),true);

       biblioteca.displayAllBooks();

       verify(printStream).println("Harry Potter - Jim, 1999\nBarcelona Guide - Jose, 2016\n");
    }

    @Test
    public void shouldCheckoutBook()  throws IOException{
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        books.put(newBook, true);

        String input = "Harry Potter";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        biblioteca.checkoutBook();

        assertEquals(false, books.get(newBook));

    }

    @Test
    public void shouldShowErrorMessageWhenBookCannotBeCheckout() {
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        books.put(newBook, true);

        String input = "Clean Code";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        biblioteca.checkoutBook();

        verify(printStream).println("Sorry this book is not available");
    }

    @Test
    public void shouldReturnBook() {
        Book newBook = new Book ("Java Master", "Kate", "2010");
        books.put(new Book("Harry Potter", "Jim", "1999"), true);
        books.put(newBook, false);


        String input = "Java Master";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        biblioteca.returnBook();

        assertEquals(true, books.get(newBook));

    }

    @Test
    public void shouldShowErrorMessageWhenBookCannotBeReturned() {
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        books.put(newBook, false);

        String input = "Agile";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        biblioteca.returnBook();

        verify(printStream).println("This is not a valid book to return");

    }
}
