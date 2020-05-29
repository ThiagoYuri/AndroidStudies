package com.example.fase2alg2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText num1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (EditText)findViewById(R.id.num1);


    }

    public void somar(View view) {

      int antessesor = Integer.parseInt(num1.getText().toString()) - 1;
      int sucessor = Integer.parseInt(num1.getText().toString() +1);


        Toast.makeText(this,"Antessesor: "+ String.valueOf(antessesor)+", sucessor: "+String.valueOf(sucessor),Toast.LENGTH_LONG).show();

    }
}
