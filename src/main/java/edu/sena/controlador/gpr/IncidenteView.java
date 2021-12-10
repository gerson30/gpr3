/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.Incidente;
import edu.sena.facade.gpr.IncidenteFacade;
import edu.sena.facade.gpr.IncidenteFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author usuario
 */
@Named(value = "incidenteView")
@ViewScoped
public class IncidenteView implements Serializable {

    @EJB
    IncidenteFacadeLocal incidenteFacadeLocal;

    /**
     * Creates a new instance of ColaboradorView
     */
    public IncidenteView() {
    }

    public List<Incidente> verInc() {

        return incidenteFacadeLocal.verInc();
    }
}