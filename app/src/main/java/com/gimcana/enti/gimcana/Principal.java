package com.gimcana.enti.gimcana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_principal);
        setContentView(R.layout.afegir_pista);
    }

    public void showAbout(View view){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

    public boolean afegirPista(int id, String tipus, String descripcio, float latitud, float longitud, int nextId){
        Pista novaPista = null;
        if(tipus.equals(getString(R.string.apTpImage))){
            novaPista = new PistaImatge(id, latitud, longitud, nextId, descripcio);
        }else if(tipus.equals(getString(R.string.apTpText))){
            novaPista = new PistaText(id, latitud, longitud, nextId, descripcio);
        }else if(tipus.equals(getString(R.string.apTpSo))){
            novaPista = new PistaSo(id, latitud, longitud, nextId, descripcio);
        }
        if(!comprobarPista(LlistaPistes.getInstance().llistaPistes, novaPista)){
            LlistaPistes.getInstance().llistaPistes.add(novaPista);
            return true;
        }
        return false;
    }

    public void mostrarNovaPista(View view){
        EditText iden = (EditText)findViewById(R.id.APidentificador);
        Spinner spin = (Spinner)findViewById(R.id.APspinner);
        EditText desc = (EditText)findViewById(R.id.APdescripcio);
        EditText lat = (EditText)findViewById(R.id.APlatitud);
        EditText lon = (EditText)findViewById(R.id.APlongitud);
        EditText idNext = (EditText)findViewById(R.id.APnextId);
        String form = "ID: " + iden.getText().toString() + "\n"
                + "Tipus: " + spin.getSelectedItem().toString() + "\n"
                + "Descripció: " + desc.getText().toString() + "\n"
                + "Latitud: " + lat.getText().toString() + "\n"
                + "Longitud: " + lon.getText().toString() + "\n"
                + "ID següent: " + idNext.getText().toString();
        String error = "";
        if(iden.getText().toString().isEmpty()){
            error += "Falta l'identificador";
        }
        if(desc.getText().toString().isEmpty()){
            if(!error.equals("")) error += "\n";
            error += "Falta la descripció";
        }
        if(lat.getText().toString().isEmpty()){
            if(!error.equals("")) error += "\n";
            error += "Falta la latitud";
        }
        if(lon.getText().toString().isEmpty()){
            if(!error.equals("")) error += "\n";
            error += "Falta la longitud";
        }
        if(idNext.getText().toString().isEmpty()){
            if(!error.equals("")) error += "\n";
            error += "Falta l'identificador de la següent pista";
        }
        if(error.equals("")){
            if(afegirPista(Integer.parseInt(iden.getText().toString()), spin.getSelectedItem().toString(), desc.getText().toString(),
                    Float.parseFloat(lat.getText().toString()), Float.parseFloat(lon.getText().toString()), Integer.parseInt(idNext.getText().toString()))){
                Toast.makeText(this, form, Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Identificador repetit", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }

    private boolean comprobarPista(ArrayList<Pista> llista, Pista pista){
        boolean find = false;
        int i = 0;
        while (i < llista.size()){
            if(pista.equals(llista.get(i))) find = true;
            i++;
        }
        return find;
    }

}
