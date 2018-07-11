import java.util.ArrayList;

public class Pizza {
    private String m_cheese;
    private Double m_price = 0.0;
    private String m_sauce;
    private String m_size;
    private Integer m_order_number;
    private ArrayList<String> m_toppings = new ArrayList<String>();

    private Pizza()
    {
    }

    public static class PizzaBuilder
    {
        private String m_cheese;
        private Double m_price = 0.0;
        private String m_sauce;
        private String m_size;
        private Integer m_order_number;
        private ArrayList<String> m_toppings = new ArrayList<String>();

        PizzaBuilder(Integer _order_number)
        {
            // Initialize a default pizza to the first of every inventory
            SetSize(SizeToPrice.Instance().GetSizes().get(0));
            SetCheese(CheeseToPrice.Instance().GetCheeses().get(0));
            SetSauce(SauceToPrice.Instance().GetSauces().get(0));
            this.m_order_number = _order_number;
        }

        public PizzaBuilder SetSize(String _size)
        {
            this.m_size = _size;
            this.m_price += SizeToPrice.Instance().GetSizePrice(_size);
            return this;
        }

        public PizzaBuilder SetCheese(String _cheese)
        {
            this.m_cheese = _cheese;
            this.m_price += CheeseToPrice.Instance().GetCheesePrice(_cheese);
            return this;
        }

        public PizzaBuilder SetSauce(String _sauce)
        {
            this.m_sauce = _sauce;
            this.m_price += SauceToPrice.Instance().GetSaucePrice(_sauce);
            return this;
        }

        public PizzaBuilder AddTopping(String _topping)
        {
            this.m_toppings.add(_topping);
            this.m_price += ToppingsToPrice.Instance().GetToppingPrice(_topping);
            return this;
        }

        public Pizza Build()
        {
            Pizza pizza = new Pizza();
            pizza.m_cheese = this.m_cheese;
            pizza.m_price = this.m_price;
            pizza.m_sauce = this.m_sauce;
            pizza.m_size = this.m_size;
            pizza.m_order_number = this.m_order_number;
            pizza.m_toppings = this.m_toppings;
            return pizza;
        }
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

    public Double GetPrice()
    {
        return m_price;
    }

}
