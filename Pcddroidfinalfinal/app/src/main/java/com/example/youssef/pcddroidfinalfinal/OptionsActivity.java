package com.example.youssef.pcddroidfinalfinal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class OptionsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Tout");
        categories.add("Angiologue");
        categories.add("Cancérologue - oncologue");
        categories.add("Dermatologue");
        categories.add("Gastro-entérologue");
        categories.add("Gynécologue-obstétricien");
        categories.add("Neurologue");
        categories.add("Ophtalmologiste");
        categories.add("Oto-rhino-laryngologiste (ORL)");
        categories.add("Pneumologue");
        categories.add("Rhumatologue");
        categories.add("Urologue");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);





        // Spinner element
        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories2 = new ArrayList<String>();
        categories2.add("1 Km");
        categories2.add("2 Km");
        categories2.add("3 Km");
        categories2.add("4 Km");
        categories2.add("5 Km");
        categories2.add("6 Km");
        categories2.add("7 Km");
        categories2.add("8 Km");
        categories2.add("9 Km");
        categories2.add("10 Km");
        categories2.add("15 Km");
        categories2.add("20 Km");
        categories2.add("30 Km");
        categories2.add("50 Km");
        categories2.add("100 Km");
        categories2.add("200 Km");
        categories2.add("300 Km");
        categories2.add("500 Km");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories2);

        // Drop down layout style - list view with radio button
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner2.setAdapter(dataAdapter2);


        /* @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            // On selecting a spinner item
            String item = parent.getItemAtPosition(position).toString();

            // Showing selected spinner item
            Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
        }
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
        } */






    }
    public void startSearch(View view){
        /*Intent intent=new Intent(this,AgentMedicalListActivity.class);
        startActivity(intent);*/
        Intent intent=new Intent(this,Agentlist.class);
        startActivity(intent);
    }

    public void showDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    public static class DatePickerFragment extends DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            // Do something with the date chosen by the user
        }
    }

    public void startdb(View view)
    {
        Log.e("DATABASE OPERATIONS","1");
        Context context=this;
        Log.e("DATABASE OPERATIONS","2");
        AgentDbHelper agentDbHelper=new AgentDbHelper(context);
        Log.e("DATABASE OPERATIONS", "3");
        SQLiteDatabase sqLiteDatabase=agentDbHelper.getWritableDatabase();
        Log.e("DATABASE OPERATIONS", "4");
        sqLiteDatabase.close();
        Button button=(Button)findViewById(R.id.button5);
    }
}
