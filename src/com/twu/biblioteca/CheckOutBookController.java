package com.twu.biblioteca;

public class CheckOutBookController {

    private Biblioteca model;
    private Display view;

    public CheckOutBookController(Biblioteca model, Display view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        String title = this.view.askForBookTitleToCheckOut();

        Book rentedItem = this.model.tryCheckOutBookByTitle(title);

        if (rentedItem == null) {
            this.view.tellBookUnavailable();
        } else {
            this.view.confirmBookRental();
        }
    }
}
