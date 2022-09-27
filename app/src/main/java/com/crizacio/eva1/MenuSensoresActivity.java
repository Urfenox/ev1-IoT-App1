package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuSensoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_sensores);
        setTitle("Menú Sensores");
    }

    public void metListaSensores(View view) {
        Intent lista_sensores = new Intent(this, ListaSensoresActivity.class);
        startActivity(lista_sensores);
    }

    public void metLuz(View view) {
        Intent luz = new Intent(this, LuzActivity.class);
        startActivity(luz);
    }

    public void metAcelerometro(View view) {
        Intent acelerometro = new Intent(this, AcelerometroActivity.class);
        startActivity(acelerometro);
    }

    public void metGiroscopio(View view) {
        Intent giroscopio = new Intent(this, GiroscopioActivity.class);
        startActivity(giroscopio);
    }
}