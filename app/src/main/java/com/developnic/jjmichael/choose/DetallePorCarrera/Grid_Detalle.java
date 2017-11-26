package com.developnic.jjmichael.choose.DetallePorCarrera;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.developnic.jjmichael.choose.Adapters.AdapterGridCar;
import com.developnic.jjmichael.choose.POJO.Carreras;
import com.developnic.jjmichael.choose.R;

/**
 * Created by jjmic on 26/11/2017.
 */

public class Grid_Detalle extends AppCompatActivity {

    RecyclerView recyclerView_Grid;
    AdapterGridCar adapterGridCar;
    GridLayoutManager gridLayoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_layout);

        setToolbar();
        if (getSupportActionBar() != null) // Habilitar up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        llenarGrid();

    }

    private void llenarGrid() {

        recyclerView_Grid = (RecyclerView) findViewById(R.id.recyclerView_Grid);
        gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView_Grid.setLayoutManager(gridLayoutManager);
        adapterGridCar = new AdapterGridCar(this, Carreras.PASAR_LISTA);
        recyclerView_Grid.setAdapter(adapterGridCar);
        setTitle(Carreras.PASAR_LISTA.get(0).getCategoria());

    }

    private void setToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
