/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.Roles;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author usuario
 */
@Named(value = "rolesSession")
@SessionScoped
public class RolesSession implements Serializable {

    /**
     * Creates a new instance of RolesSession
     */
    public RolesSession() {
    }
   
    public List<Roles> verRoles (){
    return rolesFacadeLocal.finAll();
    } 
}
