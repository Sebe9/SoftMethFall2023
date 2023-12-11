package com.example.myapplication;

/**
 * Seafood Subclass of Pizza
 * @author SebastianHanna
 */
public class Seafood extends Pizza {
    private static final double BASE_PRICE = 17.99;
    /**
     * returns the price of this pizza after adjustments
     * @return double price of this pizza
     */
    public double price(){
        double price = BASE_PRICE;
        price+=priceAdj();

        return price;
    }
}
