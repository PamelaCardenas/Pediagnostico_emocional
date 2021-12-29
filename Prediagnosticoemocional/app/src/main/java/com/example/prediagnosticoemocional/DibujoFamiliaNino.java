package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.prediagnosticoemocional.display.colorList;
import static com.example.prediagnosticoemocional.display.current_brush;
import static com.example.prediagnosticoemocional.display.pathList;

//Pantalla tipo paint, donde el niño podrá dibujar a la familia, para definir un diagnostico

public class DibujoFamiliaNino extends AppCompatActivity implements View.OnClickListener{

    //Se crean las variables de los objetos
    Intent inRegresarActividadesNino;
    public static Path path = new Path();
    public static Paint paint_brush = new Paint();
    ConstraintLayout areaDibujo;
    TextView txtVwApeNino, txtVwNomNino;
    ResultadosDibujo rd;
    Button btnDibujoListo, btnRegresarActividades;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo_familia_nino);

        //Declarar las variables vinculandolas al id de los objetos del layout
        txtVwNomNino = (TextView)findViewById(R.id.txtVwNomNinoDibujo);
        txtVwApeNino = (TextView)findViewById(R.id.txtVwApeNinoDibujo);
        btnDibujoListo = (Button)findViewById(R.id.btndibujoListo);
        btnRegresarActividades=(Button)findViewById(R.id.btnRegresarActividades);
        areaDibujo=(ConstraintLayout)findViewById(R.id.areaDibujo);
        dao=new daoUsuario(this);

        //Obtener y guardar el id del usuario que ingreso con el login, para mostrar el nombre y apellido del niño
        Bundle b = getIntent().getExtras();
        id= b.getInt("id");
        u=dao.getUsuarioById(id);
        txtVwNomNino.setText(u.getNombreNino());
        txtVwApeNino.setText(u.getApellidoNino());
    }

    //Se define el lapiz, con color negro, como principal
    public void pencil(View view) {
        paint_brush.setColor(Color.BLACK);
        currentColor(paint_brush.getColor());
    }

    //Se define el borrador, que una vez que se borrara todo de la pantalla
    public void borrador(View view) {
        pathList.clear();
        colorList.clear();
        path.reset();
    }

    //Al seleccionar el boton rojo, el lapiz se va a definir a rojo
    public void redColor(View view) {
        paint_brush.setColor(Color.RED);
        currentColor(paint_brush.getColor());
    }

    //Al seleccionar el boton amarillo, el lapiz se va a definir a amarillo
    public void yelloColor(View view) {
        paint_brush.setColor(Color.YELLOW);
        currentColor(paint_brush.getColor());
    }

    //Al seleccionar el boton azul, el lapiz se va a definir a azul
    public void blueColor(View view) {
        paint_brush.setColor(Color.BLUE);
        currentColor(paint_brush.getColor());
    }

    //Al seleccionar el boton verde, el lapiz se va a definir a verde
    public void greenColor(View view) {
        paint_brush.setColor(Color.GREEN);
        currentColor(paint_brush.getColor());
    }

    //Al seleccionar el boton negro, el lapiz se va a definir a negro
    public void blackColor(View view) {
        paint_brush.setColor(Color.BLACK);
        currentColor(paint_brush.getColor());
    }

    //Metodo para generar otro nuevo pincel luego de cada vez que se cambia de color
    public void currentColor(int c){
        current_brush = c;
        path = new Path();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btndibujoListo:

                /*ResultadosDibujo rd = new ResultadosDibujo();
                //Se inserta cada uno de los valores a la tabla
                rd.setNombreNino(u.getNombreNino());
                rd.setApellidoNino(u.getApellidoNino());
                rd.setUsuarioPadre(u.getUsuarioPadre());
                rd.setDibujoImagenNino(v.draw(canvas));

                areaDibujo.setDrawingCacheEnabled(true);


                Toast.makeText(this,"Dibujo Guardado", Toast.LENGTH_LONG).show();*/

                break;

            //Metodo en donde se va a regresar de la pantalla del dibujo a las actividades
            case R.id.btnRegresarActividades:
                //Se guardan en variables los datos almacenados del niño
                String nN = txtVwNomNino.getText().toString();
                String aN = txtVwApeNino.getText().toString();
                Usuario ux = dao.getUsuarioNino(nN,aN);

                //Se llama un intento para regresar al activity de las actividades y se pasa el id del usuario que inicio sesion
                inRegresarActividadesNino = new Intent(getApplicationContext(), Actividades_Nino.class);
                inRegresarActividadesNino.putExtra("id", ux.getId());
                startActivity(inRegresarActividadesNino);
                finish();
                break;
        }
    }

    /*public byte[] hacerBitmapdeView(View view){

        //Define a bitmap with the same size as the view
        Bitmap returnedBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(),Bitmap.Config.ARGB_8888);
        //Bind a canvas to it
        Canvas canvas = new Canvas(returnedBitmap);
        //Get the view's background
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            //has background drawable, then draw it on the canvas
            bgDrawable.draw(canvas);
        else
            //does not have background drawable, then draw white background on the canvas
            canvas.drawColor(Color.WHITE);
        // draw the view on the canvas
        view.draw(canvas);
        //return the bitmap
        return returnedBitmap;
    }*/
}