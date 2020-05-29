package com.example.fase1alg2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Enum1, Enum2;
    TextView resu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Enum1 = (EditText)findViewById(R.id.valor1);
        Enum2 = (EditText)findViewById(R.id.valor2);

        resu = (TextView)findViewById(R.id.resu);
    }

    public void Calcular(View view) {

        int num1 = Integer.parseInt(Enum1.getText().toString());
        int num2 = Integer.parseInt(Enum2.getText().toString());

        int soma = num1 + num2;

        Toast.makeText(this,String.valueOf(soma),Toast.LENGTH_LONG).show();
        resu.setText(String.valueOf(soma));

    }
}
