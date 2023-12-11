package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class SpecialtyRecycleViewAdapter extends RecyclerView.Adapter<SpecialtyRecycleViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<SpecialtyPizzaModel> pizzaModels;
    public SpecialtyRecycleViewAdapter(Context context, ArrayList<SpecialtyPizzaModel> pizzaModels){
        this.context = context;
        this.pizzaModels = pizzaModels;
    }
    @NonNull
    @Override
    public SpecialtyRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view  = inflater.inflate(R.layout.recycle_view_layout,parent,false);
        return new SpecialtyRecycleViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SpecialtyRecycleViewAdapter.MyViewHolder holder, int position) {
        Topping[] toppingArr = pizzaModels.get(position).getToppingArray();
        ArrayList<Topping> toppingArrList = new ArrayList<Topping>(Arrays.asList(toppingArr));
        holder.specialToppings.setText(toppingArrList.toString());
        holder.sauceTypeSpecialty.setText(pizzaModels.get(position).getSauce().toString());
        holder.specialPrice.setText(String.valueOf(pizzaModels.get(position).getPrice()));
        holder.specialtyImage.setImageResource(pizzaModels.get(position).getImage());
        holder.pizzaName.setText(pizzaModels.get(position).getPizzaName());
        holder.currentPizza = PizzaMaker.createPizza(pizzaModels.get(position).getPizzaName());
        holder.currentPizza.setToppings(toppingArrList);
        holder.smallButton.setChecked(true);
        holder.currentPizza.setSize(Size.SMALL);
        holder.currentPizza.setSauce(pizzaModels.get(position).getSauce());
        addListeners(holder);
        holder.addPizzaToOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String test = holder.quantityText.getText().toString();
                int quantity = Integer.parseInt( holder.quantityText.getText().toString());
                for(int i = 0; i <quantity;i++){
                    Singleton.getInstance().addPizza(holder.currentPizza);
                }
                Toast.makeText(context,"Pizza(s) added to order",Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    public int getItemCount() {

        return pizzaModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView specialtyImage;
        TextView specialToppings, sauceTypeSpecialty, specialPrice,pizzaName;
        Button addPizzaToOrder;
        Pizza currentPizza;
        EditText quantityText;
        RadioButton smallButton,mediumButton,largeButton;
        CheckBox extraCheese,extraSauce;

        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            pizzaName = itemView.findViewById(R.id.specialName);
            specialtyImage = itemView.findViewById(R.id.RecycleViewImage);
            specialToppings = itemView.findViewById(R.id.specialToppings);
            sauceTypeSpecialty = itemView.findViewById(R.id.sauceTypeSpecialty);
            specialPrice = itemView.findViewById(R.id.specialPrice);
            addPizzaToOrder = itemView.findViewById(R.id.addPizzaRecycle);
            quantityText = itemView.findViewById(R.id.specialQuantity);
            smallButton= itemView.findViewById(R.id.smallButtonSpecialty);
            mediumButton = itemView.findViewById(R.id.mediumButtonSpecialty);
            largeButton = itemView.findViewById(R.id.largeButtonSpecialty);
            extraCheese = itemView.findViewById(R.id.extraCheeseBox);
            extraSauce = itemView.findViewById(R.id.ExtraSauceBox);

        }
    }
    private void addListeners(@NonNull SpecialtyRecycleViewAdapter.MyViewHolder holder){
        ArrayList<Object> buttons = new ArrayList<>();
        buttons.add(holder.smallButton);
        buttons.add(holder.mediumButton);
        buttons.add(holder.largeButton);
        buttons.add(holder.extraCheese);
        buttons.add(holder.extraSauce);
        for(Object o:buttons){
            if (o instanceof RadioButton){
                RadioButton button = (RadioButton) o;
                button.setOnClickListener(v -> {
                    updateSpecialtyPizzaInfo(holder);
                });
            }
            if(o instanceof CheckBox){
                CheckBox button = (CheckBox) o;
                button.setOnClickListener(v->{
                    updateSpecialtyPizzaInfo(holder);
                });
            }

        }
    }

    private void updateSpecialtyPizzaInfo(@NonNull SpecialtyRecycleViewAdapter.MyViewHolder holder){
        Size currentSize;
        if(holder.smallButton.isChecked()){
            currentSize = Size.SMALL;
        }
        else if(holder.mediumButton.isChecked()){
            currentSize  =Size.MEDIUM;
        }
        else{
            currentSize = Size.LARGE;
        }
        holder.currentPizza.setSize(currentSize);
        holder.currentPizza.setExtraCheese(holder.extraCheese.isChecked());
        holder.currentPizza.setExtraSauce(holder.extraSauce.isChecked());
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        holder.specialPrice.setText(decimalFormat.format( holder.currentPizza.price()));
    }

}
