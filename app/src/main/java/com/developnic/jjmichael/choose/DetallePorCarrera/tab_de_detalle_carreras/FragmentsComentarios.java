package com.developnic.jjmichael.choose.DetallePorCarrera.tab_de_detalle_carreras;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.developnic.jjmichael.choose.Adapters.AdapterComentario;
import com.developnic.jjmichael.choose.POJO.Conexiones;
import com.developnic.jjmichael.choose.POJO.MensajeEnviar;
import com.developnic.jjmichael.choose.POJO.MensajeRecibir;
import com.developnic.jjmichael.choose.POJO.Usuarios;
import com.developnic.jjmichael.choose.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

/**
 * Created by jjmic on 25/11/2017.
 */
public class FragmentsComentarios extends android.support.v4.app.Fragment {

    private RecyclerView rvMensajes;
    private EditText txtMensaje;
    private FloatingActionButton btnEnviar;
    private AdapterComentario adapter;


    private FirebaseDatabase database;
    private DatabaseReference databaseReference;


    public FragmentsComentarios() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_detalle_comentario,container,false);


        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference("comentarios");//Sala de chat (nombre)

        rvMensajes = v.findViewById(R.id.recyclerView_Com);
        txtMensaje = v.findViewById(R.id.agregar_comentario);
        btnEnviar =  v.findViewById(R.id.bt_enviar);


        rvMensajes = v.findViewById(R.id.recyclerView_Com);
        adapter = new AdapterComentario(getActivity());
        LinearLayoutManager l = new LinearLayoutManager(getActivity());
        rvMensajes.setLayoutManager(l);
        rvMensajes.setAdapter(adapter);


        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.push().setValue(new MensajeEnviar(txtMensaje.getText().toString(), Usuarios.USER.getNombre_user(),Usuarios.USER.getFoto(),Conexiones.carreras.getId_carreras() , ServerValue.TIMESTAMP));
                txtMensaje.setText("");
            }
        });

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onItemRangeInserted(int positionStart, int itemCount) {
                super.onItemRangeInserted(positionStart, itemCount);
                setScrollbar();
            }
        });

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                MensajeRecibir m = dataSnapshot.getValue(MensajeRecibir.class);
                if(m.getType_mensaje().equals(Conexiones.carreras.getId_carreras())) {
                    adapter.addMensaje(m);
                }
                Toast.makeText(getActivity(), "TAMAÑO COMENTARIOS" + m.getNombre(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(DatabaseError databaseError) {}

        });

        return v;
    }

    private void setScrollbar(){
        rvMensajes.scrollToPosition(adapter.getItemCount()-1);
    }

}