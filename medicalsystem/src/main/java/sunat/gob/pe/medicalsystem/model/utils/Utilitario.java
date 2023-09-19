/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.utils;

import javafx.scene.control.Alert;
import sunat.gob.pe.medicalsystem.model.entities.Usuario;

/**
 *
 * @author ssamanamudr
 */
public class Utilitario {

    public static Usuario usuario;

    public void MostrarAlerta(String titulo, String mensaje, Alert.AlertType alertt) {
        Alert alert = new Alert(alertt);
        alert.setTitle(titulo);

        // Header Text: null
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }

    public String MostrarDescripcionError(int error) {
        String err;
        switch (error) {
            case 1:
                err = "ERROR";
                break;
            case 2:
                err = "Registro duplicado";
                break;
            default:
                err = "ERROR";
        }
        return err;
    }

    public static boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
