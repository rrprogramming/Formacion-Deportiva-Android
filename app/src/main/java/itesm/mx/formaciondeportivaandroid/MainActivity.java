package itesm.mx.formaciondeportivaandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cambioantalla();

    }
    public void cambioantalla(){
        Intent intent = new Intent(this, Rutinas.class);
        startActivity(intent);
    }

}
