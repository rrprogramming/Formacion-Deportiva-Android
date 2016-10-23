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

public class TiposRutina extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ArrayList<RutinaT> listRuti;
    RutinaAdapter adapterRutina;
    Button btnRegresarR;
    Button btnGuardar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos_rutina);
        getListView().setOnItemClickListener(this);
        btnRegresarR = (Button) findViewById(R.id.button_rutinas);
        btnGuardar = (Button) findViewById(R.id.button_guardar);
        ArrayList<RutinaT> arrayListArticulo;

        arrayListArticulo = getDataFotListView();

        adapterRutina = new RutinaAdapter(this, arrayListArticulo);
        setListAdapter(adapterRutina);
        btnRegresarR.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);

        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_rutinas:
                Toast.makeText(this, "Rutinas", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Rutinas.class);
                startActivity(intent);
                break;
            case R.id.button_guardar:
                Toast.makeText(this, "Se ha guardado la Rutina 1", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Rutinas.class);
                startActivity(intent2);
                break;
        }
    }

    public ArrayList<RutinaT> getDataFotListView() {
        RutinaT arti;

        listRuti = new ArrayList<RutinaT>();
        arti = new RutinaT ("Maquina Selectiva", R.mipmap.ic_launcher);
        listRuti.add(arti);
        arti = new RutinaT ("Cross Over", R.mipmap.ic_launcher);
        listRuti.add(arti);
        arti = new RutinaT ("Aparato Libre", R.mipmap.ic_launcher);
        listRuti.add(arti);
        arti = new RutinaT ("Torre Selectiva", R.mipmap.ic_launcher);
        listRuti.add(arti);


        return listRuti;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Selecciona Ejercicios", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Seleccion.class);
        startActivity(intent);
    }
}
