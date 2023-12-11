package com.example.myapplication;

public class PineApple extends Pizza{
    private static final double BASE_PRICE = 11.99;
    @Override
    public double price(){
        double price = BASE_PRICE;
        price+=priceAdj();

        return price;
    }
}
