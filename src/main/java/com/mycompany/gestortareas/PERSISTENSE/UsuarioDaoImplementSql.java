/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareas.PERSISTENSE;

import com.mycompany.gestortareas.LOGIC.Usuario;
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
public class UsuarioDaoImplementSql implements IUsuarioDAO {

    @Override
    public boolean crearUsuario(String nombre) {
        
        String consulta = "Insert into usuarios(nombre) values (?)";
        int afectado = 0;
        try (Connection con = conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setString(1, nombre);
            afectado = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return afectado == 1;
        
    }

    @Override
    public Usuario leerUsuario(int id) {
        
        // Convierte el resultado del resulset en una lista y la retorna.
        String consulta = "SELECT * FROM usuarios WHERE id = ?";
        Usuario user = null;
        try (Connection con = conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id);
            ResultSet rss = pst.executeQuery();
            if(rss.next()){ // Si no hay resultado la lista quedara vicia
                int id_usuario = rss.getInt("id");
                String nombre = rss.getString("nombre");
                user = new Usuario(id_usuario, nombre);
            }
            rss.close();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean actualizarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarUsuario(int id) {
        // ELimina al usuario con su id, true si elimina false si no
        String consulta = "delete from usuarios where id = ?";
        int resultado = 0;
        try(Connection con = conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id);
            resultado = pst.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return resultado == 1; // Si resultado igual a 1 true si no false
    }
    ConexionMySql conexion = new ConexionMySql();
}
