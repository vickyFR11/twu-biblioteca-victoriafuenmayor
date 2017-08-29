package com.twu.biblioteca;

import java.util.ArrayList;

public class Option {
    private int number;
    private  String text;

    public  Option(){
        this.number = 0;
        this.text = "";
    }

    public Option(int number, String text){
        this.number = number;
        this.text = text;
    }


    public int getNumber() {
        return number;
    }

    public String getText() {
        return text;
    }

}
