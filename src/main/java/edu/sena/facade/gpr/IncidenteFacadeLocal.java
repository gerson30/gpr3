/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Incidente;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface IncidenteFacadeLocal {

    void create(Incidente incidente);

    void edit(Incidente incidente);

    void remove(Incidente incidente);

    Incidente find(Object id);

    List<Incidente> findAll();

    List<Incidente> findRange(int[] range);

    int count();
    
}
