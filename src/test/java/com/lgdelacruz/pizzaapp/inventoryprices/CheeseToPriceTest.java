package com.lgdelacruz.pizzaapp.inventoryprices;

import org.junit.Test;

import static org.junit.Assert.*;

public class CheeseToPriceTest {

    @Test
    public void addCheese() {
        assertEquals(3, CheeseToPrice.Instance().GetCheeses().size());
        CheeseToPrice.Instance().AddCheese("Secret Cheese", 2.0);
        assertEquals(4, CheeseToPrice.Instance().GetCheeses().size());
    }

    @Test
    public void deleteCheese() {
        // Cheese num cannot go less than 3
        CheeseToPrice.Instance().DeleteCheese("cheddar");
        assertEquals(3, CheeseToPrice.Instance().GetCheeses().size());

        CheeseToPrice.Instance().AddCheese("Secret Cheese", 2.0);
        CheeseToPrice.Instance().DeleteCheese("Secret Cheese");
        assertEquals(3, CheeseToPrice.Instance().GetCheeses().size());
    }

}