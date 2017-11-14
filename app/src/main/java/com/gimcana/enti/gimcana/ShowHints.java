package com.gimcana.enti.gimcana;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowHints extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> llistaVersions;
    private RecyclerView recyclerView;
    public Adaptador adaptador;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_hints);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        adaptador = new Adaptador(this, llistaVersions);
        adaptador.setOnClickListener(this);
        recyclerView.setAdapter(adaptador);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onClick(View v){
        String s = llistaVersions.get(recyclerView.getChildAdapterPosition(v));
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
    }

}
