/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.Colaboradores;
import edu.sena.facade.gpr.ColaboradoresFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author gjimenezo
 */
@Named(value = "colaboradorView")
@ViewScoped
public class ColaboradorView implements Serializable {

    @EJB
    ColaboradoresFacadeLocal colaboradoresFacadeLocal;

    /**
     * Creates a new instance of ColaboradorView
     */
    public ColaboradorView() {
    }

    public List<Colaboradores> verCol() {

        return colaboradoresFacadeLocal.verCol();
    }
}
