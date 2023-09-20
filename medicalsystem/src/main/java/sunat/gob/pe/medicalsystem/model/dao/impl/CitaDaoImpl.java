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
import sunat.gob.pe.medicalsystem.model.dao.ICitaDao;
import sunat.gob.pe.medicalsystem.model.entities.Cita;
import sunat.gob.pe.medicalsystem.model.utils.Conexion;

/**
 *
 * @author ssamanamudr
 */
public class CitaDaoImpl implements ICitaDao{

    @Override
    public int guardarCita(Cita cita) {
        int resultado = 0;
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO cita (fecha,hora,asunto,idMedico,idPaciente,estado,consultorio)  values (?,?,?,?,?,?,?);";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, cita.getFecha());
            pstmt.setString(2, cita.getHora());
            pstmt.setString(3, cita.getAsunto());
            pstmt.setLong(4, cita.getIdMedico());
            pstmt.setLong(5, cita.getIdPaciente());
            pstmt.setString(6, cita.getEstado());
            pstmt.setString(7, cita.getConsultorio());
            
            pstmt.executeUpdate();
            resultado = 0;
        } catch (SQLException ex) {
            int index = ex.getMessage().indexOf("Duplicate");
            System.out.println("ssss" + index);
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
                System.out.println("sssssg" + index);
                resultado = 1;
                if (index == 0) {
                    resultado = 2;
                }
            }
        }
        return resultado;
    }

    @Override
    public List<Cita> consultarCita() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Cita consultarCitaPorId(Long idCita, boolean estado) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        Cita cita = null ;

        PreparedStatement pstmt = null;
        try {
            String sql = "SELECT  cita.id ,date_format(fecha, \"%d-%m-%Y\"),hora,asunto,(select concat(nombre,\", \",apellidoPaterno,\" \",apellidoMaterno) nombre from medico where id=idMedico) medico,(select concat(nombre,\", \",apellidoPaterno,\" \",apellidoMaterno) nombre from paciente where id=idPaciente) paciente,  (select descripcionLarga from parametro where codigoFila=estado and codigoTabla='000002') estado,(select descripcionLarga from parametro where codigoFila=consultorio and codigoTabla='000003') consultorio FROM paciente, cita where paciente.id=idpaciente and cita.id='" + idCita+"'";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                cita =new Cita(rs.getLong(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8));
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
        return cita;
    }

    @Override
    public List<Cita> consultarCitaPorDNI(String dni, boolean estado) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.getConnection();
        List<Cita> listaCita = new ArrayList<>();

        PreparedStatement pstmt = null;
        try {
            String sql = "SELECT cita.id ,date_format(fecha, \"%d-%m-%Y\"),hora,asunto,(select concat(nombre,\", \",apellidoPaterno,\" \",apellidoMaterno) nombre from medico where id=cita.idMedico) medico,concat(nombre,\", \",apellidoPaterno,\" \",apellidoMaterno) nombrepaciente ,(select descripcionLarga from parametro where codigoFila=estado and codigoTabla='000002') estado,(select descripcionLarga from parametro where codigoFila=consultorio and codigoTabla='000003') consultorio FROM paciente, cita where paciente.id=idpaciente and  paciente.numeroDocumento='" + dni+"'";
            pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                listaCita.add(new Cita(rs.getLong(1),
                        rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),rs.getString(8)));
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
        return listaCita;
    }

    @Override
    public void actualizarCita(Cita cita) {
        
    }

    @Override
    public void eliminarCita(Long idCita) {
        
    }
    
}
