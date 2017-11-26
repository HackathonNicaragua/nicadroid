package com.developnic.jjmichael.choose.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;
import com.developnic.jjmichael.choose.POJO.MensajeRecibir;
import com.developnic.jjmichael.choose.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jjmic on 26/11/2017.
 */

public class AdapterComentario extends  RecyclerView.Adapter<AdapterComentario.ViewHolder> implements ItemClickListener {
    private Context context;
    private List<MensajeRecibir> items = new ArrayList<>();

    public AdapterComentario(Context context) {
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView tv_nombre;
        private  TextView tv_comentario;
        private ImageView foto_perfil;
        private TextView hora;
        private ItemClickListener listener;

        public ViewHolder(View v , ItemClickListener listener) {
            super(v);

            tv_nombre = (TextView) itemView.findViewById(R.id.nombreMensaje);
            tv_comentario = (TextView) itemView.findViewById(R.id.mensajeMensaje);
            foto_perfil = (ImageView) itemView.findViewById(R.id.fotoPerfilMesaje);
            hora = (TextView) itemView.findViewById(R.id.horaMensaje);

            this.listener = listener;
            v.setOnClickListener(this);
        }

        public TextView getHora() {
            return hora;
        }

        public void setHora(TextView hora) {
            this.hora = hora;
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view,getAdapterPosition());
        }
    }

    public void addMensaje(MensajeRecibir m){
        items.add(m);
        notifyItemInserted(items.size());
    }

    @Override
    public int getItemCount() {
        if (items != null)
            return items.size();
        else
            return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cartview_comentario, viewGroup, false),this);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int i) {

        holder.tv_nombre.setText(items.get(i).getNombre());
        holder.tv_comentario.setText(items.get(i).getMensaje());
        holder.tv_comentario.setVisibility(View.VISIBLE);

        ColorGenerator generator = ColorGenerator.MATERIAL;
        int color = generator.getColor(items.get(i).getNombre()); //Genera un color según el nombre
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(holder.tv_nombre.getText().toString().substring(0,1).toUpperCase(), color);

        holder.foto_perfil.setImageDrawable(drawable);

        Long codigoHora = items.get(i).getHora();
        Date d = new Date(codigoHora);
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");//a pm o am
        holder.getHora().setText(sdf.format(d));
    }

    @Override
    public void onItemClick (View view ,int position){

    }
}
