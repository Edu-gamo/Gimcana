package com.gimcana.enti.gimcana;

/**
 * Created by egaona on 10/11/2017.
 */

public class PistaImatge extends Pista {
    private String path;

    public PistaImatge(int id, float latitud, float longitud, int nextId, String path) {
        super(id, latitud, longitud, nextId);
        this.path = path;
    }

    public String getText() { return path; }

    public void setText(String path) {
        this.path = path;
    }
}
