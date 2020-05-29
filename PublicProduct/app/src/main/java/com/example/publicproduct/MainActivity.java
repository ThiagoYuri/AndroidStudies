package com.example.publicproduct;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickLogar(View view){
        Intent intent = new Intent(this, MainAcitivityMenuUser.class);

        startActivity(intent);


    }
    public void clickRegister(View view){

        Intent intentr = new Intent(this, MainActivityRegistrarUser.class);

        startActivity(intentr);

    }
}
