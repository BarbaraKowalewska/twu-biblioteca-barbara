package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.*;

public class Register {

    private Biblioteca biblioteca;
    private PrintStream printStream;
    private Map<User, ArrayList<Item>> rentedItems;

    public Register(Biblioteca biblioteca, PrintStream printStream,Map<User, ArrayList<Item>> rentedItems){
        this.biblioteca = biblioteca;
        this.printStream = printStream;
        this.rentedItems = rentedItems;

    }

//    public Map<User, List<Item>> createRegister() {
//        Map<User, List<Item>> rentedItems = new LinkedHashMap<>();
//
//        for (User user : biblioteca.getAllUsers()) {
//            rentedItems.put(user, new LinkedList<>());
//        }
//        return rentedItems;
//    }


//    public void checkoutBook() {
//        printStream.println("Which book do you want to checkout?");
//        Scanner in = new Scanner(System.in);
//        String bookToCheckout = in.nextLine();
//
//        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = biblioteca.getAllBooks().entrySet().iterator();
//        Boolean bookNotAvailable = true;
//        while (allBooksIterator.hasNext()) {
//            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
//            if (entry.getKey().getTitle().equals(bookToCheckout) && entry.getValue().equals(true)) {
//                System.out.println("Thank you! Enjoy the book");
//                rentedItems.get(Biblioteca.currentUser).add(entry.getKey());
//                ArrayList list = rentedItems.get(Biblioteca.currentUser);
//                for (Object item:list){
//                    System.out.println(((Book)item).title);
//                }
//
//                biblioteca.getAllBooks().put(entry.getKey(),false);
//                bookNotAvailable = false;
//
//
//            }
//        }
//        if (bookNotAvailable.equals(true)){
//            printStream.println("Sorry this book is not available");
//        }
//    }
//



}
