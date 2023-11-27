package com.example.demo;

import java.util.ArrayList;

public abstract class Pizza {
    protected int numberOfToppings = 0;
    protected ArrayList<Topping> toppings; //Topping is a enum class
    protected Size size; //Size is a enum class
    protected Sauce sauce; //Sauce is a enum class
    protected boolean extraSauce;
    protected boolean extraCheese;

    public abstract double price(); //polymorphism
    public double priceAdj(){
        double price = 0;
        if(size == Size.MEDIUM){
            price+=2;
        }
        if(size == Size.LARGE){
            price+=4;
        }
        if(extraCheese){
            price+=1;
        }
        if(extraSauce){
            price+=1;
        }
        return price;
    }
    public void setExtraSauce(boolean extra){
        extraSauce = extra;
    }
    public void setExtraCheese(boolean extra){
        extraCheese = extra;
    }
    public void setSize(Size newSize){
        size = newSize;
    }
    public Size getSize(){
        return size;
    }
    public ArrayList<Topping> getToppings(){
        return toppings;
    }
    public void setToppings(ArrayList<Topping> newtoppings){
        numberOfToppings = newtoppings.size();
        toppings = newtoppings;
    }
    public Sauce getSauce(){
        return sauce;
    }
    public void setSauce(Sauce s){
        sauce = s;
    }
}
