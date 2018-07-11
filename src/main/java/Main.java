import java.util.ArrayList;

public class Main {

    public static String ListToppings(ArrayList<String> _toppings)
    {
        StringBuilder string_builder = new StringBuilder();
        for (String topping : _toppings)
        {
            string_builder.append(topping);
            string_builder.append(", ");
        }
        return string_builder.toString();
    }

    public static void DisplayPizza(Pizza _pizza)
    {
        System.out.println("Pizza order num: " + _pizza.GetOrderNumber());
        System.out.println("Pizza size: " + _pizza.GetSize());
        System.out.println("Pizza cheese: " + _pizza.GetCheese());
        System.out.println("Pizza sauce: " + _pizza.GetSauce());
        System.out.println("Pizza toppings: " + ListToppings(_pizza.GetToppings()));
        System.out.println("Pizza price: $" + _pizza.GetPrice());
    }

    public static void main(String[] args)
    {
        Pizza pizza = new Pizza.PizzaBuilder(1)
                .SetSize("medium")
                .SetCheese("swiss")
                .SetSauce("pesto")
                .AddTopping("pepperoni")
                .AddTopping("ham")
                .AddTopping("pineapple")
                .Build();

        DisplayPizza(pizza);
    }
}
