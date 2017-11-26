package com.developnic.jjmichael.choose.POJO;

import android.net.Uri;

/**
 * Created by jjmic on 26/11/2017.
 */

public class Mensaje {

    private String mensaje;
    private String nombre;
    private Uri fotoPerfil;
    private String id_carrera;

    public Mensaje() {

    }

    public Mensaje(String mensaje, String nombre, Uri fotoPerfil, String id_carrera) {
        this.mensaje = mensaje;
        this.nombre = nombre;
        this.fotoPerfil = fotoPerfil;
        this.id_carrera = id_carrera;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Uri getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(Uri fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getType_mensaje() {
        return id_carrera;
    }

    public void setType_mensaje(String id_carrera) {
        this.id_carrera = id_carrera;
    }

}
