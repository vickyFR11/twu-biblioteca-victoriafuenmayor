package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int publishYear;
    private boolean availability;


    public  Book(){
        this.title = "";
        this.author = "";
        this.publishYear = 0;
        this.availability = true;
    }

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.publishYear = year;
        this.availability = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailability() {
        return availability;
    }
}
