package ws.android.atividadeeintencao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    TextView txvLogin;
    EditText edtNomeC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //pega a itent
        Intent it = getIntent();
        ClienteV2 c = (ClienteV2) it.getSerializableExtra("cliente");

        String texto = String.format("Codigo: %d / Nome: %s", c.getCodigo(),c.getNome());
                //pega o valor do putExtra da activity anterior
        //String login = it.getStringExtra("Login");

        edtNomeC= (EditText)findViewById(R.id.edtNomeC);
        txvLogin = (TextView)findViewById(R.id.txvNomeActiviti);

        edtNomeC.setText(texto);

    }
}
