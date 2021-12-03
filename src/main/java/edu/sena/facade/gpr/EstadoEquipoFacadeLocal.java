/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.EstadoEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface EstadoEquipoFacadeLocal {

    void create(EstadoEquipo estadoEquipo);

    void edit(EstadoEquipo estadoEquipo);

    void remove(EstadoEquipo estadoEquipo);

    EstadoEquipo find(Object id);

    List<EstadoEquipo> findAll();

    List<EstadoEquipo> findRange(int[] range);

    int count();
    
}
