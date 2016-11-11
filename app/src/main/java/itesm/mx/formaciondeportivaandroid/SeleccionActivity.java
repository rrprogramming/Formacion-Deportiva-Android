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
import android.widget.Toast;

import java.util.ArrayList;

public class SeleccionActivity extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    ArrayList<TipoEjercicio> listSelec;
    RutinaAdapter adapterR;
    private Button btnRegresarAct;
    private Button btnGuardarAct;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        btnRegresarAct = (Button) findViewById(R.id.button_rutinasAct);
        btnGuardarAct = (Button) findViewById(R.id.button_guardarR);
        ArrayList<TipoEjercicio> arrayListEjercicio;

        arrayListEjercicio = getDataFotListView();

        adapterR = new RutinaAdapter(this, arrayListEjercicio);
        setListAdapter(adapterR);
        btnRegresarAct.setOnClickListener(this);
        btnGuardarAct.setOnClickListener(this);

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

    public ArrayList<TipoEjercicio> getDataFotListView() {
        TipoEjercicio arti;

        listSelec = new ArrayList<TipoEjercicio>();
        arti = new TipoEjercicio("Dominadas\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new TipoEjercicio("Aperturas\nPecho", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new TipoEjercicio("Jalon Frontal\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new TipoEjercicio("Remo Sentado\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new TipoEjercicio("Empujones\nTriceps", R.mipmap.ic_launcher);
        listSelec.add(arti);


        return listSelec;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
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

            case R.id.button_rutinasAct:
                Toast.makeText(this, "Regreso a la Rutina 1", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this, TiposRutinaActivity.class);
                startActivity(intent6);
                break;

            case R.id.button_guardarR:
                Toast.makeText(this, "Se ha guardado la Rutina 1", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(this, RutinasActivity.class);
                startActivity(intent7);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
