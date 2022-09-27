package com.crizacio.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.security.MessageDigest;

import kotlin.reflect.KFunction;

public class MainActivity extends AppCompatActivity {

    // Declaracion de objetos
    EditText edt_User, edt_Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Definicion de objetos
        edt_User = (EditText) findViewById(R.id.edtUser);
        edt_Pass = (EditText) findViewById(R.id.edtPass);
    }

    String username = "Cris";
    String password = "12345";
    public void metEntrar(View view) {
        if ((edt_User.getText().toString().equals(username)) && (edt_Pass.getText().toString().equals(password))) {
            Intent menu = new Intent(this, MenuActivity.class);
            startActivity(menu);
        } else {
            Toast.makeText(this, "Credenciales Incorrectas. \nUser: " + username + " Pass: " + password, Toast.LENGTH_SHORT).show();
        }
    }
}