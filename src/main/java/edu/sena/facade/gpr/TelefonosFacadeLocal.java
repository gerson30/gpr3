/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Equipos;
import edu.sena.entity.gpr.Telefonos;
import java.math.BigInteger;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface TelefonosFacadeLocal {

    void create(Telefonos telefonos);

    void edit(Telefonos telefonos);

    void remove(Telefonos telefonos);

    Telefonos find(Object id);

    List<Telefonos> findAll();

    List<Telefonos> findRange(int[] range);

    int count();
    
    public boolean ingresarTelefono(Telefonos telefonos);
    
    Integer obtenerUltimoId();
}
