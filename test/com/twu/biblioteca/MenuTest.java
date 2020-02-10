package com.twu.biblioteca;

import com.sun.tools.javac.comp.Check;
import org.junit.Before;
import org.junit.Ignore;
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
    private Menu menu;
    private CheckOutBookController checkOutBookController;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        books = new LinkedHashMap<Book, Boolean>();
        biblioteca = mock(Biblioteca.class);
        checkOutBookController = mock(CheckOutBookController.class);

        menu = new Menu(bufferedReader, biblioteca, printStream, checkOutBookController);
    }

    @Test
    public void shouldDisplayAllBooksWhenUserChooses1() throws IOException {
        when(bufferedReader.readLine()).thenReturn("1");

        menu.display();

        verify(biblioteca, times(1)).displayAllBooks();
    }

    @Test
    public void shouldDisplayErrorMessageWhenUserChoosesInvalidOption() throws  IOException {
        when(bufferedReader.readLine()).thenReturn("9");

        menu.display();

        verify(printStream).println("Please select a valid option!");
    }

    @Test
    public void shouldEnableBookCheckoutWhenUserChooses5() throws IOException {
        when(bufferedReader.readLine()).thenReturn("5");

        menu.display();

        verify(checkOutBookController, times(1)).start();
    }

    @Test
    public void shouldEnableBookReturnWhenUserChooses7() throws IOException {
        when(bufferedReader.readLine()).thenReturn("7");

        menu.display();

        verify(biblioteca, times(1)).returnBook();
    }

    @Test
    public void shouldDisplayAllMoviesWhenUserChooses2() throws IOException {
        when(bufferedReader.readLine()).thenReturn("2");

        menu.display();

        verify(biblioteca, times(1)).displayAllMovies();
    }

    @Test
    public void shouldEnableBookCheckoutWhenUserChooses6() throws IOException {
        when(bufferedReader.readLine()).thenReturn("6");

        menu.display();

        verify(biblioteca, times(1)).checkoutMovie();
    }

}




