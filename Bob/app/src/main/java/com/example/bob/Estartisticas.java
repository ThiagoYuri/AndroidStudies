package com.example.bob;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.logging.SimpleFormatter;

public class Estartisticas extends AppCompatActivity {


    TextView txvSessoes, txvTempo, txvObjetivo;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estartisticas);

        txvSessoes = findViewById(R.id.txvMeditacoesRealizada);
        txvObjetivo = findViewById(R.id.txvObs);
        txvTempo = findViewById(R.id.txvTimeTotal);

        db = openOrCreateDatabase("dbEstartisticas", MODE_PRIVATE, null);


        procuraTimeDB();
        procurSessoesDb();
        procuraObejtivoUsado();


    }

    int valorFinal = 0;

    public void procurSessoesDb() {
        Cursor c = db.rawQuery("Select * from tbEstartisticas where id ", null);


        try {
            while (c.moveToNext()) {

                //  Log.i("", c.getString(0));

                valorFinal += c.getInt(1);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        txvSessoes.setText(valorFinal + " sessões");

    }


    String valorHora, valorMinuto;

    public void procuraTimeDB() {

        Cursor c = db.rawQuery("Select * from tbEstartisticas where id", null);

        int valorTime = 0;
        int minutos;
        int horas;


        try {
            while (c.moveToNext()) {

                valorTime += c.getInt(2);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        minutos = (valorTime / 60000) % 60;
        horas = valorTime / 3600000;
        //  String resu = String.format(new, Time"HH:mm")+horas+minutos;

        if (horas < 10) {
            valorHora = "0" + horas;
        } else {
            valorHora = "" + horas;
        }

        if (minutos < 10) {
            valorMinuto = "0" + minutos;
        } else {
            valorMinuto = "" + minutos;
        }


        txvTempo.setText(valorHora + ":" + valorMinuto);

    }


    int obs1 = 0;
    int obs2 = 0;
    int obs3 = 0;

    public void procuraObejtivoUsado() {

        Cursor c = db.rawQuery("Select * from tbEstartisticas where id ", null);
        try {

            while (c.moveToNext()) {

                obs1 += c.getInt(3);
                obs2 += c.getInt(4);
                obs3 += c.getInt(5);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }


        if (obs1 > obs2 && obs1 > obs3) {
            txvObjetivo.setText("Fica sussa");

        } else if (obs2 > obs1 && obs2 > obs3) {

            txvObjetivo.setText("Olha Foca");

        } else if (obs3 > obs1 && obs3 > obs2) {
            txvObjetivo.setText("Dormi Bem");
        }

    }
}
