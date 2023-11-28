package com.example.demo;

import java.util.ArrayList;

/**
 * Super class of all pizza types, defines common methods as well as some abstract ones
 * @author SebastianHanna
 *
 */

public abstract class Pizza {
    private static final int PRICE_INCREASE_MEDIUM = 2;
    private static final int PRICE_INCREASE_LARGE = 4;
    private  static final int PRICE_INCREASE_EXTRA = 1;
    protected int numberOfToppings = 0;
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    /**
     * Ensures that all pizza subtypes have a function to get their price.
     * @return double price of the respective pizza
     */
    public abstract double price(); //polymorphism

    /**
     * All pizza types share the same increase in price when size is changes or when extra sauce/cheese is selected
     * @return returns the amount that the price should be increased by due to the extra selections and size.
     */
    public double priceAdj(){
        double price = 0;
        if(size == Size.MEDIUM){
            price+=PRICE_INCREASE_MEDIUM;
        }
        if(size == Size.LARGE){
            price+=PRICE_INCREASE_LARGE;
        }
        if(extraCheese){
            price+=PRICE_INCREASE_EXTRA;
        }
        if(extraSauce){
            price+=PRICE_INCREASE_EXTRA;
        }
        return price;
    }

    /**
     * Changes the value of ExtraSauce
     * @param extra new value of extraSauce
     */
    public void setExtraSauce(boolean extra){
        extraSauce = extra;
    }

    /**
     * Changes the value of extraCheese
     * @param extra new value of extraCheese
     */
    public void setExtraCheese(boolean extra){
        extraCheese = extra;
    }

    /**
     * Changes the Size of the pizza
     * @param newSize new size of the pizza
     */
    public void setSize(Size newSize){
        size = newSize;
    }

    /**
     * Gets the size of the pizza
     * @return Size of the pizza
     */
    public Size getSize(){
        return size;
    }

    /**
     * Gets the arrayList of toppings
     * @return ArrayList List of toppings
     */
    public ArrayList<Topping> getToppings(){
        return toppings;
    }

    /**
     * Changes the array of toppings
     * @param newtoppings new array of toppings
     */
    public void setToppings(ArrayList<Topping> newtoppings){
        numberOfToppings = newtoppings.size();
        toppings = newtoppings;
    }

    /**
     * Gets the Sauce type
     * @return Sauce the sauce type
     */
    public Sauce getSauce(){
        return sauce;
    }

    /**
     * Changes the sauce type
     * @param s the new sauce type
     */
    public void setSauce(Sauce s){
        sauce = s;
    }
}
