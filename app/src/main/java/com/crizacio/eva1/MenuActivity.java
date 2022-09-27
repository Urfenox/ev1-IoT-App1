package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Menú Principal");
    }

    public void metParametros(View view) {
        Intent parametros = new Intent(this, ParametrosActivity.class);
        startActivity(parametros);
    }

    public void metSpinner(View view) {
        Intent spinner = new Intent(this, SpinnerActivity.class);
        startActivity(spinner);
    }

    public void metSensores(View view) {
        Intent sensores = new Intent(this, MenuSensoresActivity.class);
        startActivity(sensores);
    }
}