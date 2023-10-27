package com.example.lab1louis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TipCalculatorActivity extends AppCompatActivity {
    // Declaring my variables
    // TexView
    private TextView tvTipCalculatorTitle;
    private TextView tvTotalTipCalculated;

    private TextView tvTotalTipPerPersonCalculated;
    private TextView tvGSTCalculated;
    private TextView tvHSTCalculated;
    //Buttons
    private Button btnBackTipCalculator;
    private Button btnCalculate;
    // Edit Text
    private EditText etBillBeforeTaxes;
    private EditText etTipPercentage;
    private EditText etNumberOfPeople;
    // CheckBox
    private CheckBox checkBoxIncludesTaxInTip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        // Initializing variables
        tvTipCalculatorTitle = findViewById(R.id.tvTipCalculatorTitle);
        btnBackTipCalculator = findViewById(R.id.btnBackTipCalculator);
        etBillBeforeTaxes = findViewById(R.id.etBillBeforeTaxes);
        etTipPercentage = findViewById(R.id.etTipPercentage);
        etNumberOfPeople = findViewById((R.id.etNumberOfPeople));
        tvTotalTipCalculated = findViewById(R.id.tvTotalTipCalculated);
        tvTotalTipPerPersonCalculated = findViewById(R.id.tvTotalTipPerPersonCalculated);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvGSTCalculated = findViewById(R.id.tvGSTCalculated);
        tvHSTCalculated = findViewById(R.id.tvHSTCalculated);
        checkBoxIncludesTaxInTip = findViewById(R.id.checkBoxIncludesTaxInTip);


        // Add input validation for etBillBeforeTaxes
        etBillBeforeTaxes.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Validate input using a regular expression
                String regex = "^\\d{0,6}(\\.\\d{0,2})?$"; // Allows up to 6 digits before the decimal point and up to 2 digits after the decimal point
                if (!s.toString().matches(regex)) {
                    // Input is not valid
                    etBillBeforeTaxes.setError("Invalid input");
                } else {
                    // Input is valid
                    etBillBeforeTaxes.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });


        // Setting text color to tvTipCalculatorTitle
        tvTipCalculatorTitle.setTextColor(Color.BLACK);

        // Setting text color to GRAY for "Bill (before taxes)", "Tip Percentage %" and "Number of people"
        etBillBeforeTaxes.setHintTextColor(Color.GRAY);
        etTipPercentage.setHintTextColor(Color.GRAY);
        etNumberOfPeople.setHintTextColor(Color.GRAY);

        // Setting text color to GREEN for "Total Tip" and "Total Tip per Person"
        tvTotalTipCalculated.setTextColor(Color.GREEN);
        tvTotalTipPerPersonCalculated.setTextColor(Color.GREEN);


        // Activating the back button
        btnBackTipCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(TipCalculatorActivity.this, MainActivity.class));
            }
        });

        // CALCULATE TIP!!!!!
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Check if required fields are filled in
                if (etBillBeforeTaxes.getText().toString().isEmpty() ||
                        etTipPercentage.getText().toString().isEmpty() ||
                        etNumberOfPeople.getText().toString().isEmpty() ||
                        etNumberOfPeople.getText().toString().equals("0")) {
                    // Display system message
                    Toast.makeText(TipCalculatorActivity.this, ". Bill (before taxes), Tip percentage and Number of people cannot be empty. Number of people cannot be 0", Toast.LENGTH_SHORT).show();
                } else {
                    // Display system message
                    Toast.makeText(TipCalculatorActivity.this, "You need to complete all fields before calculating (Bill, Tip percentage and Number of people)", Toast.LENGTH_SHORT).show();

                    calculateAndDisplayGST();
                    calculateAndDisplayHST();
                    if (checkBoxIncludesTaxInTip.isChecked()) {
                        // Tips with taxes
                        calculateAndDisplayTipWithTaxes();
                    } else {
                        // Tip without taxes
                        calculateTip();
                        calculateTipPerPerson();
                    }
                }
            }
        });
    }


        // METHODS
    // Method to calculate the tip
    private void calculateTip(){
        double BillBeforeTaxes = Double.parseDouble(etBillBeforeTaxes.getText().toString());
        double TipPercentage = (Double.parseDouble(etTipPercentage.getText().toString()))/100;
        double TotalTip = BillBeforeTaxes*TipPercentage;
        // Display
        tvTotalTipCalculated.setText(String.format("%.2f$", TotalTip));
    }

    // Method to calculate the tip per person
    private void calculateTipPerPerson(){
        double BillBeforeTaxes = Double.parseDouble(etBillBeforeTaxes.getText().toString());
        double TipPercentage = (Double.parseDouble(etTipPercentage.getText().toString()))/100;
        int NumberOfPeople = Integer.parseInt(etNumberOfPeople.getText().toString());
        double TotalTip = BillBeforeTaxes*TipPercentage;
        double TotalTipPerPerson = TotalTip/NumberOfPeople;
        // Display
        tvTotalTipPerPersonCalculated.setText(String.format("%.2f$ / per", TotalTipPerPerson));
    }

    // Calculate and display GST
    private void calculateAndDisplayGST(){
        double BillBeforeTaxes = Double.parseDouble(etBillBeforeTaxes.getText().toString());
        double GST = BillBeforeTaxes*0.05;
        tvGSTCalculated.setText(String.format("%.2f$", GST));

    }


    // Calculate and display HST
    private void calculateAndDisplayHST(){
        double BillBeforeTaxes = Double.parseDouble(etBillBeforeTaxes.getText().toString());
        double HST = BillBeforeTaxes*0.09975;
        tvHSTCalculated.setText(String.format("%.2f$", HST));
    }



    private void calculateAndDisplayTipWithTaxes(){
        double BillBeforeTaxes = Double.parseDouble(etBillBeforeTaxes.getText().toString());
        double GST = BillBeforeTaxes*0.05;
        double HST = BillBeforeTaxes*0.09975;
        double totalTaxes = GST + HST;

        // Total bill with taxes
        double totalBill =  BillBeforeTaxes + totalTaxes;

        // Total Tip with taxes
        double TipPercentage = (Double.parseDouble(etTipPercentage.getText().toString()))/100;
        int NumberOfPeople = Integer.parseInt(etNumberOfPeople.getText().toString());
        double TotalTip = totalBill*TipPercentage;
        double TotalTipPerPerson = TotalTip/NumberOfPeople;
        // Display
        tvTotalTipCalculated.setText(String.format("%.2f$", TotalTip));
        // Total tip per person with taxes
        // Display
        tvTotalTipPerPersonCalculated.setText(String.format("%.2f$ / per", TotalTipPerPerson));
    }


    }

