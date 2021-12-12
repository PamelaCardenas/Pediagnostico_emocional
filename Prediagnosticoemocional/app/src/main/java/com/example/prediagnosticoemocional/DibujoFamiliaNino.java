package com.example.prediagnosticoemocional;

import androidx.appcompat.app.AppCompatActivity;

//Pantalla tipo paint, donde el niño podrá dibujar a la familia, para definir un diagnostico

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;

import static com.example.prediagnosticoemocional.display.colorList;
import static com.example.prediagnosticoemocional.display.current_brush;
import static com.example.prediagnosticoemocional.display.pathList;

public class DibujoFamiliaNino extends AppCompatActivity {

    Intent inRegresarActividadesNino;
    public static Path path = new Path();
    public static Paint paint_brush = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dibujo_familia_nino);
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

    public void currentColor(int c){
        current_brush = c;
        path = new Path();
    }

    //Metodo en donde se va a regresar de la pantalla del dibujo a la familiar
    public void regresarActividadesNino(View view){
        inRegresarActividadesNino = new Intent(getApplicationContext(), Actividades_Nino.class);
        startActivityForResult(inRegresarActividadesNino,0);
        finish();
    }
}