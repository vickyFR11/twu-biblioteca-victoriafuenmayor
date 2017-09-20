package com.twu.biblioteca;

public class Movie {
    int id;
    int year;
    String name;
    String director;
    String movieRating;
    boolean isCheckout;

    public Movie(int id, int year, String name, String director, String movieRating, boolean isCheckout){
        this.id = id;
        this.year = year;
        this.name = name;
        this.director = director;
        this.movieRating = movieRating;
        this.isCheckout = isCheckout;
    }

    @Override
    public String toString() {
        return id+") "+name+" "+director+" "+year+" "+movieRating+"\n";
    }

}
