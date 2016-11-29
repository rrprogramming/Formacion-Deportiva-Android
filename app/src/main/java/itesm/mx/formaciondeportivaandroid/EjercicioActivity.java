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
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EjercicioActivity extends AppCompatActivity implements  View.OnClickListener{
    private Button btnListo;

    Button btnHome;
    Button btnRutinas;
    Button btnSome;
    Button btnHistoria;
    Button btnperfil;

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
        
        btnListo = (Button) findViewById(R.id.button_guardar);
        btnHome = (Button) findViewById(R.id.button_home);
        btnRutinas = (Button) findViewById(R.id.button_rutinas);
        btnSome = (Button) findViewById(R.id.button_sesion);
       btnHistoria = (Button) findViewById(R.id.button_history);
        btnperfil = (Button) findViewById(R.id.button_perfil);

        tvRutina = (TextView) findViewById(R.id.text_rutina);
        tvnomEjercicio = (TextView) findViewById(R.id.text_nomEjercicio);
        tvMusculo= (TextView) findViewById(R.id.text_musculo);
        tvRepeticiones= (TextView) findViewById(R.id.text_repeticiones);
        tvSeries= (TextView) findViewById(R.id.text_series);
        swTerminado = (Switch) findViewById(R.id.switch_terminado);
        ivEjercicio = (ImageView) findViewById(R.id.image_ejercicio);

        long idRutina = Long.parseLong(getIntent().getStringExtra("ID"));
        dbo=new DBOperations(this);
        dbo.open();

        Rutina rutina = dbo.getRutina(idRutina);
        arrEjercicio=rutina.getEjercicio();
        tvRutina.setText(rutina.getsNombre());
        pos=0;
        mostrarEjercicio();
        dbo.close();

        swTerminado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    dbo.open();
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String sdate = sdf.format(date);
                    Log.i("DATE ",sdate);
                    dbo.editEjercicio(arrEjercicio.get(pos).getId(), sdate);
                    if(pos<(arrEjercicio.size()-1)){
                        pos+=1;
                        mostrarEjercicio();
                    }
                    dbo.close();
                }
            }
        });
        
        btnHome.setOnClickListener(this);
        btnRutinas.setOnClickListener(this);
        btnSome.setOnClickListener(this);
        btnHistoria.setOnClickListener(this);
        btnperfil.setOnClickListener(this);
        btnListo.setOnClickListener(this);
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
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.button_home:
                Intent intent2 = new Intent(this,MainActivity.class);
                intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent2);
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

            case R.id.button_guardar:
                finish();
                break;
        }
    }


}
