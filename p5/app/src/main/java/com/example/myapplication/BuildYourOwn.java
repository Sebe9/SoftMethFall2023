package com.example.myapplication;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Subclass of Pizza. Unlike the other subclasses, you can manually set the sauce and toppings
 * @author SebastianHanna
 */
public class BuildYourOwn extends Pizza{

    private static final double BASE_PRICE = 8.99;
    private static final int MIN_TOPPINGS = 3;
    private static final double ADDITIONAL_TOPPING_CHARGE = 1.49;
    /**
     * Returns the price of the pizza including adjustments from toppings, size etc.
     * @return double price of the Pizza
     */
    public double price() {
        double price = BASE_PRICE;
        price += priceAdj();
        if(numberOfToppings > MIN_TOPPINGS){
            int extraToppings = numberOfToppings-MIN_TOPPINGS;
            price+=(ADDITIONAL_TOPPING_CHARGE*extraToppings);
        }
        return price;
    }

    /**
     * Assigns the toppings of this pizza to the parameter list
     * @param newtoppings ArrayList of the new toppings
     */
    public void setToppings(ArrayList<Topping> newtoppings){
        numberOfToppings = newtoppings.size();
        toppings = newtoppings;
    }

    /**
     * Sets this pizza's suace to the selection
     * @param selection sets this pizza's sauce
     */
    public void setSauce(Sauce selection){
        sauce = selection;
    }
}
