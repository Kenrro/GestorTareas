/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareas.PERSISTENSE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Conexion con la base de datos, desplegada docker
 */
public class ConexionMySql {
    
    private String url = "jdbc:mysql://localhost:3306/GestorTareas";
    private String user = "root";
    private String psw = "20032003";
    
    public Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(url,user,psw);
            System.out.println("Succes");
            
        } catch(SQLException e){
            System.out.println("Error en la conexion");
        }
        return con;
    }

    
}
