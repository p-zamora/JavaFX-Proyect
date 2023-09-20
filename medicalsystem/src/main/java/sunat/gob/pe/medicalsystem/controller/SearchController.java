/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import sunat.gob.pe.medicalsystem.model.dao.impl.CitaDaoImpl;
import sunat.gob.pe.medicalsystem.model.entities.Cita;
import sunat.gob.pe.medicalsystem.model.utils.Utilitario;

/**
 * FXML Controller class
 *
 * @author ZAMORA
 */
public class SearchController implements Initializable {

    @FXML
    private RadioButton rbDocIdentidad;

    @FXML
    private RadioButton rbNroCita;

    @FXML
    private TextField txtCita;

    @FXML
    private TextField txtIdentidad;

    @FXML
    private TableView<Cita> pacienteBusqTable;

    @FXML
    private TableColumn<Cita, Long> idColumn;

    @FXML
    private TableColumn<Cita, String> fechaColumn;

    @FXML
    private TableColumn<Cita, String> horaColumn;

    @FXML
    private TableColumn<Cita, String> asuntoColumn;

    @FXML
    private TableColumn<Cita, String> medicoColumn;

    @FXML
    private TableColumn<Cita, String> pacienteColumn;
    
    @FXML
    private TableColumn<Cita, String> consultorioColumn;

    @FXML
    private TableColumn<Cita, String> estadoColumn;

    private final ObservableList<Cita> listaCita = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        rbNroCita.setToggleGroup(group);
        rbDocIdentidad.setToggleGroup(group);
    }

    @FXML
    public void rbNroCita_OnAction() {
        txtIdentidad.setText("");
        txtIdentidad.setEditable(false);
        txtCita.setEditable(true);
        listaCita.clear();
    }

    @FXML
    public void rbDocIdentidad_OnAction() {
        txtCita.setText("");
        txtCita.setEditable(false);
        txtIdentidad.setEditable(true);
        listaCita.clear();
    }

    @FXML
    public void btnBuscar_OnAction() {
        if (rbNroCita.isSelected()) {
            if (txtCita.getText().isEmpty()) {
                new Utilitario().MostrarAlerta("Nro. Cita", "Debe ingresar Nro. de Cita del paciente", Alert.AlertType.ERROR);
                txtCita.requestFocus();
                return;
            }

            if (!Utilitario.isNumeric(txtCita.getText())) {
                new Utilitario().MostrarAlerta("Nro. Cita", "Debe ingresar Nro. de cita numérico", Alert.AlertType.ERROR);
                txtCita.requestFocus();
                return;
            }

            listaCita.clear();
            pacienteBusqTable.setItems(listaCita);
            Cita cita = new CitaDaoImpl().consultarCitaPorId(Long.valueOf(txtCita.getText()), true);
            if (cita != null) {
                listaCita.addAll(cita);

                idColumn.setCellValueFactory(rowData -> rowData.getValue().getIdCitaB());

                fechaColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaB());
                horaColumn.setCellValueFactory(rowData -> rowData.getValue().getHoraB());
                asuntoColumn.setCellValueFactory(rowData -> rowData.getValue().getAsuntoB());
                medicoColumn.setCellValueFactory(rowData -> rowData.getValue().getNombreMedicoB());
                pacienteColumn.setCellValueFactory(rowData -> rowData.getValue().getNombrePacienteB());
                consultorioColumn.setCellValueFactory(rowData -> rowData.getValue().getConsultorioB());
                estadoColumn.setCellValueFactory(rowData -> rowData.getValue().getEstadoB());
            }

        } else {
            if (txtIdentidad.getText().isEmpty()) {
                new Utilitario().MostrarAlerta("Doc. de Identidad", "Debe ingresar Nro. de identidad del paciente", Alert.AlertType.ERROR);
                txtIdentidad.requestFocus();
                return;
            }

            if (!Utilitario.isNumeric(txtIdentidad.getText())) {
                new Utilitario().MostrarAlerta("Doc. de Identidad", "Debe ingresar Nro. de identidad numérico", Alert.AlertType.ERROR);
                txtIdentidad.requestFocus();
                return;
            }

            listaCita.clear();
            pacienteBusqTable.setItems(listaCita);
            System.out.println(txtIdentidad.getText());
            List<Cita> listaCitas = new CitaDaoImpl().consultarCitaPorDNI(txtIdentidad.getText(), true);
            if (!listaCitas.isEmpty()) {
                listaCita.addAll(listaCitas);

                idColumn.setCellValueFactory(rowData -> rowData.getValue().getIdCitaB());

                fechaColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaB());
                horaColumn.setCellValueFactory(rowData -> rowData.getValue().getHoraB());
                asuntoColumn.setCellValueFactory(rowData -> rowData.getValue().getAsuntoB());
                medicoColumn.setCellValueFactory(rowData -> rowData.getValue().getNombreMedicoB());
                pacienteColumn.setCellValueFactory(rowData -> rowData.getValue().getNombrePacienteB());
                consultorioColumn.setCellValueFactory(rowData -> rowData.getValue().getConsultorioB());
                estadoColumn.setCellValueFactory(rowData -> rowData.getValue().getEstadoB());
            }
        }
    }

}
