package com.lgdelacruz.pizzaapp;

import java.util.ArrayList;
import java.util.Arrays;

public class ToppingStringParser {

    public static ArrayList<String> ParseToppingStringsList(String _toppings)
    {
        String[] toppings_array = _toppings.split(",");
        return new ArrayList<>(Arrays.asList(toppings_array));
    }
}
