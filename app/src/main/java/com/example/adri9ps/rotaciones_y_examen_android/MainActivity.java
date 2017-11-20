package com.example.adri9ps.rotaciones_y_examen_android;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private Button btnEnviar;
    private RadioButton hombre;
    private RadioButton mujer;
    private final String TAG = "Repaso";
    final int SUBACT_1 = 345;
    private String nombreGuardado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnEnviar = (Button) findViewById(R.id.id_btnEnviar);
        nombre = (EditText) findViewById(R.id.id_nombre);
        hombre = (RadioButton) findViewById(R.id.id_btnMasc);
        mujer = (RadioButton) findViewById(R.id.id_btnFem);
        nombreGuardado = nombre.toString();


        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Log.d(TAG, "Nombre: " + nombre.getText());

                //Objeto intent
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);

                //Objeto bundle para poder pasar los datos
                Bundle parametros = new Bundle();
                //String=CharSequence y el "nombreusuario" es la clave
                parametros.putString("nombreUsuario", nombre.getText().toString());
                if (hombre.isChecked()) {
                    parametros.putString("sexo", "hombre");

                } else {
                    parametros.putString("sexo", "mujer");
                }
                //Para pasarle al intent el objeto bundle
                i.putExtras(parametros);
                startActivityForResult(i, SUBACT_1);
                //startActivity(i);
            }


        });

        //restauraEstado(savedInstanceState);

        // }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SUBACT_1) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "El subactivity se ha realizado correctamente", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "El subactivity se ha cancelado", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Nombre", nombreGuardado);


    }

    /*
    public void restauraEstado (Bundle savedInstanceState){
        if(savedInstanceState != null){
            nombreGuardado = savedInstanceState.getString("Nombre");
        }
    }
    */

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        nombreGuardado = savedInstanceState.getString("Nombre");
    }


}

