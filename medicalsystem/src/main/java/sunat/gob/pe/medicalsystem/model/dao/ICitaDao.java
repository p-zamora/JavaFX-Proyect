/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.dao;

import java.util.List;
import sunat.gob.pe.medicalsystem.model.entities.Cita;

/**
 *
 * @author ssamanamudr
 */
public interface ICitaDao {

    int guardarCita(Cita cita);

    List<Cita> consultarCita();

    Cita consultarCitaPorId(Long idCita, boolean estado);

    List<Cita> consultarCitaPorDNI(String dni, boolean estado);

    void actualizarCita(Cita cita);

    void eliminarCita(Long idCita);
}
