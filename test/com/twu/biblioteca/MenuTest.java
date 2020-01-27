package com.twu.biblioteca;

import com.twu.biblioteca.Biblioteca;
import com.twu.biblioteca.Menu;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MenuTest {

    private PrintStream printStream;

    @Test
    public void shouldDisplayAllBooksWhenUserChooses1() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Biblioteca biblioteca = mock(Biblioteca.class);
        printStream = mock(PrintStream.class);
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("1");
        menu.display();
        verify(biblioteca, times(1)).displayAllBooks();
    }

    @Test
    public void shouldDisplayErrorMessageWhenUserChoosesInvalidOption() throws  IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Biblioteca biblioteca = mock(Biblioteca.class);
        printStream = mock(PrintStream.class);
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("6");
        menu.display();
        verify(printStream).println("Please select a valid option!");

    }

//    @Test
//    public void shouldCheckoutBookWhenChosen() throws IOException {
//        // user chooses a book
//        // book is no longer available
//        Biblioteca biblioteca = mock(Biblioteca.class);
//        BufferedReader bufferedReader = mock(BufferedReader.class);
//        when(bufferedReader.readLine()).thenReturn("Harry Potter");
//        biblioteca.checkoutBook();
//
//
//        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = biblioteca.getAllBooks().entrySet().iterator();
//        while (allBooksIterator.hasNext()) {
//            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
//            if (entry.getKey().getTitle() == "Harry Potter" && entry.getValue() == false) {
//
//        }
//
//        }










    }
