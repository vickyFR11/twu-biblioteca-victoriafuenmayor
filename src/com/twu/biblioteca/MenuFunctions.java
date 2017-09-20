package com.twu.biblioteca;

import java.util.ArrayList;

public class MenuFunctions {

    public void addOptionsToTheList(ArrayList<Option> listOfOptions) {
        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "List of Movies"));
        listOfOptions.add(new Option(3, "Check-Out a Book"));
        listOfOptions.add(new Option(4, "Check-Out a Movie"));
        listOfOptions.add(new Option(5, "Return a Book"));
        listOfOptions.add(new Option(6, "Quit"));
    }

    public boolean verifyValidOption(String text, int size) {
        int number;
        try {
            number = Integer.parseInt(text);
            if ((number > 0) && (number <= size)) {
                return true;
            } else {
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
