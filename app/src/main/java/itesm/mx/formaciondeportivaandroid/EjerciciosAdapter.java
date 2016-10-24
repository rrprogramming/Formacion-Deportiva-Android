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

public class EjerciciosAdapter extends ArrayAdapter<Ejercicio> {
    public EjerciciosAdapter(Context context, ArrayList<Ejercicio> ejercicio) {
        super(context, 0, ejercicio);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ejercicio ejer = getItem(position);

        //convertview --> visita a reusar, si es nulo se crea
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_descripcion,parent,false);
        }

        TextView tvEjercicio = (TextView)convertView.findViewById(R.id.tv_ejercicio);
        TextView tvSerie = (TextView)convertView.findViewById(R.id.tv_series);
        TextView tvRepeticiones = (TextView)convertView.findViewById(R.id.tv_repeticiones);
        ImageView ivArticulo = (ImageView)convertView.findViewById(R.id.image_ejercicio);

        tvEjercicio.setText(String.valueOf(ejer.getsNombreEjer()));
        tvSerie.setText(String.valueOf(ejer.getiSeries()));
        tvRepeticiones.setText(String.valueOf(ejer.getiRepeticiones()));
        ivArticulo.setImageResource(ejer.getIdFotoE());

        return convertView;
    }
}
