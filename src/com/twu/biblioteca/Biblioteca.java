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
    private Map<User, ArrayList<Item>> rentedItems;

    public Biblioteca(Map<Book,Boolean> books, PrintStream printStream, BufferedReader bufferedReader, Map<Movie,Boolean> movies, Display display,List<User> allUsers) {
        this.printStream = printStream;
        this.allBooks = books;
        this.bufferedReader = bufferedReader;
        this.allMovies = movies;
        this.display = display;
        this.allUsers = allUsers;
        this.rentedItems = createRegister();

    }

    public Map<User, ArrayList<Item>> getRentedItems() {
        return rentedItems;
    }

    public void displayWelcomeMessage() {
        display.welcomeMessage();

    }

    public Map <Book, Boolean> getAllBooks() {
        return allBooks;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

        public Map<User, ArrayList<Item>> createRegister() {
        Map<User, ArrayList<Item>> rentedItems = new LinkedHashMap<>();

        for (User user : allUsers) {
            rentedItems.put(user, new ArrayList<>());
        }
        return rentedItems;
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
        for (User user: allUsers) {
            if (user.getLibraryCardNumber().equals(cardNumber)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }


    public void displayAllBooks() {
        List<Book> availableBooks = this.getAvailableBooks();

        display.showBooks(availableBooks);
    }


    public void displayAllMovies() {
        List<Movie> availableMovies = this.getAvailableMovies();
        display.showMovies(availableMovies);
    }

    public Book tryCheckOutBookByTitle(String title) {
        Book rentedItem = null;

        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = getAllBooks().entrySet().iterator();
        while (allBooksIterator.hasNext()) {
            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
            if (entry.getKey().getTitle().equals(title) && entry.getValue().equals(true)) {
                allBooks.put(entry.getKey(),false);
                rentedItem = entry.getKey();
            }
        }

        // TODO: take this into account when testing
        if (rentedItem != null) {
            this.assignRentedItemToUser(rentedItem);
        }
        return rentedItem;
    }

    public Book returnBook() {
        System.out.println("Which book do you want to return?");
        Scanner in = new Scanner(System.in);
        String bookToReturn = in.nextLine();
        Book returnedItem = null;

        Boolean bookCannotBeReturned = true;
        Iterator<Map.Entry<Book, Boolean>> allBooksIterator = getAllBooks().entrySet().iterator();
        while (allBooksIterator.hasNext()) {
            Map.Entry<Book, Boolean> entry = allBooksIterator.next();
            if (entry.getKey().getTitle().equals(bookToReturn) && entry.getValue().equals(false)) {
                System.out.println("Thank you for returning the book!");
                allBooks.put(entry.getKey(),true);
                bookCannotBeReturned = false;
                returnedItem = entry.getKey();

            }
        }
        if (bookCannotBeReturned.equals(true)){
            printStream.println("This is not a valid book to return");
        }
        return returnedItem;
    }

    public Movie checkoutMovie() {
        System.out.println("Which movie do you want to checkout?");
        Scanner in = new Scanner(System.in);
        String movieToCheckout = in.nextLine();
        Movie rentedItem = null;

        Iterator<Map.Entry<Movie, Boolean>> allMoviesIterator = allMovies.entrySet().iterator();
        Boolean movieNotAvailable = true;
        while (allMoviesIterator.hasNext()) {
            Map.Entry<Movie,Boolean> entry = allMoviesIterator.next();
            if (entry.getKey().getTitle().equals(movieToCheckout) && entry.getValue().equals(true)) {
                System.out.println("Thank you! Enjoy the movie");
                allMovies.put(entry.getKey(),false);
                movieNotAvailable = false;
                rentedItem = entry.getKey();
            }
        }
        if (movieNotAvailable.equals(true)){
            printStream.println("Sorry this movie is not available");
        }
        return rentedItem;
    }

    public void assignRentedItemToUser(Item rentedItem){
        rentedItems.get(currentUser).add(rentedItem);
    }

    public void deleteReturnedItemFromUser(Item returnedItem){
        rentedItems.get(currentUser).remove(returnedItem);
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
    public void displayRentedItems(){
        display.showRentedItems(rentedItems);
    }
}

