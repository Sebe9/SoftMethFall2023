package com.example.myapplication;

public class Shrimp extends Pizza{
    private static final double BASE_PRICE = 12.99;
    @Override
    public double price(){
        double price = BASE_PRICE;
        price+=priceAdj();

        return price;
    }
}
