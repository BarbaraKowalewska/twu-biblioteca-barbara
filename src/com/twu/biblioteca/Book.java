package com.twu.biblioteca;

import java.util.ArrayList;

public class Book {

    private String title;


    //public static ArrayList<Book> allBooks;
//    ArrayList<Book> allBooks = new ArrayList<Book>();

    public Book(String title){
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}