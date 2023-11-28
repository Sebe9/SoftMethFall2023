package com.example.demo;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.collections.FXCollections;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static javafx.collections.FXCollections.observableArrayList;

/**
 * Controller class for the Store Orders GUI
 * @author SebastianHanna
 */
public class StoreOrdersController {
    @FXML
    private ComboBox<Integer> orderNumberComboBox;
    @FXML
    private ListView<String> storeOrderPizzaView;
    @FXML
    private TextField orderTotalStoreOrders;

    /**
     * Makes sure textfields are not editable and correctly sets the order numbers in the ComboBox
     */
    @FXML
    private void initialize(){
        orderTotalStoreOrders.setEditable(false);
        updateOrderNumbers();

    }

    /**
     * Updates the order numbers in the order number ComboBox
     */
    @FXML
    private void updateOrderNumbers(){
        ObservableList<Integer> orderNumberList  = FXCollections.observableArrayList(StoreOrders.getInstance().getOrderNumberList());
        orderNumberComboBox.setItems(orderNumberList);

    }

    /**
     * Updates the List View to correctly represent the pizzas in the currently viewed order.
     */
    @FXML
    private void updateListViewStoreOrder(){
        int orderIndex = orderNumberComboBox.getSelectionModel().getSelectedIndex();
        if(orderNumberComboBox.getSelectionModel().getSelectedIndex()==-1){
           // StoreOrders.getInstance().getOrderList().isEmpty() ||
            return;
        }
        ArrayList<Pizza> pizzaArray = StoreOrders.getInstance().getOrderList().get(orderIndex).getPizzas();
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
        storeOrderPizzaView.setItems(observableArrayList(stringRepresentation));
        double subtotal = 0;
        for(Pizza pizza: pizzaArray){
            subtotal += pizza.price();
        }

        orderTotalStoreOrders.setText(decimalFormat.format(subtotal+(subtotal*0.06625)));
    }
    @FXML
    private void removeOrder(){
        if (orderNumberComboBox.getSelectionModel().getSelectedIndex() == -1){
            Alert alert  = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Please select an order");
            alert.setHeaderText("Please select an order to remove");
            alert.showAndWait();
            return;
        }
        int removedIndex = orderNumberComboBox.getSelectionModel().getSelectedIndex();
        StoreOrders.getInstance().getOrderList().remove(removedIndex);
        updateOrderNumbers();
        storeOrderPizzaView.getItems().clear();
        orderTotalStoreOrders.clear();

    }
    @FXML
    private void exportOrder(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export Store Orders");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON Files", "*.json"));
        File file = fileChooser.showSaveDialog(new Stage());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        if (file != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                // Replace the following line with your actual JSON string
                String jsonString = "";
                for (Order order : StoreOrders.getInstance().getOrderList()){
                    ArrayList<Pizza> pizzaArray = order.getPizzas();
                    jsonString= jsonString.concat("\nOrder Number: "+order.getOrderNumber()+"");
                    for (Pizza pizza : pizzaArray) {
                        String extraString = "";
                        if (pizza.extraSauce){
                            extraString+="extra sauce, ";
                        }
                        if(pizza.extraCheese){
                            extraString+="extra cheese, ";
                        }

                        jsonString= jsonString.concat("\n\t["+pizza.getClass().getSimpleName()+"] "+pizza.getToppings().toString().toLowerCase()+" "+pizza.getSize().toString().toLowerCase()+", "+pizza.getSauce().toString().toLowerCase()+", "+extraString+decimalFormat.format(pizza.price()));
                    }
                }

                // Write the JSON content to the selected file
                writer.write(jsonString);

                System.out.println("Order exported to JSON file successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
