/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.CategoriaPrioridad;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface CategoriaPrioridadFacadeLocal {

    void create(CategoriaPrioridad categoriaPrioridad);

    void edit(CategoriaPrioridad categoriaPrioridad);

    void remove(CategoriaPrioridad categoriaPrioridad);

    CategoriaPrioridad find(Object id);

    List<CategoriaPrioridad> findAll();

    List<CategoriaPrioridad> findRange(int[] range);

    int count();
    
}
