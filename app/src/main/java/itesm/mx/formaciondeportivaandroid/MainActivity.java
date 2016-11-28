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
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;
    Button horario;
    Button reglamento;
    Button informacion;
    @Override
    public void onClick(View v){
        switch (v.getId()){

            case R.id.button_rutinas:
                Intent intent2 = new Intent(this,RutinasActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
                break;

            case R.id.button_sesion:
                Intent intent3 = new Intent(this,SesionActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
                break;

            case R.id.button_history:
                Intent intent4 = new Intent(this,HistorialActivity.class);
                intent4.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent4);
                break;

            case R.id.button_perfil:
                Intent intent5 = new Intent(this,PerfilActivity.class);
                intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent5);
                break;

            case R.id.button_reglamento:
                Intent intent6 = new Intent(this,ReglamentoActivity.class);
                intent6.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent6);
                break;

            case R.id.button_horario:
                Intent intent7 = new Intent(this,HorarioActivity.class);
                intent7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent7);
                break;
            case R.id.button_informacion:
                Intent intentinf = new Intent(this,InformacionActivity.class);
                intentinf.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intentinf);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView ivLogo = (ImageView) findViewById(R.id.iv_logo);
        ImageView ivGimnasio = (ImageView) findViewById(R.id.iv_gimnasio);
        ivLogo.setImageResource(R.drawable.logo_deportes);
        ivGimnasio.setImageResource(R.drawable.img_gym);

        home = (Button) findViewById(R.id.button_home);
        rutinas = (Button) findViewById(R.id.button_rutinas);
        sesion = (Button) findViewById(R.id.button_sesion);
        historia = (Button) findViewById(R.id.button_history);
        perfil = (Button) findViewById(R.id.button_perfil);
        horario = (Button) findViewById(R.id.button_horario);
        reglamento = (Button) findViewById(R.id.button_reglamento);
        informacion = (Button) findViewById(R.id.button_informacion);

        home.setOnClickListener(this);
        rutinas.setOnClickListener(this);
        sesion.setOnClickListener(this);
        historia.setOnClickListener(this);
        perfil.setOnClickListener(this);
        horario.setOnClickListener(this);
        reglamento.setOnClickListener(this);
        informacion.setOnClickListener(this);

    }
}