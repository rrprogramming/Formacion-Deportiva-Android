package itesm.mx.formaciondeportivaandroid;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

public class RutinasActivity extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    public String [] sRutinas;
    private Button btnAgregar;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutinas);
        sRutinas = new String[]{
                "Rutina 1",
                "Rutina 2",
                "Rutina 3",};
        btnAgregar = (Button) findViewById(R.id.button_crear_rutina);
        ArrayAdapter<String> adapterRutinas = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,sRutinas);

        setListAdapter(adapterRutinas);
        getListView().setOnItemClickListener(this);
        btnAgregar.setOnClickListener(this);

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
        //dialogoPersonalizado()

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
                Intent intent4 = new Intent(this,HistorialActivity.class);
                startActivity(intent4);
                break;

            case R.id.button_perfil:
                Intent intent5 = new Intent(this,PerfilActivity.class);
                startActivity(intent5);
                break;

            case R.id.button_crear_rutina:
                Toast.makeText(this, "Se vaa agregar una rutina", Toast.LENGTH_SHORT).show();
                Intent intent6 = new Intent(this, TiposRutinaActivity.class);
                startActivity(intent6);
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Se selecciono la rutina Rutina 1", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DescripcionRutinaActivity.class);
        startActivity(intent);
    }

}
