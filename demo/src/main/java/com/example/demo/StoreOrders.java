package com.example.demo;

import java.util.ArrayList;

public class StoreOrders {
    static private int nextNumber;
    ArrayList<Order> orderList;
    public static int getNextNumber(){
        int orderNumber = nextNumber;
        nextNumber++;
        return orderNumber;
    }


}
