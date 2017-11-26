package com.developnic.jjmichael.choose.POJO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjmic on 25/11/2017.
 */

public class Categorias_car {

    private int mGravity;
    private String nombre_catg;
    private List<Carreras> carreras;


    public static final List<String> Tipo = new ArrayList<>();

    public Categorias_car()
    {

    }

    public Categorias_car(int mGravity, String nombre_catg, List<Carreras> carreras) {
        this.mGravity = mGravity;
        this.nombre_catg = nombre_catg;
        this.carreras = carreras;
    }

    public int getmGravity() {
        return mGravity;
    }

    public void setmGravity(int mGravity) {
        this.mGravity = mGravity;
    }

    public String getNombre_catg() {
        return nombre_catg;
    }

    public void setNombre_catg(String nombre_catg) {
        this.nombre_catg = nombre_catg;
    }

    public List<Carreras> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carreras> carreras) {
        this.carreras = carreras;
    }
}
