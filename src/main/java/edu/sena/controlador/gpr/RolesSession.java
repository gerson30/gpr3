<<<<<<< HEAD
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.Roles;
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
@Named(value = "rolesSession")
@SessionScoped
public class RolesSession implements Serializable {

    @EJB
    RolesFacadeLocal rolesFacadeLocal;

    /**
     * Creates a new instance of RolesSession
     */
    public RolesSession() {
    }

    public List<Roles> verRoles() {
        return rolesFacadeLocal.findAll();
    }
    
    public Roles ponerRoles() {
        return rolesFacadeLocal.find(this.hashCode());
    }
}
>>>>>>> fec238e67f22857f4829b7239b7e23fd89cf363d
