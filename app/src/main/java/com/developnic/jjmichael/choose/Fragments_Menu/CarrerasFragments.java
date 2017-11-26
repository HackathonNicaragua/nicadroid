package com.developnic.jjmichael.choose.Fragments_Menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developnic.jjmichael.choose.Adapters.AdapterCategoriasCar;
import com.developnic.jjmichael.choose.POJO.Carreras;
import com.developnic.jjmichael.choose.POJO.Categorias_car;
import com.developnic.jjmichael.choose.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjmic on 25/11/2017.
 */

public class CarrerasFragments extends Fragment {

    private static final String INDICE_SECCION
            = "com.developnica.jjmichael.choose.extra.INDICE_SECCION";

    private static final Integer TIPO = 0;

    public static final String ORIENTATION = "orientation";


    private RecyclerView reciclador;
    private AdapterCategoriasCar snapAdapter;
    private boolean mHorizontal;

    //NUEVO

    public static CarrerasFragments nuevaInstancia(int indiceSeccion) {
        CarrerasFragments fragment = new CarrerasFragments();
        Bundle args = new Bundle();
        args.putInt(INDICE_SECCION, indiceSeccion);
        fragment.setArguments(args);
        return fragment;
    }

    //fin nuevo

    public CarrerasFragments() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_categorias_car, container, false);

        reciclador = (RecyclerView) view.findViewById(R.id.recyclerView_home);
        reciclador.setLayoutManager(new LinearLayoutManager(getActivity()));
        reciclador.setHasFixedSize(true);

        if(savedInstanceState == null){mHorizontal = true;}
        else {mHorizontal = savedInstanceState.getBoolean(ORIENTATION);}

        snapAdapter = new AdapterCategoriasCar(getActivity());

        setupAdapter();

        reciclador.setAdapter(snapAdapter);


        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION,mHorizontal);
    }

    private void setupAdapter() {

        int indiceSeccion = getArguments().getInt(INDICE_SECCION);

        OptenerCarrerasTipo();

        switch (indiceSeccion)
        {
            case 0:
                MetodoAdaptarCategorias(Carreras.LIST_CAR);
                break;
            case 1:
                MetodoAdaptarCategorias(Carreras.LIST_TEC);
                break;
            case  2:
                MetodoAdaptarCategorias(Carreras.LIST_CAR);
                break;
        }

    }

    public void MetodoAdaptarCategorias(List<Carreras> TIPO_CAR ){

        List<List<Carreras>> Array = new ArrayList<List<Carreras>>();
        int i=0;

        List<String> CategoriasPorTipo = OptenerCatPorTipo(TIPO_CAR);

        for (String Categoria: CategoriasPorTipo) {

            List<Carreras> simple = new ArrayList<>();

            for (Carreras car_item: TIPO_CAR) {
                if (Categoria.equals(car_item.getCategoria())) {
                    simple.add(car_item);
                }
            }
            Array.add(simple);
            snapAdapter.addCategoria(new Categorias_car(Gravity.CENTER_HORIZONTAL, Categoria,Array.get(i)));
            i++;
        }
    }

    private List<String> OptenerCatPorTipo(List<Carreras> TIPO) {
        List<String> lista_cat = new ArrayList<>();

        for (Carreras Car_catg: TIPO) {
            if(lista_cat.isEmpty()) {
                lista_cat.add(Car_catg.getCategoria());
            }
            if(!lista_cat.contains( Car_catg.getCategoria() )){
                lista_cat.add(Car_catg.getCategoria());
            }
        }

        return lista_cat;
    }

    public  void OptenerCarrerasTipo(){

        for (Carreras Car_catg: Carreras.LIST_COMPLETA) {
            if(Categorias_car.Tipo.isEmpty()) {
                Categorias_car.Tipo.add(Car_catg.getTipo());
            }
            if(!Categorias_car.Tipo.contains( Car_catg.getTipo() )){
                Categorias_car.Tipo.add(Car_catg.getTipo());
            }
        }

        OptenerListaporTipo();
    }

    public void OptenerListaporTipo() {
        for (String Tipo: Categorias_car.Tipo) {
            List<Carreras> simple = new ArrayList<>();

            for (Carreras tipo_item: Carreras.LIST_COMPLETA) {
                if (Tipo.equals(tipo_item.getTipo())) {
                    simple.add(tipo_item);
                }
            }

            if(Tipo.equals("carrera")){
                Carreras.LIST_CAR = simple;
            }
            else {
                Carreras.LIST_TEC = simple;
            }
        }
    }
}
