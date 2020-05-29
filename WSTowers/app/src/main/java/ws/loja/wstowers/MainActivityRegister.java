package ws.loja.wstowers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivityRegister extends AppCompatActivity  {


    EditText edtUsuario,edtSenha ,edtRepSenha,edtNome,edtSobreNome,edtEmail,edtWhatsApp,edtTelefone,edtCnpj,edtCep,edtEndereco,edtBairro,edtCidade,edtUF;
    Spinner spnInteresse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_register);

        edtUsuario = (EditText) findViewById(R.id.edtUsuario);
        edtSenha = (EditText) findViewById(R.id.edtSenha);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtSobreNome = (EditText) findViewById(R.id.edtSobreNome);
        edtEmail = (EditText) findViewById(R.id.edtEmail);
        edtWhatsApp = (EditText) findViewById(R.id.edtwhatsApp);
        edtTelefone = (EditText) findViewById(R.id.edtTellC);
        edtCnpj = (EditText) findViewById(R.id.edtCNPJ);
        edtCep = (EditText) findViewById(R.id.edtCEP);
        edtEndereco = (EditText) findViewById(R.id.edtEndereco);
        edtBairro = (EditText) findViewById(R.id.edtBairro);
        edtCidade = (EditText) findViewById(R.id.edtCidade);
        edtUF = (EditText) findViewById(R.id.edtUF);

        spnInteresse = (Spinner)findViewById(R.id.spnInteresee);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.move_esquerda,R.anim.fade_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    public void voltarLogin(View view) {

        super.onBackPressed();

    }

    public void Registrar(View view) {

        //chamar classCadastro
        Intent intent = new Intent(this, MainActivityUser.class);
        intent.putExtra("cliente",new ClassCadastro(edtUsuario.getText().toString(),edtSenha.getText().toString(),edtNome.getText().toString(),edtSobreNome.getText().toString(),edtEmail.getText().toString(),edtWhatsApp.getText().toString(),edtTelefone.getText().toString(),edtCnpj.getText().toString(),edtCep.getText().toString(),edtEndereco.getText().toString(),edtBairro.getText().toString(),edtCidade.getText().toString(),edtUF.getText().toString(),edtBairro.getText().toString()));
        startActivity(intent);

    }




}
