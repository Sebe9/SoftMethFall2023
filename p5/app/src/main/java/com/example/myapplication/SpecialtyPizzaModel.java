package com.example.myapplication;

import java.util.ArrayList;

public class SpecialtyPizzaModel {
    int image;
    String pizzaName;
    Topping[] toppingArray;
    Sauce sauce;
    double price;


    public SpecialtyPizzaModel(int image, String pizzaName, Topping[] toppingArray, Sauce sauce, double price) {
        this.image = image;
        this.pizzaName = pizzaName;
        this.toppingArray = toppingArray;
        this.sauce = sauce;
        this.price = price;
    }

    public int getImage() {
        return image;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public Topping[] getToppingArray() {
        return toppingArray;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public double getPrice() {
        return price;
    }
}
