package com.gimcana.enti.gimcana;

import java.util.ArrayList;

/**
 * Created by egaona on 11/13/2017.
 */

public class LlistaPistes {
    private static final LlistaPistes ourInstance = new LlistaPistes();

    public static LlistaPistes getInstance() {
        return ourInstance;
    }

    private LlistaPistes() {
    }
    public static ArrayList<Pista> llistaPistes = new ArrayList<Pista>();;
}
