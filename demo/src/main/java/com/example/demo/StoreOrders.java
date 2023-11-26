package com.example.demo;

import java.util.ArrayList;

public class StoreOrders {

    static private int nextNumber = 0;
    ArrayList<Order> orderList;
    public static int getNextNumber(){
        int orderNumber = nextNumber;
        nextNumber++;
        return orderNumber;
    }

    public StoreOrders(){
        orderList = new ArrayList<Order>();

    }

    public void addOrder(Order o){
        orderList.add(o);
    }


}
