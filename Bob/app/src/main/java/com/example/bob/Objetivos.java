package com.example.bob;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.ExtractedText;
import android.widget.TextView;
import android.widget.Toast;

public class Objetivos extends AppCompatActivity {

    TextView obs1,obs2,obs3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_objetivos);
        obs1 = findViewById(R.id.ObejetivoUm);
        obs2 = findViewById(R.id.ObejetivoDois);
        obs3 = findViewById(R.id.ObejetivoTreis);
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater flate = new MenuInflater(this);
//        flate.inflate(R.menu.menu,menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case R.id.estatic:
//                Intent intent = new Intent(this, Estartisticas.class);
//                startActivity(intent);
//                break;
//            case R.id.config:
//                Toast.makeText(this, "Tela em construção", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }


    public void IrMusicaUm(View view){
        Intent intent = new Intent(this, Music.class);
        intent.putExtra("vlMusic",obs1.getText().toString());
        intent.putExtra("ValorMs",1);

        startActivity(intent);



    }


    public void IrMusica2(View view){
        Intent intent = new Intent(this, Music.class);
        intent.putExtra("vlMusic",obs2.getText().toString());
        intent.putExtra("ValorMs",2);
        startActivity(intent);



    }

    public void IrMusica3(View view){
        Intent intent = new Intent(this, Music.class);
        intent.putExtra("vlMusic",obs3.getText().toString());
        intent.putExtra("ValorMs",3);
        startActivity(intent);



    }

    public void irEstatic(View view){
        Intent intent = new Intent(this, Estartisticas.class);

        startActivity(intent);



    }
}
