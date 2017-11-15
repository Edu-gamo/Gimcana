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
        setContentView(R.layout.activity_principal);
        //setContentView(R.layout.afegir_pista);


        Pista p = new PistaText(10, 123.5f, 321.5f, 20, "Pista 1");
        LlistaPistes.getInstance().addPista(p);
        /*p = new PistaText(20, 456.5f, 654.5f, 30, "Pista 2");
        LlistaPistes.addPista(p);
        p = new PistaText(30, 789.5f, 987.5f, 40, "Pista 3");
        LlistaPistes.addPista(p);*/

    }

    public void showAbout(View view){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

    public void showHints(View view){
        Intent i = new Intent(this, ShowHints.class);
        startActivity(i);
    }

    public void exitApp(View view){
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
        if(iden.getText().toString().equals(idNext.getText().toString())){
            if(!error.equals("")) error += "\n";
            error += "L'identificador no pot ser el mateix que l'identificador de la següent pista";
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

}
