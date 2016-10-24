package itesm.mx.formaciondeportivaandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SeleccionActivity extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    ArrayList<RutinaT> listSelec;
    RutinaAdapter adapterR;
    private Button btnRegresarAct;
    private Button btnGuardarAct;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);
        btnRegresarAct = (Button) findViewById(R.id.button_rutinasAct);
        btnGuardarAct = (Button) findViewById(R.id.button_guardarR);
        ArrayList<RutinaT> arrayListEjercicio;

        arrayListEjercicio = getDataFotListView();

        adapterR = new RutinaAdapter(this, arrayListEjercicio);
        setListAdapter(adapterR);
        btnRegresarAct.setOnClickListener(this);
        btnGuardarAct.setOnClickListener(this);

        getListView().setOnItemClickListener(this);

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

    public ArrayList<RutinaT> getDataFotListView() {
        RutinaT arti;

        listSelec = new ArrayList<RutinaT>();
        arti = new RutinaT ("Dominadas\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new RutinaT ("Aperturas\nPecho", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new RutinaT ("Jalon Frontal\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new RutinaT ("Remo Sentado\nEspalda", R.mipmap.ic_launcher);
        listSelec.add(arti);
        arti = new RutinaT ("Empujones\nTriceps", R.mipmap.ic_launcher);
        listSelec.add(arti);


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
                Toast.makeText(this, "Regreso a la Rutina 1", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this, TiposRutinaActivity.class);
                startActivity(intent6);
                break;

            case R.id.button_guardarR:
                Toast.makeText(this, "Se ha guardado la Rutina 1", Toast.LENGTH_SHORT).show();
                Intent intent7 = new Intent(this, RutinasActivity.class);
                startActivity(intent7);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
