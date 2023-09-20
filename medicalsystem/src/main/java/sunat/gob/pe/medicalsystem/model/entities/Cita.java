/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.entities;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ssamanamudr
 */
public class Cita {

    private ObjectProperty<Long> idCita;
    private StringProperty fecha;
    private StringProperty hora;
    private StringProperty asunto;
    private StringProperty consultorio;
    private StringProperty nombreMedico;
    private StringProperty nombrePaciente;
    private ObjectProperty<Long> idMedico;
    private ObjectProperty<Long> idPaciente;
    private StringProperty estado;

    public Cita(Long idCita, String fecha, String hora, String asunto, Long idMedico, Long idPaciente, String estado) {
        this.idCita = new SimpleObjectProperty(idCita);
        this.fecha = new SimpleStringProperty(fecha);
        this.hora = new SimpleStringProperty(hora);
        this.asunto = new SimpleStringProperty(asunto);
        this.idMedico = new SimpleObjectProperty(idMedico);
        this.idPaciente = new SimpleObjectProperty(idPaciente);
        this.estado = new SimpleStringProperty(estado);
    }

    public Cita(Long idCita, String fecha, String hora, String asunto, String nombreMedico, String nombrePaciente, String estado, String consultorio) {
        this.idCita = new SimpleObjectProperty(idCita);
        this.fecha = new SimpleStringProperty(fecha);
        this.hora = new SimpleStringProperty(hora);
        this.asunto = new SimpleStringProperty(asunto);
        this.estado = new SimpleStringProperty(estado);
        this.nombreMedico = new SimpleStringProperty(nombreMedico);
        this.nombrePaciente = new SimpleStringProperty(nombrePaciente);
        this.consultorio = new SimpleStringProperty(consultorio);
    }

    public Cita(String fecha, String hora, String asunto, Long idMedico, Long idPaciente, String estado, String consultorio) {
        this.fecha = new SimpleStringProperty(fecha);
        this.hora = new SimpleStringProperty(hora);
        this.asunto = new SimpleStringProperty(asunto);
        this.idMedico = new SimpleObjectProperty(idMedico);
        this.idPaciente = new SimpleObjectProperty(idPaciente);
        this.estado = new SimpleStringProperty(estado);
        this.consultorio = new SimpleStringProperty(consultorio);
    }

    public Cita() {
    }

    public String getNombrePaciente() {
        return nombrePaciente.get();
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente.set(nombrePaciente);
    }

    public String getNombreMedico() {
        return nombreMedico.get();
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico.set(nombreMedico);
    }

    public Long getIdCita() {
        return idCita.get();
    }

    public void setIdCita(Long idCita) {
        this.idCita.set(idCita);
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getHora() {
        return hora.get();
    }

    public void setHora(String hora) {
        this.hora.set(hora);
    }

    public String getAsunto() {
        return asunto.get();
    }

    public void setAsunto(String asunto) {
        this.asunto.set(asunto);
    }

    public Long getIdMedico() {
        return idMedico.get();
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico.set(idMedico);
    }

    public Long getIdPaciente() {
        return idPaciente.get();
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente.set(idPaciente);
    }

    public String getEstado() {
        return estado.get();
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public String getConsultorio() {
        return consultorio.get();
    }

    public void setConsultorio(String consultorio) {
        this.consultorio.set(consultorio);
    }

    //----------------------------
    public ObjectProperty<Long> getIdCitaB() {
        return idCita;
    }

    public void setIdCitaB(Long idCita) {
        this.idCita.set(idCita);
    }

    public StringProperty getFechaB() {
        return fecha;
    }

    public void setFechaB(String fecha) {
        this.fecha.set(fecha);
    }

    public StringProperty getHoraB() {
        return hora;
    }

    public void setHoraB(String hora) {
        this.hora.set(hora);
    }

    public StringProperty getAsuntoB() {
        return asunto;
    }

    public void setAsuntoB(String asunto) {
        this.asunto.set(asunto);
    }

    public ObjectProperty<Long> getIdMedicoB() {
        return idMedico;
    }

    public void setIdMedicoB(Long idMedico) {
        this.idMedico.set(idMedico);
    }

    public ObjectProperty<Long> getIdPacienteB() {
        return idPaciente;
    }

    public void setIdPacienteB(Long idPaciente) {
        this.idPaciente.set(idPaciente);
    }

    public StringProperty getEstadoB() {
        return estado;
    }

    public void setEstadoB(String estado) {
        this.estado.set(estado);
    }

    public StringProperty getNombrePacienteB() {
        return nombrePaciente;
    }

    public void setNombrePacienteB(String nombrePaciente) {
        this.nombrePaciente.set(nombrePaciente);
    }

    public StringProperty getNombreMedicoB() {
        return nombreMedico;
    }

    public void setNombreMedicoB(String nombreMedico) {
        this.nombreMedico.set(nombreMedico);
    }

    public StringProperty getConsultorioB() {
        return consultorio;
    }

    public void setConsultorioB(String consultorio) {
        this.consultorio.set(consultorio);
    }

}
