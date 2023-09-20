/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.entities;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ssamanamudr
 */
public class Paciente {

    private ObjectProperty<Long> idPaciente;
    private StringProperty tipoDocumento;
    private StringProperty numeroDocumento;
    private StringProperty nombre;
    private StringProperty apellidoPaterno;
    private StringProperty apellidoMaterno;
    private StringProperty fechaNacimiento;
    private BooleanProperty activo;
    
//        private Long idPaciente;
//    private String tipoDocumento;
//    private String numeroDocumento;
//    private String nombre;
//    private String apellidoPaterno;
//    private String apellidoMaterno;
//    private LocalDateTime fechaNacimiento;
//    private Boolean activo;
    

    public Paciente() {
    }

    public Paciente(String nombre,Long idPaciente) {
         this.idPaciente = new SimpleObjectProperty(idPaciente);
        this.nombre = new SimpleStringProperty(nombre);
    }
    
    public Paciente(String tipoDocumento, String numeroDocumento, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento) {
        this.tipoDocumento = new SimpleStringProperty(tipoDocumento);
        this.numeroDocumento = new SimpleStringProperty(numeroDocumento);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidoPaterno = new SimpleStringProperty(apellidoPaterno);
        this.apellidoMaterno = new SimpleStringProperty(apellidoMaterno);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
    }

    public Paciente(Long idPaciente, String tipoDocumento, String numeroDocumento, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, Boolean activo) {
        this.idPaciente = new SimpleObjectProperty(idPaciente);
        this.tipoDocumento = new SimpleStringProperty(tipoDocumento);
        this.numeroDocumento = new SimpleStringProperty(numeroDocumento);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidoPaterno = new SimpleStringProperty(apellidoPaterno);
        this.apellidoMaterno = new SimpleStringProperty(apellidoMaterno);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
        this.activo = new SimpleBooleanProperty(activo);
    }

    public Paciente(Long idPaciente,String tipoDocumento, String numeroDocumento, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento) {
        this.idPaciente = new SimpleObjectProperty(idPaciente);
        this.tipoDocumento = new SimpleStringProperty(tipoDocumento);
        this.numeroDocumento = new SimpleStringProperty(numeroDocumento);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidoPaterno = new SimpleStringProperty(apellidoPaterno);
        this.apellidoMaterno = new SimpleStringProperty(apellidoMaterno);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
    }
    
    public Long getIdPaciente() {
        return idPaciente.get();
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente.set(idPaciente);
    }

    public String getTipoDocumento() {
        return tipoDocumento.get();
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento.set(tipoDocumento);
    }

    public String getNumeroDocumento() {
        return numeroDocumento.get();
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento.set(numeroDocumento);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getApellidoPaterno() {
        return apellidoPaterno.get();
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno.set(apellidoPaterno);
    }

    public String getApellidoMaterno() {
        return apellidoMaterno.get();
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno.set(apellidoMaterno);
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);
    }

    public Boolean getActivo() {
        return activo.get();
    }

    public void setActivo(Boolean activo) {
        this.activo.set(activo);
    }

    //----------------
    public ObjectProperty<Long> getIdPaciente1() {
        return idPaciente;
    }

    public void setIdPaciente1(Long idPaciente) {
        this.idPaciente.set(idPaciente);
    }

    public StringProperty getTipoDocumento1() {
        return tipoDocumento;
    }

    public void setTipoDocumento1(String tipoDocumento) {
        this.tipoDocumento.set(tipoDocumento);
    }

    public StringProperty getNumeroDocumento1() {
        return numeroDocumento;
    }

    public void setNumeroDocumento1(String numeroDocumento) {
        this.numeroDocumento.set(numeroDocumento);
    }

    public StringProperty getNombre1() {
        return nombre;
    }

    public void setNombre1(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty getApellidoPaterno1() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno1(String apellidoPaterno) {
        this.apellidoPaterno.set(apellidoPaterno);
    }

    public StringProperty getApellidoMaterno1() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno1(String apellidoMaterno) {
        this.apellidoMaterno.set(apellidoMaterno);
    }

    public StringProperty getFechaNacimiento1() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento1(String fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);
    }

    public BooleanProperty getActivo1() {
        return activo;
    }

    public void setActivo1(Boolean activo) {
        this.activo.set(activo);
    }
}
