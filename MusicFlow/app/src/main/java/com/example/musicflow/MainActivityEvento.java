package com.example.musicflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivityEvento extends AppCompatActivity  {

    Spinner spnRepositorio, spnStatus;

    EditText edtNome, edtCache;
    DatePicker edtdata;
    SQLiteDatabase db;
    ContentValues valuesInserir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_evento);

        spnRepositorio = (Spinner)findViewById(R.id.spinnerRepositorio);
        ArrayAdapter adpt = ArrayAdapter.createFromResource(this,R.array.arrayInstrumental,android.R.layout.simple_spinner_item);

        spnRepositorio.setAdapter(adpt);




        spnStatus = (Spinner)findViewById(R.id.spinnerStatus);

        ArrayAdapter adpt2 = ArrayAdapter.createFromResource(this,R.array.arrayStats,android.R.layout.simple_spinner_item);

        spnStatus.setAdapter(adpt2);


        edtNome = (EditText)findViewById(R.id.edtNome);
        edtCache = (EditText)findViewById(R.id.edtCache);
        edtdata = (DatePicker)findViewById(R.id.Datapik);


        db = openOrCreateDatabase("dbEvento", MODE_PRIVATE, null);
        valuesInserir = new ContentValues();

        try {
            Cursor cursor = db.rawQuery("select * from tbEvento order by id ", null);

            while (cursor.moveToNext()) {
                Log.i("", cursor.getString(0));
                Log.i("", cursor.getString(1));
                Log.i("", cursor.getString(2));
                Log.i("", cursor.getString(3));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickRegistrar(View view){


       // if (edtNome) {
        String teste =(edtdata.getDayOfMonth()+"/"+edtdata.getMonth()+"/"+edtdata.getYear());

            valuesInserir.put("Nome",edtNome.getText().toString());
            valuesInserir.put("Data",teste);
            valuesInserir.put("Status",spnStatus.getSelectedItem().toString());
            valuesInserir.put("Cache", edtCache.getText().toString());
            valuesInserir.put("Instrumental", spnRepositorio.getSelectedItem().toString());


            db.insert("tbEvento", null, valuesInserir);

            Log.i("", "Inserido com sussesso");
            Log.i("", teste);

      //  } else {
     //       Log.i("", "Erro");
     //   }




    }

    public void clickListar(View view){

        Intent intent = new Intent(this,MainActivityListEvento.class);

        startActivity(intent);
    }


}
