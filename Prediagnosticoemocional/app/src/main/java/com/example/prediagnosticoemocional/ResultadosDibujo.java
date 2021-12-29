package com.example.prediagnosticoemocional;

import java.util.Arrays;


//Clase para definir las variables que se reciben de entrada cuando se almacena el dibujo que creo el niño
public class ResultadosDibujo {

    int id;
    String NombreNino, ApellidoNino, UsuarioPadre;
    byte[] DibujoImagenNino;

    public ResultadosDibujo() {

    }

    public ResultadosDibujo(String nombreNino, String apellidoNino, String usuarioPadre, byte[] dibujoImagenNino) {
        NombreNino = nombreNino;
        ApellidoNino = apellidoNino;
        UsuarioPadre = usuarioPadre;
        DibujoImagenNino = dibujoImagenNino;
    }

    public boolean isNull(){
        if(NombreNino.equals("")&&ApellidoNino.equals("")&&UsuarioPadre.equals("")&&DibujoImagenNino.equals("")) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "ResultadosDibujo{" +
                "id=" + id +
                ", NombreNino='" + NombreNino + '\'' +
                ", ApellidoNino='" + ApellidoNino + '\'' +
                ", UsuarioPadre='" + UsuarioPadre + '\'' +
                ", DibujoImagenNino=" + Arrays.toString(DibujoImagenNino) +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreNino() {
        return NombreNino;
    }

    public void setNombreNino(String nombreNino) {
        NombreNino = nombreNino;
    }

    public String getApellidoNino() {
        return ApellidoNino;
    }

    public void setApellidoNino(String apellidoNino) {
        ApellidoNino = apellidoNino;
    }

    public String getUsuarioPadre() {
        return UsuarioPadre;
    }

    public void setUsuarioPadre(String usuarioPadre) {
        UsuarioPadre = usuarioPadre;
    }

    public byte[] getDibujoImagenNino() {
        return DibujoImagenNino;
    }

    public void setDibujoImagenNino(byte[] dibujoImagenNino) {
        DibujoImagenNino = dibujoImagenNino;
    }
}
