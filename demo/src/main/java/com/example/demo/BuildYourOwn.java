package com.example.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BuildYourOwn extends Pizza{
    private int numberOfToppings = 0;
    public double price() {
        double price = 8.99;
        price += priceAdj();
        if(numberOfToppings > 3){
            int extraToppings = numberOfToppings-3;
            price+=(1.49*extraToppings);
        }
        return price;
    }
    public void setToppings(ArrayList<Topping> newtoppings){
        numberOfToppings = newtoppings.size();
        toppings = newtoppings;
    }
    public void setSauce(Sauce selection){
        sauce = selection;
    }
}
