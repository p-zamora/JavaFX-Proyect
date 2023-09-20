/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.dao;

import java.util.List;
import sunat.gob.pe.medicalsystem.model.entities.Paciente;

/**
 *
 * @author ssamanamudr
 */
public interface IPacienteDAO {

    int guardarPaciente(Paciente paciente);

    List<Paciente> consultarPaciente(boolean estado);

    Paciente consultarPacientePorId(Long idPaciente, boolean estado);

    Paciente consultarPacientePorDNI(String NroDoc, boolean estado);

    int actualizarPaciente(Paciente paciente);

    void eliminarPaciente(Long idPaciente);
}
