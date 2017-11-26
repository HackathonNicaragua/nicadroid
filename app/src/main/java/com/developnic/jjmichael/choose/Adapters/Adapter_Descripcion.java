package com.developnic.jjmichael.choose.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.developnic.jjmichael.choose.POJO.Carreras;
import com.developnic.jjmichael.choose.R;

/**
 * Created by jjmic on 25/11/2017.
 */

public class Adapter_Descripcion extends RecyclerView.Adapter<Adapter_Descripcion.ViewHolder> implements ItemClickListener {

    private Context context;
    private Carreras item;

    public Adapter_Descripcion(  Context context ,Carreras carreras) {

        item = carreras;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView tv_nombre;
        public TextView tv_perfil;
        public TextView tv_porque;
        public TextView tv_fuentes;
        public TextView tv_salario;
        public TextView tv_cargos;

        private ItemClickListener listener;

        public ViewHolder(View v , ItemClickListener listener) {
            super(v);

            tv_perfil =  itemView.findViewById(R.id.perfil_carrera);
            tv_porque =  itemView.findViewById(R.id.porque_carrera);
            tv_nombre = itemView.findViewById(R.id.nombre_carrera);
            tv_fuentes = itemView.findViewById(R.id.fuentes_carrera);
            tv_cargos = itemView.findViewById(R.id.cargos_carrera);
            tv_salario = itemView.findViewById(R.id.salario_carrera);

            this.listener = listener;
            v.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            listener.onItemClick(view,getAdapterPosition());
        }
    }


    @Override
    public int getItemCount() {
        if (item != null)
            return 1;
        else
            return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cartview_descripcion, viewGroup, false),this);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_nombre.setText(item.getNombre());
        viewHolder.tv_perfil.setText(item.getPerfil());
        viewHolder.tv_porque.setText(item.getDescripcion());
        viewHolder.tv_cargos.setText(item.getCargos());
        viewHolder.tv_fuentes.setText(item.getFuentes());
        viewHolder.tv_salario.setText(item.getSalario());

    }

    @Override
    public void onItemClick (View view ,int position){
        Toast.makeText(context, "CLICK", Toast.LENGTH_SHORT).show();
    }
}
