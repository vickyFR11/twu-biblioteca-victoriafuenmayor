package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    private BibliotecaFunctions functions;
    private ArrayList<Option> listOfOptions;

    @Before
    public void setUp() throws Exception {

        listOfOptions = new ArrayList<Option>();
        functions = new BibliotecaFunctions();

        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "Check-Out a Book"));
        listOfOptions.add(new Option(3, "Return a Book"));
        listOfOptions.add(new Option(4, "Quit"));
    }

    @Test
    public void successfulOptionSelectionAtMainMenu(){
        boolean resultValue = functions.verifyValidOption("2", listOfOptions.size());
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void outOfRangeOptionSelectionAtMainMenu(){
        boolean resultValue = functions.verifyValidOption("8", listOfOptions.size());
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void insertTextAsOptionAtMainMenu(){
        boolean resultValue = functions.verifyValidOption("hola", listOfOptions.size());
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

}
