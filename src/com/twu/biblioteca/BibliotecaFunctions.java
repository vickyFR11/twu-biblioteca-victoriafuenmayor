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
        listOfOptions.add(new Option(2, "List of Movies"));
        listOfOptions.add(new Option(3, "Check-Out a Book"));
        listOfOptions.add(new Option(4, "Check-Out a Movie"));
        listOfOptions.add(new Option(5, "Return a Book"));
        listOfOptions.add(new Option(6, "Quit"));
    }

    public void addMoviesToTheList(ArrayList<Movie> listOfMovies) {
        listOfMovies.add(new Movie(1, 2016, "Nocturnal Animals", "Tom Ford", "5 stars"));
        listOfMovies.add(new Movie(2, 2015, "Trolls", "Mike Mitchell"));
        listOfMovies.add(new Movie(3, 2016, "Moana", "Ron Clements", "8 stars"));
        listOfMovies.add(new Movie(4, 2016, "Suicide Squad", "Mavid Ayer"));
    }

    public void addUsersToTheList(ArrayList<User> usersList) {
        usersList.add(new User(1,"Felipe", "345-6789", "key1", "felipe@tw.com","+561287900"));
        usersList.add(new User(2,"Karina", "111-2222", "key2", "karina@tw.com", "+561236789"));
        usersList.add(new User(3,"Victoria", "123-4567", "key123", "victoria@biblioteca.cl", "+569123456"));
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

    public Book getBook(int index, ArrayList<Book> listOfBooks){
        if (!listOfBooks.isEmpty()){
            for (Book book : listOfBooks){
                if (book.getBookId() == index){
                    return book;
                }
            }
        }
        return null;
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
            if (book != null){
                book.setAvailability(true);
                return true;
            }else{
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

    public User userLogin(String userLibraryNumber, String userPassword, ArrayList<User> usersList, ArrayList<Option> listOfOption){
        if (checkLibraryNumberFormat(userLibraryNumber)){
            for(User user : usersList){
                if ((user.getLibraryNumber().equals(userLibraryNumber)) && (user.getPassword().equals(userPassword))){
                    addShowUserInformationOption(listOfOption);
                    return user;
                }
            }
        }

        return null;
    }

    public void addShowUserInformationOption(ArrayList<Option> listOfOptions){
        Option lastOption = new Option("Quit");

        listOfOptions.get(listOfOptions.size() - 1).setText("Show User Information");
        lastOption.setNumber(listOfOptions.size()+1);
        listOfOptions.add(lastOption);


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

    public boolean checkOutMovie(int movieId, ArrayList<Movie> moviesList){
        if (!moviesList.isEmpty()){
            for (Movie movie : moviesList){
                if ((movie.id == movieId) && (!movie.isCheckout)) {
                    movie.isCheckout = true;
                    return movie.isCheckout;
                }
            }
        }
        return false;
    }

    public String getUserInformation(int userId, ArrayList<User> userList){
        String userInformation = "";
        for (User user : userList){
            if (user.getUserId() == userId){
                userInformation = user.toString();
            }

        }
        return userInformation;
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

    public String printMovies(ArrayList<Movie> listOfMovies) {

        String nameOfMoviesList = "";

        if (listOfMovies.isEmpty()) {
            return null;
        } else {
            for (Movie movie : listOfMovies) {
                if (!movie.isCheckout)
                    nameOfMoviesList += movie.toString();
            }

            return nameOfMoviesList;
        }
    }

}
