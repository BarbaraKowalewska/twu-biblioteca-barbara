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

    @Test
    public void shouldEnableBookCheckoutWhenUserChooses3() throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        Biblioteca biblioteca = mock(Biblioteca.class);
        printStream = mock(PrintStream.class);
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("3");
        menu.display();
        verify(biblioteca, times(1)).checkoutBook();
    }





    }
