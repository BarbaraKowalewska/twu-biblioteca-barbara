package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

public class MenuTest {

    private BufferedReader bufferedReader;
    private PrintStream printStream;
    private Map<Book, Boolean> books;
    private Biblioteca biblioteca;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        books = new LinkedHashMap<Book, Boolean>();
        biblioteca = mock(Biblioteca.class);
    }

    @Test
    public void shouldDisplayAllBooksWhenUserChooses1() throws IOException {
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("1");

        menu.display();

        verify(biblioteca, times(1)).displayAllBooks();
    }

    @Test
    public void shouldDisplayErrorMessageWhenUserChoosesInvalidOption() throws  IOException {
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("9");

        menu.display();

        verify(printStream).println("Please select a valid option!");
    }

    @Test
    public void shouldEnableBookCheckoutWhenUserChooses3() throws IOException {
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("3");

        menu.display();

        verify(biblioteca, times(1)).checkoutBook();
    }

    @Test
    public void shouldEnableBookReturnWhenUserChooses4() throws IOException {
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("4");

        menu.display();

        verify(biblioteca, times(1)).returnBook();
    }

    @Test
    public void shouldDisplayAllMoviesWhenUserChooses5() throws IOException {
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("5");

        menu.display();

        verify(biblioteca, times(1)).displayAllMovies();
    }

    @Test
    public void shouldEnableBookCheckoutWhenUserChooses6() throws IOException {
        Menu menu = new Menu(bufferedReader, biblioteca, printStream);
        when(bufferedReader.readLine()).thenReturn("6");

        menu.display();

        verify(biblioteca, times(1)).checkoutMovie();
    }

}




