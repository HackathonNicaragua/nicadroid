package com.developnic.jjmichael.choose.POJO;

import java.util.ArrayList;
import java.util.List;

public class Carreras {

    private String id_carreras;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String icono;
    private String modalidad;
    private String perfil;
    private String salario;
    private String like;
    private String categoria;
    private String tipo;
    private String fuentes;
    private String cargos;
    private String grados;
    private String turno;
    private String duracion;
    private String ofrecen;


    public static final List<Carreras> LIST_COMPLETA = new ArrayList<Carreras>();
    public static List<Carreras> LIST_TEC = new ArrayList<>();
    public static List<Carreras> LIST_CAR = new ArrayList<Carreras>();
    public static List<Carreras> PASAR_LISTA = new ArrayList<>();
    public static List<Carreras> LIS_LINEA = new ArrayList<>();


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
        return like;
    }

    public void setRanking(String ranking) {
        this.like = ranking;
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

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getFuentes() {
        return fuentes;
    }

    public void setFuentes(String fuentes) {
        this.fuentes = fuentes;
    }

    public String getCargos() {
        return cargos;
    }

    public void setCargos(String cargos) {
        this.cargos = cargos;
    }

    public String getGrados() {
        return grados;
    }

    public void setGrados(String grados) {
        this.grados = grados;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getOfrecen() {
        return ofrecen;
    }

    public void setOfrecen(String ofrecen) {
        this.ofrecen = ofrecen;
    }
}
