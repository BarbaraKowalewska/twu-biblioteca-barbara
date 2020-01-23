package com.twu.biblioteca;

import org.junit.Test;
import static org.mockito.Mockito.*;

import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BibliotecaTests {



    @Test
    public void shouldPrintWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        Biblioteca biblioteca = new Biblioteca(printStream);

        biblioteca.displayWelcomeMessage();


        //assertThat(biblioteca.displayWelcomeMessage(), is("Welcome"));
        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!");


    }

}
