package com.developnic.jjmichael.choose.Fragment_Menu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rafael on 11-25-17.
 */

 public class addPreguntas {
    public ArrayList<structPreguntas> listaPreguntas = new ArrayList<>();

    public void addquest(int idpreg,int idcat,String preg){
        structPreguntas sp = new structPreguntas();
        sp.getidpreg(idpreg);
        sp.getidcategoria(idcat);
        sp.getpregunta(preg);
        listaPreguntas.add(sp);
    }
    public addPreguntas(){
        addquest(1,1,"¿Te gusta Ilustrar, dibujar y animar digitalmente?");
        addquest(2,2,"Realizar excavaciones para descubrir restos del pasado");
        addquest(3,3,"Seleccionar, capacitar y motivar al personal de una organización/empresa");
        addquest(4,4,"Diseñar programas de computación y explorar nuevas aplicaciones tecnológicas para uso del internet");
        addquest(5,5,"Criar, cuidar y tratar animales domésticos y de campo");
        addquest(6,1,"Tocar un instrumento y componer música");
        addquest(7,2,"Organizar eventos y atender a sus asistentes");
        addquest(8,3,"Planificar cuáles son las metas de una organización pública o privada a mediano y largo plazo");
        addquest(9,4,"Resolver problemas de cálculo para construir un puente.");
        addquest(10,5,"Investigar sobre áreas verdes, medio ambiente y cambios climáticos.");
        addquest(11,1,"Diseñar logotipos y portadas de una revista");
        addquest(12,1,"Trabajar como presentador de televisión, locutor de radio y televisión, animador de programas culturales y concursos");
        addquest(13,2,"Investigar las causas y efectos de los trastornos emocionales ");
        addquest(14,3,"Hacer propuestas y formular estrategias para aprovechar las relaciones económicas entre dos países.");
        addquest(15,4,"Diseñar máquinas que puedan simular actividades humanas. ");
        addquest(16,5,"Atender la salud de personas enfermas.");
        addquest(17,1,"Crear campañas publicitarias ");
        addquest(18,2,"Estudiar idiomas extranjeros –actuales y antiguos- para hacer traducción.");
        addquest(19,3,"Organizar un plan de distribución y venta de un gran almacén.");
        addquest(20,4,"Revisar y dar mantenimiento a artefactos eléctricos, electrónicos y computadoras");
        addquest(21,5,"Planificar y recomendar dietas para personas diabéticas y/o con sobrepeso. ");
        addquest(22,1,"Diseñar ropa para niños, jóvenes y adultos.");
        addquest(23,2,"Tratar a niños, jóvenes y adultos con problemas psicológicos. ");
        addquest(24,5,"Atender y realizar ejercicios a personas que tienen limitaciones físicas, problemas de lenguaje, etc.");
        addquest(25,3,"Controlar ingresos y egresos de fondos y presentar el balance final de una institución.");
        addquest(26,4,"Manejar y/o dar mantenimiento a dispositivos/aparatos tecnológicos en aviones, barcos, radares, etcétera");
        addquest(27,1,"Rediseñar y decorar espacios físicos en viviendas, oficinas y locales comerciales");
        addquest(28,3,"Administrar una empresa de turismo y/o agencias de viaje. ");
        addquest(29,4,"Tener un taller de reparación y mantenimiento de carros, tractores, etcétera. ");
        addquest(30,5,"Aplicar métodos alternativos a la medicina tradicional para atender personas con dolencias de diversa índole");
        addquest(31,1,"Fotografiar hechos históricos, lugares significativos, rostros, paisajes para el área publicitaria, artística, periodística y social ");
        addquest(32,2,"Conocer las distintas religiones, su filosofía y transmitirlas a la comunidad en general ");
        addquest(33,3,"Administrar una empresa (familiar, privada o pública) ");
        addquest(34,4,"Aplicar conocimientos de estadística en investigaciones en diversas áreas (social, administrativa, salud, etcétera.) ");
        addquest(35,5,"Estudiar la influencia entre las corrientes marinas y el clima y sus consecuencias ecológicas.");
        addquest(36,5,"Atender la salud dental de las personas");
        addquest(37,2,"Diseñar y ejecutar programas de turismo. ");
        addquest(38,2,"Estudiar grupos étnicos, sus costumbres, tradiciones, cultura y compartir sus vivencias. ");
        addquest(39,3,"Asistir a directivos de multinacionales con manejo de varios idiomas.");
        addquest(40,4,"Administrar y ordenar (planificar) adecuadamente la ocupación del espacio físico de ciudades, países etc., utilizando imágenes de satélite, mapas.");

    }
}
