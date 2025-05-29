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
            e.printStackTrace();
        }
        return con;
    }
    public boolean crearTarea(String descripcion, int id_usuario){
        // Crea una tarea con el id del usuario
        String query = "insert into Tareas (descripcion, id_usuario) values (?, ?)";
        int result = 0;
        try(Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(query)){
            pst.setString(1, descripcion);
            pst.setInt(2, id_usuario);
            result = pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result == 1; // Si result 1 true si no false
    }
    public List<List<String>> listarTareas(int id_usuario){
        // Consigue todas las tareas de un usuario por su id y lo retorna en una lista de listas
        String consulta = "select * from Tareas where id_usuario = ?";
        List<List<String>> listaTareas = new ArrayList<List<String>>();
        try(Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id_usuario);
            ResultSet rs = pst.executeQuery();
            // cada tarea se convierte en una lista y esa lista se agrega a otra lista
            while(rs.next()){ // Si rs no contiene nada retorna una lista vacia
                List<String> tarea = new ArrayList<String>();
                tarea.add(String.valueOf(rs.getInt("id")));
                tarea.add(String.valueOf(rs.getInt("id_usuario")));
                tarea.add(rs.getString("descripcion"));
                tarea.add(String.valueOf(rs.getBoolean("completado")));
                listaTareas.add(tarea);
            } 
            rs.close();
        } catch (SQLException E){
            E.printStackTrace();
        }
        return listaTareas;
    }
    public boolean eliminarTarea(int id){
        // Elimina una tarea por su id
        // Elimina la tarea con su id
        String consulta = "delete from Tareas where id = ?";
        int rs = 0;
        try(Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id);
            rs = pst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rs == 1; // Si rs 1 retorna true si no false
    }
    public boolean actualizarTarea(int id){
        // Al llamar este metodo actualiza el estado de la tarea, de 1 a 0
        String consultar = "select completado from Tareas where id = ?";
        String actualizar = "update Tareas set completado = ? where id = ?";
        int resultado = 0;
        try{
            Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(consultar);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            int estado = 0;
            if (rs.next()) {
                estado = (rs.getInt("completado") == 0) ? 1 : 0;
                pst.close();
                rs.close();
                try(PreparedStatement pst_update = con.prepareStatement(actualizar)){
                    pst_update.setInt(1, estado);
                    pst_update.setInt(2, id);
                    resultado = pst_update.executeUpdate();
                } 
            } else{
                System.out.println("No se ha encontrado la tarea.");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return resultado == 1; // Si resultado 1 retorna true si no false
    }
    // Usuario
    public boolean crearUsuario(String nombre){
        String consulta = "Insert into usuarios(nombre) values (?)";
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setString(1, nombre);
            int afectado = pst.executeUpdate();
            if(afectado > 0) return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public List<String> leerUsuario(int id) {
        // Convierte el resultado del resulset en una lista y la retorna.
        String consulta = "SELECT * FROM usuarios WHERE id = ?";
        List<String> lista = new ArrayList<String>();
        try (Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id);
            ResultSet rss = pst.executeQuery();
            if(rss.next()){ // Si no hay resultado la lista quedara vicia
                String id2 = String.valueOf(rss.getInt("id"));
                String nombre = rss.getString("nombre");
                lista.add(id2);
                lista.add(nombre);
            }
            rss.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    } 
    // Falta actualizar
    public boolean eliminarUsuario(int id){
        // ELimina al usuario con su id, true si elimina false si no
        String consulta = "delete from usuarios where id = ?";
        int resultado = 0;
        try(Connection con = getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id);
            resultado = pst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return resultado == 1; // Si resultado igual a 1 true si no false
        
    }
    
}
