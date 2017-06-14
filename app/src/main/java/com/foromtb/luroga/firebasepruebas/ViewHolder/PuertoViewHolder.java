package com.foromtb.luroga.firebasepruebas.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.foromtb.luroga.firebasepruebas.R;

/**
 * Created by LuisR on 13/06/2017.
 */


public  class PuertoViewHolder extends RecyclerView.ViewHolder{

    public TextView nombre, descripcion;
    public RatingBar valoracion;

    public PuertoViewHolder(View v){
        super (v);


        nombre = (TextView)v.findViewById(R.id.itemNombre);
        descripcion = (TextView)v.findViewById(R.id.itemDistancia);
        valoracion = (RatingBar)v.findViewById(R.id.itemValoracion);

    }
}
