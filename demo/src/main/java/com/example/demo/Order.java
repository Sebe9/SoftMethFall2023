package com.example.demo;

import java.util.ArrayList;

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;


    public Order(int n){

        orderNumber = n;
        pizzas = new ArrayList<Pizza>();
    }
    public void addPizzaToOrder(Pizza pizza){

        pizzas.add(pizza);
    }
    public int getOrderNumber(){
        return orderNumber;
    }
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }

    public void removePizza(int index){
        pizzas.remove(index);
    }

}
