package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaFunctions {



    public void addBooksToTheList(ArrayList<Book> listOfBooks){
        listOfBooks.add(new Book("Growing Object-Oriented Software","Steve Freeman", 2010));
        listOfBooks.add(new Book("Working Effectively With Legacy Code","Michael C. Feathers", 2005));
        listOfBooks.add(new Book("xUnit Test Patterns: Refactoring Test Code","Gerard Meszaros", 2007));
        listOfBooks.add(new Book("Object-Oriented JavaScript","Ved Antani", 2017));
        listOfBooks.add(new Book("Patterns of Enterprise Application Architecture","Martin Fowler", 2003));
        listOfBooks.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin", 2009));
    }

    public void addOptionsToTheList(ArrayList<Option> listOfOptions){
        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "Return a Book"));
        listOfOptions.add(new Option(3, "Quit"));
    }

    public boolean verifyValidOption(String text){
        int number;
        try {
            number = Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
