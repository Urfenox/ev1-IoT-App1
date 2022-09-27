package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class ParametrosActivity extends AppCompatActivity {

    // Declaracion de variables
    EditText edt1, edt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros);
        setTitle("Paso de Parametros");

        // Declaramos los controles
        edt1 = (EditText) findViewById(R.id.edtValor1);
        edt2 = (EditText) findViewById(R.id.edtValor2);

    }

    public void metMisParametros(View view) {
        Intent misParametros = new Intent(this, MisParametrosActivity.class);

        String val1, val2;
        val1 = edt1.getText().toString();
        val2 = edt2.getText().toString();

        misParametros.putExtra("Valor1", val1);
        misParametros.putExtra("Valor2", val2);
        startActivity(misParametros);
    }
}