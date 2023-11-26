package com.example.demo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.text.DecimalFormat;

import static javafx.collections.FXCollections.observableArrayList;


public class specialtyMenuController {
    @FXML
    private ImageView pizzaTypeDisplay;
    @FXML
    private ComboBox<String> pizzaTypeComboBox;
    @FXML
    private ListView<String> toppingListView;
    @FXML
    private TextField sauceText;
    @FXML
    private CheckBox extraSauce;
    @FXML
    private CheckBox extraCheese;
    @FXML
    private RadioButton largeButton;
    @FXML
    private RadioButton mediumButton;
    @FXML
    private RadioButton smallButton;
    @FXML
    private Button addToOrderButton;
    @FXML
    private TextField priceTextField;
    private Pizza currentPizza;
    @FXML
    private ObservableList<String> deluxeToppings = observableArrayList("sausage", "pepperoni", "green pepper", "onion","mushroom");
    private ObservableList<String> supremeToppings = observableArrayList("sausage", "pepperoni", "ham","green pepper", "onion","black olive","mushroom");
    private ObservableList<String> meatzzaToppings = observableArrayList("sausage", "pepperoni", "beef","ham");
    private ObservableList<String> seafoodToppings = observableArrayList("shrimp", "squid", "crab meats", "onion","mushroom");
    private ObservableList<String> pepperoniToppings = observableArrayList( "pepperoni");
    @FXML
    private void updateSpecialtyPrice(){

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        updateSpecialtyPizzaInfo();
        priceTextField.setText(decimalFormat.format(currentPizza.price()));
    }
    @FXML
    private void changePizzaDisplay(){
        if(pizzaTypeComboBox.getValue().equals("Deluxe")){
            toppingListView.setItems(deluxeToppings);
            pizzaTypeDisplay.setImage(new Image(getClass().getResourceAsStream("/images/deluxePizza.jpg")));
            sauceText.setText("tomato");

            currentPizza = PizzaMaker.createPizza("Deluxe");
        }
        else if(pizzaTypeComboBox.getValue().equals("Supreme")){
            toppingListView.setItems(supremeToppings);
            pizzaTypeDisplay.setImage(new Image(getClass().getResourceAsStream("/images/supremePizza.jpg")));
            sauceText.setText("tomato");
            currentPizza = PizzaMaker.createPizza("Supreme");
        }
        else if(pizzaTypeComboBox.getValue().equals("Meatzza")){
            toppingListView.setItems(meatzzaToppings);
            pizzaTypeDisplay.setImage(new Image(getClass().getResourceAsStream("/images/meatzzaImage.png")));
            sauceText.setText("tomato");
            currentPizza = PizzaMaker.createPizza("Meatzza");
        }
        else if(pizzaTypeComboBox.getValue().equals("Seafood")){
            toppingListView.setItems(seafoodToppings);
            pizzaTypeDisplay.setImage(new  Image(getClass().getResourceAsStream("/images/seafoodPizza.jpg")));
            sauceText.setText("alfredo");
            currentPizza = PizzaMaker.createPizza("Seafood");
        }
        else if(pizzaTypeComboBox.getValue().equals("Pepperoni")){
            toppingListView.setItems(pepperoniToppings);
            pizzaTypeDisplay.setImage(new Image(getClass().getResourceAsStream("/images/pepperoniPizza.jpg")));
            sauceText.setText("tomato");
            currentPizza = PizzaMaker.createPizza("Pepperoni");
        }
        updateSpecialtyPrice();
    }
    private void updateSpecialtyPizzaInfo(){
        Size currentSize;
        if(smallButton.isSelected()){
            currentSize = Size.SMALL;
        }
        else if(mediumButton.isSelected()){
            currentSize  =Size.MEDIUM;
        }
        else{
            currentSize = Size.LARGE;
        }
        currentPizza.setSize(currentSize);

        currentPizza.setExtraCheese(extraCheese.isSelected());
        currentPizza.setExtraSauce(extraSauce.isSelected());
    }
    @FXML
    private void initialize(){
        ObservableList<String> pizzaTypeList= observableArrayList("Deluxe","Supreme","Meatzza","Seafood","Pepperoni");
        pizzaTypeComboBox.setItems(pizzaTypeList);
        pizzaTypeComboBox.setValue("Deluxe");

        smallButton.setSelected(true);
        sauceText.setEditable(false);
        priceTextField.setEditable(false);


        changePizzaDisplay();

    }

}