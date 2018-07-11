import java.util.ArrayList;

public class Pizza {
    private String m_cheese;
    private Double m_price = 0.0;
    private String m_sauce;
    private String m_size;
    private Integer m_order_number;
    private ArrayList<String> m_toppings = new ArrayList<String>();

    public Pizza(Integer _order_number)
    {
        // Initialize a default pizza to the first of every inventory
        SetSize(SizeToPrice.Instance().GetSizes().get(0));
        SetCheese(CheeseToPrice.Instance().GetCheeses().get(0));
        SetSauce(SauceToPrice.Instance().GetSauces().get(0));
        m_order_number = _order_number;
    }

    public Integer GetOrderNumber()
    {
        return m_order_number;
    }

    public String GetSize()
    {
        return m_size;
    }

    public String GetCheese()
    {
        return m_cheese;
    }

    public String GetSauce()
    {
        return m_sauce;
    }

    public ArrayList<String> GetToppings()
    {
        return m_toppings;
    }

    private Double GetPrice()
    {
        return m_price;
    }

    public Pizza SetSize(String _size)
    {
        m_size = _size;
        m_price += SizeToPrice.Instance().GetSizePrice(_size);
        return this;
    }

    public Pizza SetCheese(String _cheese)
    {
        m_cheese = _cheese;
        m_price += CheeseToPrice.Instance().GetCheesePrice(_cheese);
        return this;
    }

    public Pizza SetSauce(String _sauce)
    {
        m_sauce = _sauce;
        m_price += SauceToPrice.Instance().GetSaucePrice(_sauce);
        return this;
    }

    public Pizza AddTopping(String _topping)
    {
        m_toppings.add(_topping);
        m_price += ToppingsToPrice.Instance().GetToppingPrice(_topping);
        return this;
    }
}
