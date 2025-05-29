/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareas.PERSISTENSE;

import com.mycompany.gestortareas.LOGIC.Usuario;
import java.util.List;

/**
 *
 * @author kenrr
 */
public class UsuarioDaoImplementSql implements IUsuarioDAO {

    @Override
    public void crearUsuario(String nombre) {
        
         System.out.println(con.crearUsuario(nombre));
        
    }

    @Override
    public Usuario leerUsuario(int id) {
        
        List<String> valores = con.leerUsuario(id);
        if(!valores.isEmpty()){
            return new Usuario(Integer.parseInt(valores.get(0)), valores.get(1));
        }
        return null;
    }

    @Override
    public void actualizarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminarUsuario(int id) {
        return con.eliminarUsuario(id);
    }
    ConexionMySql con = new ConexionMySql();
}
