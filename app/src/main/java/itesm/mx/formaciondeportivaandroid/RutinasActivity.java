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
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class RutinasActivity extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    private Button btnAgregar;
    final String KEY_NOMBRE = "nombre";
    private DBOperations dao;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;
    Rutina r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);
        dao = new DBOperations(this);
        dao.open();
        ArrayList<Rutina> arrayListRutina;
        arrayListRutina=dao.getAllRutinas();

        btnAgregar = (Button) findViewById(R.id.button_crear_rutina);

        RutinaAdapter rutinaAdapter = new RutinaAdapter(this,arrayListRutina);
        setListAdapter(rutinaAdapter);
        getListView().setOnItemClickListener(this);
        getListView().setOnItemLongClickListener(this);

        btnAgregar.setOnClickListener(this);

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

        switch (v.getId()){
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

            case R.id.button_crear_rutina:

                AlertDialog.Builder dialogorutina = new AlertDialog.Builder(this);
                final EditText etCrearRutina = new EditText(this);
                final EditText etContrasena = new EditText(this);

                LinearLayout lila= new LinearLayout(this);
                lila.setOrientation(LinearLayout.VERTICAL);

                dialogorutina.setTitle("Favor de ir con su instructor para crear una rutina");
                etCrearRutina.setHint("Nombre de la rutina");
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                etCrearRutina.setInputType(InputType.TYPE_CLASS_TEXT);
                etContrasena.setHint("Contrasena");
                etContrasena.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

                lila.addView(etContrasena);
                lila.addView(etCrearRutina);

                dialogorutina.setView(lila);
                dialogorutina.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(etContrasena.getText().length()==0 || etCrearRutina.getText().length()==0) {
                            Toast.makeText(getApplication(), "Favor de completar todos los campos de texto", Toast.LENGTH_SHORT).show();
                            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                        }
                        else{
                            if(etContrasena.getText().toString().equals("gymsport")) {
                                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                                Intent intent6 = new Intent(getApplicationContext(), TiposRutinaActivity.class);
                                intent6.putExtra(KEY_NOMBRE, etCrearRutina.getText().toString());
                                startActivity(intent6);
                            }
                            else{
                                getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
                                Toast.makeText(getApplication(), "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
                dialogorutina.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialogorutina.show();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Rutina rutina = (Rutina)parent.getItemAtPosition(position);
        Toast.makeText(this, "Se selecciono una rutina", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DescripcionRutinaActivity.class);
        intent.putExtra("ID", Long.toString(rutina.getid()));
        Log.i("ID EXTRA", Long.toString(rutina.getid()));
        startActivity(intent);
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        final Rutina rutina = (Rutina)parent.getItemAtPosition(position);
        new AlertDialog.Builder(this)
                .setTitle("Eliminar rutina")
                .setMessage("¿Deseas eliminar permanentemente esta rutina?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        long id = rutina.getid();
                        boolean result = dao.deleteRutina(id);

                        if(result){
                            Toast.makeText(getApplicationContext(), "Operación Exitosa", Toast.LENGTH_SHORT).show();
                            Intent intent5 = new Intent(getApplicationContext(),RutinasActivity.class);
                            intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent5);
                        }else {
                            Toast.makeText(getApplicationContext(), "La rutina no existe", Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
                return true;
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
