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
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class HistorialActivity extends AppCompatActivity implements View.OnClickListener {

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;
    Button enviar;
    DatePicker dp_inicio;
    DatePicker dp_fin;
    DBOperations dbo;


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
                Intent intent3 = new Intent(this,SesionActivity.class);
                startActivity(intent3);
                break;

            case R.id.button_history:
                Intent intent4 = new Intent(this,HistorialActivity.class);
                startActivity(intent4);
                break;

            case R.id.button_perfil:
                Intent intent5 = new Intent(this,PerfilActivity.class);
                startActivity(intent5);
                break;

            case R.id.btn_historial:
                GregorianCalendar cal1=new GregorianCalendar(dp_inicio.getYear(),
                        dp_inicio.getMonth(),dp_inicio.getDayOfMonth());
                Date begin=cal1.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
                String fechaInicio = sdf.format(begin);
                GregorianCalendar cal2=new GregorianCalendar(dp_fin.getYear(),
                        dp_fin.getMonth(),dp_fin.getDayOfMonth());
                Date end=cal2.getTime();
                String fechaFin = sdf.format(begin);


                dbo=new DBOperations(this);
                dbo.open();
                dbo.getHistorial(fechaInicio, fechaFin);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        home = (Button) findViewById(R.id.button_home);
        rutinas = (Button) findViewById(R.id.button_rutinas);
        sesion = (Button) findViewById(R.id.button_sesion);
        historia = (Button) findViewById(R.id.button_history);
        perfil = (Button) findViewById(R.id.button_perfil);
        enviar = (Button) findViewById(R.id.btn_historial);


        home.setOnClickListener(this);
        rutinas.setOnClickListener(this);
        sesion.setOnClickListener(this);
        historia.setOnClickListener(this);
        perfil.setOnClickListener(this);

        dp_inicio = (DatePicker) findViewById(R.id.dp_fechain);
        dp_fin = (DatePicker) findViewById(R.id.fp_fechafin);
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
