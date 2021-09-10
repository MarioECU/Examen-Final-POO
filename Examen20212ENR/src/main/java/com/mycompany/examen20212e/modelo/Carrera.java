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
public class Carrera {
    private String origen;
    private String destino;
    private double precio;
    public Carrera(String origen, String destino, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
    }
    public String getOrigen() {
        return origen;
    }
    public String getDestino() {
        return destino;
    }
    public double getPrecio() {
        return precio;
    }
}
