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
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class HistorialActivity extends AppCompatActivity implements View.OnClickListener {

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;
    Button enviar;
    String sCorreo= "";
    TextView tvC;
    DatePicker dp_inicio;
    DatePicker dp_fin;
    DBOperations dbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        home = (Button) findViewById(R.id.button_home);
        rutinas = (Button) findViewById(R.id.button_rutinas);
        sesion = (Button) findViewById(R.id.button_sesion);
        historia = (Button) findViewById(R.id.button_history);
        perfil = (Button) findViewById(R.id.button_perfil);
        enviar = (Button) findViewById(R.id.btn_historial);
        tvC = (TextView) findViewById(R.id.corr);


        tvC.setVisibility(View.INVISIBLE);
        home.setOnClickListener(this);
        rutinas.setOnClickListener(this);
        sesion.setOnClickListener(this);
        historia.setOnClickListener(this);
        perfil.setOnClickListener(this);
        enviar.setOnClickListener(this);

        dp_inicio = (DatePicker) findViewById(R.id.dp_fechain);
        dp_fin = (DatePicker) findViewById(R.id.fp_fechafin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
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
                //Intent intent4 = new Intent(this,HistorialActivity.class);
                //startActivity(intent4);
                break;

            case R.id.button_perfil:
                Intent intent5 = new Intent(this,PerfilActivity.class);
                startActivity(intent5);
                break;

            case R.id.btn_historial:
                ArrayList<Ejercicio> arrEjer;
                GregorianCalendar cal1=new GregorianCalendar(dp_inicio.getYear(),
                        dp_inicio.getMonth(),dp_inicio.getDayOfMonth());
                Date begin=cal1.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String fechaInicio = sdf.format(begin);
                GregorianCalendar cal2=new GregorianCalendar(dp_fin.getYear(),
                        dp_fin.getMonth(),dp_fin.getDayOfMonth());
                Date end=cal2.getTime();
                String fechaFin = sdf.format(end);


                dbo=new DBOperations(this);
                dbo.open();
                arrEjer=dbo.getHistorial(fechaInicio, fechaFin);
                dbo.close();
                //String[] recipients = {etrecipient.getText().toString()};
                Intent email = new Intent(Intent.ACTION_SEND,
                        Uri.parse("mailto:"));
                email.setType("text/plain");
                //emailIntent.setType("text/plain");
                String[] recipients = {tvC.getText().toString()};
                //tvC.setText("");
                for(int i=0; i<arrEjer.size();i++){
                    sCorreo+="<b>Ejercicio: </b>"+arrEjer.get(i).getsNombreEjer()+"<br>"+
                            "<b>Tipo de Ejercicio: </b>"+arrEjer.get(i).getsTipoEjer()+"<br>"+
                            "<b>Numero de Series: </b>"+arrEjer.get(i).getiSeries()+"<br>"+
                            "<b>Numero de Repeticiones: </b>"+arrEjer.get(i).getiRepeticiones()+"<br><br>";
                    Log.i("EJERCICIO HISTORIAL", sCorreo);
                }
                //tvC.setText(sCorreo);
                //String[] body = {tvC.getText().toString()};

                email.putExtra(Intent.EXTRA_EMAIL,recipients);
                email.putExtra(Intent.EXTRA_SUBJECT,"Rutinas dia "+fechaInicio+" al "+fechaFin+" "+arrEjer.size());
                email.putExtra(Intent.EXTRA_TEXT, Html.fromHtml(sCorreo));
                try{
                    startActivity(Intent.createChooser(email,"Selecciona un cliente de correo.."));
                }catch(android.content.ActivityNotFoundException ex){
                    Toast.makeText(HistorialActivity.this,"No esta instalado ese cliente de correo.",
                            Toast.LENGTH_LONG).show();
                }
                /*Intent email2 = new Intent(this, EmailActivity.class);
                startActivity(email);*/
                break;
        }
    }



}
