package com.developnic.jjmichael.choose.DetallePorCarrera.tab_de_detalle_carreras;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developnic.jjmichael.choose.Adapters.Adapter_Utilidad;
import com.developnic.jjmichael.choose.POJO.Conexiones;
import com.developnic.jjmichael.choose.R;

/**
 * Created by jjmic on 25/11/2017.
 */

public class FragmentsUtilidad extends Fragment {
    RecyclerView recyclerView_Des;
    Adapter_Utilidad adapter_utilidad;
    LinearLayoutManager linearLayoutManager;

    public FragmentsUtilidad() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_detalle_utilidad,container,false);
        recyclerView_Des = (RecyclerView) v.findViewById(R.id.recyclerView_Util);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView_Des.setLayoutManager(linearLayoutManager);
        adapter_utilidad = new Adapter_Utilidad(getActivity(), Conexiones.carreras);
        recyclerView_Des.setAdapter(adapter_utilidad);
        return v;
    }
}
