/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import sunat.gob.pe.medicalsystem.model.dao.IUsuarioDao;
import sunat.gob.pe.medicalsystem.model.entities.Usuario;
import sunat.gob.pe.medicalsystem.model.utils.Conexion;

/**
 *
 * @author ssamanamudr
 */
public class UsuarioDaoImpl implements IUsuarioDao{

    @Override
    public void guardarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Usuario> consultarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario consultarUsuarioPorId(Long idUsuario, boolean estado) {
//        Conexion conexion = new Conexion();
//        Connection conn = conexion.getConnection();
//        List<Usuario> listaUsuario = new ArrayList<>();
//
//        PreparedStatement pstmt = null;
//        try {
//            String sql = "Select idMedico,nombre,clave,activo from usuario where nombre"+"";
//            pstmt = conn.prepareStatement(sql);
//
//            ResultSet rs = pstmt.executeQuery();
//
//            while (rs.next()) {
//                listaUsuario.add(new Usuario(rs.getLong(1),rs.getLong(2),
//                        rs.getString(3), rs.getString(4),
//                        rs.getBoolean(5)));
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//                if (pstmt != null) {
//                    pstmt.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println(ex.getMessage());
//            }
//        }
//
//        return listaUsuario;
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarUsuario(Long idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario consultarUsuarioPorNombre(String nombre,String password, boolean estado) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        Usuario usuario = null;

        PreparedStatement pstmt = null;
        try {
            String sql = "Select id,idMedico,nombre,clave,activo from usuario where nombre='"+nombre+"' and clave='"+password+"' and activo="+estado;
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                usuario=new Usuario(rs.getLong(1),rs.getLong(2),
                        rs.getString(3), rs.getString(4),
                        rs.getBoolean(5));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }

        return usuario;
    }
    
}
