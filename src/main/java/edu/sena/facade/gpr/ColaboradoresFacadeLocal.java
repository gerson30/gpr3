/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Colaboradores;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface ColaboradoresFacadeLocal {

    void create(Colaboradores colaboradores);

    void edit(Colaboradores colaboradores);

    void remove(Colaboradores colaboradores);

    Colaboradores find(Object id);

    List<Colaboradores> findAll();

    List<Colaboradores> findRange(int[] range);

    int count();

    public Colaboradores recuperarContrasena(String usuarioDominio);

    public Colaboradores inicioSesion(String usuarioDominio, String contrasenaDominio);

     public boolean agregarCol(Colaboradores colIn);
     
    public boolean agregarColaborador(Colaboradores colIn, Integer idEstadoCivil, Integer idGenero, 
            Integer idTelefono, Integer idArea, Integer idParentesco);

    public List<Colaboradores> verCol();
    
    public List<Colaboradores> buscarPorInventario(Integer idInventario);
    
    public boolean eliminarPorInventario(Integer idInventario);

    
}
