package com.developnic.jjmichael.choose.Noticias;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.developnic.jjmichael.choose.Adapters.AdapterCategoriasCar;
import com.developnic.jjmichael.choose.R;

/**
 * Created by jjmic on 26/11/2017.
 */

public class Tab_Noticas extends Fragment{

    private static final String INDICE_SECCION
            = "com.developnica.jjmichael.choose.extra.INDICE_SECCION";

    private static final Integer TIPO = 0;

    public static final String ORIENTATION = "orientation";


    private RecyclerView reciclador;
    private AdapterCategoriasCar snapAdapter;
    private boolean mHorizontal;

    //NUEVO

    public static Tab_Noticas nuevaInstancia(int indiceSeccion) {
        Tab_Noticas fragment = new Tab_Noticas();
        Bundle args = new Bundle();
        args.putInt(INDICE_SECCION, indiceSeccion);
        fragment.setArguments(args);
        return fragment;
    }

    //fin nuevo

    public Tab_Noticas() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_inicio_fragmnents, container, false);

        if(savedInstanceState == null){mHorizontal = true;}
        else {mHorizontal = savedInstanceState.getBoolean(ORIENTATION);}

        reciclador = (RecyclerView) view.findViewById(R.id.recyclerView_Inicio);
        reciclador.setLayoutManager(new LinearLayoutManager(getActivity()));

        //snapAdapter = new AdapterCategoriasCar(getActivity());
        setupAdapter();
        //reciclador.setAdapter(snapAdapter);
        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION,mHorizontal);
    }

    private void setupAdapter() {

        int indiceSeccion = getArguments().getInt(INDICE_SECCION);

        switch (indiceSeccion)
        {
            case 0:
                Toast.makeText(getActivity(), "NOTICAS", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(getActivity(), "TENDENCIAS", Toast.LENGTH_SHORT).show();
                break;

        }

    }

}
