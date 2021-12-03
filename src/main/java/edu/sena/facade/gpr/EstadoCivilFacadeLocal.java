/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.EstadoCivil;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface EstadoCivilFacadeLocal {

    void create(EstadoCivil estadoCivil);

    void edit(EstadoCivil estadoCivil);

    void remove(EstadoCivil estadoCivil);

    EstadoCivil find(Object id);

    List<EstadoCivil> findAll();

    List<EstadoCivil> findRange(int[] range);

    int count();
    
}
