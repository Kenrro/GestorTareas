/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestortareas.PERSISTENSE;

import com.mycompany.gestortareas.LOGIC.Usuario;

/**
 *
 * @author kenrr
 */
public interface IUsuarioDAO {
    
    public void crearUsuario(String nombre);
    public Usuario leerUsuario(int id);
    public void actualizarUsuario();
    public boolean eliminarUsuario(int id);
    
}
