package com.twu.biblioteca;

public class Movie {
    int id;
    int year;
    String name;
    String director;
    String movieRating;
    boolean isCheckout;

    public Movie(int id, int year, String name, String director){
        this.id = id;
        this.year = year;
        this.name = name;
        this.director = director;
        this.movieRating = "unrated";
        this.isCheckout = false;
    }

    public Movie(int id, int year, String name, String director, boolean isCheckout){
        this.id = id;
        this.year = year;
        this.name = name;
        this.director = director;
        this.movieRating = "unrated";
        this.isCheckout = isCheckout;
    }

    public Movie(int id, int year, String name, String director, String movieRating){
        this.id = id;
        this.year = year;
        this.name = name;
        this.director = director;
        this.movieRating = movieRating;
        this.isCheckout = false;
    }

    @Override
    public String toString() {
        return id+") "+name+" "+director+" "+year+" "+movieRating+"\n";
    }

    public boolean isCheckout(){
        return isCheckout;
    }

}
