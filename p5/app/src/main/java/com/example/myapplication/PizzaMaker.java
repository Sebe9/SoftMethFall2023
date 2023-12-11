package com.example.myapplication;

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
        Pizza pizza;

        switch (pizzaType) {
            case "Deluxe":
                pizza = new Deluxe();
                break;
            case "Supreme":
                pizza = new Supreme();
                break;
            case "Meatzza":
                pizza = new Meatzza();
                break;
            case "Seafood":
                pizza = new Seafood();
                break;
            case "Pepperoni":
                pizza = new Pepperoni();
                break;
            case "PineApple":
                pizza = new PineApple();
                break;
            case "Veggie":
                pizza = new Veggie();
                break;
            case "Hawaiian":
                pizza = new Hawaiian();
                break;
            case "Alfredo":
                pizza = new Alfredo();
                break;
            case "Shrimp":
                pizza = new Shrimp();
                break;
            default:
                pizza = new BuildYourOwn();
                break;
        }

        return pizza;
    }
}
