package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LuzActivity extends AppCompatActivity {

    // Declaracion de variables
    TextView txtL;
    // Declaracion del objeto para operar con el sensor
    SensorManager sm;
    // Declaracion del sensor
    Sensor luz;
    // Declaracion del hilo que escucha el sensor
    SensorEventListener sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luz);
        setTitle("Luz");

        // Declaramos el TextView para controlarlo
        txtL = (TextView) findViewById(R.id.txt_Luz);

        // Habitamos el objeto para operar sensores
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // Obtenemos el sensor Luz
        luz = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        // Declaramos la escucha de los eventos del sensor
        sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                // Obtenemos el valor del sensor
                float nivel = sensorEvent.values[0];
                // Mostramos en pantalla
                txtL.setText(String.valueOf(nivel));
                // Cambio de color de fondo
                int i = Math.round(nivel/40000*255);
                txtL.setBackgroundColor(Color.argb(i, 50, 50, 50));
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        // Inicia la escucha
        sm.registerListener(sel, luz, SensorManager.SENSOR_DELAY_NORMAL);
    }
}