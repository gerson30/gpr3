/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Asignacion;
import edu.sena.entity.gpr.Colaboradores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PC
 */
@Local
public interface AsignacionFacadeLocal {
    
    List<Asignacion> findAll();
    public boolean agregarAsignacion(Asignacion asignacion, Integer idColaborador, Integer idEquipo);
    public boolean actualizarEstado(Integer idAsignacion);
    public List<Asignacion> verAsignacion();
    
}