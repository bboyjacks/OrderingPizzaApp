package com.lgdelacruz.pizzaapp;

import java.util.ArrayList;
import java.util.HashMap;

public class CheeseToPrice {
    private HashMap<String, Double> m_cheese_to_price_map = new HashMap<String, Double>();
    private static CheeseToPrice m_cheese_to_price;

    /*
     * Default com.lgdelacruz.pizzaapp.CheeseToPrice List
     */
    private CheeseToPrice()
    {
        m_cheese_to_price_map.put("pepperjack", 1.0);
        m_cheese_to_price_map.put("swiss", 1.5);
        m_cheese_to_price_map.put("cheddar", 1.25);
    }

    /*
     * Singleton instance of cheeses to price
     *
     * @return a single instance of com.lgdelacruz.pizzaapp.CheeseToPrice
     */
    public static CheeseToPrice Instance()
    {
        if (m_cheese_to_price == null)
            m_cheese_to_price = new CheeseToPrice();
        return m_cheese_to_price;
    }

    /*
     * Adds a cheese to the map with the price
     * If cheese already exists, the cheese price is simply
     * updated
     *
     * @param cheese, name of the cheese to add
     * @param price, price of the cheese
     */
    public void AddCheese(String _cheese, Double _price)
    {
        m_cheese_to_price_map.put(_cheese, _price);
    }

    /*
     * Gets an ArrayList of cheeses available currently
     *
     * @return ArrayList of string
     */
    public ArrayList<String> GetCheeses()
    {
        ArrayList<String> cheeses = new ArrayList<String>();
        for (String key : m_cheese_to_price_map.keySet())
        {
            cheeses.add(key);
        }
        return cheeses;
    }

    /*
     * Gets the price of a particular cheese
     *
     * @param cheese, name of the cheese to get price for
     * @return price
     */
    public Double GetCheesePrice(String _cheese)
    {
        return m_cheese_to_price_map.get(_cheese);
    }
}