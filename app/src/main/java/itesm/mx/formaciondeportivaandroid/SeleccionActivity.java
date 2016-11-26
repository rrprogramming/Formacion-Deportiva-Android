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
                arti = new TipoEjercicio("Pantorrila Parado","Pierna", R.drawable.img_0536);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Predicador","Bícep", R.drawable.dsc_5749);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones Sentado","Trícep", R.drawable.dsc_5751);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.drawable.img_0521);
                listSelec.add(arti);
                arti = new TipoEjercicio("Press Hombro","Hombro", R.drawable.img_6375);
                listSelec.add(arti);
                arti = new TipoEjercicio("Press Pecho","Pecho", R.drawable.img_6388);
                listSelec.add(arti);
                arti = new TipoEjercicio("Crunchs","Abdominales", R.drawable.img_6356);
                listSelec.add(arti);
                arti = new TipoEjercicio("Peck Deck","Pecho", R.drawable.dsc_5800);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Frontal","Espalda", R.drawable.img_0519);
                listSelec.add(arti);
                arti = new TipoEjercicio("Prensa Horizontal","Pierna", R.drawable.img_7132);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión Acostado","Pierna", R.drawable.dsc_5786);
                listSelec.add(arti);
                arti = new TipoEjercicio("Glúteos","Pierna", R.drawable.img_6340);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones","Pierna", R.drawable.dsc_5774);
                listSelec.add(arti);
                arti = new TipoEjercicio("Aductor","Pierna", R.drawable.dsc_5770);
                listSelec.add(arti);
                arti = new TipoEjercicio("Abductor","Pierna", R.drawable.dsc_5767);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión Sentado","Pierna", R.drawable.img_6345);
                listSelec.add(arti);
                break;
            case "Cross Over":
                arti = new TipoEjercicio("Jalón Interno","Trícep", R.drawable.img_0515);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón detrás de Cabeza","Trícep", R.drawable.img_0517);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Alto","Bícep", R.drawable.img_7010);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Alternado","Bícep", R.drawable.img_0575);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl 1 Mano","Bícep", R.drawable.img_0573);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl","Bícep", R.drawable.img_7034);
                listSelec.add(arti);
                arti = new TipoEjercicio("Dominadas","Espalda", R.drawable.dsc_5810);
                listSelec.add(arti);
                arti = new TipoEjercicio("Aperturas","Pecho", R.drawable.dsc_5806);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalon Frontal","Espalda", R.drawable.img_0584);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.drawable.img_0522);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones","Tricep", R.drawable.img_0509);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensión Sobre Cabeza","Tricep", R.drawable.img_0517);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones Invertidos","Tricep", R.drawable.img_0514);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones 1 Mano","Tricep", R.drawable.img_0511);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Lateral","Tricep", R.drawable.img_0514);
                listSelec.add(arti);
                break;
            case "Aparato Libre":
                arti = new TipoEjercicio("Máquina Inclinado","Pecho", R.drawable.img_6382);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina Press de Hombre","Hombro", R.drawable.img_6377);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina Selectiva Lateral","Hombro", R.drawable.img_0540);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Cerrado","Hombro", R.drawable.img_6914);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Predicador","Bícep", R.drawable.img_0525);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina de Apoyo","Abdominales", R.drawable.img_6356);
                listSelec.add(arti);
                arti = new TipoEjercicio("Desplante Mancuerna","Pierna", R.drawable.img_6924);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla","Pierna", R.drawable.img_6918);
                listSelec.add(arti);
                arti = new TipoEjercicio("Peso Muerto","Pierna", R.drawable.img_6940);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla con Mancuerna","Pierna", R.drawable.img_6998);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla con Discos","Pierna", R.drawable.img_0588);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones","Pierna", R.drawable.img_0531);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión 1 Pierna","Pierna", R.drawable.img_0530);
                listSelec.add(arti);
                arti = new TipoEjercicio("Glúteo","Pierna", R.drawable.dsc_5786);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jaula/Sentadilla","Pierna", R.drawable.img_7125);
                listSelec.add(arti);
                arti = new TipoEjercicio("Prensa Inclinada","Pierna", R.drawable.img_7131);
                listSelec.add(arti);
                arti = new TipoEjercicio("Pantorrilla Sentado","Pierna", R.drawable.img_0592);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.drawable.img_6368);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Frontal","Espalda", R.drawable.img_0528);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press","Pecho", R.drawable.img_6906);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press Inclinado","Pecho", R.drawable.img_6873);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press Declinado","Pecho", R.drawable.img_0599);
                listSelec.add(arti);
                break;
            case "Torre Selectiva":
                arti = new TipoEjercicio("Remo a 1 mano","Espalda", R.drawable.img_0507);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Recto","Espalda", R.drawable.img_0500);
                listSelec.add(arti);
                arti = new TipoEjercicio("Rompe Cráneos","Tricep", R.drawable.img_7088);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas con Mancuernas","Tricep", R.drawable.img_7041);
                listSelec.add(arti);
                arti = new TipoEjercicio("Copa de Mancuerna","Tricep", R.drawable.img_7020);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones","Tricep", R.drawable.img_0509);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza","Tricep", R.drawable.img_0517);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza a 1 mano","Tricep", R.drawable.img_0581);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas","Tricep", R.drawable.img_0506);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl","Bicep", R.drawable.img_0583);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl 1 mano","Bicep", R.drawable.img_0574);
                listSelec.add(arti);
                arti = new TipoEjercicio("Hiperextensiones","Espalda", R.drawable.img_6354);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Parado","Hombro", R.drawable.img_0502);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral 1 Mano","Hombro", R.drawable.img_0503);
                listSelec.add(arti);
                arti = new TipoEjercicio("Elevación Frontal 1 Mano","Hombro", R.drawable.img_0580);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral 2 manos","Hombro", R.drawable.img_6946);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral Inclinado","Hombro", R.drawable.img_6973);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Inclinado","Hombro", R.drawable.img_7029);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones 1 Mano","Trícep", R.drawable.img_0511);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujón Lateral","Trícep", R.drawable.img_0514);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujón Interno","Trícep", R.drawable.img_0515);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza","Trícep", R.drawable.img_0517);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza\n1 Mano","Trícep", R.drawable.img_0581);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas","Trícep", R.drawable.img_0506);
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
                //Intent intent = new Intent(this, RutinasActivity.class);
                //startActivity(intent);
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
                ArrayList<Ejercicio> ArrEjercicio = new ArrayList<>();
                ArrEjercicio=rutina.getEjercicio();
                if(ArrEjercicio.size()==0){
                    Toast.makeText(this, "Favor de seleccionar ejercicios antes de guardar una rutina", Toast.LENGTH_SHORT).show();
                }
                else {
                    long id = dao.addRutina(rutina);
                    rutina.setId(id);
                    Toast.makeText(this, "Se ha guardado la rutina "+ rutina.getsNombre(), Toast.LENGTH_SHORT).show();
                    Intent intent7 = new Intent(this, RutinasActivity.class);
                    startActivity(intent7);
                }

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
                if (etSeries.getText().length() == 0 || etRepeticiones.getText().length() == 0){
                    Toast.makeText(getApplication(), "Favor de ingresar Series y Repeticiones"+listEjer.size(), Toast.LENGTH_SHORT).show();
                }
                else{
                    if(etSeries.getText().toString().equals("0") || etRepeticiones.getText().toString().equals("0")){
                        Toast.makeText(getApplication(), "Favor de ingresar Series y Repeticiones", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        listEjer = rutina.getEjercicio();
                        Ejercicio ejer;
                        ejer = new Ejercicio(nombreEjer.getTipo(), sTipo, nombreEjer.getTMusculo(), Integer.parseInt(etSeries.getText().toString()),
                                Integer.parseInt(etRepeticiones.getText().toString()), nombreEjer.getIdFotoRT());
                        listEjer.add(ejer);
                        rutina.setEjercicio(listEjer);
                        Log.i("EJERCICIO", "SE AGREGO EL EJERCICIO");
                    }
                }
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
