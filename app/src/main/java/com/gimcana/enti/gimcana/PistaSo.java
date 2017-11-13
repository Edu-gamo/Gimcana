package com.gimcana.enti.gimcana;

/**
 * Created by egaona on 10/11/2017.
 */

public class PistaSo extends Pista {
    private String path;

    public PistaSo(int id, float latitud, float longitud, int nextId, String path) {
        super(id, latitud, longitud, nextId);
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
