package com.twu.biblioteca;


import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ExampleTest {


    public void test() {
        assertEquals(1, 1);
    }
    @Test
    public void chooseQuitToExit(){

        assertEquals(true, new BibliotecaFunctions().verifyValidOption("1"));
    }
}
