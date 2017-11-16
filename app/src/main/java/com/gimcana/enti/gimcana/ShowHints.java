package com.gimcana.enti.gimcana;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowHints extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    //private ArrayList<Pista> llistaItems;
    private RecyclerView recyclerView;
    public Adaptador adaptador;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hints);

        //llistaItems = LlistaPistes.getPistes();

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        //adaptador = new Adaptador(this, llistaItems);
        adaptador = new Adaptador(this);
        adaptador.setOnClickListener(this);
        adaptador.setOnLongClickListener(this);
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showForm(view);
            }
        });
    }

    public void onClick(View v){
        Pista pista = LlistaPistes.getInstance().getPista(recyclerView.getChildAdapterPosition(v));
        Toast.makeText(this, pista.getText(), Toast.LENGTH_SHORT).show();
    }

    public boolean onLongClick(View v){
        final View k = v;
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("Eliminar Pista");
        String message = String.valueOf(LlistaPistes.getInstance().getPista(recyclerView.getChildAdapterPosition(v)).getId()) + "se va a eliminar";
        alertDialogBuilder.setMessage(message);
        alertDialogBuilder.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                if(LlistaPistes.getInstance().removePista(recyclerView.getChildAdapterPosition(k))) adaptador.notifyDataSetChanged();
            }
        });
        alertDialogBuilder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        return true;
    }

    public void showForm(View view){
        Intent i = new Intent(this, Form.class);
        startActivity(i);
    }

}
