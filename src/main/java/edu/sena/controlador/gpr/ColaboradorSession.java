/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.Colaboradores;
import edu.sena.entity.gpr.Roles;
import edu.sena.facade.gpr.ColaboradoresFacadeLocal;
import edu.sena.facade.gpr.RolesFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author usuario
 */
@Named(value = "colaboradorSession")
@SessionScoped
public class ColaboradorSession implements Serializable {
@EJB
ColaboradoresFacadeLocal colaboradoresFacadeLocal;
@EJB
RolesFacadeLocal rolesFacadeLocal;

    /**
     * Creates a new instance of ColaboradorSession
     */
    public ColaboradorSession() {
    }
    
    public List<Colaboradores> leerTodo (){
    return colaboradoresFacadeLocal.findAll();
    }
    
    
}
