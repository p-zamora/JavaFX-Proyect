/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import sunat.gob.pe.medicalsystem.App;

/**
 * FXML Controller class
 *
 * @author ZAMORA
 */
public class LoginController {

    @FXML
    public void btnIngresar() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("dashboard.fxml"));
            Parent dashboard = loader.load();
            App.scene.setRoot(dashboard);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
