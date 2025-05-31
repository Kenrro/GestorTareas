/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.gestortareas.PERSISTENSE;

import com.mycompany.gestortareas.LOGIC.Tarea;
import java.util.List;

/**
 * Patron DAO
 * 
 */
public interface ITareaDAO {
    
    public boolean crearTarea(int id_usuario, String descripcion);
    public List<Tarea> listarTarea(int id_usuario);
    public boolean eliminarTarea(int id);
    public boolean actualizarTarea(int id);
    
}
