package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        String text = "";
        int option = 0, index = 0;
        BibliotecaFunctions functions = new BibliotecaFunctions();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Option> listOfOptions = new ArrayList<Option>();

        functions.addBooksToTheList(listOfBooks);
        functions.addOptionsToTheList(listOfOptions);

        Scanner read = new Scanner(System.in);

        do {
            System.out.println("");
            System.out.println("Welcome to Biblioteca!");
            System.out.println("Select one of the following options: ");
            functions.printListOfOptions(listOfOptions);

            text = read.next();
            if (functions.verifyValidOption(text, listOfOptions.size())) {
                option = Integer.parseInt(text);

                if (option == 1) {
                    functions.printAvailableBooks(listOfBooks);

                } else if (option == 2) {

                    System.out.println("Enter the number of the book to Check-Out: ");

                    text = read.next();

                    if (functions.verifyValidOption(text, listOfBooks.size())){
                        index = Integer.parseInt(text);
                        if (functions.checkOutBook(index-1, listOfBooks) != null){
                            System.out.println("THANK YOU! ENJOY YOUR BOOK.");
                        }else{
                            System.out.println("THAT BOOK IS NOT AVAILABLE");
                        }
                    }else{
                        System.out.println("THAT BOOK IS NOT AVAILABLE");
                    }

                }else if(option == 3){
                    if (functions.isAnyBookToReturn(listOfBooks)){
                        functions.printNotAvailableBooks(functions.getNotAvailableBooks(listOfBooks));
                        System.out.println("Enter the number of the book to return: ");

                        text = read.next();

                        if (functions.verifyValidOption(text, functions.getNotAvailableBooks(listOfBooks).size())){
                            index = Integer.parseInt(text);
                            if (functions.returnBook(index-1, functions.getNotAvailableBooks(listOfBooks))){
                                System.out.println("THANK YOU FOR RETURNING THE BOOK!");
                            }else{
                                System.out.println("THAT BOOK IS NOT A VALID BOOK TO RETURN");
                            }
                        }else{
                            System.out.println("THAT BOOK IS NOT A VALID BOOK TO RETURN");
                        }
                    }else{
                        System.out.println("NO BOOKS TO RETURN");
                    }

                }

            }else{
                System.out.println("SELECT A VALID OPTION");
                System.out.println("");
            }


        }while ((option != listOfOptions.size()));


    }
}
