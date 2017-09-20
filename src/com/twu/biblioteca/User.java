package com.twu.biblioteca;

public class User {
    private int id;
    private String name;
    private String libraryNumber;
    private String password;
    private String email;
    private String phoneNumber;

    public User(int id, String name, String libraryNumber, String password, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public int getUserId(){
        return id;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return " "+name+" "+email+" "+phoneNumber+"\n";
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
