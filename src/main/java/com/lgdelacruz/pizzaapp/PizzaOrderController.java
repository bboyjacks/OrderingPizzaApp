package com.lgdelacruz.pizzaapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;


@Controller
public class PizzaOrderController {

    private final AtomicLong counter = new AtomicLong();

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
        Pizza pizza = new Pizza.PizzaBuilder(counter.incrementAndGet())
                .SetSize(size)
                .SetSauce(sauce)
                .SetCheese(cheese)
                .AddTopping(topping)
                .Build();

        model.addAttribute("order_num", pizza.GetOrderNumber());
        model.addAttribute("size", pizza.GetSize());
        model.addAttribute("sauce", pizza.GetSauce());
        model.addAttribute("cheese", pizza.GetCheese());
        model.addAttribute("topping", pizza.GetToppings());
        model.addAttribute("price", pizza.GetPrice());

        return "order";
    }
}