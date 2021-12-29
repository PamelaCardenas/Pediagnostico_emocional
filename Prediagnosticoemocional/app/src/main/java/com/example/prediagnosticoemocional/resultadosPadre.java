package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


//Pantalla en donde se van a mostrar todos los resultados del niño en la sección del padre
public class resultadosPadre extends AppCompatActivity implements View.OnClickListener{

    //Se crean las variables de los objetos
    Intent inRegresarPrincipal;
    TextView txtVwNomNino, txtVwNomPadre, txtVwEdadNino;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_padre);

        //Declarar las variables vinculandolas al id de los objetos del layout
        txtVwNomNino = (TextView)findViewById(R.id.txtVwNomNinoReusltado);
        txtVwNomPadre = (TextView)findViewById(R.id.txtVwNomPadreReusltado);
        txtVwEdadNino = (TextView)findViewById(R.id.txtVwEdadNinoReusltado);

        //Obtener y guardar el id del usuario que ingreso con el login, para mostrar el nombre y apellido del niño
        Bundle b = getIntent().getExtras();
        id= b.getInt("id");
        dao= new daoUsuario(this);
        u=dao.getUsuarioById(id);
        txtVwNomNino.setText(u.getNombreNino()+" "+u.getApellidoNino());
        txtVwEdadNino.setText(u.getEdadNino());
        txtVwNomPadre.setText(u.getNombrePadre()+" "+u.getApellidoPadre());
    }

    //Método para ir de la pantalla de los resultados del padre al menú principal
    public void regresarPrincipal(View view){
        inRegresarPrincipal = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(inRegresarPrincipal);
        finish();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

        }
    }
}