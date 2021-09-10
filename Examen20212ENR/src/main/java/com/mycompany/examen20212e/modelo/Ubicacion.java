/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen20212e.modelo;

/**
 *
 * @author rocio
 */
public class Ubicacion {
    private double x;
    private double y;

    public Ubicacion(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    public static double calcularDistancia(Ubicacion u1, Ubicacion u2){
        return Math.round(Math.sqrt(Math.pow(u2.x-u1.x, 2)+Math.pow(u2.y-u1.y, 2))/10);
    }
    
    public static Ubicacion obtenerGeoposicion(String direccion){
        if(direccion.toUpperCase().equals("ESPOL")){
            return new Ubicacion(200,150);
        }else{
            return new Ubicacion(300,200);
        }
    }

    @Override
    public String toString() {
        return "(" + x + ',' + y + ')';
    }
    
    
}
