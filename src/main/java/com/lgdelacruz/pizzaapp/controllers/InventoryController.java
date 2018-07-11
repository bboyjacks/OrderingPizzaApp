package com.lgdelacruz.pizzaapp.controllers;

import com.lgdelacruz.pizzaapp.inventoryprices.CheeseToPrice;
import com.lgdelacruz.pizzaapp.inventoryprices.SauceToPrice;
import com.lgdelacruz.pizzaapp.inventoryprices.SizeToPrice;
import com.lgdelacruz.pizzaapp.inventoryprices.ToppingsToPrice;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InventoryController {

    @GetMapping("/admin")
    public String AdminPage() {
        return "admin";
    }

    @PostMapping("/addInventory")
    public String AddInventory(
            @RequestParam(name="type", required=true) String type,
            @RequestParam(name="name", required=true) String name,
            @RequestParam(name="price", required=true) Double price
    )
    {
        if (type.equalsIgnoreCase("size"))
        {
            SizeToPrice.Instance().SetSize(name, price);
        }
        else if (type.equalsIgnoreCase("sauce"))
        {
            SauceToPrice.Instance().AddSauce(name, price);
        }
        else if (type.equalsIgnoreCase("cheese"))
        {
            CheeseToPrice.Instance().AddCheese(name, price);
        }
        else if (type.equalsIgnoreCase("topping"))
        {
            ToppingsToPrice.Instance().AddTopping(name, price);
        }

        return "index";
    }

    @PostMapping("/deleteInventory")
    public String DeleteInventory(
            @RequestParam(name="type", required=true) String type,
            @RequestParam(name="name", required=true) String name)
    {
        if (type.equalsIgnoreCase("size"))
        {
            SizeToPrice.Instance().DeleteSize(name);
        }
        else if (type.equalsIgnoreCase("sauce"))
        {
            SauceToPrice.Instance().DeleteSauce(name);
        }
        else if (type.equalsIgnoreCase("cheese"))
        {
            CheeseToPrice.Instance().DeleteCheese(name);
        }
        else if (type.equalsIgnoreCase("topping"))
        {
            ToppingsToPrice.Instance().DeleteTopping(name);
        }

        return "index";
    }
}
