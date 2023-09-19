/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sunat.gob.pe.medicalsystem.model.dao.impl.MedicoDaoImpl;
import sunat.gob.pe.medicalsystem.model.entities.Medico;

/**
 * FXML Controller class
 *
 * @author ZAMORA
 */
public class CitaController implements Initializable {

//    private Medico medicoActual = new Medico("", "",0L);
    @FXML
    private ComboBox<Medico> cbMedico;
    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtConsultorio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // ingresa en el combo un registro , el que se inicializó
        //cbMedico.valueProperty().bindBidirectional(medicoActual.getNombreB());
//        txtEspecialidad.textProperty().bindBidirectional(medicoActual.getCodigoEspecialidadB());
        cargarMedico();
        cbMedico.getSelectionModel().selectedItemProperty().addListener((ov, t, t1) -> {
            txtEspecialidad.setText(t1.getCodigoEspecialidad());
            txtConsultorio.setText(t1.getIdMedico().toString());
        });

    }

    private void cargarMedico() {

        cbMedico.getItems().addAll(new MedicoDaoImpl().listarNombreMedico(true));

    }

//    private void seleccionarElemento(Medico medicoNuevo) {
//        if (medicoNuevo == null) {
//            medicoActual = new Medico("", "");
//
//        } else {
//            medicoActual.setIdMedico(medicoNuevo.getIdMedico());
//            medicoActual.setNombre(medicoNuevo.getNombre());
//            medicoActual.setCodigoEspecialidad(medicoNuevo.getCodigoEspecialidad());
//        }
//
//    }
}
