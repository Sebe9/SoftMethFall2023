package com.example.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class BuildActivity extends AppCompatActivity {
    private BuildYourOwn currentPizza;
    private ArrayList<Topping> availableToppings;
    private ArrayList<Topping> currentToppings;
    private ArrayAdapter<Topping> currentToppingsAdapter;
    private ArrayAdapter<Topping> availableToppingsAdapter;
    private ListView availableListView;
    private ListView currentListView;
    private static final int MAX_TOPPINGS = 7;
    private static final int MIN_TOPPINGS = 3;
    private Button addButton,removeButton,addPizzaToOrder;
    private RadioButton smallButton, mediumButton, largeButton, tomatoButton,alfredoButton;
    private CheckBox extraCheese,extraSauce;
    private TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);
        availableToppings = new ArrayList<Topping>( Arrays.asList( Topping.values()));
        currentToppings = new ArrayList<Topping>();
        availableToppingsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, availableToppings);
        currentToppingsAdapter= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, currentToppings);
        availableListView = findViewById(R.id.availableListView);
        currentListView = findViewById(R.id.currentListView);
        availableListView.setAdapter(availableToppingsAdapter);
        currentListView.setAdapter(currentToppingsAdapter);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);
        availableListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        currentListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        addPizzaToOrder = findViewById(R.id.buildAddToOrder);
        smallButton = findViewById(R.id.buildSmallButton);
        mediumButton =findViewById(R.id.buildMediumButton);
        largeButton = findViewById(R.id.buildLargeButton);
        tomatoButton = findViewById(R.id.buildTomatoButton);
        alfredoButton = findViewById(R.id.buildAlfredoButton);
        extraCheese = findViewById(R.id.buildExtraCheese);
        extraSauce = findViewById(R.id.buildExtraSauce);
        currentPizza = (BuildYourOwn) PizzaMaker.createPizza("Build Your Own");
        price = findViewById(R.id.buildPrice);
        updateBuildPizza();
        addListeners();

    }

    @Override
    protected void onStart(){
        super.onStart();
    }
    private void updateBuildPizza(){
        Size currentSize;
        if(smallButton.isChecked()){
            currentSize = Size.SMALL;
        }
        else if(mediumButton.isChecked()){
            currentSize  =Size.MEDIUM;
        }
        else{
            currentSize = Size.LARGE;
        }
        currentPizza.setSize(currentSize);
        currentPizza.setExtraCheese(extraCheese.isChecked());
        currentPizza.setExtraSauce(extraSauce.isChecked());

        ArrayList<Topping> arr  = new ArrayList<Topping>();
        int toppingAmount = currentToppingsAdapter.getCount();
        for(int i = 0; i<toppingAmount;i++){
            arr.add(currentToppingsAdapter.getItem(i));
        }
        currentPizza.setToppings(arr);
        if(tomatoButton.isSelected()){
            currentPizza.setSauce(Sauce.TOMATO);
        }
        else{
            currentPizza.setSauce(Sauce.ALFREDO);
        }
        updatePrice();
    }
    private void updatePrice(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        price.setText(decimalFormat.format(currentPizza.price()));
    }
    private void toppingAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Invalid Topping Amount");
        builder.setMessage("Please select between 3 and 7 toppings.");
        builder.setPositiveButton("OK", (dialog, which) -> {
            dialog.dismiss();
        });
        builder.create();
        builder.show();
    }
    private void addAndRemoveListeners(){
        addButton.setOnClickListener(v -> {
            int selectedIndex = availableListView.getCheckedItemPosition();
            if (selectedIndex != ListView.INVALID_POSITION) {
                if (currentToppingsAdapter.getCount()== 7){
                    toppingAlert();
                    return;
                }
                Topping selected = availableToppings.get(selectedIndex);
                availableToppings.remove(selected);
                currentToppings.add(selected);
                currentToppingsAdapter.notifyDataSetChanged();
                availableToppingsAdapter.notifyDataSetChanged();
                availableListView.clearChoices();
                currentListView.clearChoices();
                updateBuildPizza();
            }
        });
        removeButton.setOnClickListener(v -> {
            int selectedIndex = currentListView.getCheckedItemPosition();
            if (selectedIndex != ListView.INVALID_POSITION) {
                Topping selected = currentToppings.get(selectedIndex);
                currentToppings.remove(selected);
                availableToppings.add(selected);
                currentToppingsAdapter.notifyDataSetChanged();
                availableToppingsAdapter.notifyDataSetChanged();
                availableListView.clearChoices();
                currentListView.clearChoices();
                updateBuildPizza();
            }
        });
        addPizzaToOrder.setOnClickListener(v -> {
            if (currentToppingsAdapter.getCount() <3){
                toppingAlert();
                return;
            }
            Singleton.getInstance().addPizza(currentPizza);
            Toast.makeText(this,"Pizza(s) added to order",Toast.LENGTH_SHORT).show();

        });
    }
    private void addListeners(){
        ArrayList<Object> buttons = new ArrayList<>();
        buttons.add(smallButton);
        buttons.add(mediumButton);
        buttons.add(largeButton);
        buttons.add(extraCheese);
        buttons.add(extraSauce);
        for(Object o:buttons){
            if (o instanceof RadioButton){
                RadioButton button = (RadioButton) o;
                button.setOnClickListener(v -> {
                    updateBuildPizza();
                });
            }
            if(o instanceof CheckBox){
                CheckBox button = (CheckBox) o;
                button.setOnClickListener(v->{
                    updateBuildPizza();
                });
            }
        }
        addAndRemoveListeners();
    }
}