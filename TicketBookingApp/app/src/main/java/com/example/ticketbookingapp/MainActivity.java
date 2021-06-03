//Lab 4: Button, Toggle Button, Check Box, View, Toast
//Lab 5: Spinners, Pickers

package com.example.ticketbookingapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "";
    DatePicker picker;
    Button displayDate;
    TextView textview1;
    TimePicker timePicker;
    Button buttonDate;
    Button buttonTime;
    Button buttonSelect;
    TextView textDate;
    TextView textTime;
    Button buttonDate2;
    Button buttonTime2;
    TextView textDate2;
    TextView textTime2;
    Button toggle1;

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
        buttonSelect = findViewById(R.id.buttonSelect);
        textDate = findViewById(R.id.textDate);
        textTime = findViewById(R.id.textTime);
        buttonDate2 = findViewById(R.id.buttonDate2);
        buttonTime2 = findViewById(R.id.buttonTime2);
        textDate2 = findViewById(R.id.textDate2);
        textTime2 = findViewById(R.id.textTime2);
        toggle1 = findViewById(R.id.toggleButton);
        //timePicker=(TimePicker)findViewById(R.id.timePicker);
        //Uncomment the below line of code for 24 hour view
        //timePicker.setIs24HourView(true);
        textview1 = (TextView) findViewById(R.id.textView1);
        //picker = (DatePicker) findViewById(R.id.datePicker);

        displayDate=(Button)findViewById(R.id.buttonSelect);

        toggle1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String toggleText = toggle1.getText().toString();
                Toast.makeText(getApplicationContext(),
                        toggleText + " TRIP",
                        Toast.LENGTH_SHORT).show();
                if (toggleText.equals("ONE WAY")) {
                        buttonDate2.setEnabled(false);
                        buttonTime2.setEnabled(false);
                }
                else {
                    buttonDate2.setEnabled(true);
                    buttonTime2.setEnabled(true);
                }
            }
        });

        buttonDate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String m, d;
                        if (month<10)
                            m = "0" + Integer.toString(month);
                        else
                            m = Integer.toString(month);
                        if (day<10)
                            d = "0" + Integer.toString(day);
                        else
                            d = Integer.toString(day);
                        month = month+1;
                        textDate.setText(d + "/" + m + "/" + year);
                    }
                }, 0, 1,0);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        buttonTime.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        String hr, min;
                        if (hour<10)
                            hr = "0" + Integer.toString(hour);
                        else
                            hr = Integer.toString(hour);
                        if (minute<10)
                            min = "0" + Integer.toString(minute);
                        else
                            min = Integer.toString(minute);
                        textTime.setText(hr + ":" + min);
                    }
                }, 00,00, true);
                timePickerDialog.show();
            }
        });

        buttonDate2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        String m, d;
                        if (month<10)
                            m = "0" + Integer.toString(month);
                        else
                            m = Integer.toString(month);
                        if (day<10)
                            d = "0" + Integer.toString(day);
                        else
                            d = Integer.toString(day);
                        month = month+1;
                        textDate2.setText(d + "/" + m + "/" + year);
                    }
                }, 0, 1,0);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });

        buttonTime2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                final TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
                        String hr, min;
                        if (hour<10)
                            hr = "0" + Integer.toString(hour);
                        else
                            hr = Integer.toString(hour);
                        if (minute<10)
                            min = "0" + Integer.toString(minute);
                        else
                            min = Integer.toString(minute);
                        textTime2.setText(hr + ":" + min);
                    }
                }, 00,00, true);
                timePickerDialog.show();
            }
        });


        buttonSelect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String destText = ((Spinner)findViewById(R.id.spinnerDestinations)).getSelectedItem().toString();
                String sourceText = ((Spinner)findViewById(R.id.spinnerSource)).getSelectedItem().toString();
                if (toggle1.getText().toString().equals("ONE WAY"))
                    textview1.setText(
                            "Source : " + sourceText + "\nDestination : " + destText + "" +
                                    "\nDeparture: "+ textDate.getText() + " " + textTime.getText() );
                else
                    textview1.setText(
                            "Source : " + sourceText + "\nDestination : " + destText + "" +
                                    "\nDeparture: "+ textDate.getText() + " " + textTime.getText() +
                                    "\nReturn: "+ textDate2.getText() + " " + textTime2.getText() );
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage(textview1.getText())
                        .setTitle("Confirm");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        TextView textView1 = (TextView) findViewById(R.id.textView1);
                        String message = textView1.getText().toString();
                        intent.putExtra(EXTRA_MESSAGE, message);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //go back
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
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
