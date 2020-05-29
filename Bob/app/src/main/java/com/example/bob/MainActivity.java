package com.example.bob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    private static final String TAG = "MyActivity";

    Log valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("dbEstartisticas", MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS tbEstartisticas(id integer primary key autoincrement,QuantasSessoes int , TempoTotalMeditado int  ,vlFicaSussa int,vlOlhaFoca int,vlDormiDeBoas int)");
        /*


         */

    }


    public void irSlide2(View view) {

        Intent intent = new Intent(this, Slide2.class);

        startActivity(intent);

    }
}
