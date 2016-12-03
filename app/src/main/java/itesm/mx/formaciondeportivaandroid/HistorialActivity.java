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
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class HistorialActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnHome;
    Button btnRutinas;
    Button btnSesion;
    Button btnHistoria;
    Button btnPerfil;
    Button btnEnviar;
    String sCorreo= "";
    DatePicker dpInicio;
    DatePicker dpFin;
    DBOperations dbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        btnHome = (Button) findViewById(R.id.button_home);
        btnRutinas = (Button) findViewById(R.id.button_rutinas);
        btnSesion = (Button) findViewById(R.id.button_sesion);
        btnHistoria = (Button) findViewById(R.id.button_history);
        btnPerfil = (Button) findViewById(R.id.button_perfil);
        btnEnviar = (Button) findViewById(R.id.button_historial);

        dpInicio = (DatePicker) findViewById(R.id.date_fechain);
        dpFin = (DatePicker) findViewById(R.id.date_fechafin);

        btnHome.setOnClickListener(this);
        btnRutinas.setOnClickListener(this);
        btnSesion.setOnClickListener(this);
        btnHistoria.setOnClickListener(this);
        btnPerfil.setOnClickListener(this);
        btnEnviar.setOnClickListener(this);

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

            case R.id.button_sesion:
                Intent intent3 = new Intent(this,SesionActivity.class);
                intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent3);
                break;

            case R.id.button_perfil:
                Intent intent5 = new Intent(this,PerfilActivity.class);
                intent5.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent5);
                break;

            case R.id.button_historial:
                ArrayList<Ejercicio> arrEjer;
                GregorianCalendar cal1=new GregorianCalendar(dpInicio.getYear(),
                        dpInicio.getMonth(),dpInicio.getDayOfMonth());
                Date begin=cal1.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaInicio = sdf.format(begin);
                GregorianCalendar cal2=new GregorianCalendar(dpFin.getYear(),
                        dpFin.getMonth(),dpFin.getDayOfMonth());
                Date end=cal2.getTime();
                String fechaFin = sdf.format(end);


                dbo = new DBOperations(this);
                dbo.open();
                arrEjer = dbo.getHistorial(fechaInicio, fechaFin);
                dbo.close();

                Intent email = new Intent(Intent.ACTION_SEND,
                        Uri.parse("mailto:"));
                email.setType("text/plain");

                String[] recipients = {"casas@itesm.mx",
                        "tony.gymsport@gmail.com"};

                for(int i=0; i<arrEjer.size();i++){
                    sCorreo+="<b>Fecha de realizado: </b>"+arrEjer.get(i).getDiaFin()+"<br>"+
                            "<b>Ejercicio: </b>"+arrEjer.get(i).getsNombreEjer()+"<br>"+
                            "<b>Tipo de Ejercicio: </b>"+arrEjer.get(i).getsTipoEjer()+"<br>"+
                            "<b>Numero de Series: </b>"+arrEjer.get(i).getiSeries()+"<br>"+
                            "<b>Numero de Repeticiones: </b>"+arrEjer.get(i).getiRepeticiones()+"<br><br>";
                    Log.i("EJERCICIO HISTORIAL", sCorreo);
                }

                email.putExtra(Intent.EXTRA_EMAIL,recipients);
                email.putExtra(Intent.EXTRA_SUBJECT,"Ejercicio del dia "+fechaInicio+" al "+fechaFin);
                email.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(sCorreo));
                try{
                    startActivity(Intent.createChooser(email,"Selecciona un cliente de correo.."));
                    sCorreo="";
                }catch(android.content.ActivityNotFoundException ex){
                    Toast.makeText(HistorialActivity.this,"No esta instalado ese cliente de correo.",
                            Toast.LENGTH_LONG).show();
                }

                break;
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
