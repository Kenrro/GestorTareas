/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebamaven;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author kenrr
 */
public class PruebaMaven {

    public static void main(String[] args){
       Connectionn con = new Connectionn();
       con.getConexion();
       con.tablas();
       
       
        
    }
}
class Connectionn{
    private String url = "jdbc:mysql://localhost:3306/nueva";
    private String user = "root";
    private String psw = "20032003";
    
    public Connection getConexion(){
        Connection conexion = null;
        try{
            conexion = DriverManager.getConnection(url, user, psw);
            System.out.println("Succes");
        } catch(SQLException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        return conexion;
    }
    public void tablas(){
        Connection con = this.getConexion();  
        try {
            String consulta= "show tables";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while(rs.next()){
                System.out.println(rs.getString(1));
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
   
}
