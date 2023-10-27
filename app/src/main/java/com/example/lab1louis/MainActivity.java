package com.example.lab1louis;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // Declaring my variables
    private TextView tvTitleHerzingCollege;
    private TextView tvName;
    private TextView tvCurrentDateTime;
    private Button btnAboutMe;
    private Button btnColorSwitcher;
    private Button btnTipCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing my variables
        tvTitleHerzingCollege = findViewById(R.id.tvTitleHerzingCollege);
        tvName = findViewById(R.id.tvName);
        tvCurrentDateTime = findViewById(R.id.tvCurrentDateTime);
        btnAboutMe = findViewById(R.id.btnAboutMe);
        btnColorSwitcher = findViewById(R.id.btnColorSwitcher);
        btnTipCalculator = findViewById(R.id.btnTipCalculator);

        // Setting time in my TexView tvCurrentDateTime
        String currentTime = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault()).format(new Date());
        tvCurrentDateTime.setText(currentTime);

        // Setting tex view as black
        tvCurrentDateTime.setTextColor(Color.BLACK);
        tvName.setTextColor(Color.BLACK);
        tvTitleHerzingCollege.setTextColor(Color.BLACK);

        // Creating an intent to launch the AboutMeActivity
        Intent aboutMe = new Intent(this, AboutMeActivity.class);
        Intent colorSwitcher = new Intent(this, ColorSwitcherActivity.class);
        Intent tipCalculator = new Intent(this, TipCalculatorActivity.class);

        // Setting an OnClickListener on the btnAboutMe button
        btnAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(aboutMe);
            }
        });

        // Btn btnColorSwitcher
        btnColorSwitcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(colorSwitcher);
            }
        });

        // Btn btnTipCalculator
        btnTipCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(tipCalculator);
            }
        });
    }
}
