package com.example.bob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Slide3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide3);
    }

     public void IrObejetivos(View view){

        Intent intent = new Intent(this,Objetivos.class);
        startActivity(intent);

     }


}
