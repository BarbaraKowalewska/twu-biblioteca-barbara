package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;


import static org.mockito.Mockito.mock;

import java.io.*;
import java.util.*;

public class BibliotecaTests {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private BufferedReader bufferedReader;
    private Map<Book, Boolean> books;
    private Map<Movie,Boolean> movies;
    private Display display;
    private List<User> users;
    private User newUser;


    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        books = new LinkedHashMap<Book, Boolean>();
        movies = new LinkedHashMap<Movie,Boolean>();
        users = new LinkedList<>();
        newUser = new User ("11-1234","kot","Kate", "kate@gmail.com",765234987);
        users.add(newUser);
        User anotherUser = new User("22-2345","pies","Tom", "tom@gmail.com",765876871);
        users.add(anotherUser);

        display = new Display(printStream);
        biblioteca = new Biblioteca(books,printStream,bufferedReader,movies,display,users);
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
        Biblioteca.currentUser = newUser;

        System.out.println(biblioteca.getRentedItems());

        Book result = biblioteca.tryCheckOutBookByTitle(input);

        assertEquals(newBook, result);
        assertEquals(false, books.get(newBook));

    }

    @Test
    public void shouldShowErrorMessageWhenBookCannotBeCheckout() {
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        books.put(newBook, true);
        String input = "Clean Code";

        Book result = biblioteca.tryCheckOutBookByTitle(input);

        assertNull(result);
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

    @Test
    public void shouldDisplayAllAvailableMovies(){

        movies.put(new Movie("Sabrina","John","1990", 8), true);
        movies.put(new Movie("Kot","John","1995", 10), true);

        biblioteca.displayAllMovies();

        verify(printStream).println("Sabrina - John, 1990 rating: 8\nKot - John, 1995 rating: 10\n");

    }

    @Test
    public void shouldCheckoutMovie()  throws IOException{
        Movie newMovie = new Movie("Sabrina","John","1990", 8);

        movies.put(newMovie, true);

        String input = "Sabrina";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        biblioteca.checkoutMovie();

        assertEquals(false, movies.get(newMovie));

    }

    @Test
    public void shouldCheckIfUserCredentialsAreCorrect() {

        String cardNumber = "11-1234";
        String password = "kot";

        assertEquals(true,biblioteca.loginAuthentication(cardNumber,password));

    }

    @Test
    public void ShouldDeleteBookFromRentedItemsWhenUserReturnTheBook(){
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        biblioteca.getRentedItems().get(newUser).add(newBook);
        Biblioteca.currentUser = newUser;
        Item returnedItem = newBook;
        biblioteca.deleteReturnedItemFromUser(newBook);

        assertEquals(false,biblioteca.getRentedItems().get(newUser).contains(newBook));
    }

    @Test
    public void ShouldAddBookToRentedItemsWhenUserCheckoutTheBook(){
        Book newBook = new Book("Harry Potter", "Jim", "1999");
        Biblioteca.currentUser = newUser;
        Item returnedItem = newBook;
        biblioteca.assignRentedItemToUser(newBook);

        assertEquals(true,biblioteca.getRentedItems().get(newUser).contains(newBook));
    }



}
