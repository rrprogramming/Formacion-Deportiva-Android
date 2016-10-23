package itesm.mx.formaciondeportivaandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class PerfilActivity extends AppCompatActivity {

    Spinner genero;
    Spinner dia;
    Spinner año;
    Spinner mes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        genero = (Spinner)findViewById(R.id.spinner_genero);
        dia = (Spinner)findViewById(R.id.spinner_dia);
        año = (Spinner)findViewById(R.id.spinner_año);
        mes = (Spinner)findViewById(R.id.spinner_mes);

        ArrayAdapter<CharSequence> adapterGenero = ArrayAdapter.createFromResource(this,R.array.genero,R.layout.support_simple_spinner_dropdown_item);
        genero.setAdapter(adapterGenero);

        ArrayAdapter<CharSequence> adapterDia = ArrayAdapter.createFromResource(this,R.array.dia,R.layout.support_simple_spinner_dropdown_item);
        dia.setAdapter(adapterDia);

        ArrayAdapter<CharSequence> adapterMes = ArrayAdapter.createFromResource(this,R.array.mes,R.layout.support_simple_spinner_dropdown_item);
        mes.setAdapter(adapterMes);

        ArrayAdapter<CharSequence> adapterAño = ArrayAdapter.createFromResource(this,R.array.año,R.layout.support_simple_spinner_dropdown_item);
        año.setAdapter(adapterAño);
    }
}
