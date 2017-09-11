package com.twu.biblioteca;

public class Option {
    private int number;
    private String text;


    public Option(String text) {
        this.text = text;
    }

    public Option(int number, String text) {
        this.number = number;
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return number + ") " + text + "\n";
    }

}
