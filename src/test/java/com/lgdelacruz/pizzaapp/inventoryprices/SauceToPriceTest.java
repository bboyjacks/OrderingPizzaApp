package com.lgdelacruz.pizzaapp.inventoryprices;

import org.junit.Test;

import static org.junit.Assert.*;

public class SauceToPriceTest {

    @Test
    public void addSauce() {
        SauceToPrice.Instance().Reset();
        assertEquals(3, SauceToPrice.Instance().GetSauces().size());
        SauceToPrice.Instance().AddSauce("Secret Sauce", 2.0);
        assertEquals(4, SauceToPrice.Instance().GetSauces().size());
    }

    @Test
    public void deleteSauce() {
        SauceToPrice.Instance().Reset();

        // Sauce num cannot go less than 3
        SauceToPrice.Instance().DeleteSauce("pesto");
        assertEquals(3, SauceToPrice.Instance().GetSauces().size());

        SauceToPrice.Instance().AddSauce("Secret Sauce", 2.0);
        SauceToPrice.Instance().DeleteSauce("Secret Sauce");
        assertEquals(3, SauceToPrice.Instance().GetSauces().size());
    }
}