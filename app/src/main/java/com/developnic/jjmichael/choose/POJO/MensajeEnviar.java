package com.developnic.jjmichael.choose.POJO;

import android.net.Uri;

import java.util.Map;

/**
 * Created by jjmic on 26/11/2017.
 */

public class MensajeEnviar extends Mensaje {
    private Map hora;

    public MensajeEnviar() {
    }

    public MensajeEnviar(Map hora) {
        this.hora = hora;
    }

    public MensajeEnviar(String mensaje, String nombre, Uri fotoPerfil, String id_carrera , Map hora) {
        super(mensaje, nombre, fotoPerfil,id_carrera);
        this.hora = hora;
    }

    public Map getHora() {
        return hora;
    }

    public void setHora(Map hora) {
        this.hora = hora;
    }
}