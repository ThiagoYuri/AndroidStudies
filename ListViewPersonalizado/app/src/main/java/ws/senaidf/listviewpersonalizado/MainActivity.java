package ws.senaidf.listviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView) findViewById(R.id.lvCarro);
        ArrayAdapter adapter = new CarroAdapter(this,adicionarCarro());
        lista.setAdapter(adapter);

    }

    private ArrayList<Carro> adicionarCarro(){
        ArrayList<Carro> carros = new ArrayList<Carro>();
        Carro e = new Carro("Volkswagen","Gol",R.drawable.carro1);
           carros.add(e);
         e = new Carro("Uno","Fiat",R.drawable.carro2);
        carros.add(e);
        e = new Carro("Palio","Fiat",R.drawable.carro3);
        carros.add(e);
        e = new Carro("Siena","Volkswagen",R.drawable.carro4);
        carros.add(e);
        e = new Carro("Siena","Volkswagen",R.drawable.carro4);
        carros.add(e);
        e = new Carro("Siena","Volkswagen",R.drawable.carro1);
        carros.add(e);
        e = new Carro("Siena","Volkswagen",R.drawable.carro2);
        carros.add(e);
        e = new Carro("Siena","Volkswagen",R.drawable.carro4);
        carros.add(e);


        return carros;
    }
}
