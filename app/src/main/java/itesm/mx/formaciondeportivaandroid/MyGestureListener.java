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
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;


public class MyGestureListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    Context context;
    private ArrayList<Ejercicio> arrEjercicio;
    private int pos;
    private TextView tvnomEjercicio;
    private TextView tvMusculo;
    private TextView tvRepeticiones;
    private TextView tvSeries;
    private Switch swTerminado;
    private ImageView ivEjercicio;

    public MyGestureListener(Context context, ArrayList<Ejercicio> ejercicios, int pos, TextView tvnomEjercicio, TextView tvMusculo, TextView tvRepeticiones, TextView tvSeries, Switch swTerminado, ImageView ivEjercicio){
        this.context = context;
        this.arrEjercicio = ejercicios;
        this.pos = pos;
        this.tvnomEjercicio = tvnomEjercicio;
        this.tvMusculo = tvMusculo;
        this.tvRepeticiones = tvRepeticiones;
        this.tvSeries = tvSeries;
        this.swTerminado = swTerminado;
        this.ivEjercicio = ivEjercicio;
    }

    @Override
    public void onShowPress(MotionEvent e){
        Log.d("LISTENER_TAG", "onShowPress");
    }

    @Override
    public void onLongPress(MotionEvent e){
        Log.d("LISTENER_TAG", "onLongPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e){
        Log.d("LISTENER_TAG", "onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
        Log.d("LISTENER_TAG", "onScroll");
        return false;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float volocityY){
        Log.d("LISTENER_TAG", "onFling");

        if(e1.getX()<e2.getX()){
            Log.d("LISTENER_TAG", "onFlingRigth");

            pos--;

            if(pos<0){
                pos = arrEjercicio.size()-1;
            }

        }

        if(e1.getX()>e2.getX()){
            Log.d("LISTENER_TAG", "onFlingLeft");

            pos++;

            if(pos >= arrEjercicio.size()) {
                pos = 0;
            }
        }

        tvnomEjercicio.setText(arrEjercicio.get(pos).getsNombreEjer());
        tvMusculo.setText(arrEjercicio.get(pos).getsMusculo());
        tvRepeticiones.setText("Repeticiones: " + Integer.toString(arrEjercicio.get(pos).getiRepeticiones()));
        tvSeries.setText("Series: " + Integer.toString(arrEjercicio.get(pos).getiSeries()));

        swTerminado.setChecked(false);

        ivEjercicio.setImageResource(arrEjercicio.get(pos).getIdFotoE());

        return true;
    }

    @Override
    public boolean onDown(MotionEvent e){
        Log.d("LISTENER_TAG", "onDown");
        //Toast.makeText(context, "onDown", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e){
        Log.d("LISTENER_TAG", "onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e){
        Log.d("LISTENER_TAG", "onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e){
        Log.d("LISTENER_TAG", "onDoubleTapEvent");
        return false;
    }
}
