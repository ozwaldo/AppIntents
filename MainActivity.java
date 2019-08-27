package edu.itsur.appintents;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText mMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMensaje = (EditText) findViewById(R.id.edit_mensaje);
    }
    public void siguienteActivity(View view) {
        String textoMensaje = mMensaje.getText().toString();
        Intent intent = new Intent(
                this, SegundaActivity.class);
        intent.putExtra("TEXTO_MENSAJE",textoMensaje);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    @Nullable Intent data) {
        if (requestCode == 1) {
            if (resultCode == RESULT_OK){
                TextView respuesta = (TextView)
                        findViewById(R.id.txt_respuesta);
                String resp =
                        data.getStringExtra("RESPUESTA_MENSAJE");

                respuesta.setText(resp);
            }
        }
    }
}
