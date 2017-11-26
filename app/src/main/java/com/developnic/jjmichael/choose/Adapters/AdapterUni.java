package com.developnic.jjmichael.choose.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.developnic.jjmichael.choose.POJO.Universidad;
import com.developnic.jjmichael.choose.R;

import java.util.List;

/**
 * Created by jjmic on 26/11/2017.
 */
public class AdapterUni extends RecyclerView.Adapter<AdapterUni.ViewHolder> {

    private  Context contexto;
    private List<Universidad> items;
    private ClickListener clickLis;

    public class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        // Referencias UI
        public TextView viewNombre,txtu;
        public TextView viewUbicacion;
        public TextView viewDescripcion;
        public TextView viewPrecio;
        public ImageView viewFoto,imgu;
        public  CardView cardview;

        public ViewHolder(View v) {
            super(v);

            viewNombre = (TextView) v.findViewById(R.id.nombre);
            viewUbicacion = (TextView) v.findViewById(R.id.ubicacion);
            viewDescripcion = (TextView) v.findViewById(R.id.descripcion);
            viewPrecio = (TextView) v.findViewById(R.id.precio);
            viewFoto = (ImageView) v.findViewById(R.id.foto);
            cardview = (CardView) itemView.findViewById(R.id.cardview);
            txtu = v.findViewById(R.id.ubicacion);
            imgu = v.findViewById(R.id.imageu);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(clickLis!=null) {
                clickLis.itemClick(view,getAdapterPosition(), cardview);
            }
        }
    }

    public interface  ClickListener {
        public void itemClick(View v, int pos ,CardView cardView);
    }

    public void setClickListener (ClickListener click ){
        this.clickLis = click;
    }

    public AdapterUni(Context context , List<Universidad> lista) {
        this.contexto = context;
        this.items = lista;
    }

    public AdapterUni() {

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_universidad, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.viewNombre.setText(items.get(position).getSigla());
        holder.viewUbicacion.setText(items.get(position).getSigla());
        holder.viewDescripcion.setText(items.get(position).getNombre());
        holder.viewPrecio.setText(items.get(position).getNombre());



        Glide.with(contexto).load(items.get(position).getImg()).centerCrop().into(holder.viewFoto);
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        return 0;
    }


}