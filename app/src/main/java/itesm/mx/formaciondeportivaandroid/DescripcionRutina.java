package itesm.mx.formaciondeportivaandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import java.util.ArrayList;

public class DescripcionRutina extends ListActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ArrayList<Ejercicio> listEjerc;
    EjerciciosAdapter adapterEjercicio;
    Button btnRegresaraRutina;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion_rutina);
        btnRegresaraRutina = (Button) findViewById(R.id.button_rutinas);

        getListView().setOnItemClickListener(this);

        ArrayList<Ejercicio> arrayListEjercicio;

        arrayListEjercicio = getDataFotListView();

        adapterEjercicio = new EjerciciosAdapter(this, arrayListEjercicio);
        setListAdapter(adapterEjercicio);

        btnRegresaraRutina.setOnClickListener(this);
        getListView().setOnItemClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Rutinas.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    public ArrayList<Ejercicio> getDataFotListView() {
        Ejercicio arti;

        listEjerc = new ArrayList<Ejercicio>();
        arti = new Ejercicio ("Aperturas \n Pecho", 3,10,R.mipmap.ic_launcher);
        listEjerc.add(arti);
        arti = new Ejercicio ("Jalon Frontal\n Espalda",4,12, R.mipmap.ic_launcher);
        listEjerc.add(arti);
        arti = new Ejercicio ("Dominadas \n Espalda",4,10, R.mipmap.ic_launcher);
        listEjerc.add(arti);


        return listEjerc;
    }
}
