package com.example.demo;

import javafx.scene.control.Alert;

import java.util.ArrayList;

public class StoreOrders {
    private static StoreOrders instance;
    static private int nextNumber = 0;
    ArrayList<Order> orderList;
    private Order currentOrder;
    public static StoreOrders getInstance(){
        if (instance==null){
            instance = new StoreOrders();
        }
        return instance;
    }
    public static int getNextNumber(){
        int orderNumber = nextNumber;
        nextNumber++;
        return orderNumber;
    }

    public StoreOrders(){
        orderList = new ArrayList<Order>();

    }

    public Order getCurrentOrder() {
        if(currentOrder==null){
            currentOrder = new Order(getNextNumber());
        }
        return currentOrder;
    }

    public void addOrder(Order o){

        orderList.add(o);
        currentOrder = null;
    }
    public void addPizza(Pizza p){
        if(currentOrder==null){
            currentOrder = new Order(getNextNumber());
        }
        currentOrder.addPizzaToOrder(p);
    }
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


}
