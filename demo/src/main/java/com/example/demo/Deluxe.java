package com.example.demo;

public class Deluxe extends Pizza {
    public double price(){
        double price = 14.99;
        price+=priceAdj();

        return price;

    }
}
