package com.example.ricardo.santafesacho;


/* Created by Ricardo on 29/03/2017.
        */

public class FestivalesC {
    private int idImagen;
    private String nombre,fecha,descripcion;

    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public FestivalesC(int idImagen, String nombre, String fecha, String descripcion) {
        this.idImagen = idImagen;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}