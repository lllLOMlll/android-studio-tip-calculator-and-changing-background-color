package com.example.lab1louis;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AboutMeActivity extends AppCompatActivity {
    // Declaring my variables
    private Button btnBack;
    private Button btnSecret;

    private TextView tvAboutMe;
    private TextView tvAboutMeText;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        // Initializing my variables
        btnBack = findViewById(R.id.btnBack);
        btnSecret = findViewById(R.id.btnSecret);
        tvAboutMe = findViewById(R.id.tvAboutMe);
        tvAboutMeText = findViewById(R.id.tvAboutMeText);

        // Setting text color for tvAboutMe
        tvAboutMe.setTextColor(Color.BLACK);

        // Editing text for editTextTextMultiLineAboutMe
        tvAboutMeText.setText("My name is Louis-Olivier Major. I live in Saint-Julie with my wife Marie and my two children Victor and Magalie. I like video games and mountain biking. I was a high school teacher but I'm reorienting my career to become a programmer analyst. It's challenging but highly rewarding.");

        // BtnSecret (toast)
        btnSecret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "You are too curious for your own good", Toast.LENGTH_LONG).show();
            }
        });


        // Setting an OnClickListener on the btnAboutMe button
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                finish();
                startActivity(new Intent(AboutMeActivity.this, MainActivity.class));
            }
        });
    }
}
