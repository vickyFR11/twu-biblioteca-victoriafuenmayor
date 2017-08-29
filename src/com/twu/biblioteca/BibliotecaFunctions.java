package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliotecaFunctions {



    public void addBooksToTheList(ArrayList<Book> listOfBooks){
        listOfBooks.add(new Book("Growing Object-Oriented Software","Steve Freeman", 2010));
        listOfBooks.add(new Book("Working Effectively With Legacy Code","Michael C. Feathers", 2005));
        listOfBooks.add(new Book("xUnit Test Patterns: Refactoring Test Code","Gerard Meszaros", 2007));
        listOfBooks.add(new Book("Object-Oriented JavaScript","Ved Antani", 2017));
        listOfBooks.add(new Book("Patterns of Enterprise Application Architecture","Martin Fowler", 2003));
        listOfBooks.add(new Book("Clean Code: A Handbook of Agile Software Craftsmanship","Robert C. Martin", 2009));
    }

    public void addOptionsToTheList(ArrayList<Option> listOfOptions){
        listOfOptions.add(new Option(1, "List of Books"));
        listOfOptions.add(new Option(2, "Check-Out a Book"));
        listOfOptions.add(new Option(3, "Return a Book"));
        listOfOptions.add(new Option(4, "Quit"));
    }

    public boolean verifyValidOption(String text, int size){
        int number;
        try {
            number = Integer.parseInt(text);
            if ((number > 0) && (number <= size)){
                return true;
            }else{
                return false;
            }

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean checkOutBook(int index, ArrayList<Book> listOfBooks){

        if ((index >= 0) && (index <= listOfBooks.size())){
            if (listOfBooks.get(index).getAvailability()){
                listOfBooks.get(index).setAvailability(false);
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public boolean returnBook(int index, ArrayList<Book> listOfBooks){
        if (isAnyBookToReturn(listOfBooks)){
            if ((index >= 0) && (index <= listOfBooks.size())){
                listOfBooks.get(index).setAvailability(true);
                return true;

            }else{
                return false;
            }
        }else{
            return false;
        }

    }


    public void printListOfOptions(ArrayList<Option> listOfOptions){
        for (int i = 0; i < listOfOptions.size(); i++){
            System.out.println(listOfOptions.get(i).getNumber()+") "+listOfOptions.get(i).getText());
        }
    }


    public void printAvailableBooks(ArrayList<Book> listOfBooks){

        for (int i = 0; i < listOfBooks.size(); i++){
            if (listOfBooks.get(i).getAvailability()){
                System.out.println((i+1)+") Title: "+listOfBooks.get(i).getTitle()+". Author: "+listOfBooks.get(i).getAuthor()+". Year Published: "+listOfBooks.get(i).getPublishYear());
            }

        }

    }

    public void printNotAvailableBooks(ArrayList<Book> listOfBooks){

        for (int i = 0; i < listOfBooks.size(); i++){
            if (!listOfBooks.get(i).getAvailability()){
                System.out.println((i+1)+") Title: "+listOfBooks.get(i).getTitle()+". Author: "+listOfBooks.get(i).getAuthor()+". Year Published: "+listOfBooks.get(i).getPublishYear());
            }

        }

    }

    public boolean isAnyBookToReturn(ArrayList<Book> listOfBooks){
        for (int i = 0; i < listOfBooks.size(); i++){
            if (!listOfBooks.get(i).getAvailability()){
                return true;
            }
        }
        return false;
    }

}
