package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieTest {
    private MovieFunctions movieFunctions;
    private ArrayList<Movie> moviesList;

    @Before
    public void setUp() {
        movieFunctions = new MovieFunctions();
        moviesList = new ArrayList<Movie>();

        moviesList.add(new Movie(1, 2016, "Nocturnal Animals", "Tom Ford", "3 stars", false));
        moviesList.add(new Movie(2, 2015, "Trolls", "Mike Mitchell", "unrated", true));
        moviesList.add(new Movie(3, 2016, "Moana", "Ron Clements", "7 stars", false));
        moviesList.add(new Movie(4, 2016, "Suicide Squad", "Mavid Ayer", "2 stars", false));
    }

    @Test
    public void shouldVerifyEmptyListAtMovieCheckOut() {
        int movieId = 0;
        boolean returnedValue;

        returnedValue = movieFunctions.checkOutMovie(movieId, moviesList);

        assertFalse(returnedValue);
    }

    @Test
    public void successfulMovieCheckoutById() {

        int movieId = 1;

        boolean isMovieCheckout;


        isMovieCheckout = movieFunctions.checkOutMovie(movieId, moviesList);

        assertTrue(isMovieCheckout);
    }

    @Test
    public void notAvailableMovieToCheckout() {
        int movieId = 2;

        boolean isMovieCheckout;

        isMovieCheckout = movieFunctions.checkOutMovie(movieId, moviesList);

        assertFalse(isMovieCheckout);
    }

}
