/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sunat.gob.pe.medicalsystem.model.utils;

import java.sql.*;
/**
 *
 * @author ZAMORA
 */
public class Conexion {
    public Connection getConnection(){
        
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");        
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdmedical1", "root", "mysql@54r");        
        
        }catch(ClassNotFoundException | SQLException cnf){
            System.out.println("Error de conexion "+ cnf.getMessage());   
        }
        
        return conn;
    }
}
