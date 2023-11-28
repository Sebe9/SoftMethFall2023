package com.example.demo;

/**
 * Pepperoni Subclass of Pizza
 * @author SebastianHanna
 */
public class Pepperoni extends Pizza{
    private static final double BASE_PRICE = 10.99;
    /**
     * Returns the price of this pizza after adjustments
     * @return double The price of this pizza
     */
    public double price(){
        double price = BASE_PRICE;
        price+=priceAdj();

        return price;
    }
}
