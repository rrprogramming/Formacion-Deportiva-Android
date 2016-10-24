package itesm.mx.formaciondeportivaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SesionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_comenzar;

    Button home;
    Button rutinas;
    Button sesion;
    Button historia;
    Button perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);

        btn_comenzar = (Button) findViewById(R.id.btn_comenzar);

        Spinner spinnerPaises = (Spinner) findViewById(R.id.spinner_rutinas);
        String sPaises[] = {
                "Rutina 1",
                "Rutina 2",
                "Rutina 3"};

        ArrayAdapter<String> adapterPaises = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sPaises);
        adapterPaises.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPaises.setAdapter(adapterPaises);
        btn_comenzar.setOnClickListener(this);

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

            case R.id.btn_comenzar:
                Intent myIntent6 = new Intent(this, EjercicioActivity.class);
                startActivity(myIntent6);
                break;
        }
    }
}