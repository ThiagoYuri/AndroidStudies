package ws.senaidf.desafiocomplete;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView actvCidades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,Cidades);
        actvCidades = (AutoCompleteTextView) findViewById(R.id.actvCidades);


        String pvF = "Frase Palavra feia";


        Log.i("testeS", ":"+pvF.replace("Palavra feia","********"));

        Pattern p = Pattern.compile("a*b");
        Matcher m = p.matcher("aaaaab");
        boolean b = Pattern.matches ("a * m", "aaaaab");

        Log.i("Teste: ", "   valor p :"+p+"   valor m: "+m+"   Valor b:"+b);




        actvCidades.setAdapter(adapter);


    }

    private static  final String[] Cidades = new String[]{
      "Caruaru","Cabo de Santo Agostinho","Recife","São Paulo","Santos","Santa Cruz"
    };



}
