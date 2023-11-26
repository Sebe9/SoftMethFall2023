package com.example.demo;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
    private ObservableList<String> deluxeToppings = observableArrayList("sausage", "pepperoni", "green pepper", "onion","mushroom");
    private ObservableList<String> supremeToppings = observableArrayList("sausage", "pepperoni", "ham","green pepper", "onion","black olive","mushroom");
    private ObservableList<String> meatzzaToppings = observableArrayList("sausage", "pepperoni", "beef","ham");
    private ObservableList<String> seafoodToppings = observableArrayList("shrimp", "squid", "crab meats", "onion","mushroom");
    private ObservableList<String> pepperoniToppings = observableArrayList( "pepperoni");
    @FXML
    private void initialize(){
        ObservableList<String> pizzaTypeList= observableArrayList("Deluxe","Supreme","Meatzza","Seafood","Pepperoni");
        pizzaTypeComboBox.setItems(pizzaTypeList);

        Image pepperoni = new Image(getClass().getResourceAsStream("/images/pepperoniPizza.jpg"));
        pizzaTypeDisplay.setImage(pepperoni);

        sauceText.setEditable(false);

    }
    @FXML
    private void changePizzaDisplay(){
        if(pizzaTypeComboBox.getValue().equals("Deluxe")){
            toppingListView.setItems(deluxeToppings);
            pizzaTypeDisplay.setImage(new Image(getClass().getResourceAsStream("/images/deluxePizza.jpg")));
            sauceText.setText("tomato");

        }
        else if(pizzaTypeComboBox.getValue().equals("Supreme")){
            toppingListView.setItems(supremeToppings);
            pizzaTypeDisplay.setImage(new Image(getClass().getResourceAsStream("/images/supremePizza.jpg")));
            sauceText.setText("tomato");
        }
        else if(pizzaTypeComboBox.getValue().equals("Meatzza")){
            toppingListView.setItems(meatzzaToppings);
            pizzaTypeDisplay.setImage(new Image(getClass().getResourceAsStream("/images/meatzzaImage.png")));
            sauceText.setText("tomato");
        }
        else if(pizzaTypeComboBox.getValue().equals("Seafood")){
            toppingListView.setItems(seafoodToppings);
            pizzaTypeDisplay.setImage(new  Image(getClass().getResourceAsStream("/images/seafoodPizza.jpg")));
            sauceText.setText("alfredo");
        }
        else if(pizzaTypeComboBox.getValue().equals("Pepperoni")){
            toppingListView.setItems(pepperoniToppings);
            pizzaTypeDisplay.setImage(new Image(getClass().getResourceAsStream("/images/pepperoniPizza.jpg")));
            sauceText.setText("tomato");
        }
    }

}