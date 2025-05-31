/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareas.PERSISTENSE;

import com.mycompany.gestortareas.LOGIC.Tarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenrr
 */
public class TareaDaoImplementSql implements ITareaDAO{

    @Override
    public boolean crearTarea(int id_usuario, String descripcion) {
        // Crea una tarea con el id del usuario
        String query = "insert into Tareas (descripcion, id_usuario) values (?, ?)";
        int result = 0;
        try(Connection con = conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(query)){
            pst.setString(1, descripcion);
            pst.setInt(2, id_usuario);
            result = pst.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result == 1; // Si result 1 true si no false
    }

    @Override
    public List<Tarea> listarTarea(int id_usuario) {
        // Consigue todas las tareas de un usuario por su id y lo retorna en una lista de listas
        String consulta = "select * from Tareas where id_usuario = ?";
        List<Tarea> tareas = new ArrayList<Tarea>();
        try(Connection con = conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id_usuario);
            ResultSet rs = pst.executeQuery();
            // cada tarea se convierte en una lista y esa lista se agrega a otra lista
            while(rs.next()){ // Si rs no contiene nada retorna una lista vacia
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                boolean estado = rs.getBoolean("completado");
                tareas.add(new Tarea(id, descripcion, estado));
                
            } 
            rs.close();
        } catch (SQLException E){
            E.printStackTrace();
        }
        return tareas;
    }

    @Override
    public boolean eliminarTarea(int id) {
        // Elimina una tarea por su id
        // Elimina la tarea con su id
        String consulta = "delete from Tareas where id = ?";
        int rs = 0;
        try(Connection con = conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id);
            rs = pst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return rs == 1; // Si rs 1 retorna true si no false
    }

    @Override
    public boolean actualizarTarea(int id) {
        // Al llamar este metodo actualiza el estado de la tarea, de 1 a 0
        String consultar = "select completado from Tareas where id = ?";
        String actualizar = "update Tareas set completado = ? where id = ?";
        int resultado = 0;
        try{
            Connection con = conexion.getConnection();
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
    
    ConexionMySql conexion = new ConexionMySql();
    
}
