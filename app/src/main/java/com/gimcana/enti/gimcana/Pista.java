package com.gimcana.enti.gimcana;

/**
 * Created by egaona on 10/11/2017.
 */

public abstract class Pista {
    private int id;
    private float latitud;
    private float longitud;
    private int nextId;

    protected Pista(int id, float latitud, float longitud, int nextId) {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLatitud() { return latitud; }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public int getNextId() {
        return nextId;
    }

    public void setNextId(int nextId) { this.nextId = nextId; }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        Pista p = (Pista)obj;
        if(p.id == this.id) return true;
        return false;
    }
}
