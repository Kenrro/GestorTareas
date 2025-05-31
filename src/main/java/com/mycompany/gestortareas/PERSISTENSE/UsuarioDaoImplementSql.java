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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenrr
 */
public class UsuarioDaoImplementSql implements IUsuarioDAO {

    @Override
    public boolean crearUsuario(String nombre, String contraseña) {
        
        String consulta = "Insert into usuarios(nombre, contraseña) values (?, ?)";
        int afectado = 0;
        try (Connection con = conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setString(1, nombre);
            pst.setString(2, contraseña);
            afectado = pst.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException se) {
                System.out.println("Ese usuario ya existe");  
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return afectado == 1;
        
    }

    @Override
    public Usuario leerUsuario(String n, String contraseña) {
        
        // Convierte el resultado del resulset en una lista y la retorna.
        String consulta = "SELECT * FROM usuarios WHERE id = ? and contraseña = ?";
        Usuario user = null;
        int id = buscarUsuario(n);
        if(id > 0){
            try (Connection con = conexion.getConnection();
            PreparedStatement pst = con.prepareStatement(consulta)){
            pst.setInt(1, id);
            pst.setString(2, contraseña);
            ResultSet rss = pst.executeQuery();
            if(rss.next()){ // Si no hay resultado la lista quedara vicia
                int id_usuario = rss.getInt("id");
                String nombre = rss.getString("nombre");
                user = new Usuario(id_usuario, nombre);
            }
            else{
                System.out.println("Usuario o contraseña incorrectos.");
            }
            rss.close();
            }
            catch(SQLException e){
                e.printStackTrace();
            } 
            
        }
        else {
            System.out.println("Usuario no encontrado");
        }
        
        return user;
    }
        private int buscarUsuario(String nombre){
            // Busca coincidecias en los usuarios
            String consulta = "SELECT id from usuarios where nombre = ?";
            
            try(Connection con = conexion.getConnection();
                PreparedStatement pst = con.prepareStatement(consulta)){
                pst.setString(1, nombre);
                ResultSet rs = pst.executeQuery();
                if(rs.next()) return rs.getInt("id");
                
            } catch (SQLException e){
                e.printStackTrace();
            }
            return -1;
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
