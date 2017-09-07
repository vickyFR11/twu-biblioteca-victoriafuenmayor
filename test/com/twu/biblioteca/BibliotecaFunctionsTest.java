package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaFunctionsTest {

    private BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();
    private final ArrayList<Book> listOfBooks = new ArrayList<Book>();

    @Test
    public void successfulPrintOfOneBookList() {
        String detailsOfBook = "1) Growing Object-Oriented Software Steve Freeman 2010\n";

        listOfBooks.add(new Book(1,"Growing Object-Oriented Software", "Steve Freeman", 2010));

        String printedList = bibliotecaFunctions.print(listOfBooks);

        assertEquals(detailsOfBook, printedList);
    }

    @Test
    public void successfulPrintOfEmptyList() {
        String detailsOfBook = null;

        String printedList = bibliotecaFunctions.print(listOfBooks);

        assertEquals(detailsOfBook, printedList);
    }

    @Test
    public void successfulPrintBooksList() {
        String detailsOfBooks = "1) Growing Object-Oriented Software Steve Freeman 2010\n" +
                "2) Working Effectively With Legacy Code Michael C. Feathers 2005\n" +
                "3) xUnit Test Patterns: Refactoring Test Code Gerard Meszaros 2007\n";


        listOfBooks.add(new Book(1,"Growing Object-Oriented Software", "Steve Freeman", 2010));
        listOfBooks.add(new Book(2,"Working Effectively With Legacy Code", "Michael C. Feathers", 2005));
        listOfBooks.add(new Book(3,"xUnit Test Patterns: Refactoring Test Code", "Gerard Meszaros", 2007));

        String printedList = bibliotecaFunctions.print(listOfBooks);

        assertEquals(detailsOfBooks, printedList);
    }
}
