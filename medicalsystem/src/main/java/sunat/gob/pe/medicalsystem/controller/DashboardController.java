/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sunat.gob.pe.medicalsystem.model.utils.Utilitario;

/**
 * FXML Controller class
 *
 * @author ZAMORA
 */
public class DashboardController {

    @FXML
    private Label lbBienvenida;

    public void cambiarUsuario() {
        this.lbBienvenida.setText("Bienvenido, "+ Utilitario.usuario.getNombre());
    }
}
