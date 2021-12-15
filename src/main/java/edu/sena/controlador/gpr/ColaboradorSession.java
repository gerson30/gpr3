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

    private Colaboradores colreg = new Colaboradores();
    private Colaboradores usuLogin = new Colaboradores();
    private String usuarioDominio = "";
    private String contrasenaDominio = "";
    private String flag = "";

    /**
     * metodo de logueo*
     */
    public void ingresarColaborador() {
        if (colaboradoresFacadeLocal.agregarCol(colreg)) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Colaborador',"
                    + "  'Creado con Exito !!!',"
                    + "  'success'"
                    + ")");
            colreg = new Colaboradores();
        } else {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Colaborador',"
                    + "  'No se puede registrar, Intente de nuevo',"
                    + "  'error'"
                    + ")");
  
        }
    }

    public void validarUsuario() {
        try {
            usuLogin = colaboradoresFacadeLocal.inicioSesion(usuarioDominio, contrasenaDominio);
            if (usuLogin != null) {
                
                FacesContext fc = FacesContext.getCurrentInstance();
                fc.getExternalContext().redirect("coordinador/indexcol.xhtml");
            } else {
                PrimeFaces.current().executeScript("Swal.fire("
                        + "  'Colaborador?',"
                        + "  'No existe en la base de datos, Intente de nuevo',"
                        + "  'error'"
                        + ")");
            }
        } catch (Exception e) {

        }
    }

    public void cerrarSesion() throws IOException {
        usuLogin = null;
        FacesContext fc = FacesContext.getCurrentInstance();
        fc.getExternalContext().invalidateSession();
        fc.getExternalContext().redirect("../login.xhtml");
    }

    /**
     * Creates a new instance of ColaboradorSession
     */
    public ColaboradorSession() {
    }

    public List<Colaboradores> leerTodo() {
        return colaboradoresFacadeLocal.findAll();
    }

    public List<Roles> verRoles() {
        return rolesFacadeLocal.findAll();
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

    public List<Colaboradores> verCol() {
        return colaboradoresFacadeLocal.findAll();
    }

    public Colaboradores getUsureg() {
        return colreg;
    }

    public void setUsureg(Colaboradores usureg) {
        this.colreg = usureg;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

}
