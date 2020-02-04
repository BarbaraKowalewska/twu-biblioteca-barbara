package com.twu.biblioteca;



import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.*;


public class Biblioteca {

    static User currentUser;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private Map<Book, Boolean> allBooks;
    private Map<Movie,Boolean> allMovies;
    private Display display;
    private List<User> allUsers;

    public Biblioteca(Map<Book,Boolean> books, PrintStream printStream, BufferedReader bufferedReader, Map<Movie,Boolean> movies, Display display,List<User> allUsers) {
        this.printStream = printStream;
        this.allBooks = books;
        this.bufferedReader = bufferedReader;
        this.allMovies = movies;
        this.display = display;
        this.allUsers = allUsers;

    }

    public void displayWelcomeMessage() {
        display.welcomeMessage();

    }

    public Map <Book, Boolean> getAllBooks() {
        return allBooks;
    }
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList();
        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = allBooks.entrySet().iterator();
        while (allBooksIterator.hasNext()) {
            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
            if (entry.getValue().equals(true)) {
                availableBooks.add(entry.getKey());
            }
        }
        return availableBooks;
    }

    public List<Movie> getAvailableMovies() {
        List<Movie> availableMovies = new ArrayList<>();
        Iterator<Map.Entry<Movie, Boolean>> allMoviesIterator = allMovies.entrySet().iterator();
        while (allMoviesIterator.hasNext()) {
            Map.Entry<Movie, Boolean> entry = allMoviesIterator.next();
            if (entry.getValue().equals(true)) {
                availableMovies.add(entry.getKey());
            }
        }
        return availableMovies;
    }

    public Map<String,String> getUsersCredentials(){
        Map<String,String> usersCredentials = new LinkedHashMap<String , String>();
        for (User user: allUsers){
            usersCredentials.put(user.getLibraryCardNumber(),user.getPassword());
        }
        return usersCredentials;
    }

    public User getUserByCardNumber(String cardNumber){
        List<User> temp = new LinkedList<>();
        for (User user: allUsers){
            if(user.getLibraryCardNumber().equals(cardNumber)){
               temp.add(user);
            }
        }
        return temp.get(0);
    }



    public void displayAllBooks() {
        List<Book> availableBooks = this.getAvailableBooks();

        display.showBooks(availableBooks);
    }


    public void displayAllMovies() {
        List<Movie> availableMovies = this.getAvailableMovies();

        display.showMovies(availableMovies);

    }


    public void checkoutBook() {
        printStream.println("Which book do you want to checkout?");
        Scanner in = new Scanner(System.in);
        String bookToCheckout = in.nextLine();

        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = getAllBooks().entrySet().iterator();
        Boolean bookNotAvailable = true;
        while (allBooksIterator.hasNext()) {
            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
            if (entry.getKey().getTitle().equals(bookToCheckout) && entry.getValue().equals(true)) {
                System.out.println("Thank you! Enjoy the book");
                allBooks.put(entry.getKey(),false);
                bookNotAvailable = false;
            }
        }
        if (bookNotAvailable.equals(true)){
            printStream.println("Sorry this book is not available");
        }
    }

    public void returnBook() {
        System.out.println("Which book do you want to return?");
        Scanner in = new Scanner(System.in);
        String bookToReturn = in.nextLine();

        Boolean bookCannotBeReturned = true;
        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = getAllBooks().entrySet().iterator();
        while (allBooksIterator.hasNext()) {
            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
            if (entry.getKey().getTitle().equals(bookToReturn) && entry.getValue().equals(false)) {
                System.out.println("Thank you for returning the book!");
                allBooks.put(entry.getKey(),true);
                bookCannotBeReturned = false;
            }
        }
        if (bookCannotBeReturned.equals(true)){
            printStream.println("This is not a valid book to return");
        }

    }

    public void checkoutMovie() {
        System.out.println("Which movie do you want to checkout?");
        Scanner in = new Scanner(System.in);
        String movieToCheckout = in.nextLine();

        Iterator<Map.Entry<Movie, Boolean>> allMoviesIterator = allMovies.entrySet().iterator();
        Boolean movieNotAvailable = true;
        while (allMoviesIterator.hasNext()) {
            Map.Entry<Movie,Boolean> entry = allMoviesIterator.next();
            if (entry.getKey().getTitle().equals(movieToCheckout) && entry.getValue().equals(true)) {
                System.out.println("Thank you! Enjoy the movie");
                allMovies.put(entry.getKey(),false);
                movieNotAvailable = false;

            }
        }
        if (movieNotAvailable.equals(true)){
            printStream.println("Sorry this movie is not available");
        }
    }

    public String askForCardNumber(){
        System.out.println("What is your Biblioteca Card Number?");
        Scanner cardNumber = new Scanner(System.in);
        return cardNumber.nextLine();

    }

    public String askForPassword(){
        System.out.println("What is your password?");
        Scanner password = new Scanner(System.in);
        return password.nextLine();
    }


    public boolean loginAuthentication(String cardNumber, String password) {

        return getUsersCredentials().get(cardNumber).equals(password);
    }

    public void login(){
        String cardNumber = askForCardNumber();
        String password = askForPassword();
        if (loginAuthentication(cardNumber,password)){
            System.out.println("You are logged in!");
            currentUser = getUserByCardNumber(cardNumber);
        } else {
            System.out.println("Sorry, we don't have such user!");
        }

    }

    public void userInformation() {
        System.out.println("name: "+ currentUser.getName()+"\nemail: " + currentUser.getEmail()+"\nphone number:"+ currentUser.getPhoneNumber());
    }
}

