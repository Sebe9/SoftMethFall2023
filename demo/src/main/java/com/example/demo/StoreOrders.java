package com.example.demo;

import javafx.scene.control.Alert;

import java.util.ArrayList;

/**
 * This class contains all the orders currently saved. It maintains its data through the GUIs by having a static getInstance() method and a static instance data field
 * @author SebastianHanna
 */

public class StoreOrders {
    private static StoreOrders instance;
    static private int nextNumber = 0;
    private ArrayList<Order> orderList;
    private Order currentOrder;

    /**
     * Main way to access the current orders from each different GUI
     * @return StoreOrders Returns the instance that contains all the orders
     */
    public static StoreOrders getInstance(){
        if (instance==null){
            instance = new StoreOrders();
        }
        return instance;
    }

    /**
     * Returns the next available order number
     * @return int the next available order number
     */
    public static int getNextNumber(){
        int orderNumber = nextNumber;
        nextNumber++;
        return orderNumber;
    }

    /**
     * Creates an arrayList for all the orders
     */
    public StoreOrders(){
        orderList = new ArrayList<Order>();

    }

    /**
     * Returns the current order
     * @return Order the current order
     */
    public Order getCurrentOrder() {
        if(currentOrder==null){
            currentOrder = new Order(getNextNumber());
        }
        return currentOrder;
    }

    /**
     * Adds a pizza to the current order
     * @param p Pizza to be added
     */
    public void addPizza(Pizza p){
        if(currentOrder==null){
            currentOrder = new Order(getNextNumber());
        }
        currentOrder.addPizzaToOrder(p);
    }

    /**
     * Adds the current order to the order array
     */
    public void placeOrder(){
        if(currentOrder.getPizzas().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Cannot add order with 0 pizzas");
            alert.setHeaderText("Cannot add order with 0 pizzas");
            alert.showAndWait();
        }
        else{
            orderList.add(currentOrder);
            currentOrder = null;
        }

    }

    /**
     * Returns an arraylist containing all the orders
     * @return Arraylist the list of orders
     */
    public ArrayList<Order> getOrderList(){
        return orderList;
    }

    /**
     * Returns an arraylist containing order numbers
     * @return ArrayList List of order numbers
     */
    public ArrayList<Integer> getOrderNumberList(){
        ArrayList<Integer> orderNumberList = new ArrayList<Integer>();
        for (Order order : orderList){
            orderNumberList.add(order.getOrderNumber());
        }
        return orderNumberList;
    }


}
