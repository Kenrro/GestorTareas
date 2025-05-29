/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareas.LOGIC;

import java.util.List;

/**
 *
 * @author kenrr
 */
public class Usuario {
    
    public Usuario(){
        
    }
    public Usuario(int id, String nombre){
        this.id=id;
        this.nombre=nombre;
    }
    
    
    // Variables
    private int id;
    private String nombre;
    private List<Tarea> tareas;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(Tarea tarea) {
        tareas.add(tarea);
    }
    public void setTareas(List<Tarea> tarea){
        tareas = tarea;
    }
    
}
