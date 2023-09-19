/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.dao;

import java.util.List;
import sunat.gob.pe.medicalsystem.model.entities.Medico;

/**
 *
 * @author ssamanamudr
 */
public interface IMedicoDao {

    void guardarMedico(Medico medico);

    List<Medico> consultarMedico();

    List<Medico> listarNombreMedico(boolean estado);

    Medico consultarMedicoPorId(Long idmedico, boolean estado);

    Medico consultarMedicoPorNombre(String nombre, String password, boolean estado);

    void actualizarMedico(Medico medico);

    void eliminarMedico(Long idmedico);
}
