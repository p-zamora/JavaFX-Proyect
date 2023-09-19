/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sunat.gob.pe.medicalsystem.model.dao.IPacienteDAO;
import sunat.gob.pe.medicalsystem.model.entities.Paciente;
import sunat.gob.pe.medicalsystem.model.utils.Conexion;

/**
 *
 * @author ssamanamudr
 */
public class PacienteDaoImpl implements IPacienteDAO {

    @Override
    public int guardarPaciente(Paciente paciente) {
        int resultado = 0;
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "insert into paciente (tipoDocumento, numeroDocumento, nombre, apellidoPaterno,apellidoMaterno,fechaNacimiento) values(?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "01");
            pstmt.setString(2, paciente.getNumeroDocumento());
            pstmt.setString(3, paciente.getNombre());
            pstmt.setString(4, paciente.getApellidoMaterno());
            pstmt.setString(5, paciente.getApellidoPaterno());
            pstmt.setString(6, paciente.getFechaNacimiento());

            System.out.println(sql);
            pstmt.executeUpdate();
            resultado = 0;

        } catch (SQLException ex) {
            int index = ex.getMessage().indexOf("Duplicate");
            System.out.println("ssss"+index);
            resultado = 1;
            if (index == 0) {
                resultado = 2;
            }

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

                int index = ex.getMessage().indexOf("Duplicate");
                                System.out.println("sssssg"+index);
                resultado = 1;
                if (index == 0) {
                    resultado = 2;
                }
            }
        }
        return resultado;
    }

    @Override
    public List<Paciente> consultarPaciente(boolean estado) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        List<Paciente> listaPaciente = new ArrayList<>();

        PreparedStatement pstmt = null;
        try {
            String sql = "SELECT id,    tipoDocumento,    numeroDocumento,    nombre,    apellidoPaterno,    apellidoMaterno,   date_format(fechaNacimiento, \"%d-%m-%Y\") fechaNacimiento FROM paciente where activo=" + estado;
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                listaPaciente.add(new Paciente(rs.getLong(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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

        return listaPaciente;
    }

    @Override
    public Paciente consultarPacientePorId(Long idPaciente, boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Paciente consultarPacientePorNombre(String NroDoc, boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarUsuario(Paciente paciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarUsuario(Long idPaciente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
