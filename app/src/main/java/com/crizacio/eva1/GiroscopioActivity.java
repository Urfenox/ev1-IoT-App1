package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class GiroscopioActivity extends AppCompatActivity {

    // Declaracion de variables
    TextView txtX, txtY, txtZ;
    // Declaracion del objeto para operar con el sensor
    SensorManager sm;
    // Declaracion del sensor
    Sensor giroscopio;
    // Declaracion del hilo que escucha el sensor
    SensorEventListener sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giroscopio);
        setTitle("Giroscopio");

        // Declaramos los TextViews para controlarlos
        txtX = (TextView)findViewById(R.id.txtGX);
        txtY = (TextView)findViewById(R.id.txtGY);
        txtZ = (TextView)findViewById(R.id.txtGZ);

        // Habitamos el objeto para operar sensores
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // Obtenemos el sensor Giroscopio
        giroscopio = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        // Declaramos la escucha de los eventos del sensor
        sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                // Obtenemos los valores del sensor
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                // Mostramos en pantalla
                txtX.setText("X: \n" + x + " m/s");
                txtY.setText("Y: \n" + y + " m/s");
                txtZ.setText("Z: \n" + z + " m/s");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        // Inicia la escucha
        sm.registerListener(sel, giroscopio, SensorManager.SENSOR_DELAY_NORMAL);
    }
}