package com.developnic.jjmichael.choose.POJO;

import android.net.Uri;



public class Usuarios {

    private String nombre_user;
    private String correo_user;
    private Uri foto;

    public static final Usuarios USER = new Usuarios();

    public Usuarios() {
    }

    public Usuarios(String nombre_user, String correo_user) {
        this.nombre_user = nombre_user;
        this.correo_user = correo_user;
    }

    public String getNombre_user() {
        return nombre_user;
    }

    public void setNombre_user(String nombre_user) {
        this.nombre_user = nombre_user;
    }

    public String getCorreo_user() {
        return correo_user;
    }

    public void setCorreo_user(String correo_user) {
        this.correo_user = correo_user;
    }

    public Uri getFoto() {
        return foto;
    }

    public void setFoto(Uri foto) {
        this.foto = foto;
    }
}
