package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class AcelerometroActivity extends AppCompatActivity {

    // Declaracion de variables
    TextView txtX, txtY, txtZ;
    // Declaracion del objeto para operar con el sensor
    SensorManager sm;
    // Declaracion del sensor
    Sensor acelerometro;
    // Declaracion del hilo que escucha el sensor
    SensorEventListener sel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acelerometro);
        setTitle("Acelerometro");

        // Declaramos los TextViews para controlarlos
        txtX = (TextView)findViewById(R.id.txt_AX);
        txtY = (TextView)findViewById(R.id.txt_AY);
        txtZ = (TextView)findViewById(R.id.txt_AZ);

        // Habitamos el objeto para operar sensores
        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        // Obtenemos el sensor Acelerometro
        acelerometro = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        // Declaramos la escucha de los eventos del sensor
        sel = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                float y = sensorEvent.values[1];
                float z = sensorEvent.values[2];
                txtX.setText("X: \n" + x + " m/s");
                txtY.setText("Y: \n" + y + " m/s");
                txtZ.setText("Z: \n" + z + " m/s");
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        // Inicia la escucha
        sm.registerListener(sel, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }
}