package ws.senaidf.outrocomponente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    /*
    *
    * caixa de texto, á medida que o usuario digita, e feito uma busca*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> cidade = new ArrayList<String>();
        cidade.add("Caruaru");
        cidade.add("Cabo de Santo Agostinho");
        cidade.add("Recife");
        cidade.add("São Paulo");
        cidade.add("Santos");
        cidade.add("Santa Cruz");

        MeuAutoCompleteAdapter adapter = new MeuAutoCompleteAdapter(this,android.R.layout.simple_dropdown_item_1line,cidade);

        AutoCompleteTextView actv = findViewById(R.id.actvTxt);

        actv.setAdapter(adapter);
    }
}
