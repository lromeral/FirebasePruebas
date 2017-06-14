package com.foromtb.luroga.firebasepruebas.modelo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by LuisR on 11/06/2017.
 */

public class Puerto {
    private String nombre;
    private String descripcion;
    private float valoracion;
    private double loc_latitud;
    private double loc_longitud;
    private double loc_altura;


    public Puerto() {
    }

    public Puerto(String nombre, String descripcion, float valoracion, double loc_latitud, double loc_longitud, double loc_altura) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.valoracion = valoracion;
        this.loc_latitud = loc_latitud;
        this.loc_longitud = loc_longitud;
        this.loc_altura = loc_altura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public double getLoc_latitud() {
        return loc_latitud;
    }

    public void setLoc_latitud(double loc_latitud) {
        this.loc_latitud = loc_latitud;
    }

    public double getLoc_longitud() {
        return loc_longitud;
    }

    public void setLoc_longitud(double loc_longitud) {
        this.loc_longitud = loc_longitud;
    }

    public double getLoc_altura() {
        return loc_altura;
    }

    public void setLoc_altura(double loc_altura) {
        this.loc_altura = loc_altura;
    }


public Map<String,Object> toMap (){

    Map <String,Object> resultado = new HashMap<String, Object>();
    resultado.put("nombre", this.nombre);
    resultado.put("descripcion", this.descripcion);
    resultado.put("valoracion", this.valoracion);
    resultado.put ("locLongitud", this.loc_longitud);
    resultado.put("locLatitud", this.loc_latitud);
    resultado.put ("locAltura", this.loc_altura);

    return resultado;
}
}