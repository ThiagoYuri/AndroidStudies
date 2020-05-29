package com.example.musicflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase dbEvento;
    private static final String TAG = "MyActivity";

    Log valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //database
        dbEvento = openOrCreateDatabase("dbEvento", MODE_PRIVATE, null);
        dbEvento.execSQL("CREATE TABLE IF NOT EXISTS tbEvento(id integer primary key autoincrement,Nome varchar(100), Data varchar(100) ,Status varchar(100),Cache varchar(100),Instrumental varchar(100))");
        dbEvento.execSQL("CREATE TABLE IF NOT EXISTS tbMusica(id integer primary key autoincrement,Musica varchar(100), CD varchar(100) ,Artista varchar(100),Quemcanta varchar(100),diretorioOriginal varchar(100),diretorioEnsaio varchar(100),diretorioShow varchar(100))");



    }



    //criar intent para as telas

    public void clickEvento(View view){

        Intent intent = new Intent(this,MainActivityEvento.class);

        startActivity(intent);

    }


    public void clickmusica(View view){
        Intent intent = new Intent(this,MainActivityGerenciarMusica.class);

        startActivity(intent);
    }

    public void clickrepetorio(View view){
        Intent intent = new Intent(this,MainActivityRepetorio.class);

        startActivity(intent);
    }
}
