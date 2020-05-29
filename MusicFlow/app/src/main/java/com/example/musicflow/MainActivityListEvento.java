package com.example.musicflow;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivityListEvento extends AppCompatActivity {
    SQLiteDatabase db;

    ListView listevent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_list_evento);
        db = openOrCreateDatabase("dbEvento", MODE_PRIVATE, null);
        listevent = (ListView)findViewById(R.id.Listevent);

        ArrayList<String> eventos = preecherdados();

        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,eventos);

        listevent.setAdapter(arrayAdapter);
    }

    private ArrayList<String> preecherdados() {
        ArrayList<String> dados = new ArrayList<String>();

        Cursor c = db.rawQuery("Select * from tbEvento where id ", null);


        try {
            while (c.moveToNext()) {

                //  Log.i("", c.getString(0));

                dados.add(c.getString(1)+"--"+c.getString(2)+"--"+ c.getString(3)+"--"+ c.getString(4)+"--"+ c.getString(5));


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


      return dados;
    }



}
