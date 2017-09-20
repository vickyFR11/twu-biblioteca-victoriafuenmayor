package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieFunctions {

    public void addMoviesToTheList(ArrayList<Movie> listOfMovies) {
        listOfMovies.add(new Movie(1, 2016, "Nocturnal Animals", "Tom Ford", "5 stars", false));
        listOfMovies.add(new Movie(2, 2015, "Trolls", "Mike Mitchell", "unrated",false));
        listOfMovies.add(new Movie(3, 2016, "Moana", "Ron Clements", "8 stars", false));
        listOfMovies.add(new Movie(4, 2016, "Suicide Squad", "Mavid Ayer", "2 stars",false));
    }

    public boolean checkOutMovie(int movieId, ArrayList<Movie> moviesList) {
        if (!moviesList.isEmpty()) {
            for (Movie movie : moviesList) {
                if ((movie.id == movieId) && (!movie.isCheckout)) {
                    movie.isCheckout = true;
                    return movie.isCheckout;
                }
            }
        }
        return false;
    }
}
