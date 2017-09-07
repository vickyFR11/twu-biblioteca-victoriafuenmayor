package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class UserTest {

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

        usersList.add(new User("Felipe", "345-6789", "key1"));
        usersList.add(new User("Karina", "111-2222", "key2"));
        usersList.add(new User("Victoria", "123-4567", "key123"));

        boolean wasSuccessfulLogin = bibliotecaFunctions.userLogin(userLibraryNumber, userPassword, usersList);
        boolean expectedValue = true;

        assertEquals(expectedValue, wasSuccessfulLogin);
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

        boolean wasSuccessfulLogin = bibliotecaFunctions.userLogin(userLibraryNumber, userPassword, usersList);
        boolean expectedValue = false;

        assertEquals(expectedValue, wasSuccessfulLogin);
    }

    @Test
    public void verifyCorrectLibraryNumberFormat() {
        BibliotecaFunctions bibliotecaFunctions = new BibliotecaFunctions();

        String userLibraryNumber = "123-4567";
        String userPassword = "key123";
        ArrayList<User> usersList = new ArrayList<User>();

        usersList.add(new User("Felipe", "345-6789", "key1"));
        usersList.add(new User("Karina", "111-2222", "key2"));
        usersList.add(new User("Victoria", "123-4567", "key123"));

        boolean wasSuccessfulLogin = bibliotecaFunctions.userLogin(userLibraryNumber, userPassword, usersList);
        boolean expectedValue = true;

        assertEquals(expectedValue, wasSuccessfulLogin);
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

        boolean wasUnsuccessfulLogin = bibliotecaFunctions.userLogin(userLibraryNumber, userPassword, usersList);
        boolean expectedValue = false;

        assertEquals(expectedValue, wasUnsuccessfulLogin);
    }
}
