package com.example.demo;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;


    public Order(int n){
        orderNumber = n;
    }
    public void addPizzaToOrder(Pizza pizza){
        if(pizzas==null){
            pizzas = new ArrayList<Pizza>();
        }
        pizzas.add(pizza);
    }

}
