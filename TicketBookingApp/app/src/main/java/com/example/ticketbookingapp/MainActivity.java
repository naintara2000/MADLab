//Lab 4: Button, Toggle Button, Check Box, View, Toast
//Lab 5: Spinners, Pickers

package com.example.ticketbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinnerD = (Spinner) findViewById(R.id.spinnerDestinations);
        ArrayAdapter<CharSequence> adapterSD = ArrayAdapter.createFromResource(this, R.array.places_array, android.R.layout.simple_spinner_item);
        adapterSD.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerD.setAdapter(adapterSD);
        Spinner spinnerS = (Spinner) findViewById(R.id.spinnerSource);
        ArrayAdapter<CharSequence> adapterSS = ArrayAdapter.createFromResource(this, R.array.places_array, android.R.layout.simple_spinner_item);
        adapterSS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerS.setAdapter(adapterSS);
    }

    public void SelectButton(android.view.View view) {
        String destText = ((Spinner)findViewById(R.id.spinnerDestinations)).getSelectedItem().toString();
        String sourceText = ((Spinner)findViewById(R.id.spinnerSource)).getSelectedItem().toString();
        Toast.makeText(
                getApplicationContext(),
                "Destination : " + destText + "\nSource : " + sourceText,
                Toast.LENGTH_LONG).show();
    }
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        Toast.makeText(
                parent.getContext(),
                "The place is : " + parent.getItemAtPosition(pos).toString(),
                Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> parent) {

    }

}

//public class MyOnItemSelectedListener implements AdapterView.OnItemClickListener {
//}
