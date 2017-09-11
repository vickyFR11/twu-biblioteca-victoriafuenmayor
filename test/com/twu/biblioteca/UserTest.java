package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

    private ArrayList<Option> listOfOptions;

    @Before
    public void setUp() throws Exception {
        listOfOptions = new ArrayList<Option>();

        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "List of Movies"));
        listOfOptions.add(new Option(3, "Check-Out a Book"));
        listOfOptions.add(new Option(4, "Check-Out a Movie"));
        listOfOptions.add(new Option(5, "Return a Book"));
        listOfOptions.add(new Option(6, "Quit"));
    }

    @Test
    public void successfulUserReturnWithName() {
        User userCreated = new User("Alfredo");
        User userExpected = new User("Alfredo");

        assertEquals(userExpected, userCreated);
    }

    @Test
    public void unsuccessfulUserReturn() {
        User userCreated = null;
        User userExpected = new User("Vicky");

        assertNotEquals(userExpected, userCreated);
    }

    @Test
    public void successfulLogin() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();

        String userLibraryNumber = "123-4567";
        String userPassword = "key123";
        ArrayList<User> usersList = new ArrayList<User>();

        usersList.add(new User(1,"Felipe", "345-6789", "key1", "felipe@tw.com","+561287900"));
        usersList.add(new User(2,"Karina", "111-2222", "key2", "karina@tw.com", "+561236789"));
        usersList.add(new User(3,"Victoria", "123-4567", "key123", "victoria@biblioteca.cl", "+569123456"));

        User userLogged = bibliotecaFunctions.userLogin(userLibraryNumber, userPassword, usersList, listOfOptions);
        int userIdExpected = 3;

        assertEquals(userIdExpected, userLogged.getUserId());
    }

    @Test
    public void unsuccessfulLogin() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();

        String userLibraryNumber = "122-4567";
        String userPassword = "key123";
        ArrayList<User> usersList = new ArrayList<User>();

        usersList.add(new User("Felipe", "345-6789", "key1"));
        usersList.add(new User("Karina", "111-2222", "key2"));
        usersList.add(new User("Victoria", "123-4567", "key123"));

        User userLogged = bibliotecaFunctions.userLogin(userLibraryNumber, userPassword, usersList, listOfOptions);
        User userExpected = null;

        assertEquals(userExpected, userLogged);
    }

    @Test
    public void verifyCorrectLibraryNumberFormat() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();

        String userLibraryNumber = "123-4567";
        String userPassword = "key123";
        ArrayList<User> usersList = new ArrayList<User>();

        usersList.add(new User(1,"Felipe", "345-6789", "key1", "felipe@tw.com","+561287900"));
        usersList.add(new User(2,"Karina", "111-2222", "key2", "karina@tw.com", "+561236789"));
        usersList.add(new User(3,"Victoria", "123-4567", "key123", "victoria@biblioteca.cl", "+569123456"));

        User userLogged = bibliotecaFunctions.userLogin(userLibraryNumber, userPassword, usersList, listOfOptions);
        int userIdExpected = 3;

        assertEquals(userIdExpected, userLogged.getUserId());
    }

    @Test
    public void verifyIncorrectLibraryNumberFormat() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();

        String userLibraryNumber = "1234-45697";
        String userPassword = "key123";
        ArrayList<User> usersList = new ArrayList<User>();

        usersList.add(new User("Felipe", "345-6789", "key1"));
        usersList.add(new User("Karina", "111-2222", "key2"));
        usersList.add(new User("Victoria", "123-4567", "key123"));

        User userLogged = bibliotecaFunctions.userLogin(userLibraryNumber, userPassword, usersList, listOfOptions);
        User userExpected = null;

        assertEquals(userExpected, userLogged);
    }


    @Test
    public void returnUserInformationById() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();
        String userInformation = " Victoria victoria@biblioteca.cl +569123456\n";
        int userId = 3;

        ArrayList<User> usersList = new ArrayList<User>();

        usersList.add(new User(1,"Felipe", "345-6789", "key1", "felipe@tw.com","+561287900"));
        usersList.add(new User(2,"Karina", "111-2222", "key2", "karina@tw.com", "+561236789"));
        usersList.add(new User(3,"Victoria", "123-4567", "key123", "victoria@biblioteca.cl", "+569123456"));

        String returnedValue = bibliotecaFunctions.getUserInformation(userId, usersList);

        assertEquals(userInformation, returnedValue);
    }

    @Test
    public void returnEmptyUserInformationById() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();
        String userInformation = "";
        int userId = 0;

        ArrayList<User> usersList = new ArrayList<User>();

        usersList.add(new User(1,"Felipe", "345-6789", "key1", "felipe@tw.com","+561287900"));
        usersList.add(new User(2,"Karina", "111-2222", "key2", "karina@tw.com", "+561236789"));
        usersList.add(new User(3,"Victoria", "123-4567", "key123", "victoria@biblioteca.cl", "+569123456"));

        String returnedValue = bibliotecaFunctions.getUserInformation(userId, usersList);

        assertEquals(userInformation, returnedValue);
    }

}
