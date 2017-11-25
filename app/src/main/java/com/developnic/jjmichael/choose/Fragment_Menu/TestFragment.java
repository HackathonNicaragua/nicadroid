package com.developnic.jjmichael.choose.Fragment_Menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.developnic.jjmichael.choose.MainActivity;
import com.developnic.jjmichael.choose.R;

import java.util.ArrayList;

public class TestFragment extends android.support.v4.app.Fragment {
    addPreguntas ap = new addPreguntas();
    public ArrayList<structPreguntas> preguntas = ap.listaPreguntas;
    public ArrayList<seguimiento>seguimientos = new ArrayList<>();
    RadioButton si,no;
    Button atras,sig;
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

        si = vista.findViewById(R.id.si);
        no = vista.findViewById(R.id.no);
        atras = vista.findViewById(R.id.atras);
        sig = vista.findViewById(R.id.sig);
        preg = vista.findViewById(R.id.preg);

        structPreguntas sp= preguntas.get(idp);
        preg.setText(sp.idpreg+". "+sp.pregunta);

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_click(v);
            }
        });
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option_click(v);
            }
        });
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sig_click(v);
            }
        });
        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                atras_click(v);
            }
        });
        return vista;
    }
    void sig_click(View v){
        if(si.isChecked()||no.isChecked())if(idp<40) {
            idp++;
            structPreguntas sp = preguntas.get(idp);
            preg.setText(sp.idpreg + ". " + sp.pregunta);
            if (idp > ultima) ultima = idp;
        }
    }
    void atras_click(View v){
        if(si.isChecked()||no.isChecked())if(idp>0){
            idp--;
            structPreguntas sp= preguntas.get(idp);
            preg.setText(sp.idpreg+". "+sp.pregunta);
        }
    }
    void option_click(View v){
        if(si.isChecked()){
            alSeguimiento(idp,preguntas.get(idp).idcategoria,1);
        }else{
            alSeguimiento(idp,preguntas.get(idp).idcategoria,0);
        }
    }
    void alSeguimiento(int idpre,int cat,int sino){
        seguimiento s = new seguimiento();
        s.setCat(cat);
        s.setIdp(idpre);
        s.setSiono(sino);
        seguimientos.add(s);
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
class resultados{
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