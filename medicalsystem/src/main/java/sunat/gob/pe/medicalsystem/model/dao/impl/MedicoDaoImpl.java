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
import sunat.gob.pe.medicalsystem.model.dao.IMedicoDao;
import sunat.gob.pe.medicalsystem.model.entities.Medico;
import sunat.gob.pe.medicalsystem.model.utils.Conexion;

/**
 *
 * @author ssamanamudr
 */
public class MedicoDaoImpl implements IMedicoDao {

    @Override
    public void guardarMedico(Medico medico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Medico> consultarMedico() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medico consultarMedicoPorId(Long idmedico, boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medico consultarMedicoPorNombre(String nombre, String password, boolean estado) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizarMedico(Medico medico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarMedico(Long idmedico) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Medico> listarNombreMedico(boolean estado) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        List<Medico> listaMedico = new ArrayList<>();

        PreparedStatement pstmt = null;
        try {
            String sql = "SELECT concat(numeroDocumento,\" - \",nombre,\", \",apellidoPaterno,\" \",apellidoMaterno) nombre,codigoEspecialidad,id,(select descripcionLarga from parametro where codigoFila=codigoEspecialidad and codigoTabla='000001')  FROM medico where activo=" + estado;
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                listaMedico.add(new Medico(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getString(4)));
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

        return listaMedico;
    }

}
