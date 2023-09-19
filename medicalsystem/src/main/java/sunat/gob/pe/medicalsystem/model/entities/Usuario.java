/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.entities;

/**
 *
 * @author ssamanamudr
 */
public class Usuario {
    private Long idUsuario;
    private Long idMedico;
    private String nombre;
    private String clave;
    private Boolean activo;

    public Usuario() {
    }

    public Usuario(Long idUsuario, Long idMedico, String nombre, String clave, Boolean activo) {
        this.idUsuario = idUsuario;
        this.idMedico = idMedico;
        this.nombre = nombre;
        this.clave = clave;
        this.activo = activo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
