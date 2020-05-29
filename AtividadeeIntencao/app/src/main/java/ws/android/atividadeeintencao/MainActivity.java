package ws.android.atividadeeintencao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    /*
    *
    * Anotação Importantes de aula modelo 2 - android
    *
    * 1)Activity
    *      *Herda de Context
    *          Traz informaçoes sobre o ambiente de aplicaçao
    *
    *      *Como um contexto, temos acessor aos recursos da aplicação.servicoes
    *       do sistema, podemos iniciar outras activities.
    *
    *       Meta: Iniciar outra acitivy
    *           Habilidade
    *               A) Criar um objeto intent (represente uma ação)
    *               B)startActivity(Intent) : "dar o show()" rsrs
    *           Atitudes:
    *                Começar a estudar de formas teorica e exaustive (Ciclo de vida da Activity)

    *  */
    //Exemplo
    /*
       criar uma nova activit para que possa chama-la depois
    */

    EditText edtLogin;
    EditText edtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      edtLogin = (EditText)findViewById(R.id.edtlogin);
      edtSenha = (EditText)findViewById(R.id.edtSenha);
    }

    public void clickActivity2(View view) {
        //instanciando uma intençao para que possa abrir outra tela mais no caso não ira funcionar
        // so com essa linha pq temos uma inteção mais nao ultilizamos dela
        //this significa que no contexto atual
        //.class e a class da outra activity que tenha a entenção de chamar
        Intent intent = new Intent(this, Main2Activity.class);

        //Adicionar o putExtra para aproxima activity pegar o value
        //intent.putExtra("Login",edtLogin.getText());
        //intent.putExtra("Senha",edtSenha.getText());
        intent.putExtra("cliente",new ClienteV2(edtLogin.getText().toString(),1));
        //Essa linha ela chamara a intenção acima para que possa ser iniciarda e roda a activity na tela
        startActivity(intent);

    }


}
