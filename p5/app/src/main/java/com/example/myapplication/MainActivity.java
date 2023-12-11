package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setImageButton();

    }
    @Override
    protected void onStart(){
        super.onStart();
    }
    private void setImageButton(){
        ImageView specialtyImage = findViewById(R.id.specialtyImage);
        ImageView buildImage = findViewById(R.id.buildImage);
        ImageView currentOrderImage = findViewById(R.id.currentOrderImage);
        ImageView storeOrdersImage = findViewById(R.id.storeOrdersImage);
        specialtyImage.setOnClickListener(v -> openSpecialtyMenu());
        buildImage.setOnClickListener(v -> openBuildMenu());
        currentOrderImage.setOnClickListener(v -> openCurrentOrderMenu());
        storeOrdersImage.setOnClickListener(v -> openStoreOrdersMenu());
    }
    private void openSpecialtyMenu(){
        Intent intent = new Intent(this, SpecialtyActivity.class);
        startActivity(intent);
    }
    private void openBuildMenu(){
        Intent intent = new Intent(this, BuildActivity.class);
        startActivity(intent);
    }
    private void openCurrentOrderMenu(){
        Intent intent = new Intent(this, CurrentOrderActivity.class);
        startActivity(intent);
    }
    private void openStoreOrdersMenu(){
        Intent intent = new Intent(this, StoreOrdersActivity.class);
        startActivity(intent);
    }

}