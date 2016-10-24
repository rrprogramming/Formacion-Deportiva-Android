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

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.ArrayList;

public class DescripcionRutinaActivity extends ListActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ArrayList<Ejercicio> listEjerc;
    EjerciciosAdapter adapterEjercicio;
    Button btnRegresaraRutina;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_rutina);
        btnRegresaraRutina = (Button) findViewById(R.id.button_rutinas);

        getListView().setOnItemClickListener(this);

        ArrayList<Ejercicio> arrayListEjercicio;

        arrayListEjercicio = getDataFotListView();

        adapterEjercicio = new EjerciciosAdapter(this, arrayListEjercicio);
        setListAdapter(adapterEjercicio);

        btnRegresaraRutina.setOnClickListener(this);
        getListView().setOnItemClickListener(this);

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
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public ArrayList<Ejercicio> getDataFotListView() {
        Ejercicio arti;

        listEjerc = new ArrayList<Ejercicio>();
        arti = new Ejercicio ("Aperturas \n Pecho", 3,10,R.mipmap.ic_launcher);
        listEjerc.add(arti);
        arti = new Ejercicio ("Jalon Frontal\n Espalda",4,12, R.mipmap.ic_launcher);
        listEjerc.add(arti);
        arti = new Ejercicio ("Dominadas \n Espalda",4,10, R.mipmap.ic_launcher);
        listEjerc.add(arti);


        return listEjerc;
    }
}
