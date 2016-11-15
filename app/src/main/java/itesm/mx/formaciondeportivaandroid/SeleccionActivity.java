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

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class SeleccionActivity extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    ArrayList<TipoEjercicio> listSelec;
    ArrayList<Ejercicio> listEjer = new ArrayList<Ejercicio>();
    TipoEjercicioAdapter adapterR;
    Rutina rutina;
    private Button btnRegresarAct;
    private Button btnGuardarAct;
    private DBOperations dao;

    String sTipo;
    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;
    TextView tvTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        dao = new DBOperations(this);
        dao.open();
        btnRegresarAct = (Button) findViewById(R.id.button_rutinasAct);
        btnGuardarAct = (Button) findViewById(R.id.button_guardarR);
        ArrayList<TipoEjercicio> arrayListEjercicio;
        sTipo=getIntent().getStringExtra("tipo");
        Gson gson = new Gson();
        rutina = gson.fromJson(getIntent().getStringExtra("json"),Rutina.class);
        //rutina = new Rutina(getIntent().getStringExtra("nombre"), listEjer, R.mipmap.ic_launcher);

        arrayListEjercicio = getDataFotListView();
        //getIntent().getArra

        adapterR = new TipoEjercicioAdapter(this, arrayListEjercicio);
        setListAdapter(adapterR);
        btnRegresarAct.setOnClickListener(this);
        btnGuardarAct.setOnClickListener(this);

        getListView().setOnItemClickListener(this);

        home = (Button) findViewById(R.id.button_home);
        rutinas = (Button) findViewById(R.id.button_rutinas);
        sesion = (Button) findViewById(R.id.button_sesion);
        historia = (Button) findViewById(R.id.button_history);
        perfil = (Button) findViewById(R.id.button_perfil);
        tvTipo = (TextView) findViewById(R.id.text_title);

        home.setOnClickListener(this);
        rutinas.setOnClickListener(this);
        sesion.setOnClickListener(this);
        historia.setOnClickListener(this);
        perfil.setOnClickListener(this);

        tvTipo.setText(sTipo);
    }

    public ArrayList<TipoEjercicio> getDataFotListView() {
        TipoEjercicio arti;
        listSelec = new ArrayList<TipoEjercicio>();
        switch(sTipo){
            case "Maquina Selectiva":
                arti = new TipoEjercicio("Pantorrila Parado","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Predicador","Bícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones Sentado","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Press Hombro","Pecho", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Press Pecho","Pecho", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Crunchs","Abdominales", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Peck Deck","Pecho", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Frontal","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Prensa Horizontal","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión Acostado","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Glúteos","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Aductor","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Abductor","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión Sentado","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                break;
            case "Cross Over":
                arti = new TipoEjercicio("Jalón Interno","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón detrás de Cabeza","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Alto","Bícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Alternado","Bícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl 1 Mano","Bícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl","Bícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Dominadas","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Aperturas","Pecho", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalon Frontal","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensión Sobre Cabeza","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones Invertidos","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones 1 Mano","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Lateral","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                break;
            case "Aparato Libre":
                arti = new TipoEjercicio("Máquina Inclinado","Pecho", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina Press de Hombre","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina Selectiva Lateral","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Cerrado","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Predicador","Bícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina de Apoyo","Abdominales", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Desplante Mancuerna","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Peso Muerto","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla con Mancuerna","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla con Discos","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión 1 Pierna","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Glúteo","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jaula/Sentadilla","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Prensa Inclinada","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Pantorrilla Sentado","Pierna", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Frontal","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press","Pecho", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press Inclinado","Pecho", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press Declinado","Pecho", R.mipmap.ic_launcher);
                listSelec.add(arti);
                break;
            case "Torre Selectiva":
                arti = new TipoEjercicio("Remo a 1 mano","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Recto","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Rompe Cráneos","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas con Mancuernas","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Copa de Mancuerna","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza a 1 mano","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas","Tricep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl","Bicep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl 1 mano","Bicep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Hiperextensiones","Espalda", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Parado","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral 1 Mano","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Elevación Frontal 1 Mano","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral 2 manos","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral Inclinado","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Inclinado","Hombro", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones 1 Mano","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujón Lateral","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujón Interno","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza\n1 Mano","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas","Trícep", R.mipmap.ic_launcher);
                listSelec.add(arti);
                break;
        }

        /*arti = new TipoEjercicio("Dominadas\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new TipoEjercicio("Aperturas\nPecho", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new TipoEjercicio("Jalon Frontal\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new TipoEjercicio("Remo Sentado\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new TipoEjercicio("Empujones\nTriceps", R.mipmap.ic_launcher);
        listSelec.add(arti);*/


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
                Gson gson = new Gson();
                String json = gson.toJson(rutina);
                Intent intentjson = new Intent();
                intentjson.putExtra("json",json);
                setResult(TiposRutinaActivity.RESULT_OK,intentjson);
                //Toast.makeText(this, "Regreso a la Rutina 1", Toast.LENGTH_SHORT).show();
                finish();
                //Intent intent6 = new Intent(this, TiposRutinaActivity.class);
                //startActivity(intent6);
                break;

            case R.id.button_guardarR:
                //rutina = new Rutina(getIntent().getStringExtra("nombre"), listEjer, R.mipmap.ic_launcher);
                long id = dao.addRutina(rutina);
                rutina.setId(id);
                Toast.makeText(this, "Se ha guardado la Rutina 1 "+listEjer.size(), Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(this, RutinasActivity.class);
                startActivity(intent7);

                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        final TipoEjercicio nombreEjer = (TipoEjercicio) parent.getItemAtPosition(position);
        AlertDialog.Builder dialogoSeRep = new AlertDialog.Builder(this);

        final EditText etSeries = new EditText(this);
        final EditText etRepeticiones = new EditText(this);

        dialogoSeRep.setTitle("Ingresa el número de series y repeticiones");

        LinearLayout lila= new LinearLayout(this);
        lila.setOrientation(LinearLayout.VERTICAL);

        etSeries.setHint("Número de series");
        etSeries.setInputType(InputType.TYPE_CLASS_NUMBER);
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        //imm.showSoftInput(etSeries, InputMethodManager.SHOW_IMPLICIT);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        etRepeticiones.setHint("Número de repeticiones");
        etRepeticiones.setInputType(InputType.TYPE_CLASS_NUMBER);

        lila.addView(etSeries);
        lila.addView(etRepeticiones);

        dialogoSeRep.setView(lila);
        dialogoSeRep.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //rutina.setEjercicio();
                listEjer = rutina.getEjercicio();
                Ejercicio ejer;
                ejer = new Ejercicio(nombreEjer.getTipo(),sTipo,nombreEjer.getTMusculo(),Integer.parseInt(etSeries.getText().toString()),
                        Integer.parseInt(etRepeticiones.getText().toString()),R.mipmap.ic_launcher);
                listEjer.add(ejer);
                rutina.setEjercicio(listEjer);

                Log.i("EJERCICIO", "SE AGREGO EL EJERCICIO");
            }
        });
        dialogoSeRep.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogoSeRep.show();
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
