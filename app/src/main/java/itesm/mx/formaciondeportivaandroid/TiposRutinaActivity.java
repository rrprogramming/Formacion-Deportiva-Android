package itesm.mx.formaciondeportivaandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class TiposRutinaActivity extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    ArrayList<RutinaT> listRuti;
    RutinaAdapter adapterRutina;

    Button btnRegresarR;
    Button btnGuardar;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

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
        switch (v.getId()) {
            case R.id.button_rutinas:
                Intent intent = new Intent(this, RutinasActivity.class);
                startActivity(intent);
                break;

            case R.id.button_home:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;

            case R.id.button_sesion:
                Intent intent3 = new Intent(this, SesionActivity.class);
                startActivity(intent3);
                break;

            case R.id.button_history:
                Intent intent4 = new Intent(this, HistorialActivity.class);
                startActivity(intent4);
                break;

            case R.id.button_perfil:
                Intent intent5 = new Intent(this, PerfilActivity.class);
                startActivity(intent5);
                break;

            case R.id.button_guardar:
                Toast.makeText(this, "Se ha guardado la Rutina 1", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this, RutinasActivity.class);
                startActivity(intent6);
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
        Intent intent = new Intent(this, SeleccionActivity.class);
        startActivity(intent);
    }
}
