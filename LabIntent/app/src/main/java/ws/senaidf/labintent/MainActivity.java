package ws.senaidf.labintent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.DownloadManager;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//s        setContentView(R.layout.activity_main);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.acoes));

        setListAdapter(adapter);

       // if (ContextCompat.checkSelfPermission(this,Manifest.permission.SET_ALARM)== PackageManager.PERMISSION_GRANTED){
       // }else{
       //     requestPermissions(new String[]{Manifest.permission.SET_ALARM}, RESULT_OK);
      //  }

    }

    @Override
    protected  void onListItemClick(ListView l , View v, int position, long id){
        Uri uri = null;
        Intent intent = null;

        /*Ao executar a aplicação
        *  1) criamos uma lista de opçoes que ao clicar chama uma aplicação-Chave.
        *  2)Objeto : Uri : ele aponta para algum recurso do aparelho que queremos acessar
        *  3)Qua Açaõ?
        *  4) tenho que abrir uma URL usando o browser?
        *                  Usuario tem a a inteção(intent) de visualizar(ACTION_VIEW) e
        *                  recursos(Uri)
        *                  www.google.com.br
        *  5)Qual e minha Inteção? Discar(ACTION_DIAL)
        *     (scheme) tel:00000000
        *
        *     ACTION_DIAL(discar)
        *     ACTION_CALL(inicar ligação)
        *
        * */

        switch (position){
            case 0 :
                uri = Uri.parse("https://www.google.com.br");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                dispararIntent(intent);
                break;
            case 1 :
              //  uri = Uri.parse("tel:61998693090");
                if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},0);
                    //ActivityCompat
                    /*
                    *
                    *
                    *
                    * */

                }else
                {
                    discar();
                }
               // intent = new Intent(Intent.ACTION_DIAL,uri);
               // dispararIntent(intent);
                break;
            case 2 :
                uri= Uri.parse("geo:0,0?q=rua+Amelia,Recife");
                intent = new Intent(Intent.ACTION_VIEW,uri);
                dispararIntent(intent);
                break;
            case 3 :
                uri = Uri.parse("file:///mnt/scard/musica.mp3");
                intent = new Intent().setAction(Intent.ACTION_VIEW).setDataAndType(uri,"audio/mp3");
                dispararIntent(intent);
                break;
            case 4:
                uri = Uri.parse("sms:12345");
                intent = new Intent(Intent.ACTION_VIEW,uri) . putExtra("sms_body","Corpo do SMS");
                dispararIntent(intent);
                break;
            case 5:

                intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_SUBJECT,"Titulo teste");
                intent.putExtra(Intent.EXTRA_TEXT,"Senai 2020");
                intent.setType("text/plain");
                dispararIntent(intent);
                break;
            case 6:


                intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Novo alarme");
                intent.putExtra(AlarmClock.EXTRA_HOUR,10);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,30);
                dispararIntent(intent);
                break;
            case 7:
                break;
            case 8:
                break;

        }

    }

    private void dispararIntent(Intent intent){
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else{
            Toast.makeText(this,R.string.erro_Intent,Toast.LENGTH_LONG).show();//Mensagem de erro
        }
    }

    private void discar(){
      Uri uri = Uri.parse("tel:888998557");
      Intent intent = new Intent(Intent.ACTION_CALL,uri);
      dispararIntent(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,String[] permission,int[] grantResult){
        super.onRequestPermissionsResult(requestCode,permission,grantResult);
        if(grantResult[0] == PackageManager.PERMISSION_GRANTED){
          discar();
        }
    }
}
