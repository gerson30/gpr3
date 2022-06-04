/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Colaboradores;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gjimenezo
 */
@Stateless
public class ColaboradoresFacade extends AbstractFacade<Colaboradores> implements ColaboradoresFacadeLocal {

    @PersistenceContext(unitName = "up_gpr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ColaboradoresFacade() {
        super(Colaboradores.class);
    }

    @Override
    public List<Colaboradores> verCol() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query con = em.createQuery("SELECT c FROM Colaboradores c");
        return con.getResultList();
    }


//    @Override
//    public boolean agregarCol(Colaboradores colIn) {
//        try {
//            Query ac = em.createNativeQuery(
//                    ac.setParameter(1, colIn.getCedula());
//            ac.setParameter(2, colIn.getNombre());
//            ac.setParameter(3, colIn.getApellido());
//            ac.setParameter(4, colIn.getUsuarioDominio());
//            ac.setParameter(5, colIn.getContrasenaDominio());
//            ac.executeUpdate();
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }

    @Override
    public boolean agregarCol(Colaboradores colIn) {
        try {
            Query ac = em.createNativeQuery("INSERT INTO `gpr`.`tbl_colaboradores` (`cedula`, `fechaIngreso`, `nombre`, "
                    + "`apellido`, `fechaNacim`)"
                    + " VALUES (?, ?, ?, ?, ?, ?);");
            ac.setParameter(1, colIn.getCedula());
            ac.setParameter(2, colIn.getFechaIngreso());
            ac.setParameter(3, colIn.getNombre());
            ac.setParameter(4, colIn.getApellido());
            ac.setParameter(5, colIn.getFechaNacim());

            ac.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    @Override
    public boolean agregarColaborador(Colaboradores colIn, Integer idEstadoCivil, Integer idGenero, 
            Integer idTelefono, Integer idArea, Integer idParentesco) {
        try {
            Query ac = em.createNativeQuery("INSERT INTO `gpr`.`tbl_colaboradores` (`cedula`, `fechaIngreso`, `nombre`, "
                    + "`apellido`, `fechaNacim`, `id_EstadoCivil`, `id_Genero`, `direccion`, `id_Telefono`, `id_Area`, `nombreContacto`, "
                    + "`apellidoContacto`, `id_Parentesco`, `correo`, `contrasenaDominio`, `usuarioDominio`)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ac.setParameter(1, colIn.getCedula());
            ac.setParameter(2, colIn.getFechaIngreso());
            ac.setParameter(3, colIn.getNombre());
            ac.setParameter(4, colIn.getApellido());
            ac.setParameter(5, colIn.getFechaNacim());
            ac.setParameter(6, idEstadoCivil);
            ac.setParameter(7, idGenero);
            ac.setParameter(8, colIn.getDireccion());
            ac.setParameter(9, idTelefono);
            ac.setParameter(10, idArea);
            ac.setParameter(11, colIn.getNombreContacto());
            ac.setParameter(12, colIn.getApellidoContacto());
            ac.setParameter(13, idParentesco);
            ac.setParameter(14, colIn.getCorreo());
            ac.setParameter(15, colIn.getContrasenaDominio());            
            ac.setParameter(16, colIn.getUsuarioDominio());

            ac.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    public Colaboradores inicioSesion(String usuarioDominio, String contrasenaDominio) {
        try {
            Query q = em.createQuery("SELECT c FROM Colaboradores c WHERE c.usuarioDominio = :usuarioDominio AND c.contrasenaDominio = :contrasenaDominio");
            q.setParameter("usuarioDominio", usuarioDominio);
            q.setParameter("contrasenaDominio", Integer.parseInt(contrasenaDominio));
            return (Colaboradores) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Colaboradores recuperarContrasena(String usuarioDominio) {
        try {
            Query q = em.createQuery("SELECT c FROM Colaboradores c WHERE c.usuarioDominio = :usuarioDominio");
            q.setParameter("usuarioDominio", usuarioDominio);
            return (Colaboradores) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public boolean eliminarPorInventario(Integer idInventario) {
          System.out.println("idInventario: " + idInventario);
       try {
            Query qi = em.createNativeQuery("DELETE FROM tbl_colaboradores where id_Inventario=? ");
            qi.setParameter(1, idInventario);

            qi.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public List<Colaboradores> buscarPorInventario(Integer idInventario) {
         try {
            Query q = em.createQuery("SELECT c FROM Colaboradores c WHERE c.idInventario.idInventario = :idInventario");
            q.setParameter("idInventario", idInventario);
            return  q.getResultList();
        } catch (Exception e) {
            return null;
        }
    
    }

    

}
