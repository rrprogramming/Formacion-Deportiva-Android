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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DescripcionRutinaActivity extends ListActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ArrayList<Ejercicio> listEjerc;
    Rutina rutina;
    EjerciciosAdapter adapterEjercicio;
    private DBOperations dao;
    private long id;
    Button btnRegresaraRutina;
    ListaEjercicios arti;

    Button btnHome;
    Button btnRutinas;
    Button btnSesion;
    Button btnHistoria;
    Button btnPerfil;
    TextView tvNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_rutina);

        dao = new DBOperations(this);
        dao.open();

        id = Long.parseLong(getIntent().getStringExtra("ID"));
        rutina = dao.getRutina(id);
        String sN = rutina.getsNombre();

        listEjerc = rutina.getEjercicio();

        adapterEjercicio = new EjerciciosAdapter(this, listEjerc);
        setListAdapter(adapterEjercicio);
        getListView().setOnItemClickListener(this);

        btnRegresaraRutina = (Button) findViewById(R.id.button_rutinas);
        btnRegresaraRutina.setOnClickListener(this);

        btnHome= (Button) findViewById(R.id.button_home);
        btnRutinas = (Button) findViewById(R.id.button_rutinas);
        btnSesion = (Button) findViewById(R.id.button_sesion);
        btnHistoria = (Button) findViewById(R.id.button_history);
        btnPerfil = (Button) findViewById(R.id.button_perfil);
        tvNombre = (TextView) findViewById(R.id.tv_nomrut);
        tvNombre.setText(sN);

        btnHome.setOnClickListener(this);
        btnRutinas.setOnClickListener(this);
        btnSesion.setOnClickListener(this);
        btnHistoria.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
            case R.id.button_rutinas:
                //intent = new Intent(this, RutinasActivity.class);
                //startActivity(intent);
                break;
            case R.id.button_home:
                intent = new Intent(this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;

            case R.id.button_sesion:
                intent = new Intent(this,SesionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;

            case R.id.button_history:
                intent = new Intent(this,HistorialActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;

            case R.id.button_perfil:
                intent = new Intent(this,PerfilActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public ArrayList<Ejercicio> getDataFotListView() {
        return arti.getLista();
    }

    @Override
    public void onPause(){
        super.onPause();
        dao.close();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        dao.close();
    }
}
