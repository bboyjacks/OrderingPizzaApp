package com.lgdelacruz.pizzaapp.inventoryprices;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToppingsToPriceTest {

    @Test
    public void addTopping() {
        ToppingsToPrice.Instance().Reset();
        assertEquals(5, ToppingsToPrice.Instance().GetToppings().size());
        ToppingsToPrice.Instance().AddTopping("Secret Sauce", 2.0);
        assertEquals(6, ToppingsToPrice.Instance().GetToppings().size());
    }

    @Test
    public void deleteTopping() {
        ToppingsToPrice.Instance().Reset();

        // Toppings num cannot go less than 3
        ToppingsToPrice.Instance().DeleteTopping("ham");
        assertEquals(4, ToppingsToPrice.Instance().GetToppings().size());

        ToppingsToPrice.Instance().DeleteTopping("pepperoni");
        assertEquals(3, ToppingsToPrice.Instance().GetToppings().size());

        ToppingsToPrice.Instance().DeleteTopping("olives");
        assertEquals(3, ToppingsToPrice.Instance().GetToppings().size());
    }

    @Test
    public void isToppingAnOption() {
        ToppingsToPrice.Instance().Reset();

        assertFalse(ToppingsToPrice.Instance().IsToppingAnOption("Doesn't exits"));
        assertTrue(ToppingsToPrice.Instance().IsToppingAnOption("ham"));
    }
}