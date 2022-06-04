/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Asignacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author PC
 */
@Stateless
public class AsignacionFacade extends AbstractFacade<Asignacion> implements AsignacionFacadeLocal{

    @PersistenceContext(unitName = "up_gpr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AsignacionFacade() {
        super(Asignacion.class);
    }

    @Override
    public boolean agregarAsignacion(Asignacion asignacion, Integer idColaborador, Integer idEquipo) {
        try {
            Query ac = em.createNativeQuery("INSERT INTO `gpr`.`tbl_asignacion` (`comentario`, `fecha_asignacion`, " 
                    + "`numero_activo`, `unidad`, `id_Equipo`, `id_Colab`, `estado`) VALUES (?, ?, ?, ?, ?, ?, ?);");
            
            ac.setParameter(1, asignacion.getComentario());
            ac.setParameter(2, asignacion.getFechaAsignacion());
            ac.setParameter(3, asignacion.getNumeroActivo());
            ac.setParameter(4, asignacion.getUnidad());
            ac.setParameter(5, idEquipo);
            ac.setParameter(6, idColaborador);
            ac.setParameter(7, asignacion.getEstado());

            ac.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Asignacion> verAsignacion() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query con = em.createQuery("SELECT a FROM Asignacion a");
        return con.getResultList();
    }

    @Override
    public boolean actualizarEstado(Integer idAsignacion) {
         try {
            Query ac = em.createNativeQuery("UPDATE `gpr`.`tbl_asignacion` SET estado = 'LIBERADO'  WHERE id_Asignacion = ?");
            
            ac.setParameter(1, idAsignacion); 

            ac.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
