package com.twu.biblioteca;

public class Book {
    private int id;
    private String title;
    private String author;
    private int publishYear;
    private boolean availability;

    public Book(int id, String title, String author, int year, boolean availability) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publishYear = year;
        this.availability = availability;
    }

    @Override
    public String toString() {
        return id + ") " + title + " " + author + " " + publishYear + "\n";
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean getAvailability() {
        return availability;
    }

    public int getBookId(){
        return id;
    }
}
