package com.twu.biblioteca;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    private BibliotecaFunctions functions;
    private ArrayList<Option> listOfOptions;
    private ArrayList<Book> listOfBooks;

    @Before
    public void setUp() throws Exception {
        listOfBooks = new ArrayList<Book>();
        listOfOptions = new ArrayList<Option>();
        functions = new BibliotecaFunctions();

        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "Check-Out a Book"));
        listOfOptions.add(new Option(3, "Return a Book"));
        listOfOptions.add(new Option(4, "Quit"));

        listOfBooks.add(new Book("Growing Object-Oriented Software","Steve Freeman", 2010, false));
        listOfBooks.add(new Book("Working Effectively With Legacy Code","Michael C. Feathers", 2005));
        listOfBooks.add(new Book("xUnit Test Patterns: Refactoring Test Code","Gerard Meszaros", 2007, false));
        listOfBooks.add(new Book("Object-Oriented JavaScript","Ved Antani", 2017));
        listOfBooks.add(new Book("Patterns of Enterprise Application Architecture","Martin Fowler", 2003));
        listOfBooks.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin", 2009));
    }

    @Test
    public void successfulOptionSelectionAtMainMenu(){
        boolean resultValue = functions.verifyValidOption("2", listOfOptions.size());
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void outOfRangeOptionSelectionAtMainMenu(){
        boolean resultValue = functions.verifyValidOption("8", listOfOptions.size());
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void insertTextAsOptionAtMainMenu(){
        boolean resultValue = functions.verifyValidOption("hola", listOfOptions.size());
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void successfulBookCheckOut(){
        boolean resultValue = functions.checkOutBook(1, listOfBooks);
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);

    }

    @Test
    public void unsuccessfulBookCheckOut(){
        boolean resultValue = functions.checkOutBook(0, listOfBooks);
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);

    }

    @Test
    public void returnBookSuccessfully(){
        boolean resultValue = functions.returnBook(2, listOfBooks);
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void returnBookUnsuccessfully(){
        boolean resultValue = functions.returnBook(4, listOfBooks);
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }



}
