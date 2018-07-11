package com.lgdelacruz.pizzaapp.controllers;

import com.lgdelacruz.pizzaapp.models.Pizza;
import com.lgdelacruz.pizzaapp.ToppingStringParser;
import com.lgdelacruz.pizzaapp.inventoryprices.CheeseToPrice;
import com.lgdelacruz.pizzaapp.inventoryprices.SauceToPrice;
import com.lgdelacruz.pizzaapp.inventoryprices.SizeToPrice;
import com.lgdelacruz.pizzaapp.inventoryprices.ToppingsToPrice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;


@Controller
public class PizzaOrderController {

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/sizes")
    @ResponseBody
    public SizeToPrice size() {
        return SizeToPrice.Instance();
    }

    @RequestMapping("/sauce")
    @ResponseBody
    public SauceToPrice sauce() {
        return SauceToPrice.Instance();
    }

    @RequestMapping("/topping")
    @ResponseBody
    public ToppingsToPrice topping() {
        return ToppingsToPrice.Instance();
    }

    @RequestMapping("/cheese")
    @ResponseBody
    public CheeseToPrice cheese() {
        return CheeseToPrice.Instance();
    }

    @GetMapping("/")
    public String LoadMainPage() {
        return "index";
    }

    @GetMapping("/order")
    public String LoadOrderPage(Model model,
            @RequestParam(name="size", required=true) String size,
            @RequestParam(name="sauce", required=true) String sauce,
            @RequestParam(name="cheese", required=true) String cheese,
            @RequestParam(name="topping", required=true) String topping
    ) {
        Pizza.PizzaBuilder pizza_builder = new Pizza.PizzaBuilder(counter.incrementAndGet())
                .SetSize(size)
                .SetSauce(sauce)
                .SetCheese(cheese);

        ArrayList<String> toppings = ToppingStringParser.ParseToppingStringsList(topping);

        for (String topping_item : toppings)
            pizza_builder = pizza_builder.AddTopping(topping_item);

        Pizza pizza = pizza_builder.Build();

        model.addAttribute("order_num", pizza.GetOrderNumber());
        model.addAttribute("size", pizza.GetSize());
        model.addAttribute("sauce", pizza.GetSauce());
        model.addAttribute("cheese", pizza.GetCheese());
        model.addAttribute("topping", pizza.GetToppings());
        model.addAttribute("price", pizza.GetPrice());

        return "order";
    }


}