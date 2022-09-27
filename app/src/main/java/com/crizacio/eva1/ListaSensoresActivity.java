package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

public class ListaSensoresActivity extends AppCompatActivity {

    // Declaracion de variables
    TextView txtL;
    // Declaracion del objeto para operar con el sensor
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sensores);
        setTitle("Lista Sensores");

        // Declaramos el TextView para controlarlo
        txtL = (TextView) findViewById(R.id.txt_ListaSensores);
        // Habitamos el objeto para operar sensores
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Ingresamos todos los sensores a una <lista (De Sensores)>
        List<Sensor> lista = sm.getSensorList(Sensor.TYPE_ALL);
        // Obtenemos la cantidad de sensores
        int tam = lista.size();
        // Mostramos la cantidad de sensores
        txtL.setText("Número de sensores: "+ tam + "\n");

        // Ciclo for que indexa cada sensor y asi recorremos los valores de cada de estos
        for (int i = 0; i < tam; i++) {
            // Obtenemos el sensor y lo declaramos
            Sensor sensor = lista.get(i);

            // Tomamos los valores del sensor
            int version = sensor.getVersion();
            int tipo = sensor.getType();
            String nombre = sensor.getName();
            String fabricante = sensor.getVendor();
            float consumo = sensor.getPower();
            float rango = sensor.getMaximumRange();
            // Mostramos los valores del sensor
            txtL.append("\n\n Nombre: " + nombre);
            txtL.append("\n Tipo: " + tipo);
            txtL.append("\n Version: " + version);
            txtL.append("\n Consumo: " + consumo);
            txtL.append("\n Rango: " + rango);
            txtL.append("\n Fabricante: " + fabricante);
        }
        // Permitimos que se pueda hacer scroll al label.
        txtL.setMovementMethod(new ScrollingMovementMethod());
    }
}