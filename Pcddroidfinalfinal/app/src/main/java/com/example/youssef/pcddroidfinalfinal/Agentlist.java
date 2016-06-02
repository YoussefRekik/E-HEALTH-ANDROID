package com.example.youssef.pcddroidfinalfinal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

public class Agentlist extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    AgentDbHelper agentDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agentlist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        listView=(ListView)findViewById(R.id.list);
        agentDbHelper=new AgentDbHelper(getApplicationContext());
        listDataAdapter=new ListDataAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listDataAdapter);
        sqLiteDatabase=agentDbHelper.getReadableDatabase();
        cursor=agentDbHelper.getinfo(sqLiteDatabase);
        if (cursor.moveToFirst())
        {
            do {
                String name,prenom,adresse;
                name=cursor.getString(0);
                prenom=cursor.getString(1);
                adresse=cursor.getString(2);
                DataProvider dataProvider=new DataProvider(name,prenom,adresse);
                listDataAdapter.add(dataProvider);
            }while (cursor.moveToNext());
        }
    }

}
