package com.gimcana.enti.gimcana;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by egaona on 11/27/2017.
 */

public class ShowDetailPista extends Fragment {

    View vista;

    public View onCreateView(LayoutInflater inflador, ViewGroup contenedor, Bundle savedInstanceState){
        vista = inflador.inflate(R.layout.fragment_show_detail_pista, contenedor, false);
        updateContent();
        return vista;
    }

    public void onActivityCreated(Bundle state){
        super.onActivityCreated(state);
    }

    public void updateContent(){
        Pista p = LlistaPistes.getInstance().getPista(0);
        TextView v = (TextView)vista.findViewById(R.id.pistaDetails);
        v.setText(p.toString());
    }

}
