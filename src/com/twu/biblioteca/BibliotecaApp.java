package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        String text;
        int option = 0, index;
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> notAvailableBooks;
        ArrayList<Option> listOfOptions = new ArrayList<Option>();
        ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
        ArrayList<User> listOfUsers = new ArrayList<User>();
        User userLogged = null;
        BookTransaction booksFunction = new BookTransaction();
        UserFunctions userFunctions = new UserFunctions();
        Print printFunction = new Print();
        MenuFunctions menuFunctions = new MenuFunctions();
        MovieFunctions movieFunctions = new MovieFunctions();

        booksFunction.addBooksToTheList(availableBooks);
        menuFunctions.addOptionsToTheList(listOfOptions);
        movieFunctions.addMoviesToTheList(listOfMovies);
        userFunctions.addUsersToTheList(listOfUsers);

        Scanner read = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("Welcome to Biblioteca!");
            System.out.println("Select one of the following options: ");
            System.out.println(printFunction.printListOfOptions(listOfOptions));

            text = read.next();
            if (menuFunctions.verifyValidOption(text, listOfOptions.size())) {
                option = Integer.parseInt(text);

                if (option == 1) {
                    System.out.println(printFunction.printBooks(booksFunction.getAvailableBooks(availableBooks)));

                } else if (option == 2) {
                    System.out.println(printFunction.printMovies(listOfMovies));

                } else if (option == 3) {
                    System.out.println("Please login");
                    System.out.println("Enter your Library Number (xxx-xxxx): ");
                    String libraryNumber = read.next();
                    System.out.println("Enter your Password: ");
                    String userPassword = read.next();

                    userLogged = userFunctions.userLogin(libraryNumber, userPassword, listOfUsers, listOfOptions);
                    if (userLogged != null) {
                        System.out.println("Enter the number of the book to Check-Out: ");

                        text = read.next();

                        if (menuFunctions.verifyValidOption(text, availableBooks.size())) {
                            index = Integer.parseInt(text);
                            ArrayList<Book> books = booksFunction.checkOutBook(index - 1, availableBooks);
                            if (books != null) {
                                System.out.println("THANK YOU! ENJOY YOUR BOOK.");
                                availableBooks = books;
                            } else {
                                System.out.println("THAT BOOK IS NOT AVAILABLE");
                            }
                        } else {
                            System.out.println("THAT BOOK IS NOT AVAILABLE");
                        }
                    } else {
                        System.out.println("INCORRECT USER OR PASSWORD");
                    }


                } else if (option == 4) {
                    System.out.println("Enter the number of the movie to Check-Out: ");

                    text = read.next();

                    if (menuFunctions.verifyValidOption(text, listOfMovies.size())) {
                        index = Integer.parseInt(text);
                        if (movieFunctions.checkOutMovie(index, listOfMovies)) {
                            System.out.println("THANK YOU! ENJOY YOUR MOVIE.");
                        } else {
                            System.out.println("THAT MOVIE IS NOT AVAILABLE");
                        }
                    } else {
                        System.out.println("THAT MOVIE IS NOT AVAILABLE");
                    }

                } else if (option == 5) {
                    notAvailableBooks = booksFunction.getNotAvailableBooks(availableBooks);
                    if (booksFunction.booksToReturn(notAvailableBooks)) {
                        System.out.println(printFunction.printBooks(notAvailableBooks));

                        System.out.println("Enter the number of the book to return: ");

                        text = read.next();

                        if (menuFunctions.verifyValidOption(text, availableBooks.size())) {
                            index = Integer.parseInt(text);
                            if (booksFunction.returnBook(index, notAvailableBooks)) {
                                System.out.println("THANK YOU FOR RETURNING THE BOOK!");
                            } else {
                                System.out.println("THAT BOOK IS NOT A VALID BOOK TO RETURN");
                            }
                        } else {
                            System.out.println("THAT BOOK IS NOT A VALID BOOK TO RETURN");
                        }
                    } else {
                        System.out.println("NO BOOKS TO RETURN");
                    }
                } else if (option == 6) {

                    System.out.println("User:" + userFunctions.getUserInformation(userLogged.getUserId(), listOfUsers));

                }

            } else {
                System.out.println("SELECT A VALID OPTION");
                System.out.println("");
            }


        } while ((option != listOfOptions.size()));


    }
}
