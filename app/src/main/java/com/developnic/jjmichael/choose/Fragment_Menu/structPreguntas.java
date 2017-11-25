package com.developnic.jjmichael.choose.Fragment_Menu;

/**
 * Created by rafael on 11-25-17.
 */

public final class structPreguntas {
    int idpreg;
    int idcategoria;
    String pregunta;
    void getidpreg(int id){
        idpreg = id;
    }
    void getidcategoria(int id){
        idcategoria = id;
    }
    void getpregunta(String pregunta){
        this.pregunta = pregunta;
    }
}
