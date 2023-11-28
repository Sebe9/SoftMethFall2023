package com.example.demo;

/**
 * Serves as a factor for all pizza types
 * @author Sebastianhanna
 */

public class PizzaMaker {
    /**
     * Creates a pizza using a string to determine the type of pizza
     * @param pizzaType String that determines the type of pizza that will be returned
     * @return The new pizza
     */
    public static Pizza createPizza(String pizzaType) {
        switch (pizzaType) {
            case "Deluxe" -> {
                return new Deluxe();
            }
            case "Supreme" -> {
                return new Supreme();
            }
            case "Meatzza" -> {
                return new Meatzza();
            }
            case "Seafood" -> {
                return new Seafood();
            }
            case "Pepperoni" -> {
                return new Pepperoni();
            }
            default -> {
                return new BuildYourOwn();
            }
        }

    }
}
