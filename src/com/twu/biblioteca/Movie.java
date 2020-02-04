package com.twu.biblioteca;

public class Movie extends Item {

    private String director;
    private String year;
    private int rating;

    public Movie(String title, String director, String year, int rating){
        super(title);
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }
}
