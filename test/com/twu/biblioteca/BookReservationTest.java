package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookReservationTest {

    private BibliotecaFunctions functions;
    private ArrayList<Book> listOfBooks;
    private ArrayList<Book> booksNotAvailable;

    @Before
    public void setUp() throws Exception {
        functions = new BibliotecaFunctions();
        listOfBooks = new ArrayList<Book>();
        booksNotAvailable = new ArrayList<Book>();

        listOfBooks.add(new Book("Growing Object-Oriented Software","Steve Freeman", 2010, false));
        listOfBooks.add(new Book("Working Effectively With Legacy Code","Michael C. Feathers", 2005));
        listOfBooks.add(new Book("xUnit Test Patterns: Refactoring Test Code","Gerard Meszaros", 2007));
        listOfBooks.add(new Book("Object-Oriented JavaScript","Ved Antani", 2017));
        listOfBooks.add(new Book("Patterns of Enterprise Application Architecture","Martin Fowler", 2003));
        listOfBooks.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin", 2009));

        booksNotAvailable = functions.getNotAvailableBooks(listOfBooks);
    }

    @Test
    public void successfulBookCheckOut(){
        ArrayList<Book> resultValue = functions.checkOutBook(1, listOfBooks);
        int countOfBooksAfterCheckOut = 4;

        assertEquals(countOfBooksAfterCheckOut, resultValue.size());
    }

    @Test
    public void unsuccessfulBookCheckOut(){
        ArrayList<Book> resultValue = functions.checkOutBook(0, listOfBooks);

        assertEquals(null, resultValue);

    }

    @Test
    public void returnBookSuccessfully(){
        boolean resultValue = functions.returnBook(0, listOfBooks);
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void returnBookUnsuccessfully(){
        boolean resultValue = functions.returnBook(4, booksNotAvailable);
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }
}
