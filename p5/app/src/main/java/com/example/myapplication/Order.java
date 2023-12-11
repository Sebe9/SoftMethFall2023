package com.example.myapplication;

import java.util.ArrayList;

/**
 * This class represents 1 order, it contains an order nubmer and an array of pizzas that are in the order.
 * @author SebastianHanna
 */

public class Order {
    private int orderNumber;
    private ArrayList<Pizza> pizzas;

    /**
     * Creates an order from an order number
     * @param n The order number for this order
     */
    public Order(int n){

        orderNumber = n;
        pizzas = new ArrayList<Pizza>();
    }

    /**
     * Adds a pizza to an order
     * @param pizza pizza to be added
     */
    public void addPizzaToOrder(Pizza pizza){

        pizzas.add(pizza);
    }

    /**
     * Returns the order number of this order
     * @return int The order number
     */
    public int getOrderNumber(){
        return orderNumber;
    }

    /**
     * Returns an ArrayList containing all the pizzas in this order
     * @return ArrayList The arraylist of pizzas
     */
    public ArrayList<Pizza> getPizzas(){
        return pizzas;
    }

    /**
     * Removes a pizza at a particular index of the pizza array
     * @param index index of pizza to be removed
     */

    public void removePizza(int index){
        pizzas.remove(index);
    }

}
