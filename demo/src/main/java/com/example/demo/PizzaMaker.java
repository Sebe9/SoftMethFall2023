package com.example.demo;

public class PizzaMaker {
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
