package ws.senaidf.obter;

import androidx.appcompat.app.AppCompatActivity;
//Criar componentes é uma boa pratica .
// No android podemos componetizar uma activity de modo que ela retoner uma informação para quem chama-la
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/*
* Devemos seguir agumas etapas:
*
*    1) Inicie a actiity usando o metodo startActivityForResult(intent,Int)
*       Intent: para a activity da qual se quer obter os dados
*       Int: Definido pelo desenvolvedor para intentificar a requisição realizada
*
*    2) Na activity que retorará a informação, deve-se chamar o metodo setResult(Intent)
*     ou setResult(Intent,int). A intent conterá os dados a serem retornados, enquanto o int
*     indica se a operão foi bem-sucedida ou nãp. Em caso positivo, retonamos a constante activity. RESULT_OK, caso contratio, retornamos a
*    constante Activity.RESULT_CANCELED*
*
*     3) O Ultimo passo é tratar a activity de origem os dados retornados pela activity que foi chamada. Para isso, devemos sobreescrever o
*     método onActivityResult(int,int,intent), que é dispado assim que a segunda tela é fechada. Esse método contem os seguintes parametros:
* *        -O primeiro parametro, normalmente nomeado de requestCode, é o mesmo int que informamos no startActivityForResult(Intent,int).
*  Com ee, pdemos checar se o retorno es´ta de acordo com a requisição que definimos.
*          - O segundo parametro, normamente nomeado de resultCode,Indica o resultado da requisição , que
*          pode ser sucesso ou falha. Se o usuario realmente fez a ação na outra tela o valor será RESULT_OK: caso contratio
*          será RESULT_CANSLED
*          -O ultimp árametro,do tipo intent, trara os dados retornados pela activity que foi chamada.
* */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
   private static final int REQUEST_ESTADO = 1;
   private static final String STATE_ESTADO = "estado";
   Button botaoEstado;
   String estado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoEstado = findViewById(R.id.btnState);
        botaoEstado.setOnClickListener(this);
        if(savedInstanceState != null){
            estado = savedInstanceState.getString(STATE_ESTADO);
            botaoEstado.setText(estado);
        }
    }

    @Override
    public void onClick(View v){
        Intent it = new Intent(this,TelaSelecaoActivity.class);
        it.putExtra(TelaSelecaoActivity.EXTRA_ESTADO,estado);
        startActivityForResult(it,REQUEST_ESTADO);
    }

    @Override
    protected  void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode == RESULT_OK && requestCode == REQUEST_ESTADO){
           estado = data.getStringExtra(TelaSelecaoActivity.EXTRA_RESULTADO);
           if (estado != null){
               botaoEstado.setText(estado);
           }
        }
    }
    //
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_ESTADO,estado);
    }

}

