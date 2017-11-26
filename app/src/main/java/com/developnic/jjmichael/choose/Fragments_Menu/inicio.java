package com.developnic.jjmichael.choose.Fragments_Menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v13.app.FragmentTabHost;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developnic.jjmichael.choose.R;
import com.developnic.jjmichael.choose.inicio.noticias;
import com.developnic.jjmichael.choose.inicio.tendencia;

public class inicio extends android.support.v4.app.Fragment{

    private FragmentTabHost tabHost;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //setContentView(R.layout.fragment_inicio);
        View view = inflater.inflate(R.layout.fragmento_paginado, container, false);
        tabHost= view.findViewById(android.R.id.tabhost);
        //tabHost.setup(this,getFragmentManager(),android.R.id.tabcontent);
        tabHost.addTab(tabHost.newTabSpec("Noticias").setIndicator("calendario"),
                noticias.class, null);
        tabHost.addTab(tabHost.newTabSpec("Tendencia").setIndicator("radio group"),
                tendencia.class, null);
        return view;
    }


}
