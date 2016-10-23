package itesm.mx.formaciondeportivaandroid;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class Rutinas extends ListActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    public String [] sRutinas;
    private Button btnAgregar;
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
    }


    @Override
    public void onClick(View v) {
                Toast.makeText(this, "Se vaa agregar una rutina", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, TiposRutina.class);
                startActivity(intent);
        //dialogoPersonalizado()
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "Se selecciono la rutina Rutina 1", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, DescripcionRutina.class);
        startActivity(intent);
    }

}
