package com.gimcana.enti.gimcana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Form extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.afegir_pista);
    }

    public void exit(View view){
        finish();
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
        return LlistaPistes.getInstance().addPista(novaPista);
    }

    public void comprobaForm(View view){
        EditText id = (EditText)findViewById(R.id.APidentificador);
        Spinner type = (Spinner)findViewById(R.id.APspinner);
        EditText desc = (EditText)findViewById(R.id.APdescripcio);
        EditText lat = (EditText)findViewById(R.id.APlatitud);
        EditText lon = (EditText)findViewById(R.id.APlongitud);
        EditText idNext = (EditText)findViewById(R.id.APnextId);
        String form = "ID: " + id.getText().toString() + "\n"
                + "Tipus: " + type.getSelectedItem().toString() + "\n"
                + "Descripció: " + desc.getText().toString() + "\n"
                + "Latitud: " + lat.getText().toString() + "\n"
                + "Longitud: " + lon.getText().toString() + "\n"
                + "ID següent: " + idNext.getText().toString();
        String error = "";
        if(id.getText().toString().isEmpty()){
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
        if(id.getText().toString().equals(idNext.getText().toString())){
            if(!error.equals("")) error += "\n";
            error += "L'identificador no pot ser el mateix que l'identificador de la següent pista";
        }
        if(error.equals("")){
            if(afegirPista(Integer.parseInt(id.getText().toString()), type.getSelectedItem().toString(), desc.getText().toString(),
                    Float.parseFloat(lat.getText().toString()), Float.parseFloat(lon.getText().toString()), Integer.parseInt(idNext.getText().toString()))){
                Toast.makeText(this, form, Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(this, "Identificador repetit", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
    }
}
