package com.example.lab1louis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class ColorSwitcherActivity extends AppCompatActivity {
    // Declaring my variables
    private TextView tvColorSwitcher;
    private Button btnBackColorSwitcher;
    private RadioButton radioButtonRed;
    private RadioButton radioButtonGreen;
    private RadioButton radioButtonBlue;
    private CheckBox checkBoxRed;
    private CheckBox checkBoxGreen;
    private CheckBox checkBoxBlue;
    private ConstraintLayout constraintLayoutColorSwitcher;

    // Colors
    private int defaultColor = Color.parseColor("#9CB5FF");

    private int redColor = Color.RED;
    private int greenColor = Color.GREEN;
    private int blueColor = Color.BLUE;
    private int purpleColor = Color.rgb(255, 0, 255);
    private int yellowColor = Color.YELLOW;
    private int tealColor = Color.rgb(0, 255, 255);
    private int blackColor = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_switcher);

        // Initializing variables
        tvColorSwitcher = findViewById(R.id.tvColorSwitcher);
        btnBackColorSwitcher = findViewById(R.id.btnBackColorSwitcher);
        radioButtonRed = findViewById(R.id.radioButtonRed);
        radioButtonGreen = findViewById(R.id.radioButtonGreen);
        radioButtonBlue = findViewById(R.id.radioButtonBlue);
        checkBoxRed = findViewById(R.id.checkBoxRed);
        checkBoxGreen = findViewById(R.id.checkBoxGreen);
        checkBoxBlue = findViewById(R.id.checkBoxBlue);
        constraintLayoutColorSwitcher = findViewById(R.id.ConstraintLayoutColorSwitcher);

        // Setting text color tvColorSwitcher
        tvColorSwitcher.setTextColor(Color.BLACK);

        // btnBack
        btnBackColorSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                finish();
                startActivity(new Intent(ColorSwitcherActivity.this, MainActivity.class));
            }
        });

        // Switching radio button RED
        radioButtonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor();
            }
        });

        // Switching radio button GREEN
        radioButtonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor();
            }
        });

        // Switching radio button BLUE
        radioButtonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor();
            }
        });

        // Update background color based on checkboxes
        checkBoxRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor();
            }
        });

        checkBoxGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor();
            }
        });

        checkBoxBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBackgroundColor();
            }
        });
    }

    // Update the background color based on the selected radio button and checkboxes
    private void updateBackgroundColor() {
        int color = defaultColor;
        if (radioButtonRed.isChecked()) {
            if (checkBoxGreen.isChecked() && !checkBoxBlue.isChecked()) {
                color = yellowColor;
            } else if (checkBoxBlue.isChecked() && !checkBoxGreen.isChecked()) {
                color = purpleColor;
            } else if (checkBoxGreen.isChecked() && checkBoxBlue.isChecked()) {
                color = blackColor;
            } else {
                color = redColor;
            }
        } else if (radioButtonGreen.isChecked()) {
            if (checkBoxRed.isChecked() && !checkBoxBlue.isChecked()) {
                color = yellowColor;
            } else if (checkBoxBlue.isChecked() && !checkBoxRed.isChecked()) {
                color = tealColor;
            } else if (checkBoxRed.isChecked() && checkBoxBlue.isChecked()) {
                color = blackColor;
            } else {
                color = greenColor;
            }
        } else if (radioButtonBlue.isChecked()) {
            if (checkBoxRed.isChecked() && !checkBoxGreen.isChecked()) {
                color = purpleColor;
            } else if (checkBoxGreen.isChecked() && !checkBoxRed.isChecked()) {
                color = tealColor;
            } else if (checkBoxRed.isChecked() && checkBoxGreen.isChecked()) {
                color = blackColor;
            } else {
                color = blueColor;
            }
        }
        constraintLayoutColorSwitcher.setBackgroundColor(color);
    }
}