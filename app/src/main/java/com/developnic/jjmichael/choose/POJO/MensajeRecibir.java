package com.developnic.jjmichael.choose.POJO;

import android.net.Uri;

/**
 * Created by jjmic on 26/11/2017.
 */

public class MensajeRecibir extends Mensaje {

    private Long hora;

    public MensajeRecibir() {

    }

    public MensajeRecibir(Long hora) {
        this.hora = hora;
    }

    public MensajeRecibir(String mensaje, String nombre, Uri fotoPerfil, String id_carrera, Long hora) {
        super(mensaje, nombre, fotoPerfil,id_carrera);
        this.hora = hora;
    }
    public Long getHora() {
        return hora;
    }

    public void setHora(Long hora) {
        this.hora = hora;
    }
}
