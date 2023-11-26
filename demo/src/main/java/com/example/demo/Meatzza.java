package com.example.demo;

public class Meatzza extends Pizza{
    public double price(){
        double price = 16.99;
        price+=priceAdj();

        return price;
    }
}
