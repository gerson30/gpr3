/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Tipopc;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface TipopcFacadeLocal {

    void create(Tipopc tipopc);

    void edit(Tipopc tipopc);

    void remove(Tipopc tipopc);

    Tipopc find(Object id);

    List<Tipopc> findAll();

    List<Tipopc> findRange(int[] range);

    int count();
    
}
