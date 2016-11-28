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

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {

    DBOperations dbOperations;

    long id = -1;

    Spinner spGenero;

    DatePicker dpNacimiento;

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

        byte[] image=perfil.getFoto();

        if(image!=null){
            Bitmap bmimage = BitmapFactory.decodeByteArray(image,0,image.length);
            ivFoto.setImageBitmap(bmimage);
        }

        String sFecha = perfil.getFechaNacimiento();
        Log.i("FECHA", sFecha);
        int iAño = Integer.parseInt(sFecha.substring(0,sFecha.indexOf("-")));
        int iMes = Integer.parseInt(sFecha.substring(sFecha.indexOf("-")+1,sFecha.lastIndexOf("-")));
        int iDia = Integer.parseInt(sFecha.substring(sFecha.lastIndexOf("-")+1));

        Log.i("DATOS FECHA",iAño+" / "+iMes+" / "+iDia);

        dpNacimiento.updateDate(iAño,iMes-1,iDia);

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

            case R.id.button_tomarFoto:
                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                /**Valida que el dispositivo tenga camara */
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivityForResult(intent,keys.REQUEST_CODE);
                }
                break;

            case R.id.button_guardar:

                AlertDialog.Builder dialogorutina = new AlertDialog.Builder(this);
                final EditText etContraseña = new EditText(this);

                LinearLayout lila= new LinearLayout(this);
                lila.setOrientation(LinearLayout.VERTICAL);

                dialogorutina.setTitle("Favor de ir con su instructor para modificar el perfil");
                etContraseña.setHint("Contraseña");
                InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                etContraseña.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);

                lila.addView(etContraseña);

                dialogorutina.setView(lila);
                dialogorutina.setPositiveButton("Crear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(etContraseña.getText().length()==0) {
                            Toast.makeText(getApplication(), "Favor de completar todos los campos de texto", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            if(etContraseña.getText().toString().equals("gymsport")) {
                                GregorianCalendar cal1=new GregorianCalendar(dpNacimiento.getYear(),
                                        dpNacimiento.getMonth(),dpNacimiento.getDayOfMonth());
                                Date nac=cal1.getTime();
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                                String fecha = sdf.format(nac);

                                Perfil perfil = new Perfil(etNombre.getText().toString(),etMatricula.getText().toString(),spGenero.getSelectedItem().toString(),fecha,etPesoActual.getText().toString(),etPesoMeta.getText().toString(),etPesoMaximoPierna.getText().toString(),
                                        etPesoMaximoBrazo.getText().toString(),etGrupoMuscular.getText().toString(),etRepeticion.getText().toString(),etPorcentaje.getText().toString(),etPeso.getText().toString(),byteArray);

                                id = dbOperations.addPerfil(perfil);

                                SharedPreferences settings = getPreferences(MODE_PRIVATE);
                                SharedPreferences.Editor editor = settings.edit();
                                editor.putLong(keys.KEY_ID, id);
                                editor.commit();

                                Toast.makeText(getApplicationContext(),"Perfil actualizado con exito",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "La contraseña es incorrecta", Toast.LENGTH_SHORT).show();
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        dbOperations = new DBOperations(this);
        dbOperations.open();

        spGenero = (Spinner)findViewById(R.id.spinner_genero);

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

        dpNacimiento = (DatePicker) findViewById(R.id.date_nacimiento);

        SharedPreferences settings = getPreferences(MODE_PRIVATE);
        id = settings.getLong(keys.KEY_ID, -1);

        if(id != -1){
            setData();
        }

        etNombre.requestFocus();

        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this,R.array.genero,R.layout.support_simple_spinner_dropdown_item);
        spGenero.setAdapter(adapterGenero);

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
