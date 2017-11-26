package com.developnic.jjmichael.choose.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.developnic.jjmichael.choose.DetallePorCarrera.DetalleCarrera;
import com.developnic.jjmichael.choose.POJO.Carreras;
import com.developnic.jjmichael.choose.R;

import java.util.List;

/**
 * Created by jjmic on 25/11/2017.
 */

public class AdapterCarreras extends RecyclerView.Adapter<AdapterCarreras.ViewHolder> implements ItemClickListener {

    private Context context;
    private List<Carreras> items;
    private boolean mHorizontal;
    private boolean mPager;

    public AdapterCarreras(boolean horizontal, boolean pager, List<Carreras> carreras, Context context) {
        mHorizontal = horizontal;
        items = carreras;
        mPager = pager;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public ImageView imageView;
        public TextView nameTextView;
        public TextView ratingTextView;

        private ItemClickListener listener;

        public ViewHolder(View v , ItemClickListener listener) {
            super(v);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            ratingTextView = (TextView) itemView.findViewById(R.id.ratingTextView);

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
        if (items != null)
            return items.size();
        else
            return 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_list_carreras_page_normal, viewGroup, false),this);

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Carreras item = items.get(i);

        Glide.with(context).load(items.get(i).getIcono()).centerCrop().into(viewHolder.imageView);
        viewHolder.nameTextView.setText(item.getNombre());
        viewHolder.ratingTextView.setText(item.getRanking());
    }

    @Override
    public void onItemClick (View view ,int position){
      DetalleCarrera.createInstance( (Activity) context , items.get(position));

    }
}
