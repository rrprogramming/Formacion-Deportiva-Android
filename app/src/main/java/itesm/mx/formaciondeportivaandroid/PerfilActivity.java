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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner genero;
    Spinner dia;
    Spinner año;
    Spinner mes;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button_home:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;

            case R.id.button_rutinas:
                Intent intent2 = new Intent(this,RutinasActivity.class);
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        genero = (Spinner)findViewById(R.id.spinner_genero);
        dia = (Spinner)findViewById(R.id.spinner_dia);
        año = (Spinner)findViewById(R.id.spinner_año);
        mes = (Spinner)findViewById(R.id.spinner_mes);

        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this,R.array.genero,R.layout.support_simple_spinner_dropdown_item);
        genero.setAdapter(adapterGenero);

        ArrayAdapter<CharSequence> adapterDia = ArrayAdapter.createFromResource(this,R.array.dia,R.layout.support_simple_spinner_dropdown_item);
        dia.setAdapter(adapterDia);

        ArrayAdapter<CharSequence> adapterMes = ArrayAdapter.createFromResource(this,R.array.mes,R.layout.support_simple_spinner_dropdown_item);
        mes.setAdapter(adapterMes);

        ArrayAdapter<CharSequence> adapterAño = ArrayAdapter.createFromResource(this,R.array.año,R.layout.support_simple_spinner_dropdown_item);
        año.setAdapter(adapterAño);

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
}
