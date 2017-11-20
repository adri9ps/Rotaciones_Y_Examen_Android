package com.example.adri9ps.rotaciones_y_examen_android;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView textoInicio;
    Button btnCancel;

    Button btnContinuar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //enlazamos elementos del XML con java
        textoInicio = (TextView) findViewById(R.id.textoInicio);
        btnCancel = (Button) findViewById(R.id.btnCancelar);
        btnContinuar = (Button) findViewById(R.id.id_btnContinuar);
        //Cogemos el intent que hemos enlazado a esta actividad

        Intent i = getIntent();

        Bundle parametrosRecibidos = i.getExtras();
        if(parametrosRecibidos!=null){
            String nombreUsuario = parametrosRecibidos.getString("nombreUsuario");
            String sexo = parametrosRecibidos.getString("sexo");
            textoInicio.setText("Hola, "+nombreUsuario+" ("+sexo+"), introduce tu edad: ");
        }

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);
                finish();
            }
        });

    }

}