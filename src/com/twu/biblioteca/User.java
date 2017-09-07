package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String name;
    private String libraryNumber;
    private String password;

    public User(String name) {

        this.name = name;
    }

    public User(String name, String libraryNumber, String password) {

        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
