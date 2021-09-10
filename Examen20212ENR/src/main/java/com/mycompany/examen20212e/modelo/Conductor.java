/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.examen20212e.modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rocio
 */
public class Conductor {
    private String nickname;
    private Ubicacion ubicacion;
    private Carrera carreraActual;

    public Conductor(String nickname, Ubicacion ubicacion) {
        this.nickname = nickname;
        this.ubicacion = ubicacion;
    }

    public String getNickname() {
        return nickname;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public Carrera getCarreraActual() {
        return carreraActual;
    }

    public void setCarreraActual(Carrera carreraActual) {
        this.carreraActual = carreraActual;
    }
    
    public static List<Conductor> leerConductores() throws IOException{
        List<Conductor> conductores = new ArrayList<>();
        List<String> lines = Files.readAllLines(Paths.get("datos/conductores.txt"));
        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length != 3)
                throw new InvalidArgumentException();
            Ubicacion ub = new Ubicacion(Double.parseDouble(data[1]),
                                        Double.parseDouble(data[2]));
            Conductor c = new Conductor(data[0], ub);
            conductores.add(c);
        }
        return conductores;
    }

    @Override
    public String toString() {
        return nickname + ", Ubicacion: " + ubicacion;
    }
    
    
}
