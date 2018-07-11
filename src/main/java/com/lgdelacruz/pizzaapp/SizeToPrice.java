package com.lgdelacruz.pizzaapp;

import java.util.ArrayList;
import java.util.HashMap;

public class SizeToPrice {
    private HashMap<String, Double> m_size_to_price_map = new HashMap<String, Double>();
    private static SizeToPrice m_size_to_price;

    /*
     * Default com.lgdelacruz.pizzaapp.SizeToPrice List
     */
    private SizeToPrice()
    {
        m_size_to_price_map.put("small", 6.0);
        m_size_to_price_map.put("medium", 6.5);
        m_size_to_price_map.put("large", 6.25);
    }

    /*
     * Singleton instance of pizza size to price
     *
     * @return a single instance of com.lgdelacruz.pizzaapp.SizeToPrice
     */
    public static SizeToPrice Instance()
    {
        if (m_size_to_price == null)
            m_size_to_price = new SizeToPrice();
        return m_size_to_price;
    }

    /*
     * Adds a size to the map with the price
     * If size already exists, the size price is simply
     * updated
     *
     * @param size, name of the size to add
     * @param price, price of the size
     */
    public void SetSize(String _size, Double _price)
    {
        m_size_to_price_map.put(_size, _price);
    }

    /*
     * Gets an ArrayList of pizza sizes available currently
     *
     * @return ArrayList of string
     */
    public ArrayList<String> GetSizes()
    {
        ArrayList<String> sizes = new ArrayList<String>();
        for (String key : m_size_to_price_map.keySet())
        {
            sizes.add(key);
        }
        return sizes;
    }

    /*
     * Gets the price of a particular pizza size
     *
     * @param size, name of the pizza size to get price for
     * @return price
     */
    public Double GetSizePrice(String _size)
    {
        return m_size_to_price_map.get(_size);
    }
}