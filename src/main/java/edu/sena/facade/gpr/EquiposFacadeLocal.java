/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Equipos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface EquiposFacadeLocal {

    void create(Equipos equipos);
    void edit(Equipos equipos);
    void remove(Equipos equipos);
    Equipos find(Object id);
    List<Equipos> findAll();
    List<Equipos> findRange(int[] range);
    int count();
    public List<Equipos> leerTodo();
    public boolean ingresarEquipo(Equipos nuequi, int idTipopc, int idMarca, int idCondicion);
    //esta es una prueba para editar equipo
    public boolean actualizar(Equipos nuequi);
    public boolean eliminar(Integer idEquipo);    
    
}