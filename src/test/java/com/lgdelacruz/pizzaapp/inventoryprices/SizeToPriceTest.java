package com.lgdelacruz.pizzaapp.inventoryprices;

import org.junit.Test;

import static org.junit.Assert.*;

public class SizeToPriceTest {

    @Test
    public void setSize() {
        SizeToPrice.Instance().Reset();
        assertEquals(3, SizeToPrice.Instance().GetSizes().size());
        SizeToPrice.Instance().SetSize("Secret Size", 2.0);
        assertEquals(4, SizeToPrice.Instance().GetSizes().size());
    }

    @Test
    public void deleteSize() {
        SizeToPrice.Instance().Reset();

        // Size num cannot go less than 3
        SizeToPrice.Instance().DeleteSize("small");
        assertEquals(3, SizeToPrice.Instance().GetSizes().size());

        SizeToPrice.Instance().SetSize("Secret Sauce", 2.0);
        SizeToPrice.Instance().DeleteSize("Secret Sauce");
        assertEquals(3, SizeToPrice.Instance().GetSizes().size());
    }
}