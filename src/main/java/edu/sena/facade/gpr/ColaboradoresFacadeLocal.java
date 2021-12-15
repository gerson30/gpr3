/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Colaboradores;
import java.util.Date;
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

    

    public List<Colaboradores> verCol();

    public boolean agregarCol2(Colaboradores colIn, double cedula, Date fechaingreso, Date fecharetiro, String nombre, String apellido, Date fechanacimiento, String direccion, String barrio, String ciudad, String nombreContacto, String apellidoContacto, String usuarioDominio, int contrasenaDominio, String correo, int idEstadocolab, int idEstadocivil, int idGenero, int idTelefonos, int idArea, int idParentesco);

    public boolean agregarCol(Colaboradores colIn);

    
}
