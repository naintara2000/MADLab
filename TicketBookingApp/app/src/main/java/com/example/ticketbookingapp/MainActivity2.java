package com.example.ticketbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    TextView textView;
    Button button;
    CheckBox A1, A2, A3, A4, B1, B2, B3, B4, C1, C2, C3, C4, D1, D2, D3, D4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        textView = findViewById(R.id.textView);
        textView.setText(message);

        addListenerOnButtonClick();

    }
    public void addListenerOnButtonClick() {
        //Getting instance of CheckBoxes and Button from the activty_main.xml file
        A1 = (CheckBox) findViewById(R.id.checkBoxA1);
        A2 = (CheckBox) findViewById(R.id.checkBoxA2);
        A3 = (CheckBox) findViewById(R.id.checkBoxA3);
        A4 = (CheckBox) findViewById(R.id.checkBoxA4);
        B1 = (CheckBox) findViewById(R.id.checkBoxB1);
        B2 = (CheckBox) findViewById(R.id.checkBoxB2);
        B3 = (CheckBox) findViewById(R.id.checkBoxB3);
        B4 = (CheckBox) findViewById(R.id.checkBoxB4);
        C1 = (CheckBox) findViewById(R.id.checkBoxC1);
        C2 = (CheckBox) findViewById(R.id.checkBoxC2);
        C3 = (CheckBox) findViewById(R.id.checkBoxC3);
        C4 = (CheckBox) findViewById(R.id.checkBoxC4);
        D1 = (CheckBox) findViewById(R.id.checkBoxD1);
        D2 = (CheckBox) findViewById(R.id.checkBoxD2);
        D3 = (CheckBox) findViewById(R.id.checkBoxD3);
        D4 = (CheckBox) findViewById(R.id.checkBoxD4);
        button = (Button) findViewById(R.id.button);

        //Applying the Listener on the Button click
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int totalamount = 0;
                StringBuilder result = new StringBuilder();
                result.append("");
                if (A1.isChecked()) {
                    totalamount += 1000;
                }
                if (A2.isChecked()) {
                    totalamount += 1000;
                }
                if (A3.isChecked()) {
                    totalamount += 1000;
                }
                if (A4.isChecked()) {
                    totalamount += 1000;
                }
                if (B1.isChecked()) {
                    totalamount += 1000;
                }
                if (B2.isChecked()) {
                    totalamount += 1000;
                }
                if (B3.isChecked()) {
                    totalamount += 1000;
                }
                if (B4.isChecked()) {
                    totalamount += 1000;
                }
                if (C1.isChecked()) {
                    totalamount += 750;
                }
                if (C2.isChecked()) {
                    totalamount += 750;
                }
                if (C3.isChecked()) {
                    totalamount += 7500;
                }
                if (C4.isChecked()) {
                    totalamount += 7500;
                }
                if (D1.isChecked()) {
                    totalamount += 500;
                }
                if (D2.isChecked()) {
                    totalamount += 500;
                }
                if (D3.isChecked()) {
                    totalamount += 500;
                }
                if (D4.isChecked()) {
                    totalamount += 500;
                }
                result.append("\nTotal: " + totalamount + "Rs");
                //Displaying the message on the toast
                Toast.makeText(getApplicationContext(), result.toString(), Toast.LENGTH_LONG).show();
            }

        });
        }
    }