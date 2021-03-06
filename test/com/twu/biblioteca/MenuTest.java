package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    private UserFunctions userFunctions;
    private MenuFunctions menuFunctions;
    private Print printFunctions;
    private ArrayList<Option> listOfOptions;

    @Before
    public void setUp() throws Exception {

        listOfOptions = new ArrayList<Option>();
        menuFunctions = new MenuFunctions();
        userFunctions = new UserFunctions();
        printFunctions = new Print();

        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "List of Movies"));
        listOfOptions.add(new Option(3, "Check-Out a Book"));
        listOfOptions.add(new Option(4, "Check-Out a Movie"));
        listOfOptions.add(new Option(5, "Return a Book"));
        listOfOptions.add(new Option(6, "Quit"));
    }

    @Test
    public void successfulOptionSelectionAtMainMenu() {
        boolean resultValue = menuFunctions.verifyValidOption("2", listOfOptions.size());
        boolean expectedValue = true;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void outOfRangeOptionSelectionAtMainMenu() {
        boolean resultValue = menuFunctions.verifyValidOption("8", listOfOptions.size());
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void insertTextAsOptionAtMainMenu() {
        boolean resultValue = menuFunctions.verifyValidOption("hola", listOfOptions.size());
        boolean expectedValue = false;

        assertEquals(expectedValue, resultValue);
    }

    @Test
    public void addNewOptionToCurrentList() {
        String returnedValue = "";
        String expectedValue =  "1) List of Books\n" +
                                "2) List of Movies\n" +
                                "3) Check-Out a Book\n" +
                                "4) Check-Out a Movie\n" +
                                "5) Return a Book\n" +
                                "6) Show User Information\n" +
                                "7) Quit\n";


        userFunctions.addShowUserInformationOption(listOfOptions);
        returnedValue = printFunctions.printListOfOptions(listOfOptions);

        assertEquals(expectedValue, returnedValue);
    }
}
