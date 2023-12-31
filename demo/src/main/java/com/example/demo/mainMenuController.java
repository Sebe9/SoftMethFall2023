package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.util.ArrayList;

/**
 * Controller class for the main menu GUI
 * @author SebastianHanna
 */
public class mainMenuController {

    @FXML
    private Label welcomeText;
    @FXML
    private VBox specialtyMenuButtonVBox;
    @FXML
    private VBox buildMenuButtonVBox;
    @FXML
    private VBox currentOrderMenuButtonVBox;
    @FXML
    private VBox storeOrdersButtonVBox;


    /**
     * Opens the specialty menu GUi
     */
    @FXML
    protected void openSpecialtyMenu(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(mainMenuApplication.class.getResource("specialtyMenu.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.setController(new specialtyMenuController());

            Scene scene = new Scene(root, 800, 800);

            Stage newStage = new Stage();
            newStage.setTitle("Specialty Menu");
            newStage.setScene(scene);

            newStage.show();

        }catch (Exception e){

        }
    }

    /**
     * Opens the build menu GUI
     */
    @FXML
    protected void openBuildMenu(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(mainMenuApplication.class.getResource("buildMenu.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.setController(new specialtyMenuController());

            Scene scene = new Scene(root, 800, 800);

            Stage newStage = new Stage();
            newStage.setTitle("Build Your Own Pizza.java");
            newStage.setScene(scene);

            newStage.show();

        }catch (Exception e){

        }
    }

    /**
     * Opens the current order GUI
     */
    @FXML
    protected void openCurrentOrder(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(mainMenuApplication.class.getResource("currentOrder.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.setController(new specialtyMenuController());

            Scene scene = new Scene(root, 800, 800);

            Stage newStage = new Stage();
            newStage.setTitle("Current Order");
            newStage.setScene(scene);

            newStage.show();

        }catch (Exception e){

        }
    }

    /**
     * Opens the store orders GUi
     */
    @FXML
    protected void openStoreOrders(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(mainMenuApplication.class.getResource("storeOrders.fxml"));
            Parent root = fxmlLoader.load();
            fxmlLoader.setController(new specialtyMenuController());

            Scene scene = new Scene(root, 800, 800);
            Stage newStage = new Stage();
            newStage.setTitle("Store Orders");
            newStage.setScene(scene);

            newStage.show();

        }catch (Exception e){

        }
    }


}