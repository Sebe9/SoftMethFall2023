package com.example.demo;

/**
 * Deluxe Pizza Subclass.
 * @author SebastianHanna
 */
public class Deluxe extends Pizza {
    private static final double BASE_PRICE = 14.99;

    /**
     * Returns the price of the pizza after adjustments from toppings, sauce etc.
     * @return double price of the pizza
     */
    public double price(){
        double price = BASE_PRICE;
        price+=priceAdj();

        return price;

    }
}
