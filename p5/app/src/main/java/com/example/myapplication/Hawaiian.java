package com.example.myapplication;

public class Hawaiian extends Pizza{
    private static final double BASE_PRICE = 10.99;
    @Override
    public double price(){
        double price = BASE_PRICE;
        price+=priceAdj();

        return price;
    }
}
