package com.gimcana.enti.gimcana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

        Toolbar toolbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Pista p = new PistaText(10, 123.5f, 321.5f, 20, "Pista 1");
        LlistaPistes.getInstance().addPista(p);
        p = new PistaText(20, 456.5f, 654.5f, 30, "Pista 2");
        LlistaPistes.addPista(p);
        p = new PistaText(30, 789.5f, 987.5f, 40, "Pista 3");
        LlistaPistes.addPista(p);

    }

    public void showAbout(View view){
        Intent i = new Intent(this, About.class);
        startActivity(i);
    }

    public void showHints(View view){
        Intent i = new Intent(this, ShowHints.class);
        startActivity(i);
    }

    public void showPista(View view){
        Intent i = new Intent(this, MostrarPista.class);
        startActivity(i);
    }

    public void exit(View view){
        finish();
    }

}
