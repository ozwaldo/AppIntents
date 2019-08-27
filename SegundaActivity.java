package edu.itsur.appintents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SegundaActivity extends AppCompatActivity {
    EditText mRespuesta;
    TextView mMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        mMensaje = (TextView) findViewById(R.id.txt_mensaje);
        Intent intent = getIntent();
        String getMensaje =
                intent.getStringExtra("TEXTO_MENSAJE");

        mMensaje.setText(getMensaje);
    }

    public void responder(View view) {
        mRespuesta = (EditText) findViewById(R.id.edit_respuesta);
        String resp = mRespuesta.getText().toString();
        Intent intent = new Intent();
        intent.putExtra("RESPUESTA_MENSAJE", resp);
        setResult(RESULT_OK, intent);
        finish();
    }
}
