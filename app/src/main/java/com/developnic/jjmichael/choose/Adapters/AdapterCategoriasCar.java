package com.developnic.jjmichael.choose.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.developnic.jjmichael.choose.DetallePorCarrera.Grid_Detalle;
import com.developnic.jjmichael.choose.POJO.Carreras;
import com.developnic.jjmichael.choose.POJO.Categorias_car;
import com.developnic.jjmichael.choose.R;
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjmic on 25/11/2017.
 */

public class AdapterCategoriasCar extends RecyclerView.Adapter<AdapterCategoriasCar.ViewHolder> implements
        ItemClickListener , GravitySnapHelper.SnapListener {


    private static final int HORIZONTAL = 1;
    private Context context;

    private List<Categorias_car> CategoriasCar = new ArrayList<>();

    public AdapterCategoriasCar(Context context) {
        this.context = context;
    }

    public void addCategoria(Categorias_car categorias) {
        CategoriasCar.add(categorias);
    }

    @Override
    public int getItemViewType(int position) {
        return HORIZONTAL;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_items_list_carreras, parent, false);
        return new ViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Categorias_car categ_car = CategoriasCar.get(position);
        holder.snapTextView.setText(categ_car.getNombre_catg());

        if (categ_car.getmGravity() == Gravity.START || categ_car.getmGravity() == Gravity.END || categ_car.getmGravity() == Gravity.CENTER_HORIZONTAL) {
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
                    .recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setOnFlingListener(null);
            new LinearSnapHelper()
                    .attachToRecyclerView(holder.recyclerView);

        } else if (categ_car.getmGravity() == Gravity.CENTER) { // Pager snap
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
                    .recyclerView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            holder.recyclerView.setOnFlingListener(null);
            new PagerSnapHelper().attachToRecyclerView(holder.recyclerView);
        } else { // Top / Bottom
            holder.recyclerView.setLayoutManager(new LinearLayoutManager(holder
                    .recyclerView.getContext()));
            holder.recyclerView.setOnFlingListener(null);
            new GravitySnapHelper(categ_car.getmGravity()).attachToRecyclerView(holder.recyclerView);
        }


        holder.recyclerView.setAdapter(new AdapterCarreras(categ_car.getmGravity() == Gravity.START
                || categ_car.getmGravity() == Gravity.END
                || categ_car.getmGravity() == Gravity.CENTER_HORIZONTAL,
                categ_car.getmGravity() == Gravity.CENTER, categ_car.getCarreras(), context));

    }

    @Override
    public int getItemCount() {
        return CategoriasCar.size();
    }

    @Override
    public void onSnap(int position) {
        Log.d("Snapped: ", position + "");
    }

    @Override
    public void onItemClick(View view, int position) {
        Carreras.PASAR_LISTA = CategoriasCar.get(position).getCarreras();
        Toast.makeText(context, "MAS..." + CategoriasCar.get(position).getCarreras().size(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, Grid_Detalle.class);
        context.startActivity(intent);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView snapTextView;
        private RecyclerView recyclerView;
        private ItemClickListener listener;

        public ViewHolder(View itemView, ItemClickListener listener) {
            super(itemView);
            snapTextView = (TextView) itemView.findViewById(R.id.snapTextView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.recyclerView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getAdapterPosition());
        }
    }
}
