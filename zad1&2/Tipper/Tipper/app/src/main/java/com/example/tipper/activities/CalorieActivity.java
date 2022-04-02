package com.example.tipper.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tipper.R;

import java.text.DecimalFormat;

public class CalorieActivity extends AppCompatActivity {

    private double weight = 0.0;
    private double height = 0.0;
    private int age;
    private double result;
    private String gender;
    private Spinner genderDropdown;
    private EditText heightEditText;
    private EditText weightEditText;
    private EditText ageEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        genderDropdown = (Spinner) findViewById(R.id.genderDropdown);
        genderDropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calculate();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        heightEditText = (EditText) findViewById(R.id.heightEditText);
        heightEditText.addTextChangedListener(heightEditTextWatcher);

        weightEditText = (EditText) findViewById(R.id.weightEditText);
        weightEditText.addTextChangedListener(weightEditTextWatcher);

        ageEditText = (EditText) findViewById(R.id.ageEditText);
        ageEditText.addTextChangedListener(ageEditTextWatcher);
        resultTextView = (TextView) findViewById(R.id.resultTextView);


    }

    private void calculate() {
        gender = genderDropdown.getSelectedItem().toString();

        DecimalFormat df = new DecimalFormat("##.##");
        result = 0.0;

        if(age > 0 && height > 0.0 && weight > 0.0){
            if(new String("Male").equals(gender)){
                // Calculate for man
                result = 66.5 + (13.75 * weight) + (5.003 * height) - (6.775 * age);
            } else {
                // Calculate for woman
                result = 655.1 + (9.563 * weight) + (1.85 * height) - (4.676 * age);
            }
            resultTextView.setText(df.format(result));
        } else {
            resultTextView.setText("");
        }
    }

    private final TextWatcher weightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get weight
                weight = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e) { // if s is empty or non-numeric
                weight = 0.0;
            }

            calculate(); // update the bmi TextView
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher heightEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get weight
                height = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e) {
                height = 0.0;
            }

            calculate(); // update the bmi TextView
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };

    private final TextWatcher ageEditTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start,
                                  int before, int count) {

            try { // get weight
                age = Integer.parseInt(s.toString());
            }
            catch (NumberFormatException e) {
                age = 0;
            }

            calculate(); // update the bmi TextView
        }

        @Override
        public void afterTextChanged(Editable s) { }

        @Override
        public void beforeTextChanged(
                CharSequence s, int start, int count, int after) { }
    };
}