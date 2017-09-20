package com.twu.biblioteca;

import java.util.ArrayList;

public class Print {

    public String printBooks(ArrayList<Book> listOfBooks) {
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

    public String printListOfOptions(ArrayList<Option> listOfOptions) {
        String optionList = "";

        for (Option option : listOfOptions) {
            optionList += option.toString();
        }
        return optionList;
    }
}
