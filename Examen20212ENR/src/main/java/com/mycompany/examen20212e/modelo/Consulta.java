package com.mycompany.examen20212e.modelo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Consulta implements Runnable {

    private final String origen, destino;
    private final double precio;

    private boolean consultando = true;

    private final Pane panelMapa;
    private final TextField recogida, llegada, oferta;
    
    public Consulta(TextField recogida, TextField llegada, TextField oferta, Pane panelMapa) {
        this.recogida = recogida;
        this.llegada = llegada;
        this.oferta = oferta;
        this.panelMapa = panelMapa;
        origen = recogida.getText();
        destino = llegada.getText();
        precio = Double.parseDouble(oferta.getText());
    }

    @Override
    public void run() {
        while (consultando) {
            Platform.runLater(() -> panelMapa.getChildren().clear());
            try {
                List<Conductor> conductores = Conductor.leerConductores();
                for (Conductor c : conductores) {
                    Ubicacion inicio = Ubicacion.obtenerGeoposicion(origen);
                    double distance = Ubicacion.calcularDistancia(inicio, c.getUbicacion());
                    if (distance <= 9) {
                        VBox conductorBox = new VBox();
                        File file = new File("datos/" + c.getNickname() + ".png");
                        ImageView pp = new ImageView(new Image(file.toURI().toString()));
                        pp.setFitHeight(50);
                        pp.setFitWidth(50);
                        Label nick = new Label(c.getNickname());
                        Label d = new Label("" + distance);
                        conductorBox.getChildren().addAll(pp, nick, d);
                        conductorBox.setOnMouseClicked((e) -> {
                            Carrera carr = new Carrera(origen, destino, precio);
                            c.setCarreraActual(carr);
                            panelMapa.getChildren().clear();
                            recogida.setText("");
                            llegada.setText("");
                            oferta.setText("");
                            Alert a = new Alert(AlertType.CONFIRMATION);
                            a.setTitle("");
                            a.setHeaderText("Confirmado");
                            a.setContentText("La carrera ha sido aceptada");
                            a.showAndWait();
                            consultando = false;
                        });
                        conductorBox.setLayoutX(c.getUbicacion().getX());
                        conductorBox.setLayoutY(c.getUbicacion().getY());
                        Platform.runLater(() -> panelMapa.getChildren().add(conductorBox));
                    }
                }
            } catch (InvalidArgumentException iae) {
                Alert a = new Alert(AlertType.ERROR);
                a.setTitle("");
                a.setHeaderText("ERROR");
                a.setContentText(iae.getMessage());
                a.showAndWait();
            } catch (IOException ex) {
            }
            try {
                Thread.sleep(40000);
            } catch (InterruptedException ex) {
            }
        }
    }

}
