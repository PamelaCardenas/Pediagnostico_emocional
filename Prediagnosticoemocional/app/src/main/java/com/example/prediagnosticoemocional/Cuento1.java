package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class Cuento1 extends AppCompatActivity implements View.OnClickListener {

    public Button btnPlay, btnPausa, btnStop;
    public MediaPlayer mediaPlayer;
    TextView txtVwApeNino, txtVwNomNino;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuento1);

        //Declarar las variables vinculandolas al id de los objetos del layout
        txtVwNomNino = (TextView)findViewById(R.id.txtVwNomNinoCuentos);
        txtVwApeNino = (TextView)findViewById(R.id.txtVwApeNinoCuentos);

        dao=new daoUsuario(this);

        //Obtener y guardar el id del usuario que ingreso con el login, para mostrar el nombre y apellido del niño
        Bundle b = getIntent().getExtras();
        id= b.getInt("id");
        u=dao.getUsuarioById(id);

        //Se muestra el nombre del niño y el apellido en la pantalla
        //txtVwNomNino.setText(u.getNombreNino());
        //txtVwApeNino.setText(u.getApellidoPadre());

        //Inicializamos la clase MediaPlayer asociandole el fichero de Audio
        mediaPlayer = MediaPlayer.create(this, R.raw.manuelitafinal);

        //Obtenemos los tres botones de la interfaz
        btnPlay= (Button)findViewById(R.id.btnPlay);
        btnStop= (Button)findViewById(R.id.btnStop);
        btnPausa= (Button)findViewById(R.id.btnPausa);

        //Y les asignamos el controlador de eventos
        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnPausa.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //Comprobamos el identificador del boton que ha llamado al evento para ver
        //cual de los botones es y ejecutar la acción correspondiente
        switch(view.getId()){
            case R.id.btnPlay:
                //Iniciamos el audio
                mediaPlayer.start();
                break;
            case R.id.btnPausa:
                //Pausamos el audio
                mediaPlayer.pause();
                break;
            case R.id.btnStop:
                //Paramos el audio y volvemos a inicializar
                try {
                    mediaPlayer.stop();
                    mediaPlayer.prepare();
                    mediaPlayer.seekTo(0);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}