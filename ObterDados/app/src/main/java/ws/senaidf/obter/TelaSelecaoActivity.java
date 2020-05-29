package ws.senaidf.obter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;
//Herda-se da ListActivity : Ela é ultilizada para tela de Listagem
public class TelaSelecaoActivity extends ListActivity {


    //Duas constantes
    public static  final  String EXTRA_ESTADO = "estado";
    public static  final String EXTRA_RESULTADO ="result";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      // setContentView(R.layout.activity_tela_selecao);
        // array de estados que chama a string de estados
        String[] estados = getResources().getStringArray(R.array.estados);
        // E o adapter da lista - Aparencia do radioButton
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,estados));
        //Ler o parametro da Intent e vamos atribuir o valor estado.
        String estado = getIntent().getStringExtra(EXTRA_ESTADO);

        //
        if(estado != null){
            //Caso o paarametro tenha sido passado, Procuramos a posição do estado na lista
            int position = Arrays.asList(estados).indexOf(estado); // pega a posição
            //e selecionamos posição correspondente no ListVieww usando o metodo setItemChecked(int,boolean)
            getListView().setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);//
            getListView().setItemChecked(position,true);//
        }

    }

    @Override
    protected  void onListItemClick(ListView l , View v ,int position,long id){
        //4 parametros:
        /*
        *  --> Position:: informaqual a posiç~]ao da lista que foi clicada , e com o metodo
        * getItemAtPosition() obtemos a String do estado selecionado
        * */
        super.onListItemClick(l,v,position,id);
        String result= l.getItemAtPosition(position).toString();
        //criar uma inteção
        Intent it = new Intent();
        //atribuiu o resultado com a chave "result"
        it.putExtra(EXTRA_RESULTADO,result);

        setResult(RESULT_OK,it);
        finish();
    }
}
