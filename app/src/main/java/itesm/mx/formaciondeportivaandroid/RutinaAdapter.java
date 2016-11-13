package itesm.mx.formaciondeportivaandroid;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rolando on 11/13/2016.
 */
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
