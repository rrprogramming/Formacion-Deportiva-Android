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
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner spGenero;
    Spinner spDia;
    Spinner spAño;
    Spinner spMes;

    Button btnHome;
    Button btnRutinas;
    Button btnSesion;
    Button btnHistoria;
    Button btnPerfil;
    Button btnGuardar;

    ImageView ivFoto;

    EditText etNombre;
    EditText etMatricula;
    EditText etPesoActual;
    EditText etPesoMeta;
    EditText etPesoMaximoPierna;
    EditText etPesoMaximoBrazo;

    Keys keys = new Keys();

    byte[] byteArray;


    @Override
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.button_home:
                intent = new Intent(this,MainActivity.class);
                finishAffinity();
                startActivity(intent);
                break;

            case R.id.button_rutinas:
                intent = new Intent(this,RutinasActivity.class);
                finishAffinity();
                startActivity(intent);
                break;

            case R.id.button_sesion:
                intent = new Intent(this,SesionActivity.class);
                finishAffinity();
                startActivity(intent);
                break;

            case R.id.button_history:
                intent = new Intent(this,HistorialActivity.class);
                finishAffinity();
                startActivity(intent);
                break;

            case R.id.button_perfil:
                intent = new Intent(this,PerfilActivity.class);
                finishAffinity();
                startActivity(intent);
                break;

            case R.id.button_guardar:
                SharedPreferences settings = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString(keys.KEY_NOMBRE, etNombre.getText().toString());
                editor.putString(keys.KEY_MATRICULA, etMatricula.getText().toString());
                editor.putString(keys.KEY_GENERO, spGenero.getSelectedItem().toString());
                editor.putString(keys.KEY_DIA, spDia.getSelectedItem().toString());
                editor.putString(keys.KEY_MES, spMes.getSelectedItem().toString());
                editor.putString(keys.KEY_AÑO, spAño.getSelectedItem().toString());
                editor.putString(keys.KEY_PESO_ACTUAL, etPesoActual.getText().toString());
                editor.putString(keys.KEY_PESO_META, etPesoMeta.getText().toString());
                editor.putString(keys.KEY_PESO_MAXIMO_PIERNA, etPesoMaximoPierna.getText().toString());
                editor.putString(keys.KEY_PESO_MAXIMO_BRAZO, etPesoMaximoBrazo.getText().toString());

                editor.putString(keys.KEY_GENERO_POS, Integer.toString(spGenero.getSelectedItemPosition()));
                editor.putString(keys.KEY_AÑO_POS, Integer.toString(spAño.getSelectedItemPosition()));
                editor.putString(keys.KEY_MES_POS, Integer.toString(spMes.getSelectedItemPosition()));
                editor.putString(keys.KEY_DIA_POS, Integer.toString(spDia.getSelectedItemPosition()));

                /*Gson gson = new Gson();
                String json = gson.toJson(byteArray);
                editor.putString(keys.KEY_IMAGEN,json);*/

                editor.commit();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        spGenero = (Spinner)findViewById(R.id.spinner_genero);
        spDia = (Spinner)findViewById(R.id.spinner_dia);
        spAño = (Spinner)findViewById(R.id.spinner_año);
        spMes = (Spinner)findViewById(R.id.spinner_mes);
        ivFoto = (ImageView)findViewById(R.id.image_perfil);

        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this,R.array.genero,R.layout.support_simple_spinner_dropdown_item);
        spGenero.setAdapter(adapterGenero);

        ArrayAdapter<CharSequence> adapterDia = ArrayAdapter.createFromResource(this,R.array.dia,R.layout.support_simple_spinner_dropdown_item);
        spDia.setAdapter(adapterDia);

        ArrayAdapter<CharSequence> adapterMes = ArrayAdapter.createFromResource(this,R.array.mes,R.layout.support_simple_spinner_dropdown_item);
        spMes.setAdapter(adapterMes);

        ArrayAdapter<CharSequence> adapterAño = ArrayAdapter.createFromResource(this,R.array.año,R.layout.support_simple_spinner_dropdown_item);
        spAño.setAdapter(adapterAño);

        btnHome = (Button) findViewById(R.id.button_home);
        btnRutinas = (Button) findViewById(R.id.button_rutinas);
        btnSesion = (Button) findViewById(R.id.button_sesion);
        btnHistoria = (Button) findViewById(R.id.button_history);
        btnPerfil = (Button) findViewById(R.id.button_perfil);
        btnGuardar = (Button) findViewById(R.id.button_guardar);

        etNombre = (EditText) findViewById(R.id.edit_nombre);
        etMatricula = (EditText) findViewById(R.id.edit_matricula);
        etPesoActual = (EditText) findViewById(R.id.edit_pesoActual);
        etPesoMeta = (EditText) findViewById(R.id.edit_pesoMeta);
        etPesoMaximoPierna = (EditText) findViewById(R.id.edit_pesoMaximoPierna);
        etPesoMaximoBrazo = (EditText) findViewById(R.id.edit_pesoMaximoBrazo);

        btnHome.setOnClickListener(this);
        btnRutinas.setOnClickListener(this);
        btnSesion.setOnClickListener(this);
        btnHistoria.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);

        SharedPreferences settings = getPreferences(MODE_PRIVATE);

        String json = settings.getString(keys.KEY_IMAGEN, "");
        String nombre = settings.getString(keys.KEY_NOMBRE, null);
        String matricula = settings.getString(keys.KEY_MATRICULA, null);
        String pesoActual = settings.getString(keys.KEY_PESO_ACTUAL, null);
        String pesoMeta = settings.getString(keys.KEY_PESO_META, null);
        String pesoMaximoPierna = settings.getString(keys.KEY_PESO_MAXIMO_PIERNA, null);
        String pesoMaximoBrazo = settings.getString(keys.KEY_PESO_MAXIMO_BRAZO, null);

        /*Gson gson = new Gson();
        if(!json.contentEquals("")){
            byteArray = gson.fromJson(json, byte[]);
            Bitmap bmimage = BitmapFactory.decodeByteArray(byteArray,0,image.length);
            ivFoto.setImageBitmap(bmimage);
        }*/

        /*
        spGenero.setSelection(Integer.parseInt(settings.getString(keys.KEY_GENERO_POS, "0")));
        spDia.setSelection(Integer.parseInt(settings.getString(keys.KEY_DIA_POS, "0")));
        spMes.setSelection(Integer.parseInt(settings.getString(keys.KEY_MES_POS, "0")));
        spAño.setSelection(Integer.parseInt(settings.getString(keys.KEY_AÑO_POS, "0")));*/

        etNombre.setText(nombre);
        etMatricula.setText(matricula);
        etPesoActual.setText(pesoActual);
        etPesoMeta.setText(pesoMeta);
        etPesoMaximoPierna.setText(pesoMaximoPierna);
        etPesoMaximoBrazo.setText(pesoMaximoBrazo);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==keys.REQUEST_CODE && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteArray = stream.toByteArray();

            ivFoto.setImageBitmap(bitmap);
        }
    }
}
