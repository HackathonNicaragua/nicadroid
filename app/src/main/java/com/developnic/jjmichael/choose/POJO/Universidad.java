package com.developnic.jjmichael.choose.POJO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjmic on 26/11/2017.
 */

public class Universidad {

    public String sigla;
    public String nombre;
    public String img;

    public static List<Universidad> LIST_UNI = new ArrayList<>();

    public Universidad() {
    }

    public Universidad(String sigla, String nombre, String img) {
        this.sigla = sigla;
        this.nombre = nombre;
        this.img = img;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public static List<Universidad> getListUni() {
        return LIST_UNI;
    }

    public static void setListUni(List<Universidad> listUni) {
        LIST_UNI = listUni;
    }

}

