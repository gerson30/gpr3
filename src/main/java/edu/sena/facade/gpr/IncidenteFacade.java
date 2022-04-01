/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;


import edu.sena.entity.gpr.Incidente;
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
public class IncidenteFacade extends AbstractFacade<Incidente> implements IncidenteFacadeLocal {

    @PersistenceContext(unitName = "up_gpr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IncidenteFacade() {
        super(Incidente.class);
    }

    @Override
    public List<Incidente> verInc() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query coninc=em.createQuery("SELECT i FROM Incidente i");
        return coninc.getResultList();
    }
    
    @Override
    public boolean eliminar(Integer idColaboradores) {
       try { 
           System.out.println("idColaboradores: "+ idColaboradores);
            Query qi = em.createNativeQuery("DELETE FROM tbl_incidente where fk_colabAsigna=? ");
            qi.setParameter(1, idColaboradores);

            qi.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    @Override
    public List<Incidente> buscarPorColaborador(Integer idColaboradores) {
       
        try {
            Query q = em.createQuery("SELECT c FROM Incidente c WHERE c.colaboradores1.idColab = :idColaboradores");
            q.setParameter("idColaboradores", idColaboradores);
            return  q.getResultList();
        } catch (Exception e) {
            return null;
        }
     
    }
    
}
