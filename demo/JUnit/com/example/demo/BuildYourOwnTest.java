package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BuildYourOwnTest {

    @Test
    void priceNoOptions() {
        Pizza buildYourOwnTest = PizzaMaker.createPizza("BuildYourOwn");
        assertEquals(8.99, buildYourOwnTest.price());
    }
    @Test
    void priceLarge() {
        Pizza buildYourOwnTest = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwnTest.setSize(Size.LARGE);
        assertEquals(12.99, buildYourOwnTest.price());
    }
    @Test
    void price5Toppings() {
        Pizza buildYourOwnTest = PizzaMaker.createPizza("BuildYourOwn");
        ArrayList<Topping> testToppings = new ArrayList();
        testToppings.add(Topping.SAUSAGE);
        testToppings.add(Topping.BLACK_OLIVE);
        testToppings.add(Topping.PINEAPPLE);
        testToppings.add(Topping.PEPPERONI);
        testToppings.add(Topping.ONION);
        buildYourOwnTest.setToppings(testToppings);
        assertEquals(11.97, buildYourOwnTest.price());
    }
    @Test
    void priceExtraBoth() {
        Pizza buildYourOwnTest = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwnTest.setExtraSauce(true);
        buildYourOwnTest.setExtraCheese(true);
        assertEquals(10.99, buildYourOwnTest.price());
    }
    @Test
    void priceAllOptions() {
        Pizza buildYourOwnTest = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwnTest.setSize(Size.LARGE);
        buildYourOwnTest.setExtraCheese(true);
        buildYourOwnTest.setExtraSauce(true);

        ArrayList<Topping> testToppings = new ArrayList();
        testToppings.add(Topping.SAUSAGE);
        testToppings.add(Topping.BLACK_OLIVE);
        testToppings.add(Topping.PINEAPPLE);
        testToppings.add(Topping.PEPPERONI);
        testToppings.add(Topping.ONION);
        testToppings.add(Topping.GREEN_PEPPER);
        testToppings.add(Topping.BEEF);

        buildYourOwnTest.setToppings(testToppings);
        assertEquals(20.95, buildYourOwnTest.price());
    }

    @Test
    void priceAlfredo() {
        Pizza buildYourOwnTest = PizzaMaker.createPizza("BuildYourOwn");
        buildYourOwnTest.setSauce(Sauce.ALFREDO);
        assertEquals(8.99, buildYourOwnTest.price());
    }
}