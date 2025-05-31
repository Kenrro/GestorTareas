/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestortareas.LOGIC;

/**
 *
 * @author kenrr
 */
public class Tarea {
    
    public Tarea(){
        
    }
    public Tarea(int id, String descripcion, boolean estado){
        this.id=id;
        this.descripcion=descripcion;
        this.estado=estado;
                
    }
    
    // Variables
    
    private int id;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    private boolean estado;
}
