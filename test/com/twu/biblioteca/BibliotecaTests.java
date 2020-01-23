package com.twu.biblioteca;

import org.junit.Test;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.PrintStream;
import java.util.ArrayList;M

public class BibliotecaTests {



    @Test
    public void shouldPrintWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        ArrayList<Book> books = new ArrayList<Book>();
        Biblioteca biblioteca = new Biblioteca(books,printStream);

        biblioteca.displayWelcomeMessage();
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!");
    }

    @Test
    public void shouldPrintAllBooks() {
        PrintStream printStream = mock(PrintStream.class);
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Harry Potter"));
        books.add(new Book ("Java Master"));
        books.add(new Book ("Barcelona Guide"));


        Biblioteca biblioteca = new Biblioteca(books,printStream);
//        Book book1 = mock(Book.class);
//        Book book2 = mock(Book.class);
//        Book book3 = mock(Book.class);

//        when(book1.getTitle()).thenReturn("Harry Potter");
//        when(book2.getTitle()).thenReturn("Java");
//        when(book3.getTitle()).thenReturn("Barcelona Guide");


       biblioteca.displayAllBooks();
       verify(printStream).println("Harry Potter\nJava Master\nBarcelona Guide\n");



    }


}
