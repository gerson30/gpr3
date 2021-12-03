/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.EstadoColaborador;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface EstadoColaboradorFacadeLocal {

    void create(EstadoColaborador estadoColaborador);

    void edit(EstadoColaborador estadoColaborador);

    void remove(EstadoColaborador estadoColaborador);

    EstadoColaborador find(Object id);

    List<EstadoColaborador> findAll();

    List<EstadoColaborador> findRange(int[] range);

    int count();
    
}
