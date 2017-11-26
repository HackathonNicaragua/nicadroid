package com.developnic.jjmichael.choose.Fragments_Menu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.developnic.jjmichael.choose.Adapters.AdapterUni;
import com.developnic.jjmichael.choose.POJO.Universidad;
import com.developnic.jjmichael.choose.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjmic on 26/11/2017.
 *
 */

public class FragmentsUniver extends Fragment {

    private RecyclerView reciclador;
    private LinearLayoutManager layoutManager;
    private AdapterUni adaptador;
    private ImageView imgu;
    private TextView txtu;
    public FragmentsUniver() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_universidad, container, false);

        ObtenerDatosFirebase();
        reciclador = view.findViewById(R.id.recycler_universidad);
        layoutManager = new LinearLayoutManager(getActivity());
        reciclador.setLayoutManager(layoutManager);
        adaptador = new AdapterUni(getActivity(), Universidad.getListUni());

        reciclador.setAdapter(adaptador);

        return view;
    }
    private void ObtenerDatosFirebase() {

        final FirebaseDatabase database = FirebaseDatabase.getInstance();

        database.getReference("univerisidad").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Universidad.LIST_UNI.clear();
                for (DataSnapshot snapshot:
                        dataSnapshot.getChildren()) {
                    Universidad uni = snapshot.getValue(Universidad.class);
                    Universidad.LIST_UNI.add(uni);
                }
                adaptador.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}

