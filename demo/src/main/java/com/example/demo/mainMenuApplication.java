package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Driver class
 * @author SebastianHanna
 */
public class mainMenuApplication extends Application {
    /**
     * Creates the main menu GUI
     * @param stage the state for the main menu GUI
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(mainMenuApplication.class.getResource("mainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800     , 800);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * launches the program
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }
}