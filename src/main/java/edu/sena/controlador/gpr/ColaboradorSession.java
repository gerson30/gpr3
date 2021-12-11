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
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

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

    private Colaboradores usuLogin = new Colaboradores();
    private String usuarioDominio = "";
    private String contrasenaDominio = "";

    /**
     * metodo de logueo*
     */
    public void validarUsuario() {
        try {
            usuLogin = colaboradoresFacadeLocal.inicioSesion(usuarioDominio,contrasenaDominio);
            if (usuLogin != null) {
                
                 /*captura lo que hay en el conexto*/
                    FacesContext fc = FacesContext.getCurrentInstance();
                    /*se envía hacía afuera*/
                    fc.getExternalContext().redirect("coordinador/indexcol.xhtml");
                    
                    } else {
                PrimeFaces.current().executeScript("alert(Usuario no existe)");
            }
        } catch (IOException e) {
        
        }
    }

    /**
     * Creates a new instance of ColaboradorSession
     */
    public ColaboradorSession() {
    }

    public List<Colaboradores> leerTodo() {
        return colaboradoresFacadeLocal.findAll();
    }


    public String getUsuarioDominio() {
        return usuarioDominio;
    }

    public void setUsuarioDominio(String usuarioDominio) {
        this.usuarioDominio = usuarioDominio;
    }

    public String getContrasenaDominio() {
        return contrasenaDominio;
    }

    public void setContrasenaDominio(String contrasenaDominio) {
        this.contrasenaDominio = contrasenaDominio;
    }

    public Colaboradores getUsuLogin() {
        return usuLogin;
    }

    public void setUsuLogin(Colaboradores usuLogin) {
        this.usuLogin = usuLogin;
    }


    public List<Colaboradores> verCol (){
    return colaboradoresFacadeLocal.findAll();
    }
    
    public List<Roles> verRoles (){
    return rolesFacadeLocal.findAll();
    }
    
    

}
