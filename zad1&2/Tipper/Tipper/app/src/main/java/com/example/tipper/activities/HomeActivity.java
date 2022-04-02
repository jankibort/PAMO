package com.example.tipper.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tipper.R;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // call superclass onCreate
        setContentView(R.layout.activity_home); // inflate the GUI

        Button bmiButton;
        Button kcalButton;
        Button recipesButton;

        bmiButton = (Button) findViewById(R.id.bmiButton);
        kcalButton = (Button) findViewById(R.id.kcalButton);
        recipesButton = (Button) findViewById(R.id.recipesButton);

        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchBMIActivity();
            }
        });

        kcalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchCalorieActivity();
            }
        });

        recipesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchRecipeActivity();
            }
        });

    }

    private void launchRecipeActivity(){
        Intent intent = new Intent(this, RecipeActivity.class);
        startActivity(intent);
    }

    private void launchCalorieActivity(){
        Intent intent = new Intent(this, CalorieActivity.class);
        startActivity(intent);
    }

    private void launchBMIActivity(){
        Intent intent = new Intent(this, Bmi_Activity.class);
        startActivity(intent);
    }
}