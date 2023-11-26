package com.example.demo;

import java.text.DecimalFormat;

public class Supreme extends Pizza{
    public double price(){
        double price = 15.99;
        price+=priceAdj();

        return price;
    }
}
