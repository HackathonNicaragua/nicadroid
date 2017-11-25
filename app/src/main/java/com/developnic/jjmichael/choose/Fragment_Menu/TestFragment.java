package com.developnic.jjmichael.choose.Fragment_Menu;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developnic.jjmichael.choose.R;

import java.util.ArrayList;

public class TestFragment extends android.support.v4.app.Fragment {
    addPreguntas ap = new addPreguntas();
    public ArrayList<structPreguntas> preguntas = ap.listaPreguntas;



    public TestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_test, container, false);
    }


}
