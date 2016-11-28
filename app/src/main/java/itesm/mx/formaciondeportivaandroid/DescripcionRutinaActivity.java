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
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DescripcionRutinaActivity extends ListActivity implements View.OnClickListener {

    ArrayList<Ejercicio> listEjerc;
    Rutina rutina;
    EjerciciosAdapter adapterEjercicio;

    private DBOperations dao;
    private long iId;

    Button btnRegresaraRutina;
    Button btnHome;
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

        iId = Long.parseLong(getIntent().getStringExtra("ID"));
        rutina = dao.getRutina(iId);
        String sN = rutina.getsNombre();

        listEjerc = rutina.getEjercicio();

        adapterEjercicio = new EjerciciosAdapter(this, listEjerc);
        setListAdapter(adapterEjercicio);

        btnRegresaraRutina = (Button) findViewById(R.id.button_rutinas);
        btnHome= (Button) findViewById(R.id.button_home);
        btnSesion = (Button) findViewById(R.id.button_sesion);
        btnHistoria = (Button) findViewById(R.id.button_history);
        btnPerfil = (Button) findViewById(R.id.button_perfil);
        tvNombre = (TextView) findViewById(R.id.text_rutina);
        tvNombre.setText(sN);

        btnHome.setOnClickListener(this);
        btnRegresaraRutina.setOnClickListener(this);
        btnSesion.setOnClickListener(this);
        btnHistoria.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
        btnRegresaraRutina.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()){
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

            case R.id.button_rutinas:
                finish();
                break;
        }
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
