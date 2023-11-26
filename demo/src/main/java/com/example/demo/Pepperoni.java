package com.example.demo;

public class Pepperoni extends Pizza{
    public double price(){
        double price = 10.99;
        price+=priceAdj();

        return price;
    }
}
