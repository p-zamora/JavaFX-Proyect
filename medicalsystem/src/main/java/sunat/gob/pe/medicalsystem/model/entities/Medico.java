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
public class Medico {

    private ObjectProperty<Long> idMedico;
    private StringProperty tipoDocumento;
    private StringProperty numeroDocumento;
    private StringProperty nombre;
    private StringProperty apellidoPaterno;
    private StringProperty apellidoMaterno;
    private StringProperty fechaNacimiento;
    private StringProperty codigoEspecialidad;
    private BooleanProperty activo;

//        private ObjectProperty<Long> idMedico;
//    private StringProperty tipoDocumento;
//    private StringProperty numeroDocumento;
//    private StringProperty nombre;
//    private StringProperty apellidoPaterno;
//    private StringProperty apellidoMaterno;
//    private LocalDateTime fechaNacimiento;
//    private StringProperty codigoEspecialidad;
//    private ObjectProperty<Boolean> activo;
    public Medico(Long idMedico, String tipoDocumento, String numeroDocumento, String nombre, String apellidoPaterno, String apellidoMaterno, String fechaNacimiento, String codigoEspecialidad, Boolean activo) {
        this.idMedico = new SimpleObjectProperty(idMedico);
        this.tipoDocumento = new SimpleStringProperty(tipoDocumento);
        this.numeroDocumento = new SimpleStringProperty(numeroDocumento);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidoPaterno = new SimpleStringProperty(apellidoPaterno);
        this.apellidoMaterno = new SimpleStringProperty(apellidoMaterno);
        this.fechaNacimiento = new SimpleStringProperty(fechaNacimiento);
        this.codigoEspecialidad = new SimpleStringProperty(codigoEspecialidad);
        this.activo = new SimpleBooleanProperty(activo);
    }

    public Medico(String nombre, String codigoEspecialidad,Long idMedico,String numeroDocumento) {
        this.idMedico = new SimpleObjectProperty(idMedico);
        this.nombre = new SimpleStringProperty(nombre);
        this.codigoEspecialidad = new SimpleStringProperty(codigoEspecialidad);
        this.numeroDocumento = new SimpleStringProperty(numeroDocumento);
    }

    @Override
    public String toString() {
        return this.nombre.get();
    }

    public Long getIdMedico() {
        return idMedico.get();
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico.set(idMedico);
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

    public String getCodigoEspecialidad() {
        return codigoEspecialidad.get();
    }

    public void setCodigoEspecialidad(String codigoEspecialidad) {
        this.codigoEspecialidad.set(codigoEspecialidad);
    }

    public Boolean getActivo() {
        return activo.get();
    }

    public void setActivo(Boolean activo) {
        this.activo.set(activo);
    }

    //--------------------------------------------
    public ObjectProperty<Long> getIdMedicoB() {
        return idMedico;
    }

    public void setIdMedicoB(Long idMedico) {
        this.idMedico.set(idMedico);
    }

    public StringProperty getTipoDocumentoB() {
        return tipoDocumento;
    }

    public void setTipoDocumentoB(String tipoDocumento) {
        this.tipoDocumento.set(tipoDocumento);
    }

    public StringProperty getNumeroDocumentoB() {
        return numeroDocumento;
    }

    public void setNumeroDocumentoB(String numeroDocumento) {
        this.numeroDocumento.set(numeroDocumento);
    }

    public StringProperty getNombreB() {
        return nombre;
    }

    public void setNombreB(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty getApellidoPaternoB() {
        return apellidoPaterno;
    }

    public void setApellidoPaternoB(String apellidoPaterno) {
        this.apellidoPaterno.set(apellidoPaterno);
    }

    public StringProperty getApellidoMaternoB() {
        return apellidoMaterno;
    }

    public void setApellidoMaternoB(String apellidoMaterno) {
        this.apellidoMaterno.set(apellidoMaterno);
    }

    public StringProperty getFechaNacimientoB() {
        return fechaNacimiento;
    }

    public void setFechaNacimientoB(String fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento);
    }

    public StringProperty getCodigoEspecialidadB() {
        return codigoEspecialidad;
    }

    public void setCodigoEspecialidadB(String codigoEspecialidad) {
        this.codigoEspecialidad.set(codigoEspecialidad);
    }

    public BooleanProperty getActivoB() {
        return activo;
    }

    public void setActivoB(Boolean activo) {
        this.activo.set(activo);
    }

}
