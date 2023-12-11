package com.example.myapplication;

/**
 * Meatzza subclass of Pizza
 * @author SebastianHanna
 */
public class Meatzza extends Pizza{
    private static final double BASE_PRICE = 16.99;

    /**
     * Returns the price of this pizza
     * @return double returns price of the pizza after adjustments
     */
    public double price(){
        double price = BASE_PRICE;
        price+=priceAdj();

        return price;
    }
}
