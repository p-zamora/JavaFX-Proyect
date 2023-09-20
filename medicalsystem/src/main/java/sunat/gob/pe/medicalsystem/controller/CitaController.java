/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package sunat.gob.pe.medicalsystem.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import sunat.gob.pe.medicalsystem.model.dao.impl.CitaDaoImpl;
import sunat.gob.pe.medicalsystem.model.dao.impl.MedicoDaoImpl;
import sunat.gob.pe.medicalsystem.model.dao.impl.PacienteDaoImpl;
import sunat.gob.pe.medicalsystem.model.entities.Cita;
import sunat.gob.pe.medicalsystem.model.entities.Medico;
import sunat.gob.pe.medicalsystem.model.entities.Paciente;
import sunat.gob.pe.medicalsystem.model.utils.Utilitario;

/**
 * FXML Controller class
 *
 * @author ZAMORA
 */
public class CitaController implements Initializable {

    private Paciente paciente = null;

    @FXML
    private ComboBox<Medico> cbMedico;

    @FXML
    private ComboBox cbHora;

    @FXML
    private TextField txtEspecialidad;

    @FXML
    private TextField txtConsultorio;

    @FXML
    private TextField txtNombreP;

    @FXML
    private TextField txtDNI;

    @FXML
    private TextArea txtaAsunto;

    @FXML
    private Label lbIdMedico;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private ComboBox cbConsultorio;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // ingresa en el combo un registro , el que se inicializó
        //cbMedico.valueProperty().bindBidirectional(medicoActual.getNombreB());
//        txtEspecialidad.textProperty().bindBidirectional(medicoActual.getCodigoEspecialidadB());
        cargarHora();
        cargarConsultorio();
        cargarMedico();
        cbMedico.getSelectionModel().selectedItemProperty().addListener((ov, t, t1) -> {
            if (t1 != null) {
                txtEspecialidad.setText(t1.getNumeroDocumento());
                txtConsultorio.setText(t1.getIdMedico().toString());
                lbIdMedico.setText(t1.getIdMedico().toString());
            }
        });

        txtDNI.setOnKeyPressed(e -> keyPressed(e));
    }

    @FXML
    public void btnLimpiar_OnAction() {
        Limpiar();
    }

    @FXML
    public void btnGuardar_OnAction() {
        if (txtDNI.isEditable()) {
            new Utilitario().MostrarAlerta("DNI", "Debe ingresar Nro. de Paciente", Alert.AlertType.ERROR);
            txtNombreP.setText("");
            txtDNI.requestFocus();
            return;
        }

        if (lbIdMedico.getText().equals("")) {
            new Utilitario().MostrarAlerta("Médico", "Debe seleccionar un Médico", Alert.AlertType.ERROR);
            txtNombreP.setText("");
            txtDNI.requestFocus();
            return;
        }

        if (dpFecha.getValue() == null) {
            new Utilitario().MostrarAlerta("Fecha Cita", "Debe seleccionar Fecha Cita", Alert.AlertType.ERROR);
            dpFecha.requestFocus();
            return;
        }

        if (cbHora.getSelectionModel().getSelectedIndex() == -1) {
            new Utilitario().MostrarAlerta("Hora", "Debe seleccionar Hora de Cita", Alert.AlertType.ERROR);
            cbHora.requestFocus();
            return;
        }

        if (cbMedico.getSelectionModel().getSelectedIndex() == -1) {
            new Utilitario().MostrarAlerta("Médico", "Debe seleccionar Médico", Alert.AlertType.ERROR);
            cbMedico.requestFocus();
            return;
        }

        if (txtaAsunto.getText().equals("")) {
            new Utilitario().MostrarAlerta("Asunto", "Debe ingresar asunto", Alert.AlertType.ERROR);
            txtNombreP.setText("");
            txtDNI.requestFocus();
            return;
        }

        if (txtaAsunto.getText().length() > 250 || txtaAsunto.getText().length() == 0) {
            new Utilitario().MostrarAlerta("Asunto", "Debe ingresar asunto máximo 250 caracteres", Alert.AlertType.ERROR);
            txtaAsunto.requestFocus();
            return;
        }

        Cita cita = new Cita(dpFecha.getValue().toString(), cbHora.getSelectionModel().getSelectedItem().toString(), txtaAsunto.getText(), Long.valueOf(lbIdMedico.getText()), paciente.getIdPaciente(), "01", cbConsultorio.getSelectionModel().getSelectedItem().toString().substring(12, 14));
        int resultado = new CitaDaoImpl().guardarCita(cita);
        if (resultado == 0) {
            Limpiar();
            new Utilitario().MostrarAlerta("Cita", "Grabó correctamente", Alert.AlertType.ERROR);
        } else {
            if (resultado == 2) {
                new Utilitario().MostrarAlerta("Duplicidad", new Utilitario().MostrarDescripcionError(resultado), Alert.AlertType.ERROR);
            }
        }
    }

    private void Limpiar() {
        txtConsultorio.setText("");
        txtNombreP.setText("");
        txtDNI.setText("");
        txtDNI.setEditable(true);
        txtEspecialidad.setText("");
        txtaAsunto.setText("");
        cbHora.getSelectionModel().clearSelection();
        cbMedico.getSelectionModel().clearSelection();
        cbConsultorio.getSelectionModel().clearSelection();
        dpFecha.getEditor().clear();
    }

    private void keyPressed(KeyEvent evt) {
        KeyCode key = evt.getCode();  // keyboard code for the pressed key
        System.out.println("Key Pressed: " + key);  // for testing
        if (key == KeyCode.ENTER) {  // left arrow key
            if (txtDNI.getText().isEmpty()) {
                new Utilitario().MostrarAlerta("DNI", "Debe ingresar Nro. de Paciente", Alert.AlertType.ERROR);
                txtNombreP.setText("");
                txtDNI.requestFocus();
                return;
            }
            if (!Utilitario.isNumeric(txtDNI.getText())) {
                new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Nro. de documento numérico", Alert.AlertType.ERROR);
                txtNombreP.setText("");
                txtDNI.requestFocus();
                return;
            }
            if (txtDNI.getText().length() != 8) {
                new Utilitario().MostrarAlerta("Paciente", "Debe ingresar Nro. de documento de paciente de 8 digitos", Alert.AlertType.ERROR);
                txtNombreP.setText("");
                txtDNI.requestFocus();
                return;
            }

            paciente = new PacienteDaoImpl().consultarPacientePorDNI(txtDNI.getText(), true);
            String nombre = paciente.getNombre();
            if (!nombre.equals("")) {
                txtNombreP.setText(nombre);
                txtDNI.setEditable(false);
            } else {
                txtNombreP.setText("");
            }
        }
    }

    private void cargarMedico() {
        cbMedico.getItems().addAll(new MedicoDaoImpl().listarNombreMedico(true));
    }

    private void cargarConsultorio() {
        List<String> consult = new ArrayList<>();
        consult.add("CONSULTORIO 01");
        consult.add("CONSULTORIO 02");
        consult.add("CONSULTORIO 03");
        consult.add("CONSULTORIO 04");
        consult.add("CONSULTORIO 05");
        consult.add("CONSULTORIO 06");
        cbConsultorio.getItems().addAll(consult);
    }

    private void cargarHora() {
        List<String> horario = new ArrayList<>();
        horario.add("07:30");
        horario.add("07:45");
        horario.add("08:00");
        horario.add("08:15");
        horario.add("08:30");
        horario.add("09:45");
        horario.add("10:00");
        horario.add("10:15");
        horario.add("10:30");
        horario.add("10:45");
        horario.add("11:00");
        horario.add("11:15");
        horario.add("11:30");
        horario.add("11:45");
        horario.add("12:00");
        horario.add("12:15");
        horario.add("12:30");
        horario.add("12:45");
        horario.add("13:00");
        horario.add("13:15");
        horario.add("13:30");
        horario.add("13:45");
        horario.add("14:00");
        horario.add("15:15");
        horario.add("15:30");
        horario.add("15:45");
        horario.add("16:00");
        horario.add("16:15");
        horario.add("16:30");
        horario.add("16:45");
        horario.add("17:00");
        horario.add("17:15");
        horario.add("17:30");
        horario.add("17:45");
        horario.add("18:00");
        horario.add("18:15");
        horario.add("18:30");
        horario.add("18:45");
        horario.add("19:00");
        horario.add("19:15");
        horario.add("19:30");
        horario.add("19:45");
        horario.add("20:00");
        horario.add("20:15");
        horario.add("20:30");
        horario.add("20:45");
        horario.add("21:00");
        horario.add("21:15");
        horario.add("21:30");
        horario.add("21:45");
        horario.add("22:00");
        cbHora.getItems().addAll(horario);
    }
}
