/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sunat.gob.pe.medicalsystem.model.dao.impl.PacienteDaoImpl;
import sunat.gob.pe.medicalsystem.model.entities.Paciente;
import sunat.gob.pe.medicalsystem.model.utils.Utilitario;

/**
 * FXML Controller class
 *
 * @author ZAMORA
 */
public class PacienteController implements Initializable {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApMaterno;

    @FXML
    private TextField txtApPaterno;

    @FXML
    private TextField txtIdentidad;

    @FXML
    private DatePicker dpFechaNaci;

    @FXML
    private TableView<Paciente> pacienteTable;

    @FXML
    private TableColumn<Paciente, Long> idColumn;

    @FXML
    private TableColumn<Paciente, String> nroDocColum;

    @FXML
    private TableColumn<Paciente, String> nombreColumn;

    @FXML
    private TableColumn<Paciente, String> apPaternoColumn;

    @FXML
    private TableColumn<Paciente, String> apMaternoColumn;

    @FXML
    private TableColumn<Paciente, String> fNacimColumn;

    private final ObservableList<Paciente> listaPaciente = FXCollections.observableArrayList();

    private void Limpiar() {
        txtNombre.setText("");
        txtApMaterno.setText("");
        txtApPaterno.setText("");
        txtIdentidad.setText("");
        dpFechaNaci.getEditor().clear();
    }

    @FXML
    public void btnNuevo_OnAction() {
        Limpiar();
    }

    @FXML
    public void btnGuardar_OnAction() {
        if (txtIdentidad.getText().isEmpty()) {
            new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Nro. documento de paciente", Alert.AlertType.ERROR);
            txtIdentidad.requestFocus();
            return;
        }
        if (!Utilitario.isNumeric(txtIdentidad.getText())) {
            new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Nro. de documento numérico", Alert.AlertType.ERROR);
            txtIdentidad.requestFocus();
            return;
        }

        if (txtIdentidad.getText().length() != 8) {
            new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Nro. de documento de paciente de 8 digitos", Alert.AlertType.ERROR);
            txtIdentidad.requestFocus();
            return;
        }

        if (txtNombre.getText().isEmpty()) {
            new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Nombre", Alert.AlertType.ERROR);
            txtNombre.requestFocus();
            return;
        }

        if (txtApPaterno.getText().isEmpty()) {
            new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Apellido Paterno", Alert.AlertType.ERROR);
            txtApPaterno.requestFocus();
            return;
        }

        if (txtApMaterno.getText().isEmpty()) {
            new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Apellido Materno", Alert.AlertType.ERROR);
            txtApMaterno.requestFocus();
            return;
        }
        
        if (dpFechaNaci.getValue() == null) {
            new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Fecha de Nacimiento", Alert.AlertType.ERROR);
            dpFechaNaci.requestFocus();
            return;
        }

        Paciente paciente = new Paciente("01", txtIdentidad.getText(), txtNombre.getText(), txtApPaterno.getText(), txtApMaterno.getText(), dpFechaNaci.getValue().toString());
//        System.out.println("on()"+        dpFechaNaci.getValue());
        int resultado = new PacienteDaoImpl().guardarPaciente(paciente);
        if (resultado == 0) {
            ObtenerPacientes();
            Limpiar();
        } else {
            if (resultado == 2) {
                new Utilitario().MostrarAlerta("Duplicidad", new Utilitario().MostrarDescripcionError(resultado), Alert.AlertType.ERROR);
            }
        }

    }

    public void ObtenerPacientes() {
        listaPaciente.clear();
        pacienteTable.setItems(listaPaciente);
        PacienteDaoImpl pacienteImpl = new PacienteDaoImpl();

        listaPaciente.addAll(pacienteImpl.consultarPaciente(true));
        // te permite mostrar la informaciónd e la bd
        idColumn.setCellValueFactory(rowData -> rowData.getValue().getIdPaciente1());
        nroDocColum.setCellValueFactory(rowData -> rowData.getValue().getNumeroDocumento1());
        nombreColumn.setCellValueFactory(rowData -> rowData.getValue().getNombre1());
        apPaternoColumn.setCellValueFactory(rowData -> rowData.getValue().getApellidoPaterno1());
        apMaternoColumn.setCellValueFactory(rowData -> rowData.getValue().getApellidoMaterno1());
        fNacimColumn.setCellValueFactory(rowData -> rowData.getValue().getFechaNacimiento1());

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObtenerPacientes();
    }
}
