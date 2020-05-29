package ws.senaidf.outrocomponente;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.Filter;
import android.widget.Filterable;
import  java.util.ArrayList;
import java.util.List;

public class MeuAutoCompleteAdapter extends ArrayAdapter<String> {

    private List<String> listaCompleta;
    private List<String> resultados;
    private Filter meuFiltro; // atributo do tipo filter

    public MeuAutoCompleteAdapter(Context ctx,int layout,List<String> textos){
        super(ctx,layout,textos);
        this.listaCompleta = textos;
        this.resultados = listaCompleta;
        this.meuFiltro = new MeuFiltro();
    }


    @Override
    public int getCount(){
        return resultados.size();
    }

    @Override
    public String getItem(int position){
        if(resultados != null && resultados.size()> 0 && position < resultados.size()){
            return  resultados.get(position);
        }else{
            return null;
        }

    }

    @Override
    public Filter getFilter(){
        return meuFiltro;
    }

    private class MeuFiltro extends  Filter{

        /**
         * <p>Invoked in a worker thread to filter the data according to the
         * constraint. Subclasses must implement this method to perform the
         * filtering operation. Results computed by the filtering operation
         * must be returned as a {@link FilterResults} that
         * will then be published in the UI thread through
         * {@link #publishResults(CharSequence,
         * FilterResults)}.</p>
         *
         * <p><strong>Contract:</strong> When the constraint is null, the original
         * data must be restored.</p>
         *
         * @param constraint the constraint used to filter the data
         * @return the results of the filtering operation
         * @see #filter(CharSequence, FilterListener)
         * @see #publishResults(CharSequence, FilterResults)
         * @see FilterResults
         */
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            ArrayList<String> temp = new ArrayList<String>();
            if(constraint!= null){
                String term = Util.removeAcentos(constraint.toString().trim().toLowerCase());
                String placeStr;
                for (String p:listaCompleta){
                    placeStr = Util.removeAcentos(p.toLowerCase());
                    if (placeStr.indexOf(term) > -1){
                        temp.add(p);
                    }
                }
            }
            filterResults.values = temp;
            filterResults.count = temp.size();
            return filterResults;
        }


        @Override
        protected void publishResults(CharSequence constraint, FilterResults filterResults) {
                    resultados =(ArrayList<String>) filterResults.values;
                    notifyDataSetChanged(); // atualizar o adapter
        }
    }
}

/*
* Na classe anterior temos duas lista de string
*   a original e a que será usada na busca
*   temos os metodos
*   getCount() getItem() ------> trabalhar na lista de resultados
*   getFilter()
*   classe Interna: MeuFiltro
*     *Busca personalizada
*     performFiltering() que retorna um Filter Results
*
*
* */
