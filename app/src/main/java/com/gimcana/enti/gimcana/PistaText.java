package com.gimcana.enti.gimcana;

/**
 * Created by egaona on 10/11/2017.
 */

public class PistaText extends Pista {
    private String text;

    public PistaText(int id, float latitud, float longitud, int nextId, String text) {
        super(id, latitud, longitud, nextId);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
