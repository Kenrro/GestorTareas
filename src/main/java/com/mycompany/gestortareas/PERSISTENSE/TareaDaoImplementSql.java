/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareas.PERSISTENSE;

import com.mycompany.gestortareas.LOGIC.Tarea;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kenrr
 */
public class TareaDaoImplementSql implements ITareaDAO{

    @Override
    public void crearTarea(int id_usuario, String descripcion) {
        con.crearTarea(descripcion, id_usuario);
    }

    @Override
    public List<Tarea> listarTarea(int id_usuario) {
        List<Tarea> tareas = new ArrayList<>();
        List<List<String>> lista = con.listarTareas(id_usuario);
        if (!lista.isEmpty()) {
            for(List<String> l : lista){
                int id = Integer.parseInt(l.get(0));
                boolean estado = Boolean.parseBoolean(l.get(3));
                String descripcion = l.get(2);
                tareas.add(new Tarea(id,descripcion, estado));
            }
            System.out.println("Esta lleno");
            return tareas;
        }
        return tareas;
    }

    @Override
    public void eliminarTarea(int id) {
        con.eliminarTarea(id);
    }

    @Override
    public void actualizarTarea(int id) {
        con.actualizarTarea(id);
    }
    
    ConexionMySql con = new ConexionMySql();
    
}
