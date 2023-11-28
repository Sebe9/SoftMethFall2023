package com.example.demo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Controller Class for the Current Order GUI
 * @author SebastianHanna
 */
public class CurrentOrderController {
    @FXML
    private TextField orderNumberTextField;
    @FXML
    private TextField subtotalTextField;
    @FXML
    private TextField salesTaxTextField;
    @FXML
    private TextField orderTotalTextField;
    @FXML
    private ListView<String> pizzasInOrderListView;
    private static final double TAX_RATE = 0.06625;
    /**
     * initializes all text fields to be uneditable and sets default display.
     */
    @FXML
    private void initialize(){
        orderNumberTextField.setEditable(false);
        subtotalTextField.setEditable(false);
        salesTaxTextField.setEditable(false);
        orderTotalTextField.setEditable(false);
        updateDisplay();

    }

    /**
     * Updates all elements of the display including the listview, subtotal, tax, and total
     */
    @FXML
    private void updateDisplay(){
        orderNumberTextField.setText(Integer.toString(StoreOrders.getInstance().getCurrentOrder().getOrderNumber()));
        ArrayList<Pizza> pizzaArray = StoreOrders.getInstance().getCurrentOrder().getPizzas();
        ArrayList<String> stringRepresentation = new ArrayList<String>();
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        for (Pizza pizza : pizzaArray) {
            String extraString = "";
            if (pizza.extraSauce){
                extraString+="extra sauce, ";
            }
            if(pizza.extraCheese){
                extraString+="extra cheese, ";
            }

            stringRepresentation.add("["+pizza.getClass().getSimpleName()+"] "+pizza.getToppings().toString().toLowerCase()+" "+pizza.getSize().toString().toLowerCase()+", "+pizza.getSauce().toString().toLowerCase()+", "+extraString+decimalFormat.format(pizza.price()));
        }
        pizzasInOrderListView.setItems(observableArrayList(stringRepresentation));
        double subtotal = 0;
        for(Pizza pizza: pizzaArray){
            subtotal += pizza.price();
        }
        subtotalTextField.setText(decimalFormat.format(subtotal));
        salesTaxTextField.setText(decimalFormat.format(subtotal*TAX_RATE));
        orderTotalTextField.setText(decimalFormat.format(subtotal+(subtotal*TAX_RATE)));
    }

    /**
     * Removes the selected pizza from the current order
     */
    @FXML
    private void removePizza(){
        int removedIndex = pizzasInOrderListView.getSelectionModel().getSelectedIndex();
        StoreOrders.getInstance().getCurrentOrder().removePizza(removedIndex);
        updateDisplay();
    }

    /**
     * Adds the current order to Store Orders
     */
    @FXML
    private void placeOrder(){
        StoreOrders.getInstance().placeOrder();
        updateDisplay();
    }
}
