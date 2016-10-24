package itesm.mx.formaciondeportivaandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by armando on 23/10/2016.
 */
public class RutinaAdapter extends ArrayAdapter<RutinaT> {
    public RutinaAdapter(Context context, ArrayList<RutinaT> rutina) {
        super(context, 0, rutina);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RutinaT rutin = getItem(position);

        //convertview --> visita a reusar, si es nulo se crea
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.row,parent,false);
        }

        TextView tvSerie = (TextView)convertView.findViewById(R.id.tv_tipo_ejercicio);
        ImageView ivArticulo = (ImageView)convertView.findViewById(R.id.image_tipo);

        tvSerie.setText(String.valueOf(rutin.getsTipo()));
        ivArticulo.setImageResource(rutin.getIdFotoRT());

        return convertView;
    }
}
