package com.gimcana.enti.gimcana;

import java.util.ArrayList;

/**
 * Created by egaona on 11/13/2017.
 */

public class LlistaPistes {
    private static LlistaPistes ourInstance = null;
    private static ArrayList<Pista> llistaPistes;

    public static LlistaPistes getInstance() {
        if (ourInstance==null)
            ourInstance=new LlistaPistes();
        return ourInstance;
    }


    private LlistaPistes() {
        llistaPistes = new ArrayList<Pista>();
    }

    public static boolean addPista(Pista pista){

        boolean find = searchPista(pista);
        if(!find) llistaPistes.add(pista);
        return !find;

    }

    public static boolean removePista(Pista pista){

        boolean find = searchPista(pista);
        if(find) llistaPistes.remove(pista);
        return find;
    }

    public static int size() {
        return llistaPistes.size();
    }

    public static boolean searchPista(Pista pista){

        boolean find = false;
        int i = 0;

        while (i < llistaPistes.size()){
            if(pista.equals(llistaPistes.get(i))) find = true;
            i++;
        }

        return find;
    }

}
