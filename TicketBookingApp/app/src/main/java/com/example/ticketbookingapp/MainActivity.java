//Lab 4: Button, Toggle Button, Check Box, View, Toast
//Lab 5: Spinners, Pickers

package com.example.ticketbookingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker picker;
    Button displayDate;
    TextView textview1;
    TimePicker timePicker;
    Button buttonDate;
    Button buttonTime;
    TextView textDate;
    TextView textTime;

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
        buttonDate = findViewById(R.id.buttonDate);
        buttonTime = findViewById(R.id.buttonTime);
        textDate = findViewById(R.id.textDate);
        textTime = findViewById(R.id.textTime);
        //timePicker=(TimePicker)findViewById(R.id.timePicker);
        //Uncomment the below line of code for 24 hour view
        timePicker.setIs24HourView(true);
        textview1 = (TextView) findViewById(R.id.textView1);
        //picker = (DatePicker) findViewById(R.id.datePicker);

        displayDate=(Button)findViewById(R.id.buttonSelect);



        buttonDate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int time) {

                    }
                }, 0, 0,0 );
                datePickerDialog.show();
            }
        });

    }

    public void SelectButton(android.view.View view) {
        //textview1.setText("Current Date: "+getCurrentDate() + "Time: " + getCurrentTime());
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

    /*public String getCurrentDate(){
        StringBuilder builder=new StringBuilder();;
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        return builder.toString();
    }

    public String getCurrentTime(){
        String currentTime=timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
        return currentTime;
    }*/

}
