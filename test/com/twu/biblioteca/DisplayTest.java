package com.twu.biblioteca;

import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
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

    @Test
    public void shouldDisplayUsersAndTheirRentedItems() {
        PrintStream printStream = mock(PrintStream.class);
        Display display = new Display(printStream);
        Map<User, ArrayList<Item>> rentedItemsPerUser = new LinkedHashMap<>();
        User user1 = new User("11-1234","kot","Kate", "kate@gmail.com",765234987);
        User user2 = new User("22-2345","pies","Tom", "tom@gmail.com",765876871);
        User user3 = new User ("33-3456","ryba","Jose", "jose@gmail.com",635412987);
        Book book1 = new Book("Harry Potter", "Jim", "1999");
        Book book2 = new Book ("Agile", "Jose", "2016");
        Movie movie1 = new Movie("Sabrina","John","1995",8);
        Movie movie2 = new Movie("Shrek","Alla","2015",10);
        ArrayList<Item> list1 = new ArrayList<>();
        list1.add(book1);
        ArrayList<Item> list2 = new ArrayList<>();
        list2.add(book2);
        list2.add(movie2);
        ArrayList<Item> list3 = new ArrayList<>();
        list3.add(movie1);
        rentedItemsPerUser.put(user1,list1);
        rentedItemsPerUser.put(user2,list2);
        rentedItemsPerUser.put(user3,list3);

        String output ="Kate rented: Harry Potter, \n" +"Tom rented: Agile, Shrek, \n" + "Jose rented: Sabrina, \n";

        assertEquals(output, display.showRentedItems(rentedItemsPerUser));





    }


}
