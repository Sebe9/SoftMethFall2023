package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SpecialtyActivity extends AppCompatActivity {
    private ArrayList<SpecialtyPizzaModel> specialtyPizzaModels= new ArrayList<SpecialtyPizzaModel>();
    private int[] specialityPizzaImages = {R.drawable.deluxe_pizza,R.drawable.supreme_pizza,R.drawable.meatzza_image,
            R.drawable.seafood_pizza,R.drawable.pepperoni_pizza,R.drawable.pineapple_pizza,R.drawable.veggie_pizza,
            R.drawable.hawaiian_pizza,R.drawable.alfredo_pizza,R.drawable.shrimp_pizza};
    private Topping[] DeluxeToppings = {Topping.SAUSAGE, Topping.PEPPERONI, Topping.GREEN_PEPPER, Topping.ONION,Topping.MUSHROOM};
    private Topping[] SupremeToppings ={Topping.SAUSAGE, Topping.PEPPERONI, Topping.HAM,Topping.GREEN_PEPPER, Topping.ONION,Topping.BLACK_OLIVE,Topping.MUSHROOM};
    private Topping[] MeatzzaToppings ={Topping.SAUSAGE, Topping.PEPPERONI, Topping.BEEF,Topping.HAM};
    private Topping[] SeafoodToppings ={Topping.SHRIMP, Topping.SQUID, Topping.CRAB_MEATS,Topping.ONION,Topping.MUSHROOM};
    private Topping[] PepperoniToppings ={Topping.PEPPERONI};
    private Topping[] PineAppleToppings = {Topping.PINEAPPLE};
    private Topping[] VeggieToppings = {Topping.BLACK_OLIVE,Topping.GREEN_PEPPER,Topping.MUSHROOM,Topping.ONION};
    private Topping[] HawaiianToppings = {Topping.PINEAPPLE,Topping.HAM};
    private Topping[] AlfredoToppings = {Topping.PEPPERONI};
    private Topping[] ShrimpToppings = {Topping.SHRIMP,Topping.ONION};
    private Topping[][] ToppingLists = {DeluxeToppings,SupremeToppings,MeatzzaToppings,SeafoodToppings,PepperoniToppings,
            PineAppleToppings,VeggieToppings,HawaiianToppings,AlfredoToppings,ShrimpToppings};
    String[] specialtyPizzaNames;
    Sauce[] specialtySauces = {Sauce.TOMATO,Sauce.TOMATO,Sauce.TOMATO,Sauce.ALFREDO,Sauce.TOMATO,Sauce.TOMATO,Sauce.TOMATO,Sauce.TOMATO,Sauce.ALFREDO,Sauce.ALFREDO};
    double[] specialtyPrices = {14.99,15.99,16.99,17.99,10.99,11.99,11.99,10.99,10.99,12.99,};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialty);
        specialtyPizzaNames = getResources().getStringArray(R.array.specialty_pizza_names);
        setUpModels();
        RecyclerView recyclerView = findViewById(R.id.RecyclerViewPizzas);
        SpecialtyRecycleViewAdapter adapter = new SpecialtyRecycleViewAdapter(this, specialtyPizzaModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        specialtyPizzaNames = getResources().getStringArray(R.array.specialty_pizza_names);

    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    private void setUpModels(){

        for (int i =0; i<specialtyPizzaNames.length;i++){
            specialtyPizzaModels.add(new SpecialtyPizzaModel(specialityPizzaImages[i],specialtyPizzaNames[i],ToppingLists[i],
                    specialtySauces[i],specialtyPrices[i]));
        }
    }


}
