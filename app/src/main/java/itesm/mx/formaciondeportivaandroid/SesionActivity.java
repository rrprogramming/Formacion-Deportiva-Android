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
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class SesionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_comenzar;
    private Spinner spinnerRutinas;
    private String sRutinas[];

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

    DBOperations dbo;
    ArrayList<Rutina> arrRutina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        btn_comenzar = (Button) findViewById(R.id.btn_comenzar);

        spinnerRutinas = (Spinner) findViewById(R.id.spinner_rutinas);
        dbo=new DBOperations(this);
        dbo.open();
        arrRutina = dbo.getAllRutinas();
        sRutinas = new String[arrRutina.size()];
        for(int i=0; i<arrRutina.size(); i++){
            sRutinas[i]=arrRutina.get(i).getsNombre();
        }

        ArrayAdapter<String> adapterRutina = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sRutinas);
        adapterRutina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRutinas.setAdapter(adapterRutina);
        btn_comenzar.setOnClickListener(this);

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
        switch (v.getId()) {
            case R.id.button_rutinas:
                Intent intent = new Intent(this, RutinasActivity.class);
                startActivity(intent);
                break;
            case R.id.button_home:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;

            case R.id.button_sesion:
                //Intent intent3 = new Intent(this, SesionActivity.class);
                //startActivity(intent3);
                break;

            case R.id.button_history:
                Intent intent4 = new Intent(this, HistorialActivity.class);
                startActivity(intent4);
                break;

            case R.id.button_perfil:
                Intent intent5 = new Intent(this, PerfilActivity.class);
                startActivity(intent5);
                break;

            case R.id.btn_comenzar:
                Intent myIntent6 = new Intent(this, EjercicioActivity.class);
                myIntent6.putExtra("ID", Long.toString(arrRutina.get(spinnerRutinas.getSelectedItemPosition()).getid()));
                Log.i("ID EXTRA", Long.toString(arrRutina.get(spinnerRutinas.getSelectedItemPosition()).getid()));
                startActivity(myIntent6);
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