package com.developnic.jjmichael.choose.Fragments_Menu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developnic.jjmichael.choose.DetallePorCarrera.InfoPerfil;

/**
 * Created by jjmic on 26/11/2017.
 */
public class PerfilFragment extends Fragment {

    public PerfilFragment() {

    }
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        InfoPerfil.createInstance(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

