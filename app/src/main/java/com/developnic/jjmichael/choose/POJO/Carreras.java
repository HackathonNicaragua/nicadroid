package com.developnic.jjmichael.choose.POJO;

import java.util.ArrayList;
import java.util.List;

public class Carreras {

    private String id_carreras;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String icono;
    private String link_pensum;
    private String modalidad;
    private String perfil;
    private String salario;
    private String ranking;
    private String categoria;
    private String tipo;

    public static final List<Carreras> LIST_COMPLETA = new ArrayList<Carreras>();
    public static List<Carreras> LIST_TEC = new ArrayList<>();
    public static List<Carreras> LIST_CAR = new ArrayList<Carreras>();
    public static List<Carreras> PASAR_LISTA = new ArrayList<>();


    public Carreras() {

    }

    public String getId_carreras() {
        return id_carreras;
    }

    public void setId_carreras(String id_carreras) {
        this.id_carreras = id_carreras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public String getLink_pensum() {
        return link_pensum;
    }

    public void setLink_pensum(String link_pensum) {
        this.link_pensum = link_pensum;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
