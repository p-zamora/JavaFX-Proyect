/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import sunat.gob.pe.medicalsystem.App;

/**
 * FXML Controller class
 *
 * @author ZAMORA
 */
public class MenuController {

    @FXML
    private Button btnDashboard;
    @FXML
    private Button btnPaciente;
    @FXML
    private Button btnSepararCita;
    @FXML
    private Button btnConsultarCita;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        btnDashboard.setOnAction(this::irDashboard);
        btnPaciente.setOnAction(this::irPaciente);
        btnSepararCita.setOnAction(this::irSepararCita);
        btnConsultarCita.setOnAction(this::irConsultarCita);
    }

    @FXML
    public void irDashboard(ActionEvent event) {
        try {
            System.out.println("Ingreso al dashboard");
            FXMLLoader loader = new FXMLLoader(App.class.getResource("dashboard.fxml"));
            Parent dashboard = loader.load();

//            DashboardController dashboardController = loader.<DashboardController>getController();

            App.scene.setRoot(dashboard);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    @FXML
    public void irPaciente(ActionEvent event) {
        try {
            System.out.println("Ingreso al paciente");
            App.scene.setRoot(App.loadFXML("paciente"));
//            FXMLLoader loader = new FXMLLoader(App.class.getResource("paciente.fxml"));
//            Parent Opcionpaciente = loader.load();
//            PacienteController pacienteController =loader.<PacienteController>getController();
////            pacienteController.ObtenerPacientes();
//            
//            App.scene.setRoot(Opcionpaciente);
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    @FXML
    public void irSepararCita(ActionEvent event) {
        try {
            System.out.println("Ingreso a la cita");
            App.scene.setRoot(App.loadFXML("cita"));
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    @FXML
    public void irConsultarCita(ActionEvent event) {
        try {
            System.out.println("Ingreso a la consulta");
            App.scene.setRoot(App.loadFXML("search"));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
