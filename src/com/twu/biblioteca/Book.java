package com.twu.biblioteca;


public class Book {

    private String title;
    private String author;
    private String publicationDate;

    public Book(String title, String author, String publicationDate){
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
}