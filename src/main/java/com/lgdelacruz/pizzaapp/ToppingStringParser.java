package com.lgdelacruz.pizzaapp;

import java.util.ArrayList;
import java.util.Arrays;

public class ToppingStringParser {

    /*
     * Removes white space of a list of toppings in a form of string
     * and splits them via comma
     *
     * @param toppings, String list of of toppings
     * @return ArrayList of strings of individual toppings
     */
    public static ArrayList<String> ParseToppingStringsList(String _toppings)
    {
        String[] toppings_array = _toppings.replaceAll("\\s+","").split(",");
        return new ArrayList<>(Arrays.asList(toppings_array));
    }
}
