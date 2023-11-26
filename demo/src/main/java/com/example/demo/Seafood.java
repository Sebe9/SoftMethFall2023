package com.example.demo;

public class Seafood extends Pizza {
    public double price(){
        double price = 17.99;
        price+=priceAdj();

        return price;
    }
}
