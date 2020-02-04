package com.twu.biblioteca;


public class Book extends Item {

    private String author;
    private String publicationDate;

    public Book(String title, String author, String publicationDate){
        super(title);
        this.author = author;
        this.publicationDate = publicationDate;

    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublicationDate() {
        return publicationDate;
    }
}