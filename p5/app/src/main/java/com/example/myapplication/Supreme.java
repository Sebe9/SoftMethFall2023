package com.example.myapplication;

import java.text.DecimalFormat;

/**
 * Supreme Subclass of Pizza
 */

public class Supreme extends Pizza{
    private static final double BASE_PRICE = 15.99;
    /**
     * Returns the price of this pizza after adjustments
     * @return double price of this pizza
     */
    public double price(){
        double price = BASE_PRICE;
        price+=priceAdj();

        return price;
    }
}
