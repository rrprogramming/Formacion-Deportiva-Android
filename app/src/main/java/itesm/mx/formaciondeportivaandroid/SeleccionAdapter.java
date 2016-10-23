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
public class SeleccionAdapter extends ArrayAdapter<Ejercicio> {
    public SeleccionAdapter(Context context, ArrayList<Ejercicio> ejercicio) {
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
        ImageView ivArticulo = (ImageView)convertView.findViewById(R.id.image_ejercicio);

        tvEjercicio.setText(String.valueOf(ejer.getsNombreEjer()));
        ivArticulo.setImageResource(ejer.getIdFotoE());

        return convertView;
    }

}
