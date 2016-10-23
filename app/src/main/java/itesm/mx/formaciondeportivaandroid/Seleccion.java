package itesm.mx.formaciondeportivaandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Seleccion extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener{

    ArrayList<RutinaT> listSelec;
    RutinaAdapter adapterR;
    private Button btnRegresarAct;
    private Button btnGuardarAct;
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
            case R.id.button_rutinasAct:
                Toast.makeText(this, "Regreso a la Rutina 1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TiposRutina.class);
                startActivity(intent);
                break;
            case R.id.button_guardarR:
                Toast.makeText(this, "Se ha guardado la Rutina 1", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Rutinas.class);
                startActivity(intent2);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
