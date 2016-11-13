package itesm.mx.formaciondeportivaandroid;

/*
* Copyright (c) 2016, Instituto Tecnológico y de Estudios Superiores de Monterrey, México. Derechos reservados.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses.
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TipoEjercicioAdapter extends ArrayAdapter<TipoEjercicio> {
    public TipoEjercicioAdapter(Context context, ArrayList<TipoEjercicio> rutina) {
        super(context, 0, rutina);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TipoEjercicio rutin = getItem(position);

        //convertview --> visita a reusar, si es nulo se crea
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_tipo_ejercicio,parent,false);
        }

        TextView tvSerie = (TextView)convertView.findViewById(R.id.tv_tipo_ejercicio);
        TextView tvMusculo = (TextView)convertView.findViewById(R.id.tv_tipo_musculo);
        ImageView ivArticulo = (ImageView)convertView.findViewById(R.id.image_tipo);

        if(rutin.getTMusculo().length()==0) {
            tvSerie.setText(String.valueOf(rutin.getTipo()));
            ivArticulo.setImageResource(rutin.getIdFotoRT());
        }
        else{
            tvSerie.setText(String.valueOf(rutin.getTipo()));
            tvMusculo.setText(String.valueOf(rutin.getTMusculo()));
            ivArticulo.setImageResource(rutin.getIdFotoRT());
        }

        return convertView;
    }
}
