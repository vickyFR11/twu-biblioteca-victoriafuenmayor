package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int publishYear;
    private boolean availability;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.publishYear = year;
        this.availability = true;
    }

    public Book(String title, String author, int year, boolean availability){
        this.title = title;
        this.author = author;
        this.publishYear = year;
        this.availability = availability;
    }

    @Override
    public String toString(){
        return " " + title + " " + author + " " + publishYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean getAvailability() {
        return availability;
    }


}
