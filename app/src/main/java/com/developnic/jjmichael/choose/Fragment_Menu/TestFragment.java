package com.developnic.jjmichael.choose.Fragment_Menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import com.developnic.jjmichael.choose.MainActivity;
import com.developnic.jjmichael.choose.R;

import java.util.ArrayList;

public class TestFragment extends android.support.v4.app.Fragment {
    addPreguntas ap = new addPreguntas();
    public ArrayList<structPreguntas> preguntas = ap.listaPreguntas;
    public ArrayList<seguimiento>seguimientos = new ArrayList<>();
    public ArrayList<structResultados>resultados = new ArrayList<>();
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
        todoslosres();
        si = vista.findViewById(R.id.si);
        no = vista.findViewById(R.id.no);
        atras = vista.findViewById(R.id.atras);
        sig = vista.findViewById(R.id.sig);
        preg = vista.findViewById(R.id.preg);

        structPreguntas sp= preguntas.get(ultima);
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
            if(ultima ==39){
                sig.setText("finalizar");
                sig.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        conteo(v);
                    }
                });
            }
        }
    }
    void conteo(View v){
        for(int x = 1;x<=40;x++){
            seguimiento s = new seguimiento();
            s = seguimientos.get(x);
            if(s.cat == 1)resultados.get(0).setPuntaje(resultados.get(0).idcat+s.siono);
            if(s.cat == 2)resultados.get(1).setPuntaje(resultados.get(1).idcat+s.siono);
            if(s.cat == 3)resultados.get(2).setPuntaje(resultados.get(2).idcat+s.siono);
            if(s.cat == 4)resultados.get(3).setPuntaje(resultados.get(3).idcat+s.siono);
            if(s.cat == 5)resultados.get(4).setPuntaje(resultados.get(4).idcat+s.siono);

        }
        preg.setText(resultados.get(0).nombre+": "+resultados.get(0).puntaje+"\n"+
                resultados.get(1).nombre+": "+resultados.get(1).puntaje+"\n"+
                resultados.get(2).nombre+": "+resultados.get(2).puntaje+"\n"+
                resultados.get(3).nombre+": "+resultados.get(3).puntaje+"\n"+
                resultados.get(4).nombre+": "+resultados.get(4).puntaje+"\n"
        );
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