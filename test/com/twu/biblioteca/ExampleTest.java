package com.twu.biblioteca;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ExampleTest {


    public void test() {
        assertEquals(1, 1);
    }

    @Test
    public void successfulOptionSelectionAtMainMenu(){
        ArrayList<Option> listOfOptions = new ArrayList<Option>();
        BibliotecaFunctions functions = new BibliotecaFunctions();

        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "Check-Out a Book"));
        listOfOptions.add(new Option(3, "Return a Book"));
        listOfOptions.add(new Option(4, "Quit"));

        boolean resultValue = functions.verifyValidOption("2", listOfOptions.size());
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void outOfRangeOptionSelectionAtMainMenu(){
        ArrayList<Option> listOfOptions = new ArrayList<Option>();
        BibliotecaFunctions functions = new BibliotecaFunctions();

        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "Check-Out a Book"));
        listOfOptions.add(new Option(3, "Return a Book"));
        listOfOptions.add(new Option(4, "Quit"));

        boolean resultValue = functions.verifyValidOption("8", listOfOptions.size());
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void insertTextAsOptionAtMainMenu(){
        ArrayList<Option> listOfOptions = new ArrayList<Option>();
        BibliotecaFunctions functions = new BibliotecaFunctions();

        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "Check-Out a Book"));
        listOfOptions.add(new Option(3, "Return a Book"));
        listOfOptions.add(new Option(4, "Quit"));

        boolean resultValue = functions.verifyValidOption("hola", listOfOptions.size());
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void successfulBookCheckOut(){
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        BibliotecaFunctions functions = new BibliotecaFunctions();

        listOfBooks.add(new Book("Growing Object-Oriented Software","Steve Freeman", 2010));
        listOfBooks.add(new Book("Working Effectively With Legacy Code","Michael C. Feathers", 2005));
        listOfBooks.add(new Book("xUnit Test Patterns: Refactoring Test Code","Gerard Meszaros", 2007));
        listOfBooks.add(new Book("Object-Oriented JavaScript","Ved Antani", 2017));
        listOfBooks.add(new Book("Patterns of Enterprise Application Architecture","Martin Fowler", 2003));
        listOfBooks.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin", 2009));

        boolean resultValue = functions.checkOutBook(1, listOfBooks);
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);

    }

    @Test
    public void unsuccessfulBookCheckOut(){
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        BibliotecaFunctions functions = new BibliotecaFunctions();

        listOfBooks.add(new Book("Growing Object-Oriented Software","Steve Freeman", 2010, false));
        listOfBooks.add(new Book("Working Effectively With Legacy Code","Michael C. Feathers", 2005));
        listOfBooks.add(new Book("xUnit Test Patterns: Refactoring Test Code","Gerard Meszaros", 2007));
        listOfBooks.add(new Book("Object-Oriented JavaScript","Ved Antani", 2017));
        listOfBooks.add(new Book("Patterns of Enterprise Application Architecture","Martin Fowler", 2003));
        listOfBooks.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin", 2009));

        boolean resultValue = functions.checkOutBook(0, listOfBooks);
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);

    }

    @Test
    public void returnBookSuccessfully(){
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        BibliotecaFunctions functions = new BibliotecaFunctions();

        listOfBooks.add(new Book("Growing Object-Oriented Software","Steve Freeman", 2010));
        listOfBooks.add(new Book("Working Effectively With Legacy Code","Michael C. Feathers", 2005));
        listOfBooks.add(new Book("xUnit Test Patterns: Refactoring Test Code","Gerard Meszaros", 2007, false));
        listOfBooks.add(new Book("Object-Oriented JavaScript","Ved Antani", 2017));
        listOfBooks.add(new Book("Patterns of Enterprise Application Architecture","Martin Fowler", 2003));
        listOfBooks.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin", 2009));

        boolean resultValue = functions.returnBook(2, listOfBooks);
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void returnBookUnsuccessfully(){
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        BibliotecaFunctions functions = new BibliotecaFunctions();

        listOfBooks.add(new Book("Growing Object-Oriented Software","Steve Freeman", 2010));
        listOfBooks.add(new Book("Working Effectively With Legacy Code","Michael C. Feathers", 2005));
        listOfBooks.add(new Book("xUnit Test Patterns: Refactoring Test Code","Gerard Meszaros", 2007));
        listOfBooks.add(new Book("Object-Oriented JavaScript","Ved Antani", 2017));
        listOfBooks.add(new Book("Patterns of Enterprise Application Architecture","Martin Fowler", 2003));
        listOfBooks.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin", 2009));

        boolean resultValue = functions.returnBook(1, listOfBooks);
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }



}
