package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookReservationTest {

    private BookTransaction functions;
    private ArrayList<Book> listOfBooks;
    private ArrayList<Book> booksNotAvailable;

    @Before
    public void setUp() throws Exception {
        functions = new BookTransaction();
        listOfBooks = new ArrayList<Book>();
        booksNotAvailable = new ArrayList<Book>();

        listOfBooks.add(new Book(1,"Growing Object-Oriented Software", "Steve Freeman", 2010, false));
        listOfBooks.add(new Book(2,"Working Effectively With Legacy Code", "Michael C. Feathers", 2005, true));
        listOfBooks.add(new Book(3,"xUnit Test Patterns: Refactoring Test Code", "Gerard Meszaros", 2007, true));
        listOfBooks.add(new Book(4,"Object-Oriented JavaScript", "Ved Antani", 2017, true));
        listOfBooks.add(new Book(5,"Patterns of Enterprise Application Architecture", "Martin Fowler", 2003, true));
        listOfBooks.add(new Book(6,"Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2009, true));

        booksNotAvailable = functions.getNotAvailableBooks(listOfBooks);
    }


    @Test
    public void successfulBookCheckOut() {
        ArrayList<Book> resultValue = functions.checkOutBook(1, listOfBooks);
        boolean isAvailable = false;

        assertEquals(isAvailable, resultValue.get(1).getAvailability());
    }

    @Test
    public void unsuccessfulBookCheckOut() {
        ArrayList<Book> resultValue = functions.checkOutBook(0, listOfBooks);

        assertEquals(null, resultValue);

    }

    @Test
    public void isThereAnyBookToReturn() {
        boolean resultValue = functions.booksToReturn(listOfBooks);
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void returnBookSuccessfully() {
        boolean resultValue = functions.returnBook(1, listOfBooks);
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void returnBookUnsuccessfully() {
        boolean resultValue = functions.returnBook(4, booksNotAvailable);
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void successfulGetBookById() {
        int bookId = 2;
        Book expectedBook = new Book(2,"Working Effectively With Legacy Code", "Michael C. Feathers", 2005, true);

        Book returnedBook = functions.getBook(bookId, listOfBooks);

        assertEquals(expectedBook.toString(), returnedBook.toString());
    }

    @Test
    public void unsuccessfulGetBookById() {

        int bookId = 0;
        Book expectedBook = null;
        Book returnedBook = functions.getBook(bookId, listOfBooks);


        assertEquals(expectedBook, returnedBook);
    }
}
