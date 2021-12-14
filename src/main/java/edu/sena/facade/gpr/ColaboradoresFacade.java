/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Colaboradores;
import edu.sena.entity.gpr.Roles;
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
            Query ac = em.createNativeQuery("INSERT INTO `gpr`.`tbl_colaboradores` (`cedula`, "
                    + "`fechaIngreso`, `nombre`, `apellido`, `id_EstadoCivil`) VALUES ('?', "
                    + "'?', '?', '?', '?');");
            ac.setParameter(1, colIn.getCedula());
            ac.setParameter(2, colIn.getFechaIngreso());
            ac.setParameter(3, colIn.getNombre());
            ac.setParameter(4, colIn.getApellido());
            ac.setParameter(5, colIn.getIdEstadoCivil());

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

    

}
