package com.example.bob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Slide2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide2);
    }

    public void irSlide3(View vie){

        Intent intent = new Intent(this, Slide3.class);

        startActivity(intent);

    }
}
