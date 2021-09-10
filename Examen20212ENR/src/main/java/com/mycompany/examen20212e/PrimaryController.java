package com.mycompany.examen20212e;

import com.mycompany.examen20212e.modelo.Consulta;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class PrimaryController implements Initializable{

    
    @FXML
    private Pane panelMapa;
    
    @FXML
    private Button consultar;
    
    @FXML
    private TextField recogida, llegada, oferta;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        consultar.setOnAction((e) -> {
            Consulta c = new Consulta(recogida, llegada, oferta, panelMapa);
            Thread t = new Thread(c);
            t.start();
        });
    } 
    
}
