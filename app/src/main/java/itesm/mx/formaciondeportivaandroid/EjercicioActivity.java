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

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EjercicioActivity extends AppCompatActivity implements  View.OnClickListener{
    private Button btn_listo;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

    TextView tvRutina;
    TextView tvnomEjercicio;
    TextView tvMusculo;
    TextView tvRepeticiones;
    TextView tvSeries;
    Switch swTerminado;
    ImageView ivEjercicio;
    DBOperations dbo;

    private int pos;
    private ArrayList<Ejercicio> arrEjercicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio);
        btn_listo = (Button) findViewById(R.id.btn_listo);
        btn_listo.setOnClickListener(this);

        home = (Button) findViewById(R.id.button_home);
        rutinas = (Button) findViewById(R.id.button_rutinas);
        sesion = (Button) findViewById(R.id.button_sesion);
        historia = (Button) findViewById(R.id.button_history);
        perfil = (Button) findViewById(R.id.button_perfil);

        home.setOnClickListener(this);
        rutinas.setOnClickListener(this);
        sesion.setOnClickListener(this);
        historia.setOnClickListener(this);
        perfil.setOnClickListener(this);

        tvRutina = (TextView) findViewById(R.id.tvrutina);
        tvnomEjercicio = (TextView) findViewById(R.id.tv_nomEjercicio);
        tvMusculo= (TextView) findViewById(R.id.tv_musculo);
        tvRepeticiones= (TextView) findViewById(R.id.tv_repeticiones);
        tvSeries= (TextView) findViewById(R.id.tv_series);
        swTerminado = (Switch) findViewById(R.id.sw_terminado);
        ivEjercicio = (ImageView) findViewById(R.id.iv_ejercicio);

        long idRutina = Long.parseLong(getIntent().getStringExtra("ID"));

        Log.i("ID EXTRA", Long.toString(idRutina));
        dbo=new DBOperations(this);
        dbo.open();

        Rutina rutina = dbo.getRutina(idRutina);
        arrEjercicio=rutina.getEjercicio();
        tvRutina.setText(rutina.getsNombre());
        pos=0;
        mostrarEjercicio();

        swTerminado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                    String sdate = sdf.format(date);
                    dbo.editEjercicio(arrEjercicio.get(pos).getId(), sdate);
                    if(pos<(arrEjercicio.size()-1)){
                        pos+=1;
                        mostrarEjercicio();
                    }
                }
            }
        });
    }

    public void mostrarEjercicio(){
        tvnomEjercicio.setText(arrEjercicio.get(pos).getsNombreEjer());
        tvMusculo.setText(arrEjercicio.get(pos).getsMusculo());
        tvRepeticiones.setText("Repeticiones: " + Integer.toString(arrEjercicio.get(pos).getiRepeticiones()));
        tvSeries.setText("Series: " + Integer.toString(arrEjercicio.get(pos).getiSeries()));
        swTerminado.setChecked(false);
        ivEjercicio.setImageResource(arrEjercicio.get(pos).getIdFotoE());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_rutinas:
                Intent intent = new Intent(this, RutinasActivity.class);
                startActivity(intent);
                break;
            case R.id.button_home:
                Intent intent2 = new Intent(this,MainActivity.class);
                startActivity(intent2);
                break;

            case R.id.button_sesion:
                //Intent intent3 = new Intent(this,SesionActivity.class);
                //startActivity(intent3);
                break;

            case R.id.button_history:
                Intent intent4 = new Intent(this,HistorialActivity.class);
                startActivity(intent4);
                break;

            case R.id.button_perfil:
                Intent intent5 = new Intent(this,PerfilActivity.class);
                startActivity(intent5);
                break;

            case R.id.btn_listo:
                finish();
                break;
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        dbo.close();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        dbo.close();
    }
}
