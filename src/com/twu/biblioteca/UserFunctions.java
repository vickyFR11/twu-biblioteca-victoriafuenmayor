package com.twu.biblioteca;

import java.util.ArrayList;

public class UserFunctions {
    boolean isOptionAdded = false;

    public void addUsersToTheList(ArrayList<User> usersList) {
        usersList.add(new User(1, "Felipe", "345-6789", "key1", "felipe@tw.com", "+561287900"));
        usersList.add(new User(2, "Karina", "111-2222", "key2", "karina@tw.com", "+561236789"));
        usersList.add(new User(3, "Victoria", "123-4567", "key123", "victoria@biblioteca.cl", "+569123456"));
    }

    public User userLogin(String userLibraryNumber, String userPassword, ArrayList<User> usersList, ArrayList<Option> listOfOption) {
        if (checkLibraryNumberFormat(userLibraryNumber)) {
            for (User user : usersList) {
                if ((user.getLibraryNumber().equals(userLibraryNumber)) && (user.getPassword().equals(userPassword))) {
                    addShowUserInformationOption(listOfOption);
                    return user;
                }
            }
        }

        return null;
    }

    public void addShowUserInformationOption(ArrayList<Option> listOfOptions) {
        Option lastOption = new Option(0,"Quit");

        if (!isOptionAdded) {
            listOfOptions.get(listOfOptions.size() - 1).setText("Show User Information");
            lastOption.setNumber(listOfOptions.size() + 1);
            listOfOptions.add(lastOption);
            isOptionAdded = true;
        }
    }

    private boolean checkLibraryNumberFormat(String userLibraryNumber) {
        String[] splitResult = userLibraryNumber.split("-");

        if (splitResult.length > 0 && splitResult.length <= 2) {
            if ((splitResult[0].length() == 3) && (splitResult[1].length() == 4)) {
                return true;
            }
        }

        return false;
    }

    public String getUserInformation(int userId, ArrayList<User> userList) {
        String userInformation = "";
        for (User user : userList) {
            if (user.getUserId() == userId) {
                userInformation = user.toString();
            }

        }
        return userInformation;
    }
}
