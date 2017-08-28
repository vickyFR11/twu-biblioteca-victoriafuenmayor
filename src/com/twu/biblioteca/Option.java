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

    public void printListOfOptions(ArrayList<Option> listOfOptions){
        for (int i = 0; i < listOfOptions.size(); i++){
            System.out.println(listOfOptions.get(i).number+") "+listOfOptions.get(i).text);
        }
    }

}
