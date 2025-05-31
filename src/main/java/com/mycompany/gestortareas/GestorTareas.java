/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestortareas;

import com.mycompany.gestortareas.IGU.Inicio;
import com.mycompany.gestortareas.LOGIC.Tarea;
import com.mycompany.gestortareas.LOGIC.Usuario;
import com.mycompany.gestortareas.PERSISTENSE.ConexionMySql;
import com.mycompany.gestortareas.PERSISTENSE.ITareaDAO;
import com.mycompany.gestortareas.PERSISTENSE.IUsuarioDAO;
import com.mycompany.gestortareas.PERSISTENSE.TareaDaoImplementSql;
import com.mycompany.gestortareas.PERSISTENSE.UsuarioDaoImplementSql;
import java.util.Scanner;

/**
 *
 * @author kenrr
 */
public class GestorTareas {

    public static void main(String[] args) {
        
        //IUsuarioDAO dao = new UsuarioDaoImplementSql();
        //dao.crearUsuario("Victoria", "contraseñanuevape");
        //ITareaDAO daot = new TareaDaoImplementSql();
        Inicio init = new Inicio();
        init.setVisible(true);
        //daot.crearTarea(2, "Miguel es una fufurufa");
        //Usuario user = dao.leerUsuario("Carlos");
        //user.setTareas(daot.listarTarea(2));
        /*if(user.getTareas().isEmpty()){
            System.out.println("Sin tareas");
        }else{
            for(Tarea t : user.getTareas()){
            System.out.println(t.getDescripcion());
            }
        }
        
        daot.actualizarTarea(15);
        */
        
    }
}
