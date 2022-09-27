package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SpinnerActivity extends AppCompatActivity {

    // Declaracion de variables
    Spinner cmbC;
    EditText edtC;
    // Arreglo
    ArrayList<String> ciudades = new ArrayList<String>();
    //String [] ciudades = new String[] {"Santiago"};
    // Adaptador de datos a formato
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        setTitle("Mi ComboBox o Spinner");

        // Declaramos los controles
        cmbC = (Spinner) findViewById(R.id.spnCiudades);
        edtC = (EditText) findViewById(R.id.edtCiudad);

        // Agregamos una ciudade
        ciudades.add("Santiago");

        indexarItems();
    }

    public void metAgregar(View view) {
        ciudades.add(edtC.getText().toString());
    }

    public void indexarItems() {
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, ciudades);
        cmbC.setAdapter(adaptador);

        cmbC.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = adaptador.getItem(i);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}