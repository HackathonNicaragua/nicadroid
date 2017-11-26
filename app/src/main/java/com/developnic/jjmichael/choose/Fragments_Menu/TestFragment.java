package com.developnic.jjmichael.choose.Fragments_Menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.developnic.jjmichael.choose.R;

import java.util.ArrayList;

public class TestFragment extends android.support.v4.app.Fragment {
    addPreguntas ap = new addPreguntas();
    public ArrayList<structPreguntas> preguntas = ap.listaPreguntas;
    public ArrayList<seguimiento>seguimientos = new ArrayList<>();
    public ArrayList<structResultados>resultados = new ArrayList<>();
    Button si,no,atras,sig;
    TextView preg;
    int idp = 0;
    public int ultima=0;

    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_test, container, false);
        todoslosres();

        si = vista.findViewById(R.id.si);
        no = vista.findViewById(R.id.no);
        preg = vista.findViewById(R.id.preg);
        preg.setText(preguntas.get(ultima).idpreg+": "+preguntas.get(ultima).pregunta);
        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                si_click(v);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_click(v);
            }
        });
        return vista;
    }

    private void no_click(View v) {
        alSeguimiento(idp,preguntas.get(idp).idcategoria,0);
        idp++;
        if(idp>ultima)ultima = idp;
        preg.setText(preguntas.get(ultima).pregunta);
        if(ultima==39){
            no.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cuenta(v);
                }
            });
        }
    }

    private void si_click(View v) {
        alSeguimiento(idp,preguntas.get(idp).idcategoria,1);
        idp++;
        if(idp>ultima)ultima = idp;
        preg.setText(preguntas.get(ultima).idpreg+": "+preguntas.get(ultima).pregunta);
        if(ultima==39){
            si.setText("Finalizar");
            si.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cuenta(v);
                }
            });
        }
    }

    private void cuenta(View v) {
        for(int x = 0;x<39;x++) {
            if (seguimientos.get(x).cat == 1)
                resultados.get(0).setPuntaje(seguimientos.get(x).siono + resultados.get(0).puntaje);
            if (seguimientos.get(x).cat == 2)
                resultados.get(1).setPuntaje(seguimientos.get(x).siono + resultados.get(1).puntaje);
            if (seguimientos.get(x).cat == 3)
                resultados.get(2).setPuntaje(seguimientos.get(x).siono + resultados.get(2).puntaje);
            if (seguimientos.get(x).cat == 4)
                resultados.get(3).setPuntaje(seguimientos.get(x).siono + resultados.get(3).puntaje);
            if (seguimientos.get(x).cat == 5)
                resultados.get(4).setPuntaje(seguimientos.get(x).siono + resultados.get(4).puntaje);
        }
        preg.setText(resultados.get(0).puntaje+","
                +resultados.get(1).puntaje+","
                +resultados.get(2).puntaje+","
                +resultados.get(3).puntaje+","
                +resultados.get(4).puntaje+",");
    }

    void alSeguimiento(int idpre,int cat,int sino){
        seguimiento s = new seguimiento();
        s.setCat(cat);
        s.setIdp(idpre);
        s.setSiono(sino);
        seguimientos.add(s);
    }

    void todoslosres(){
        structResultados c1,c2,c3,c4,c5;
        c1 = new structResultados();
        c2 = new structResultados();
        c3 = new structResultados();
        c4 = new structResultados();
        c5 = new structResultados();
        c1.setIdcat(1);c1.setNombre("Arte y Creatividad");c1.setPuntaje(0);
        c2.setIdcat(2);c2.setNombre("Ciencias Sociales");c2.setPuntaje(0);
        c3.setIdcat(3);c3.setNombre("Economica, Administrativa y financiera");c3.setPuntaje(0);
        c4.setIdcat(4);c4.setNombre("Ciencias y Tecnologia");c4.setPuntaje(0);
        c5.setIdcat(5);c5.setNombre("Ciencias ecologicas, biologicas y de Salud");c5.setPuntaje(0);
        resultados.add(c1);
        resultados.add(c2);
        resultados.add(c3);
        resultados.add(c4);
        resultados.add(c5);
    }
}
class seguimiento{
    int idp,siono,cat;
    void setIdp(int id ){
        idp=id;
    }
    void setCat(int id ){
        cat=id;
    }
    void setSiono(int id ){
        siono=id;
    }

}
class structResultados{
    int idcat,puntaje;
    String nombre;

    void setIdcat(int id){
        idcat = id;
    }
    void setNombre(String nombre){
        this.nombre = nombre;
    }
    void setPuntaje(int puntos){
        puntaje = puntos;
    }
}