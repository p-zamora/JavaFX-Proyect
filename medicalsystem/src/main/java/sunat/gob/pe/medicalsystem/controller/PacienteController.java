/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
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
    Paciente pacienteTmp = new Paciente(0L, "", "", "", "", "", "");;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObtenerPacientes();
//        pacienteTmp.setNombre("");
    }

    private void Limpiar() {
        txtNombre.setText("");
        txtApMaterno.setText("");
        txtApPaterno.setText("");
        txtIdentidad.setText("");
        dpFechaNaci.getEditor().clear();
        pacienteTmp  = new Paciente(0L, "", "", "", "", "", "");;
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

        int resultado = new PacienteDaoImpl().guardarPaciente(paciente);
        if (resultado == 0) {
            Limpiar();
            ObtenerPacientes();
            new Utilitario().MostrarAlerta("Paciente", "Se registró correctamente", Alert.AlertType.ERROR);
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

    @FXML
    public void pacienteTable_OnMouseClicked(MouseEvent evnt) {
        if (evnt.getClickCount() == 2) {
            TableView.TableViewSelectionModel<Paciente> selectionModel = pacienteTable.getSelectionModel();
            List<Paciente> selectedItems = selectionModel.getSelectedItems();
//            long idpaciente=selectedItems.get(0).getIdPaciente();
//            System.out.println("sunat"+idpaciente);
            txtIdentidad.setText(selectedItems.get(0).getNumeroDocumento());
            txtNombre.setText(selectedItems.get(0).getNombre());
            txtApPaterno.setText(selectedItems.get(0).getApellidoPaterno());
            txtApMaterno.setText(selectedItems.get(0).getApellidoMaterno());
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            System.out.println("fecha)"+LocalDate.parse(selectedItems.get(0).getFechaNacimiento(), dateFormatter));
            dpFechaNaci.setValue(LocalDate.MIN);
//            dpFechaNaci.getEditor().clear();
            dpFechaNaci.setValue(LocalDate.parse(selectedItems.get(0).getFechaNacimiento(), dateFormatter));
            pacienteTmp = new Paciente(0L, "", "", "", "", "", "");
            pacienteTmp.setIdPaciente(selectedItems.get(0).getIdPaciente());
        }
    }

    @FXML
    public void btnActualizar_OnAction() {
        if (pacienteTmp.getIdPaciente() == 0L) {
            new Utilitario().MostrarAlerta("Paciente", "Debe seleccionar un paciente", Alert.AlertType.ERROR);
            return;
        }
        
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
        System.out.println("on()" + dpFechaNaci.getValue());
//1er ErrorData truncation: Incorrect date value: '20-09-2023' for column 'fechaNacimiento' at row 1
//        pacienteTmp.setIdPaciente(selectedItems.get(0).getIdPaciente());
        pacienteTmp.setNumeroDocumento(txtIdentidad.getText());
        pacienteTmp.setNombre(txtNombre.getText());
        pacienteTmp.setApellidoPaterno(txtApPaterno.getText());
        pacienteTmp.setApellidoMaterno(txtApMaterno.getText());
        pacienteTmp.setFechaNacimiento(dpFechaNaci.getValue().toString());

        if (pacienteTmp.getIdPaciente() != 0L) {
            System.out.println("actualziar()");
            int resultado = new PacienteDaoImpl().actualizarPaciente(pacienteTmp);
            if (resultado == 0) {
                ObtenerPacientes();
                Limpiar();
                new Utilitario().MostrarAlerta("Paciente", "Se actualizó correctamente", Alert.AlertType.ERROR);
            } else {
                if (resultado == 2) {
                    new Utilitario().MostrarAlerta("Duplicidad", new Utilitario().MostrarDescripcionError(resultado), Alert.AlertType.ERROR);
                }
            }
        } else {
            new Utilitario().MostrarAlerta("Paciente", "Seleccione un registro", Alert.AlertType.ERROR);
        }

    }
}
