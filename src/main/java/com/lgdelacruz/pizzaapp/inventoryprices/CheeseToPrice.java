package com.lgdelacruz.pizzaapp.inventoryprices;

import java.util.ArrayList;
import java.util.HashMap;

public class CheeseToPrice {


    private HashMap<String, Double> m_cheese_to_price_map = new HashMap<String, Double>();
    private static CheeseToPrice m_cheese_to_price;

    /*
     * Default CheeseToPrice List
     */
    private CheeseToPrice()
    {
        Reset();
    }

    /*
     * Resets map to original
     */
    public void Reset() {
        m_cheese_to_price_map.clear();
        m_cheese_to_price_map.put("pepperjack", 1.0);
        m_cheese_to_price_map.put("swiss", 1.5);
        m_cheese_to_price_map.put("cheddar", 1.25);
    }

    /*
     * Singleton instance of cheeses to price
     *
     * @return a single instance of CheeseToPrice
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
     * There must be at least 3 cheeses
     * in at all times. Delete the cheese if
     * it exists
     *
     */
    public void DeleteCheese(String _cheese)
    {
        if (m_cheese_to_price_map.size() > 3)
        {
            m_cheese_to_price_map.remove(_cheese);
        }
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



    /*
     * Gets cheese to price map for get request
     *
     * @return the cheese to price map
     */
    public HashMap<String, Double> getM_cheese_to_price_map() {
        return m_cheese_to_price_map;
    }
}