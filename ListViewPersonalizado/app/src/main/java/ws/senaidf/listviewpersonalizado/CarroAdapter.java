package ws.senaidf.listviewpersonalizado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CarroAdapter extends ArrayAdapter<Carro> {
    private final Context context ;
    private final ArrayList<Carro> elementos;
    public  CarroAdapter (Context context,ArrayList<Carro> elementos){
        super(context,R.layout.activity_linha,elementos);
        this.context = context;
        this.elementos = elementos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_linha,parent,false);

        TextView nomeCarro = (TextView) rowView.findViewById(R.id.nome);
        TextView modelo = (TextView) rowView.findViewById(R.id.modelo);
        ImageView Imagem = (ImageView) rowView.findViewById(R.id.imagem);

        nomeCarro.setText(elementos.get(position).getNome());
        modelo.setText(elementos.get(position).getModelo());
        Imagem.setImageResource(elementos.get(position).getImagem());

        return rowView;
    }
}
