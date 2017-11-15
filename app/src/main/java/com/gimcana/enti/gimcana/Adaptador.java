package com.gimcana.enti.gimcana;

/**
 * Created by Eduard on 14/11/2017.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {

    protected ArrayList<Pista> llistaItems;        //Items a mostrar

    protected LayoutInflater inflador;             //Crea Layouts a partir de l'XML list_item

    protected Context contexto;                    //Necessari per l'inflater

    protected View.OnClickListener onClickListener;


    public Adaptador(Context contexto, ArrayList<Pista> llistaItems) {

        this.contexto = contexto;

//TO DO: assignar la llista de items a la propietat
        //ens guardem una referència a la llista d'strings
        this.llistaItems = llistaItems;

//END TO DO



        inflador = (LayoutInflater) contexto

                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    //Creem el ViewHolder, amb els elements que cal mostrar

    public static class ViewHolder extends RecyclerView.ViewHolder {



        //Posem com a propietats tots els views que conté cada ítem de la llista

        // (en aquest cas només un TextView per a guardar el nom de la versió

        public TextView textItem;



        public ViewHolder(View itemView) {

            super(itemView);

            //TO DO: assignar a la propietat textItem el TextView que s'ha especificat al layout amb el seu ID

            textItem = itemView.findViewById(R.id.nomListItem);

            //END TO DO



        }

    }

    //Mètode obligatori que genera un ViewHolder a partir de l'id de l'XML list_item

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = inflador.inflate(R.layout.list_item, null);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);

    }

    // Mètode obligatori que ens permet especificar què posar als views de cada item

    @Override

    public void onBindViewHolder(ViewHolder holder, int posicio) {

        holder.textItem.setText(llistaItems.get(posicio).getId());

    }

    //Mètode obligatori que retorna el número d'elements total de la llista

    @Override public int getItemCount() {

//TO DO: retornar el número d'elements de llistaItems

    return llistaItems.size();

//END TO DO

    }

    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }

}
