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

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by jjmic on 25/11/2017.
 */

public class Adapter_Utilidad extends RecyclerView.Adapter<Adapter_Utilidad.ViewHolder> implements ItemClickListener {

    private Context context;
    private Carreras item;

    public Adapter_Utilidad(Carreras carreras, Context context) {

        item = carreras;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView tv_ofrece;
        public TextView tv_duracion;
        public TextView tv_modalidad;
        public TextView tv_turno;
        public TextView tv_grado;
        public CircleImageView circleImageView1;
        public CircleImageView circleImageView2;
        public CircleImageView circleImageView3;

        private ItemClickListener listener;

        public ViewHolder(View v, ItemClickListener listener) {
            super(v);

            circleImageView1 = itemView.findViewById(R.id.icono_util_duracion);
            circleImageView2 = itemView.findViewById(R.id.icono_util_modalidad);
            circleImageView3 = itemView.findViewById(R.id.icono_util_turno);
            tv_ofrece = itemView.findViewById(R.id.ofrecen_carrera);
            tv_duracion = itemView.findViewById(R.id.duracion_carrera);
            tv_modalidad = itemView.findViewById(R.id.modalidad_carrera);
            tv_turno = itemView.findViewById(R.id.turno_carrera);
            tv_grado = itemView.findViewById(R.id.grado_carrera);

            this.listener = listener;
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getAdapterPosition());
        }
    }


    public Adapter_Utilidad(Context context, Carreras items) {
        this.context = context;
        this.item = items;
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
                .inflate(R.layout.cartview_utilidad, viewGroup, false), this);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_ofrece.setText(item.getOfrecen());
        viewHolder.tv_duracion.setText(item.getDuracion());
        viewHolder.tv_modalidad.setText(item.getModalidad());
        viewHolder.tv_turno.setText(item.getTurno());
        viewHolder.tv_grado.setText(item.getFuentes());

        viewHolder.circleImageView1.setImageResource(R.drawable.duracion);
        viewHolder.circleImageView2.setImageResource(R.drawable.modallidades);
        viewHolder.circleImageView3.setImageResource(R.drawable.turno);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(context, "CLICK", Toast.LENGTH_SHORT).show();
    }

}