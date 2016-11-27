package itesm.mx.formaciondeportivaandroid;

/*
* Copyright (c) 2016, Instituto TecnolÃ³gico y de Estudios Superiores de Monterrey, MÃ©xico. Derechos reservados.
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

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {

    DBOperations dbOperations;

    long id = -1;

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
    Button btnTomarFoto;

    ImageView ivFoto;

    EditText etNombre;
    EditText etMatricula;
    EditText etPesoActual;
    EditText etPesoMeta;
    EditText etPesoMaximoPierna;
    EditText etPesoMaximoBrazo;
    EditText etGrupoMuscular;
    EditText etPeso;
    EditText etRepeticion;
    EditText etPorcentaje;

    Keys keys = new Keys();

    Bitmap bitmap;

    byte[] byteArray;

    public void setData(){
        Perfil perfil;

        perfil = dbOperations.getPerfil(id);

        if(perfil.getGenero().equalsIgnoreCase("Masculino")){
            spGenero.setSelection(1);
        }else if(perfil.getGenero().equalsIgnoreCase("Femenino")){
            spGenero.setSelection(2);
        }else {
            spGenero.setSelection(3);
        }
        spDia.setSelection(Integer.parseInt(perfil.getDiaNaciemiento()));
        spAño.setSelection(Integer.parseInt(perfil.getAnoNaciemiento()));
        spMes.setSelection(Integer.parseInt(perfil.getMesNaciemiento()));
        etGrupoMuscular.setText(perfil.getGrupoMuscular());
        etPeso.setText(perfil.getPeso());
        etRepeticion.setText(perfil.getRepeticion());
        etPorcentaje.setText(perfil.getPorcentaje());
        etNombre.setText(perfil.getNombre());
        etMatricula.setText(perfil.getMatricula());
        etPesoActual.setText(perfil.getPesoActual());
        etPesoMeta.setText(perfil.getPesoMeta());
        etPesoMaximoPierna.setText(perfil.getPesoMaximoPierna());
        etPesoMaximoBrazo.setText(perfil.getPesoMaximoBrazo());


        ivFoto = (ImageView)findViewById(R.id.image_perfil);
    }


    @Override
    public void onClick(View v){
        Intent intent;
        switch (v.getId()){
            case R.id.button_home:
                intent = new Intent(this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;

            case R.id.button_rutinas:
                intent = new Intent(this,RutinasActivity.class);
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
                //intent = new Intent(this,PerfilActivity.class);
                //finishAffinity();
                //startActivity(intent);
                break;

            case R.id.button_tomarFoto:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                /**Valida que el dispositivo tenga camara */
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(intent,keys.REQUEST_CODE);
                }
                break;

            case R.id.button_guardar:

                Perfil perfil = new Perfil(etNombre.getText().toString(),etMatricula.getText().toString(),spGenero.getSelectedItem().toString(),Integer.toString(spDia.getSelectedItemPosition()),
                        Integer.toString(spMes.getSelectedItemPosition()),Integer.toString(spAño.getSelectedItemPosition()),etPesoActual.getText().toString(),etPesoMeta.getText().toString(),etPesoMaximoPierna.getText().toString(),
                        etPesoMaximoBrazo.getText().toString(),etGrupoMuscular.getText().toString(),etRepeticion.getText().toString(),etPorcentaje.getText().toString(),etPeso.getText().toString(),byteArray);

                id = dbOperations.addPerfil(perfil);

                SharedPreferences settings = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = settings.edit();
                editor.putLong(keys.KEY_ID, id);
                editor.commit();

                Toast.makeText(this,"Perfil actualizado con exito",Toast.LENGTH_LONG).show();

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        dbOperations = new DBOperations(this);
        dbOperations.open();

        spGenero = (Spinner)findViewById(R.id.spinner_genero);
        spDia = (Spinner)findViewById(R.id.spinner_dia);
        spAño = (Spinner)findViewById(R.id.spinner_año);
        spMes = (Spinner)findViewById(R.id.spinner_mes);

        ivFoto = (ImageView)findViewById(R.id.image_perfil);

        etGrupoMuscular = (EditText)findViewById(R.id.edit_grupoMuscular);
        etPeso = (EditText)findViewById(R.id.edit_peso);
        etRepeticion = (EditText)findViewById(R.id.edit_repeticion);
        etPorcentaje = (EditText)findViewById(R.id.edit_porcentaje);
        etNombre = (EditText) findViewById(R.id.edit_nombre);
        etMatricula = (EditText) findViewById(R.id.edit_matricula);
        etPesoActual = (EditText) findViewById(R.id.edit_pesoActual);
        etPesoMeta = (EditText) findViewById(R.id.edit_pesoMeta);
        etPesoMaximoPierna = (EditText) findViewById(R.id.edit_pesoMaximoPierna);
        etPesoMaximoBrazo = (EditText) findViewById(R.id.edit_pesoMaximoBrazo);

        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        id = settings.getLong(keys.KEY_ID, -1);

        if(id != -1){
            setData();
        }

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
        btnTomarFoto = (Button) findViewById(R.id.button_tomarFoto);

        btnHome.setOnClickListener(this);
        btnRutinas.setOnClickListener(this);
        btnSesion.setOnClickListener(this);
        btnHistoria.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
        btnTomarFoto.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode==keys.REQUEST_CODE && resultCode == RESULT_OK){
            bitmap = (Bitmap) data.getExtras().get("data");

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteArray = stream.toByteArray();

            ivFoto.setImageBitmap(bitmap);
        }
    }
}
