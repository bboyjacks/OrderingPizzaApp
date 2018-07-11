package com.lgdelacruz.pizzaapp.inventoryprices;

import java.util.ArrayList;
import java.util.HashMap;

public class ToppingsToPrice {

    private HashMap<String, Double> m_topping_to_price_map = new HashMap<String, Double>();
    private static ToppingsToPrice m_toppings_to_price;



    /*
     * Default com.lgdelacruz.pizzaapp.inventoryprices.ToppingsToPrice List
     */
    private ToppingsToPrice()
    {
        m_topping_to_price_map.put("pepperoni", 1.0);
        m_topping_to_price_map.put("olives", 1.0);
        m_topping_to_price_map.put("pineapple", 1.5);
        m_topping_to_price_map.put("ham", 1.25);
        m_topping_to_price_map.put("sausage", 1.75);
    }

    /*
     * Singleton instance of toppings to price
     *
     * @return a single instance of com.lgdelacruz.pizzaapp.inventoryprices.ToppingsToPrice
     */
    public static ToppingsToPrice Instance()
    {
        if (m_toppings_to_price == null)
            m_toppings_to_price = new ToppingsToPrice();
        return m_toppings_to_price;
    }

    /*
     * Adds a topping to the map with the price
     * If topping already exists, the topping price is simply
     * updated
     *
     * @param topping, name of the topping to add
     * @param price, price of the topping
     */
    public void AddTopping(String _topping, Double _price)
    {
        m_topping_to_price_map.put(_topping, _price);
    }

    /*
     * Gets an ArrayList of toppings available currently
     *
     * @return ArrayList of string
     */
    public ArrayList<String> GetToppings()
    {
        ArrayList<String> toppings = new ArrayList<String>();
        for (String key : m_topping_to_price_map.keySet())
        {
            toppings.add(key);
        }
        return toppings;
    }

    /*
     * Gets the price of a particular topping
     *
     * @param topping, name of the topping to get price for
     * @return price
     */
    public Double GetToppingPrice(String _topping)
    {
        return m_topping_to_price_map.get(_topping);
    }

    public Boolean IsToppingAnOption(String _topping)
    {
        return m_topping_to_price_map.containsKey(_topping);
    }


    /*
     * Gets topping to price map for get request
     *
     * @return the topping to price map
     */
    public HashMap<String, Double> getM_topping_to_price_map() {
        return m_topping_to_price_map;
    }
}