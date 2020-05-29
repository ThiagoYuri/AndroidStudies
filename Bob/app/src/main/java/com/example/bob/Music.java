package com.example.bob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Music extends AppCompatActivity {

    private MediaPlayer mp;
    private boolean play;
    private SeekBar seekBar;
    TextView valorObs;
    String valordoObsBD;
    Timer timer = new Timer();
    SQLiteDatabase db;
    ContentValues valuesInse;
    String nomeObs;
    int ValorMs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);


        Log.i("", "---------teste--------------");
        //Valor activity anterior-----------------------------
        Intent intent = getIntent();

        savedInstanceState = intent.getExtras();

        nomeObs = savedInstanceState.getString("vlMusic");
        ValorMs = savedInstanceState.getInt("ValorMs");


        valorObs = findViewById(R.id.textObjetivo);
        valorObs.setText("" + nomeObs);

        //Musica-----------------------------
        mp = MediaPlayer.create(this, R.raw.medita);

        seekBar = findViewById(R.id.seekBarms);


        seekBar.setMax(mp.getDuration());

        seekBar.setEnabled(false);

        //banco-----------------------------
        db = openOrCreateDatabase("dbEstartisticas", MODE_PRIVATE, null);

        valuesInse = new ContentValues();

        try {
            Cursor cursor = db.rawQuery("select * from tbEstartisticas order by id ", null);

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

    //-----------------------------Musica------------------------------------------------
    public void musicaPlay(View view) {


        play = mp.isPlaying();


        if (play) {
            mp.pause();

        } else if (mp.getDuration() != 0) {
            mp.start();

            AtualizarBar();


            // Toast.makeText(this, ""+, Toast.LENGTH_SHORT).show();

        } else {
            mp = MediaPlayer.create(this, R.raw.medita);
            mp.start();

            seekBar.setProgress(mp.getCurrentPosition());


//        seekBar.setMax(0);
//        seekBar.setMax();
//        seekBar.setProgress();

//        seekBar.setMax(1000);
//        seekBar.setProgress(valorteste);
        }

    }


    public void AtualizarBar() {


        timer.scheduleAtFixedRate(new TimerTask() {

            public void run() {

                seekBar.setProgress(mp.getCurrentPosition());
            }

        }, 20, 10);


    }




    //BAnco de dados CRUD
    protected void onStop() {
        super.onStop();
        inserirDB();
    }

    public void inserirDB() {

        if (ValorMs == 1) {


            valuesInse.put("QuantasSessoes", 1);
            valuesInse.put("TempoTotalMeditado", mp.getCurrentPosition());
            valuesInse.put("vlFicaSussa", 1);
            valuesInse.put("vlOlhaFoca", 0);
            valuesInse.put("vlDormiDeBoas", 0);


            db.insert("tbEstartisticas", null, valuesInse);

            Log.i("", "Inserido com sussesso");

        } else if (ValorMs == 2) {
            valuesInse.put("quantSessoes", 1);
            valuesInse.put("TempoTotalMeditado", mp.getCurrentPosition());
            valuesInse.put("vlFicaSussa", 0);
            valuesInse.put("vlOlhaFoca", 1);
            valuesInse.put("vlDormiDeBoas", 0);

            db.insert("dbEstartisticas", null, valuesInse);
            Log.i("", "Inserido com sussesso");

        } else if (ValorMs == 3) {
            valuesInse.put("quantSessoes", 1);
            valuesInse.put("TempoTotalMeditado", mp.getCurrentPosition());
            valuesInse.put("vlFicaSussa", 0);
            valuesInse.put("vlOlhaFoca", 0);
            valuesInse.put("vlDormiDeBoas", 1);
            db.insert("dbEstartisticas", null, valuesInse);
            Log.i("", "Inserido com sussesso");
        } else {
            Log.i("", "Erro");
        }


        //valorInse = db.insert("tbEstartisticas",null,"");


    }


}


