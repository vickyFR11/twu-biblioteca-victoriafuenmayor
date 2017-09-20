package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    private ArrayList<Option> listOfOptions;
    private UserFunctions userFunctions;
    private User userExpected;
    private ArrayList<User> usersList;

    @Before
    public void setUp() throws Exception {
        userFunctions = new UserFunctions();
        userExpected = new User(1, "Felipe", "345-6789", "key1", "felipe@tw.com", "+561287900");
        listOfOptions = new ArrayList<Option>();
        usersList = new ArrayList<User>();

        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "List of Movies"));
        listOfOptions.add(new Option(3, "Check-Out a Book"));
        listOfOptions.add(new Option(4, "Check-Out a Movie"));
        listOfOptions.add(new Option(5, "Return a Book"));
        listOfOptions.add(new Option(6, "Quit"));

        usersList.add(new User(1, "Felipe", "345-6789", "key1", "felipe@tw.com", "+561287900"));
        usersList.add(new User(2, "Karina", "111-2222", "key2", "karina@tw.com", "+561236789"));
        usersList.add(new User(3, "Victoria", "123-4567", "key123", "victoria@biblioteca.cl", "+569123456"));
    }

    @Test
    public void successfulUserReturnWithName() {
        User userCreated = new User(1, "Felipe", "345-6789", "key1", "felipe@tw.com", "+561287900");

        assertEquals(userExpected, userCreated);
    }

    @Test
    public void unsuccessfulUserReturn() {
        User userCreated = null;

        assertNotEquals(userExpected, userCreated);
    }

    @Test
    public void successfulLogin() {
        String userLibraryNumber = "123-4567";
        String userPassword = "key123";
        int userIdExpected = 3;

        User userLogged = userFunctions.userLogin(userLibraryNumber, userPassword, usersList, listOfOptions);

        assertEquals(userIdExpected, userLogged.getUserId());
    }

    @Test
    public void unsuccessfulLogin() {
        String userLibraryNumber = "122-4567";
        String userPassword = "key123";

        User userLogged = userFunctions.userLogin(userLibraryNumber, userPassword, usersList, listOfOptions);
        User userExpected = null;

        assertEquals(userExpected, userLogged);
    }

    @Test
    public void verifyCorrectLibraryNumberFormat() {
        String userLibraryNumber = "123-4567";
        String userPassword = "key123";
        int userIdExpected = 3;

        User userLogged = userFunctions.userLogin(userLibraryNumber, userPassword, usersList, listOfOptions);

        assertEquals(userIdExpected, userLogged.getUserId());
    }

    @Test
    public void verifyIncorrectLibraryNumberFormat() {
        String userLibraryNumber = "1234-45697";
        String userPassword = "key123";

        User userLogged = userFunctions.userLogin(userLibraryNumber, userPassword, usersList, listOfOptions);
        User userExpected = null;

        assertEquals(userExpected, userLogged);
    }


    @Test
    public void returnUserInformationById() {
        String userInformation = " Victoria victoria@biblioteca.cl +569123456\n";
        int userId = 3;

        String returnedValue = userFunctions.getUserInformation(userId, usersList);

        assertEquals(userInformation, returnedValue);
    }

    @Test
    public void returnEmptyUserInformationById() {
        String userInformation = "";
        int userId = 0;

        String returnedValue = userFunctions.getUserInformation(userId, usersList);

        assertEquals(userInformation, returnedValue);
    }

}
