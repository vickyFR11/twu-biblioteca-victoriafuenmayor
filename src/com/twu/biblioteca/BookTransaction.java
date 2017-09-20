package com.twu.biblioteca;

import java.util.ArrayList;

public class BookTransaction {

    public void addBooksToTheList(ArrayList<Book> listOfBooks) {
        listOfBooks.add(new Book(1, "Growing Object-Oriented Software", "Steve Freeman", 2010, true));
        listOfBooks.add(new Book(2, "Working Effectively With Legacy Code", "Michael C. Feathers", 2005, true));
        listOfBooks.add(new Book(3, "xUnit Test Patterns: Refactoring Test Code", "Gerard Meszaros", 2007, true));
        listOfBooks.add(new Book(4, "Object-Oriented JavaScript", "Ved Antani", 2017, true));
        listOfBooks.add(new Book(5, "Patterns of Enterprise Application Architecture", "Martin Fowler", 2003, true));
        listOfBooks.add(new Book(6, "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2009, true));
    }

    public ArrayList<Book> checkOutBook(int index, ArrayList<Book> listOfBooks) {

        if ((index >= 0) && (index < listOfBooks.size())) {
            if (listOfBooks.get(index).getAvailability()) {
                listOfBooks.get(index).setAvailability(false);
                return listOfBooks;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public boolean returnBook(int index, ArrayList<Book> listOfBooks) {
        if (booksToReturn(listOfBooks)) {
            Book book = getBook(index, listOfBooks);
            if (book != null) {
                book.setAvailability(true);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }

    }

    public ArrayList<Book> getNotAvailableBooks(ArrayList<Book> listOfBooks) {
        ArrayList<Book> auxList = new ArrayList<Book>();

        for (int i = 0; i < listOfBooks.size(); i++) {
            if (!listOfBooks.get(i).getAvailability()) {
                auxList.add(listOfBooks.get(i));
            }

        }

        return auxList;
    }

    public ArrayList<Book> getAvailableBooks(ArrayList<Book> listOfBooks) {
        ArrayList<Book> auxList = new ArrayList<Book>();

        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).getAvailability()) {
                auxList.add(listOfBooks.get(i));
            }

        }

        return auxList;
    }

    public boolean booksToReturn(ArrayList<Book> listOfBooks) {
        if (listOfBooks.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public Book getBook(int index, ArrayList<Book> listOfBooks) {
        if (!listOfBooks.isEmpty()) {
            for (Book book : listOfBooks) {
                if (book.getBookId() == index) {
                    return book;
                }
            }
        }
        return null;
    }
}
