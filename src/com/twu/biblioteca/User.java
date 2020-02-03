package com.twu.biblioteca;

import java.util.*;

public class User {

    private String libraryCardNumber;
    private String password;
    private String name;
    private String email;
    private int phoneNumber;
    private ArrayList<Book> checkedBooks;

    public User(String libraryCardNumber, String password, String name, String email, int phoneNumber){
        this.libraryCardNumber = libraryCardNumber;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public String getPassword() {
        return password;
    }
}
