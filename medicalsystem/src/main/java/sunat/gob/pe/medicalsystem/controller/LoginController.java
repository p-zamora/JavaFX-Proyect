/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sunat.gob.pe.medicalsystem.App;
import sunat.gob.pe.medicalsystem.model.dao.impl.UsuarioDaoImpl;
import sunat.gob.pe.medicalsystem.model.entities.Usuario;
import sunat.gob.pe.medicalsystem.model.utils.Utilitario;

/**
 * FXML Controller class
 *
 * @author ZAMORA
 */
public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Button btningresar;

    @FXML
    public void btnIngresar() {
        try {
            if (txtUsuario.getText().isEmpty()) {
                new Utilitario().MostrarAlerta("Usuario", "Debe ingrsar un usuario.", Alert.AlertType.ERROR);
                txtUsuario.requestFocus();
                return;
            }
            if (txtPassword.getText().isEmpty()) {
                new Utilitario().MostrarAlerta("Paswword", "Debe ingrsar un password.", Alert.AlertType.ERROR);
                txtPassword.requestFocus();
                return;
            }
            //id_btningresar.getScene().getWindow().hide();
            //App.scene.getWindow().hide();

            Usuario usuario = new UsuarioDaoImpl().consultarUsuarioPorNombre(txtUsuario.getText().toUpperCase(), txtPassword.getText(), true);
            if (usuario == null) {
                new Utilitario().MostrarAlerta("Sistema Mecical Enterprice", "Credenciales incorrectos o Usuario no existe.", Alert.AlertType.ERROR);
            } else {
                Utilitario.usuario=usuario;
                FXMLLoader loader = new FXMLLoader(App.class.getResource("dashboard.fxml"));
                Parent dashboard = loader.load();
                DashboardController dashboardController = loader.<DashboardController>getController();
                dashboardController.cambiarUsuario();
                //Stage stage = new Stage();
                //Scene scene = new Scene(dashboard);

                //stage.setScene(scene);
                //stage.setResizable(false);
                //stage.setMaximized(false);
                //stage.show();
                App.scene.setRoot(dashboard);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

}
