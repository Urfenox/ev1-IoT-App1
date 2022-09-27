package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MisParametrosActivity extends AppCompatActivity {

    // Declaracion de variables
    TextView txt1, txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_parametros);
        setTitle("Mis Parametros");

        // Declaramos los controles
        txt1 = (TextView) findViewById(R.id.txtValor1);
        txt2 = (TextView) findViewById(R.id.txtValor2);

        // obtenemos la instancia
        Intent i = getIntent();
        // ponemos el String dentro del TextView
        txt1.setText("Valor 1\n" + i.getStringExtra("Valor1"));
        txt2.setText("Valor 2\n" + i.getStringExtra("Valor2"));
    }
}