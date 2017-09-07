package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaFunctions {

    public void addBooksToTheList(ArrayList<Book> listOfBooks) {
        listOfBooks.add(new Book(1, "Growing Object-Oriented Software", "Steve Freeman", 2010));
        listOfBooks.add(new Book(2, "Working Effectively With Legacy Code", "Michael C. Feathers", 2005));
        listOfBooks.add(new Book(3, "xUnit Test Patterns: Refactoring Test Code", "Gerard Meszaros", 2007));
        listOfBooks.add(new Book(4, "Object-Oriented JavaScript", "Ved Antani", 2017));
        listOfBooks.add(new Book(5, "Patterns of Enterprise Application Architecture", "Martin Fowler", 2003));
        listOfBooks.add(new Book(6, "Clean Code: A Handbook of Agile Software Craftsmanship", "Robert C. Martin", 2009));
    }

    public void addOptionsToTheList(ArrayList<Option> listOfOptions) {
        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "Check-Out a Book"));
        listOfOptions.add(new Option(3, "Return a Book"));
        listOfOptions.add(new Option(4, "Quit"));
    }

    public boolean verifyValidOption(String text, int size) {
        int number;
        try {
            number = Integer.parseInt(text);
            if ((number > 0) && (number <= size)) {
                return true;
            } else {
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public ArrayList<Book> checkOutBook(int index, ArrayList<Book> listOfBooks) {

        if ((index >= 0) && (index <= listOfBooks.size())) {
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
            if ((index >= 0) && (index <= listOfBooks.size())) {
                listOfBooks.get(index).setAvailability(true);
                return true;

            } else {
                return false;
            }
        } else {
            return false;
        }

    }


    public String printListOfOptions(ArrayList<Option> listOfOptions) {
        String optionList = "";
        for (Option option : listOfOptions) {
            optionList += option.toString();
        }

        return optionList;
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

    public boolean userLogin(String userLibraryNumber, String userPassword, ArrayList<User> usersList){
        if (checkLibraryNumberFormat(userLibraryNumber)){
            for(User user : usersList){
                if ((user.getLibraryNumber() == userLibraryNumber) && (user.getPassword() == userPassword)){
                    return true;
                }
            }
        }

        return false;
    }


    private boolean checkLibraryNumberFormat(String userLibraryNumber){
        String[] splitResult = userLibraryNumber.split("-");

        if (splitResult.length > 0 && splitResult.length <= 2){
            if ((splitResult[0].length() == 3) && (splitResult[1].length() == 4)) {
                return true;
            }
        }

        return false;
    }

    public String print(ArrayList<Book> listOfBooks) {

        String nameOfBooksList = "";

        if (listOfBooks.isEmpty()) {
            return null;
        } else {
            for (Book book : listOfBooks) {
                nameOfBooksList += book.toString();
            }

            return nameOfBooksList;
        }

    }
}
