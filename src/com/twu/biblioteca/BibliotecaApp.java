package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        String text = "";
        int option = 0;
        BibliotecaFunctions functions = new BibliotecaFunctions();
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        ArrayList<Option> listOfOptions = new ArrayList<Option>();

        functions.addBooksToTheList(listOfBooks);
        functions.addOptionsToTheList(listOfOptions);

        Scanner read = new Scanner(System.in);

        do {
            System.out.println("Welcome to Biblioteca!");
            System.out.println("Select one of the following options: ");
            listOfOptions.get(0).printListOfOptions(listOfOptions);

            option = read.nextInt();

        }while ((option != 3));


    }
}
