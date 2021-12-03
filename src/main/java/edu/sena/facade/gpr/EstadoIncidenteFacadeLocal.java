/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.EstadoIncidente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface EstadoIncidenteFacadeLocal {

    void create(EstadoIncidente estadoIncidente);

    void edit(EstadoIncidente estadoIncidente);

    void remove(EstadoIncidente estadoIncidente);

    EstadoIncidente find(Object id);

    List<EstadoIncidente> findAll();

    List<EstadoIncidente> findRange(int[] range);

    int count();
    
}
