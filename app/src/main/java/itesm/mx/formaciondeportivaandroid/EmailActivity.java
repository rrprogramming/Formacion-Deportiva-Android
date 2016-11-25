package itesm.mx.formaciondeportivaandroid;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class EmailActivity extends Activity {

    private EditText etrecipient;
    private EditText etsubject;
    private TextView tvbody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        etrecipient = (EditText)findViewById(R.id.recipient);
        etsubject = (EditText)findViewById(R.id.subject);
        tvbody = (TextView) findViewById(R.id.body);

        Button btnCorreo = (Button)findViewById(R.id.sendEmail);
        btnCorreo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sendEmail();
                etrecipient.setText("");
                etsubject.setText("");
                tvbody.setText("");
            }
        });
    }

    protected  void sendEmail(){
        String[] recipients = {etrecipient.getText().toString()};
        Intent email = new Intent(Intent.ACTION_SEND,
        Uri.parse("mailto:"));

        email.setType("message/rfc822");

        email.putExtra(Intent.EXTRA_EMAIL,recipients);
        email.putExtra(Intent.EXTRA_SUBJECT,etsubject.getText().toString());
        email.putExtra(Intent.EXTRA_TEXT,tvbody.getText().toString());
        try{
            startActivity(Intent.createChooser(email,"Selecciona un cliente de correo.."));
        }catch(android.content.ActivityNotFoundException ex){
            Toast.makeText(EmailActivity.this,"No esta instalado ese cliente de correo.",
                    Toast.LENGTH_LONG).show();
        }
    }
}
