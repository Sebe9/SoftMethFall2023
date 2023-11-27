package com.example.demo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;
import static javafx.collections.FXCollections.observableList;


public class BuildController {
    @FXML
    private ImageView buildDisplay;
    @FXML
    private RadioButton tomatoButtonBuild;
    @FXML
    private RadioButton alfredoButtonBuild;
    @FXML
    private RadioButton smallButtonBuild;
    @FXML
    private RadioButton mediumButtonBuild;
    @FXML
    private RadioButton largeButtonBuild;
    @FXML
    private CheckBox extraSauceBuild;
    @FXML
    private CheckBox extraCheeseBuild;
    @FXML
    private ListView<Topping> availableToppings;
    @FXML
    private Button addToppingButton;
    @FXML
    private Button removeToppingButton;
    @FXML
    private TextField priceFieldBuild;
    @FXML
    private Pizza currentPizza;
    @FXML
    private ListView<Topping> currentToppings;
    @FXML
    private Button addToOrderButtonBuild;
    @FXML
    private void initialize(){
        availableToppings.setItems(observableArrayList(Topping.values()));
        currentPizza = PizzaMaker.createPizza("BuildYourOwn");
        tomatoButtonBuild.setSelected(true);
        smallButtonBuild.setSelected(true);
        updateBuildPizza();

    }
    @FXML
    private void updateBuildPizza(){
        Size currentSize;
        if(smallButtonBuild.isSelected()){
            currentSize = Size.SMALL;
        }
        else if(mediumButtonBuild.isSelected()){
            currentSize  =Size.MEDIUM;
        }
        else{
            currentSize = Size.LARGE;
        }
        currentPizza.setSize(currentSize);
        currentPizza.setExtraCheese(extraCheeseBuild.isSelected());
        currentPizza.setExtraSauce(extraSauceBuild.isSelected());


        BuildYourOwn castedPizza = (BuildYourOwn) currentPizza;

        ArrayList<Topping> arr  = new ArrayList<>(currentToppings.getItems());
        castedPizza.setToppings(arr);
        if(tomatoButtonBuild.isSelected()){
            castedPizza.setSauce(Sauce.TOMATO);
        }
        else{
            castedPizza.setSauce(Sauce.ALFREDO);
        }
        updatePrice();
    }
    @FXML
    private void updatePrice(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        priceFieldBuild.setText(decimalFormat.format(currentPizza.price()));
    }
    @FXML
    private void addTopping() {
        if (currentToppings.getItems().size() ==7){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Too many Toppings");
            alert.setHeaderText("You can't add more than 7 toppings to your pizza.");
            alert.setContentText("Please remove a topping before adding another one.");
            alert.showAndWait();
            return;
        }
        Topping selected = availableToppings.getSelectionModel().getSelectedItem();
        if (selected != null  ) {
            currentToppings.getItems().add(selected);
            availableToppings.getItems().remove(selected);
        }
        updateBuildPizza();
    }
    @FXML
    private void removeTopping() {
        Topping selected = currentToppings.getSelectionModel().getSelectedItem();
        if (selected != null) {
            availableToppings.getItems().add(selected);
            currentToppings.getItems().remove(selected);

        }
        updateBuildPizza();
    }
    @FXML
    private void addToOrderBuild(){
        if(currentToppings.getItems().size()<3){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Too Little Toppings");
            alert.setHeaderText("You can't have less than 3 toppings on your pizza.");
            alert.setContentText("Please add some toppings before trying again.");
            alert.showAndWait();

        }
        else{
            StoreOrders.getInstance().addPizza(currentPizza);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Pizza added to Order");
            alert.setHeaderText("Pizza added to Order");
            alert.showAndWait();

        }

    }


}
