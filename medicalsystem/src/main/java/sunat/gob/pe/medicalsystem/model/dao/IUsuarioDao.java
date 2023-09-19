/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.dao;

import java.util.List;
import sunat.gob.pe.medicalsystem.model.entities.Usuario;

/**
 *
 * @author ssamanamudr
 */
public interface IUsuarioDao {

    void guardarUsuario(Usuario usuario);

    List<Usuario> consultarUsuario();

    Usuario consultarUsuarioPorId(Long idUsuario, boolean estado);

    Usuario consultarUsuarioPorNombre(String nombre, String password, boolean estado);

    void actualizarUsuario(Usuario usuario);

    void eliminarUsuario(Long idUsuario);
}
