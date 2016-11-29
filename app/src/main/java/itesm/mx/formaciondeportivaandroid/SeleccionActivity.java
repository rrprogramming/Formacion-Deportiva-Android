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
import android.view.WindowManager;
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
    ArrayList<Ejercicio> listEjer = new ArrayList<>();
    TipoEjercicioAdapter adapterR;
    Rutina rutina;
    
    private DBOperations dao;

    String sTipo;
    
    Button btnRegresarAct;
    Button btnGuardarAct;
    Button btnHome;
    Button btnRutinas;
    Button btnSesion;
    Button btnHistoria;
    Button btnPerfil;
    TextView tvTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        dao = new DBOperations(this);
        dao.open();

        btnRegresarAct = (Button) findViewById(R.id.button_rutinasAct);
        btnGuardarAct = (Button) findViewById(R.id.button_guardarR);
        btnHome = (Button) findViewById(R.id.button_home);
        btnRutinas = (Button) findViewById(R.id.button_rutinas);
        btnSesion = (Button) findViewById(R.id.button_sesion);
        btnHistoria = (Button) findViewById(R.id.button_history);
        btnPerfil = (Button) findViewById(R.id.button_perfil);
        tvTipo = (TextView) findViewById(R.id.text_title);

        ArrayList<TipoEjercicio> arrayListEjercicio;
        sTipo = getIntent().getStringExtra("tipo");
        Gson gson = new Gson();
        rutina = gson.fromJson(getIntent().getStringExtra("json"),Rutina.class);

        arrayListEjercicio = getDataFotListView();

        adapterR = new TipoEjercicioAdapter(this, arrayListEjercicio);
        setListAdapter(adapterR);

        btnHome.setOnClickListener(this);
        btnRutinas.setOnClickListener(this);
        btnSesion.setOnClickListener(this);
        btnHistoria.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
        btnRegresarAct.setOnClickListener(this);
        btnGuardarAct.setOnClickListener(this);

        getListView().setOnItemClickListener(this);

        tvTipo.setText(sTipo);
    }

    public ArrayList<TipoEjercicio> getDataFotListView() {
        TipoEjercicio arti;
        listSelec = new ArrayList<>();
        switch(sTipo){
            case "Maquina Selectiva":
                arti = new TipoEjercicio("Pantorrila Parado","Pierna", R.drawable.img_05360);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Predicador","Bícep", R.drawable.dsc_57490);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones Sentado","Trícep", R.drawable.dsc_57510);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.drawable.img_05210);
                listSelec.add(arti);
                arti = new TipoEjercicio("Press Hombro","Hombro", R.drawable.img_63750);
                listSelec.add(arti);
                arti = new TipoEjercicio("Press Pecho","Pecho", R.drawable.img_63880);
                listSelec.add(arti);
                arti = new TipoEjercicio("Crunchs","Abdominales", R.drawable.img_63560);
                listSelec.add(arti);
                arti = new TipoEjercicio("Peck Deck","Pecho", R.drawable.dsc_58000);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Frontal","Espalda", R.drawable.img_05190);
                listSelec.add(arti);
                arti = new TipoEjercicio("Prensa Horizontal","Pierna", R.drawable.img_71320);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión Acostado","Pierna", R.drawable.dsc_57860);
                listSelec.add(arti);
                arti = new TipoEjercicio("Glúteos","Pierna", R.drawable.img_63400);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones","Pierna", R.drawable.dsc_57740);
                listSelec.add(arti);
                arti = new TipoEjercicio("Aductor","Pierna", R.drawable.dsc_57700);
                listSelec.add(arti);
                arti = new TipoEjercicio("Abductor","Pierna", R.drawable.dsc_57670);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión Sentado","Pierna", R.drawable.img_63450);
                listSelec.add(arti);
                break;
            case "Cross Over":
                arti = new TipoEjercicio("Jalón Interno","Trícep", R.drawable.img_05150);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón detrás de Cabeza","Trícep", R.drawable.img_05170);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Alto","Bícep", R.drawable.img_70100);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Alternado","Bícep", R.drawable.img_05750);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl 1 Mano","Bícep", R.drawable.img_05730);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl","Bícep", R.drawable.img_70340);
                listSelec.add(arti);
                arti = new TipoEjercicio("Dominadas","Espalda", R.drawable.dsc_58100);
                listSelec.add(arti);
                arti = new TipoEjercicio("Aperturas","Pecho", R.drawable.dsc_58060);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalon Frontal","Espalda", R.drawable.img_05840);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.drawable.img_05220);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones","Tricep", R.drawable.img_05090);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensión Sobre Cabeza","Tricep", R.drawable.img_05170);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones Invertidos","Tricep", R.drawable.img_05140);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones 1 Mano","Tricep", R.drawable.img_05110);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Lateral","Tricep", R.drawable.img_05140);
                listSelec.add(arti);
                break;
            case "Aparato Libre":
                arti = new TipoEjercicio("Máquina Inclinado","Pecho", R.drawable.img_63820);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina Press de Hombre","Hombro", R.drawable.img_63770);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina Selectiva Lateral","Hombro", R.drawable.img_05400);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Cerrado","Hombro", R.drawable.img_69140);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl Predicador","Bícep", R.drawable.img_05250);
                listSelec.add(arti);
                arti = new TipoEjercicio("Máquina de Apoyo","Abdominales", R.drawable.img_63560);
                listSelec.add(arti);
                arti = new TipoEjercicio("Desplante Mancuerna","Pierna", R.drawable.img_69240);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla","Pierna", R.drawable.img_69180);
                listSelec.add(arti);
                arti = new TipoEjercicio("Peso Muerto","Pierna", R.drawable.img_69400);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla con Mancuerna","Pierna", R.drawable.img_69980);
                listSelec.add(arti);
                arti = new TipoEjercicio("Sentadilla con Discos","Pierna", R.drawable.img_05880);
                listSelec.add(arti);
                arti = new TipoEjercicio("Extensiones","Pierna", R.drawable.img_05310);
                listSelec.add(arti);
                arti = new TipoEjercicio("Flexión 1 Pierna","Pierna", R.drawable.img_05300);
                listSelec.add(arti);
                arti = new TipoEjercicio("Glúteo","Pierna", R.drawable.dsc_57860);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jaula/Sentadilla","Pierna", R.drawable.img_71250);
                listSelec.add(arti);
                arti = new TipoEjercicio("Prensa Inclinada","Pierna", R.drawable.img_71310);
                listSelec.add(arti);
                arti = new TipoEjercicio("Pantorrilla Sentado","Pierna", R.drawable.img_05920);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Sentado","Espalda", R.drawable.img_63680);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Frontal","Espalda", R.drawable.img_05280);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press","Pecho", R.drawable.img_69060);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press Inclinado","Pecho", R.drawable.img_68730);
                listSelec.add(arti);
                arti = new TipoEjercicio("Bench Press Declinado","Pecho", R.drawable.img_05990);
                listSelec.add(arti);
                break;
            case "Torre Selectiva":
                arti = new TipoEjercicio("Remo a 1 mano","Espalda", R.drawable.img_05070);
                listSelec.add(arti);
                arti = new TipoEjercicio("Jalón Recto","Espalda", R.drawable.img_05000);
                listSelec.add(arti);
                arti = new TipoEjercicio("Rompe Cráneos","Tricep", R.drawable.img_70880);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas con Mancuernas","Tricep", R.drawable.img_70410);
                listSelec.add(arti);
                arti = new TipoEjercicio("Copa de Mancuerna","Tricep", R.drawable.img_70200);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones","Tricep", R.drawable.img_05090);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza","Tricep", R.drawable.img_05170);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza a 1 mano","Tricep", R.drawable.img_05810);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas","Tricep", R.drawable.img_05060);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl","Bicep", R.drawable.img_05830);
                listSelec.add(arti);
                arti = new TipoEjercicio("Curl 1 mano","Bicep", R.drawable.img_05740);
                listSelec.add(arti);
                arti = new TipoEjercicio("Hiperextensiones","Espalda", R.drawable.img_63540);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Parado","Hombro", R.drawable.img_05020);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral 1 Mano","Hombro", R.drawable.img_05030);
                listSelec.add(arti);
                arti = new TipoEjercicio("Elevación Frontal 1 Mano","Hombro", R.drawable.img_05800);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral 2 manos","Hombro", R.drawable.img_69460);
                listSelec.add(arti);
                arti = new TipoEjercicio("Lateral Inclinado","Hombro", R.drawable.img_69730);
                listSelec.add(arti);
                arti = new TipoEjercicio("Remo Inclinado","Hombro", R.drawable.img_70290);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones 1 Mano","Trícep", R.drawable.img_05110);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujón Lateral","Trícep", R.drawable.img_05140);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujón Interno","Trícep", R.drawable.img_05150);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza","Trícep", R.drawable.img_05170);
                listSelec.add(arti);
                arti = new TipoEjercicio("Empujones sobre Cabeza\n1 Mano","Trícep", R.drawable.img_05810);
                listSelec.add(arti);
                arti = new TipoEjercicio("Patadas","Trícep", R.drawable.img_05060);
                listSelec.add(arti);
                break;
        }


        return listSelec;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_home:
                Intent intent2 = new Intent(this,MainActivity.class);
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

            case R.id.button_rutinasAct:
                Gson gson = new Gson();
                String json = gson.toJson(rutina);
                Intent intentjson = new Intent();
                intentjson.putExtra("json",json);
                setResult(TiposRutinaActivity.RESULT_OK,intentjson);
                finish();
                break;

            case R.id.button_guardarR:
                ArrayList<Ejercicio> ArrEjercicio;
                ArrEjercicio=rutina.getEjercicio();
                if(ArrEjercicio.size()==0){
                    Toast.makeText(this, "Favor de seleccionar ejercicios antes de guardar una rutina", Toast.LENGTH_SHORT).show();
                }
                else {
                    long id = dao.addRutina(rutina);
                    rutina.setId(id);
                    Toast.makeText(this, "Se ha guardado la rutina "+ rutina.getsNombre(), Toast.LENGTH_SHORT).show();
                    Intent intent7 = new Intent(this, RutinasActivity.class);
                    intent7.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent7);
                }

                break;
        }
    }

    @Override
    public void onBackPressed() {
        Gson gson = new Gson();
        String json = gson.toJson(rutina);
        Intent intentjson = new Intent();
        intentjson.putExtra("json",json);
        setResult(TiposRutinaActivity.RESULT_OK,intentjson);
        finish();
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
                    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                }
                else{
                    if(etSeries.getText().toString().equals("0") || etRepeticiones.getText().toString().equals("0")) {
                        Toast.makeText(getApplication(), "Favor de ingresar Series y Repeticiones", Toast.LENGTH_SHORT).show();
                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                    }
                    else{
                        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
