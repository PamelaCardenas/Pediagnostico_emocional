package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Pantalla para realizar el registro a la aplicacion
public class Registro extends AppCompatActivity implements View.OnClickListener{

    //Se crean las variables de los objetos
    Intent inRegresarPrincipal;
    EditText usrRegPadre, passRegPadre, nomRegPadre, apRegPadre, nomRegNino,apRegNino, edadRegNino;
    Button btnRegistro, btnRegresarRegPrincipal;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        //Declarar las variables vinculandolas al id de los objetos del layout
        usrRegPadre=(EditText)findViewById(R.id.edTxtUsuarioRegPadre);
        passRegPadre=(EditText)findViewById(R.id.edTxtContraseñaRegPadre);
        nomRegPadre=(EditText)findViewById(R.id.edTxtNombreRegPadre);
        apRegPadre=(EditText)findViewById(R.id.edTxtApellidoRegPadre);
        nomRegNino=(EditText)findViewById(R.id.edTxtNombreRegNiño);
        apRegNino=(EditText)findViewById(R.id.edTxtApellidoRegNiño);
        edadRegNino=(EditText)findViewById(R.id.edTxtEdadRegNiño);
        btnRegistro=(Button)findViewById(R.id.btnRegistrar);
        btnRegresarRegPrincipal=(Button)findViewById(R.id.btnRegresarRegPrincipal);

        //Declarar eventos onClick al presionar un boton
        btnRegistro.setOnClickListener(this);
        btnRegresarRegPrincipal.setOnClickListener(this);

        dao = new daoUsuario(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistrar:
                Usuario u = new Usuario();
                //Se obtiene cada uno de los valores de los EditText
                u.setNombreNino(nomRegNino.getText().toString());
                u.setApellidoNino(apRegNino.getText().toString());
                u.setEdadNino(edadRegNino.getText().toString());
                u.setNombrePadre(nomRegPadre.getText().toString());
                u.setApellidoPadre(apRegPadre.getText().toString());
                u.setUsuarioPadre(usrRegPadre.getText().toString());
                u.setPasswordPadre(passRegPadre.getText().toString());

                //Desiciones por si se inserta o no correctamente el usuario
                //Si el usuario esta vacio (Nulo), significa que no se almaceno nada, es decir un error por los campos vacios
                if(!u.isNull()){
                    Toast.makeText(this,"ERROR! Campos vacíos", Toast.LENGTH_LONG).show();
                    //Si ingresaron datos, se almacenan (registran) en la tabla de los usuarios
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this,"Registro exitoso", Toast.LENGTH_LONG).show();
                    inRegresarPrincipal = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(inRegresarPrincipal);
                    finish();

                    //Si no sucede nada de eso, significa que el usuario ya fue registrado
                }else{
                    Toast.makeText(this,"Usuario ya registrado", Toast.LENGTH_LONG).show();
                }

                break;

            //Se regresa a la pantalla anterior, el menú principal
            case R.id.btnRegresarRegPrincipal:
                inRegresarPrincipal = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(inRegresarPrincipal);
                finish();
                break;
        }
    }
}