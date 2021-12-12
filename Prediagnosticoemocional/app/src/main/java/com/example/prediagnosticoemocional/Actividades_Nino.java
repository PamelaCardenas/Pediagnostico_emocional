package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//Pantalla para mostrar las diferentes actividades que puede realizar el niño

public class Actividades_Nino extends AppCompatActivity {

    Intent inRegresarPrincipal, inDibujaFam, inCuentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades__nino);
    }

    //Método para regresar de la pantalla de las actividades del niño, al menú principal
    public void regresarPrincipal(View view){
        inRegresarPrincipal = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(inRegresarPrincipal,0);
        finish();
    }

    //Método para pasar de la pantalla de las actividades del niño, a la actividad de dibujar a la familia
    public void dibujaFamilia(View view){
        inDibujaFam = new Intent(getApplicationContext(), DibujoFamiliaNino.class);
        startActivityForResult(inDibujaFam,0);
        finish();
    }

    //Método para pasar de la pantalla de las actividades del niño, a la actividad de los cuentos
    public void cuentos(View view){
        inCuentos = new Intent(getApplicationContext(), cuentos.class);
        startActivityForResult(inCuentos,0);
        finish();
    }
}