/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Colaboradores;
import edu.sena.entity.gpr.Roles;
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

    public List<Colaboradores> verCol();

    public boolean agregarCol(Colaboradores colIn);

    public List<Roles> verRoles();

    public Object verRoles(String nombRol);

    public Colaboradores inicioSesion(String usuarioDominio, int contrasenaDominio);

    public Colaboradores recuperarContrasena(String usuarioDominio);
    

    public Colaboradores inicioSesion(String usuarioDominio, String contrasenaDominio);
    
}
