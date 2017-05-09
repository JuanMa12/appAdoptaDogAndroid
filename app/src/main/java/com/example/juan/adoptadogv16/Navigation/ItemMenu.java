package com.example.juan.adoptadogv16.Navigation;

/**
 * Created by ADSI on 24/03/2015.
 */
public class ItemMenu {

    private String titulo;
    private int icono;

    public ItemMenu(String titulo, int icono) {
        this.titulo = titulo;
        this.icono  =   icono;

    }

    public String getTitulo() {
        return titulo;
    }

    public int getIcono() {
        return icono;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }
}
