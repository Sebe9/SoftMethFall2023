package com.example.myapplication;
import java.util.ArrayList;

public class Singleton {
    private static Singleton instance;
    private static int nextNumber = 0;
    private ArrayList<Order> orderList;

    private Order currentOrder;

    private Singleton() {
        orderList = new ArrayList<>();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public static int getNextNumber(){
        int orderNumber = nextNumber;
        nextNumber++;
        return orderNumber;
    }

    /**
     * Creates an arrayList for all the orders
     */


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
           /// Alert alert = new Alert(Alert.AlertType.WARNING);
           // alert.setTitle("Cannot add order with 0 pizzas");
          //  alert.setHeaderText("Cannot add order with 0 pizzas");
          //  alert.showAndWait();
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
