package com.lgdelacruz.pizzaapp;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ToppingStringParserTest {

    @Test
    public void parseToppingStringsList() {
        String test_input = "ham,pepperoni,olives";
        String[] expected_result = {"ham", "pepperoni", "olives"};

        ArrayList<String> result = ToppingStringParser.ParseToppingStringsList(test_input);
        assertArrayEquals(expected_result, result.toArray());
    }
}