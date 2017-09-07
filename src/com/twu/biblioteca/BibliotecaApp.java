package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        String text = "";
        int option = 0, index = 0;
        BibliotecaFunctions functions = new BibliotecaFunctions();
        ArrayList<Book> availableBooks = new ArrayList<Book>();
        ArrayList<Book> notAvailableBooks = new ArrayList<Book>();
        ArrayList<Option> listOfOptions = new ArrayList<Option>();

        functions.addBooksToTheList(availableBooks);
        functions.addOptionsToTheList(listOfOptions);

        Scanner read = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("Welcome to Biblioteca!");
            System.out.println("Select one of the following options: ");
            System.out.println(functions.printListOfOptions(listOfOptions));

            text = read.next();
            if (functions.verifyValidOption(text, listOfOptions.size())) {
                option = Integer.parseInt(text);

                if (option == 1) {
                    System.out.println(functions.print(functions.getAvailableBooks(availableBooks)));

                } else if (option == 2) {

                    System.out.println("Enter the number of the book to Check-Out: ");

                    text = read.next();

                    if (functions.verifyValidOption(text, availableBooks.size())) {
                        index = Integer.parseInt(text);
                        ArrayList<Book> books = functions.checkOutBook(index - 1, availableBooks);
                        if (books != null) {
                            System.out.println("THANK YOU! ENJOY YOUR BOOK.");
                            availableBooks = books;
                        } else {
                            System.out.println("THAT BOOK IS NOT AVAILABLE");
                        }
                    } else {
                        System.out.println("THAT BOOK IS NOT AVAILABLE");
                    }

                } else if (option == 3) {
                    notAvailableBooks = functions.getNotAvailableBooks(availableBooks);
                    if (functions.booksToReturn(notAvailableBooks)) {
                        System.out.println(functions.print(notAvailableBooks));

                        System.out.println("Enter the number of the book to return: ");

                        text = read.next();

                        if (functions.verifyValidOption(text, notAvailableBooks.size())) {
                            index = Integer.parseInt(text);
                            if (functions.returnBook(index - 1, notAvailableBooks)) {
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

                }

            } else {
                System.out.println("SELECT A VALID OPTION");
                System.out.println("");
            }


        } while ((option != listOfOptions.size()));


    }
}
