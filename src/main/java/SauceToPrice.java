import java.util.ArrayList;
import java.util.HashMap;

public class SauceToPrice {
    private HashMap<String, Double> m_sauce_to_price_map = new HashMap<String, Double>();
    private static SauceToPrice m_sauce_to_price;

    /*
     * Default SauceToPrice map
     */
    private SauceToPrice()
    {
        m_sauce_to_price_map.put("marinara", 1.0);
        m_sauce_to_price_map.put("pesto", 1.5);
        m_sauce_to_price_map.put("alfredo", 1.25);
    }

    /*
     * Singleton instance of sauce to price
     *
     * @return a single instance of SauceToPrice
     */
    public static SauceToPrice Instance()
    {
        if (m_sauce_to_price == null)
            m_sauce_to_price = new SauceToPrice();
        return m_sauce_to_price;
    }

    /*
     * Adds a sauce to the map with the price
     * If sauce already exists, the sauce price is simply
     * updated
     *
     * @param sauce, name of the sauce to add
     * @param price, price of the sauce
     */
    public void AddSauce(String _sauce, Double price)
    {
        m_sauce_to_price_map.put(_sauce, price);
    }

    /*
     * Gets an ArrayList of sauce available currently
     *
     * @return ArrayList of string
     */
    public ArrayList<String> GetSauces()
    {
        ArrayList<String> sauces = new ArrayList<String>();
        for (String key : m_sauce_to_price_map.keySet())
            sauces.add(key);
        return sauces;
    }

    /*
     * Gets the price of a particular sauce
     *
     * @param sauce, name of the sauce to get price for
     * @return price
     */
    public Double GetSaucePrice(String _sauce)
    {
        return m_sauce_to_price_map.get(_sauce);
    }
}
