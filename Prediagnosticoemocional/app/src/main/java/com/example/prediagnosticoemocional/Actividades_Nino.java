package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//Pantalla para mostrar las diferentes actividades que puede realizar el niño

public class Actividades_Nino extends AppCompatActivity {

    //Se crean las variables de los objetos
    Intent inRegresarPrincipal, inDibujaFam, inCuentos, inPreguntas;
    TextView txtVwApeNinoAct, txtVwNomNinoAct;
    int id=0;
    Usuario u;
    EditText nomNino, apNino;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividades__nino);

        //Declarar las variables vinculandolas al id de los objetos del layout
        txtVwNomNinoAct = (TextView)findViewById(R.id.txtVwNomNinoActividades);
        txtVwApeNinoAct = (TextView)findViewById(R.id.txtVwApeNinoActividades);


        nomNino=(EditText)findViewById(R.id.edTxtUserLogNino);
        apNino=(EditText)findViewById(R.id.edTxtApellidoNino);

        //Obtener y guardar el id del usuario que ingreso con el login, para mostrar el nombre y apellido del niño
        Bundle b = getIntent().getExtras();
        id= b.getInt("id");
        dao= new daoUsuario(this);
        u=dao.getUsuarioById(id);

        //Se muestra el nombre del niño y el apellido en la pantalla
        txtVwNomNinoAct.setText(u.getNombreNino());
        txtVwApeNinoAct.setText(u.getApellidoNino());

    }

    //Método para regresar de la pantalla de las actividades del niño, al menú principal
    public void regresarPrincipal(View view){
        inRegresarPrincipal = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(inRegresarPrincipal);
        finish();
    }

    //Método para pasar de la pantalla de las actividades del niño, a la actividad de dibujar a la familia
    public void dibujaFamilia(View view){

        //Se guardan en variables los datos almacenados del niño
        String nN = txtVwNomNinoAct.getText().toString();
        String aN = txtVwApeNinoAct.getText().toString();
        Usuario ux = dao.getUsuarioNino(nN, aN);

        //Se llama un intento para abrir la nueva activity del Dibujo y se pasa el id del usuario que inicio sesion
        inDibujaFam = new Intent(getApplicationContext(), DibujoFamiliaNino.class);
        inDibujaFam.putExtra("id", ux.getId());
        startActivity(inDibujaFam);
        finish();
    }

    //Método para pasar de la pantalla de las actividades del niño, a la actividad de los cuentos
    public void cuentos(View view){

        //Se guardan en variables los datos almacenados del niño
        String nN = txtVwNomNinoAct.getText().toString();
        String aN = txtVwApeNinoAct.getText().toString();
        Usuario ux = dao.getUsuarioNino(nN, aN);

        //Se llama un intento para abrir la nueva activity de los cuentos y se pasa el id del usuario que inicio sesion
        inCuentos = new Intent(getApplicationContext(), cuentos.class);
        inCuentos.putExtra("id", ux.getId());
        startActivity(inCuentos);
        finish();
    }

    //Método para pasar de la pantalla de las actividades del niño, a la actividad de las preguntas
    public void preguntas(View view){

        //Se guardan en variables los datos almacenados del niño
        String nN = txtVwNomNinoAct.getText().toString();
        String aN = txtVwApeNinoAct.getText().toString();
        Usuario ux = dao.getUsuarioNino(nN, aN);

        //Se llama un intento para abrir la nueva activity de las preguntas y se pasa el id del usuario que inicio sesion
        inPreguntas = new Intent(getApplicationContext(), TestPreguntas.class);
        inPreguntas.putExtra("id", ux.getId());
        startActivity(inPreguntas);
        finish();
    }
}