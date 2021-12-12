package com.example.prediagnosticoemocional;

//Clase para definir las variables que se reciben de entrada en la pantalla de registro
public class Usuario {

    int id;
    String NombrePadre, ApellidoPadre, NombreNino, ApellidoNino, PasswordPadre, EdadNino, UsuarioPadre;

    public Usuario() {

    }

    public Usuario(String nombreNino, String apellidoNino, String edadNino, String nombrePadre, String apellidoPadre, String usuarioPadre, String passwordPadre) {
        NombreNino = nombreNino;
        ApellidoNino = apellidoNino;
        EdadNino = edadNino;
        NombrePadre = nombrePadre;
        ApellidoPadre = apellidoPadre;
        UsuarioPadre = usuarioPadre;
        PasswordPadre = passwordPadre;
    }

    public boolean isNull(){
        if(NombreNino.equals("")&&ApellidoNino.equals("")&&EdadNino.equals("")&&NombrePadre.equals("")&&ApellidoPadre.equals("")&&UsuarioPadre.equals("")&&PasswordPadre.equals("")) {
            return false;
        }else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", NombrePadre='" + NombrePadre + '\'' +
                ", ApellidoPadre='" + ApellidoPadre + '\'' +
                ", NombreNino='" + NombreNino + '\'' +
                ", ApellidoNino='" + ApellidoNino + '\'' +
                ", PasswordPadre='" + PasswordPadre + '\'' +
                ", EdadNino='" + EdadNino + '\'' +
                ", UsuarioPadre='" + UsuarioPadre + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePadre() {
        return NombrePadre;
    }

    public void setNombrePadre(String nombrePadre) {
        NombrePadre = nombrePadre;
    }

    public String getApellidoPadre() {
        return ApellidoPadre;
    }

    public void setApellidoPadre(String apellidoPadre) {
        ApellidoPadre = apellidoPadre;
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

    public String getPasswordPadre() {
        return PasswordPadre;
    }

    public void setPasswordPadre(String passwordPadre) {
        PasswordPadre = passwordPadre;
    }

    public String getEdadNino() { return EdadNino; }

    public void setEdadNino(String edadNino) {
        EdadNino = edadNino;
    }

    public String getUsuarioPadre() {
        return UsuarioPadre;
    }

    public void setUsuarioPadre(String usuarioPadre) {
        UsuarioPadre = usuarioPadre;
    }
}
