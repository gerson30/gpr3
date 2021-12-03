/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.CondicionEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface CondicionEquipoFacadeLocal {

    void create(CondicionEquipo condicionEquipo);

    void edit(CondicionEquipo condicionEquipo);

    void remove(CondicionEquipo condicionEquipo);

    CondicionEquipo find(Object id);

    List<CondicionEquipo> findAll();

    List<CondicionEquipo> findRange(int[] range);

    int count();
    
}