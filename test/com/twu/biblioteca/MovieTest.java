package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void verifyEmptyListAtMovieCheckOut() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();
        int movieId = 0;
        ArrayList<Movie> moviesList = new ArrayList<Movie>();
        boolean expectedValue = false;
        boolean returnedValue;


        returnedValue = bibliotecaFunctions.checkOutMovie(movieId, moviesList);

        assertEquals(expectedValue, returnedValue);
    }

    @Test
    public void successfulMovieCheckoutById() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();
        int movieId = 1;
        ArrayList<Movie> moviesList = new ArrayList<Movie>();
        boolean expectedValue = true;
        boolean isMovieCheckout;

        moviesList.add(new Movie(1, 2016, "Nocturnal Animals", "Tom Ford"));
        moviesList.add(new Movie(2, 2015, "Trolls", "Mike Mitchell"));
        moviesList.add(new Movie(3, 2016, "Moana", "Ron Clements"));
        moviesList.add(new Movie(4, 2016, "Suicide Squad", "Mavid Ayer"));


        isMovieCheckout = bibliotecaFunctions.checkOutMovie(movieId, moviesList);

        assertEquals(expectedValue, isMovieCheckout);
    }

    @Test
    public void notAvailableMovieToCheckout() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();
        int movieId = 1;
        ArrayList<Movie> moviesList = new ArrayList<Movie>();
        boolean expectedValue = false;
        boolean isMovieCheckout;

        moviesList.add(new Movie(1, 2016, "Nocturnal Animals", "Tom Ford", true));
        moviesList.add(new Movie(2, 2015, "Trolls", "Mike Mitchell", "6 stars"));
        moviesList.add(new Movie(3, 2016, "Moana", "Ron Clements"));
        moviesList.add(new Movie(4, 2016, "Suicide Squad", "Mavid Ayer", "3 stars"));


        isMovieCheckout = bibliotecaFunctions.checkOutMovie(movieId, moviesList);

        assertEquals(expectedValue, isMovieCheckout);
    }

}
