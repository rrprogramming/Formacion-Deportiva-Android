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
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RutinaAdapter extends ArrayAdapter<Rutina> {

    public RutinaAdapter(Context context, ArrayList<Rutina> rutina) {
        super(context, 0, rutina);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Rutina rutina = getItem(position);

        //convertview --> visita a reusar, si es nulo se crea
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row_rutina,parent,false);
        }

        TextView tvNombre = (TextView)convertView.findViewById(R.id.text_nombre);
        TextView tvId = (TextView)convertView.findViewById(R.id.text_id);

        tvNombre.setText(rutina.getsNombre());
        tvId.setText(Long.toString(rutina.getid()));

        return convertView;
    }
}
