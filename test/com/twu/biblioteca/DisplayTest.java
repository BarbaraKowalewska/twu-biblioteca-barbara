package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayTest {


    @Test
    public void shouldDisplayWelcomeMessage() {
        PrintStream printStream = mock(PrintStream.class);
        Display display = new Display(printStream);

        display.welcomeMessage();

        verify(printStream).println("Welcome to Biblioteca. Your one-stop-shop for great titles in Bangalore!");
    }


}
