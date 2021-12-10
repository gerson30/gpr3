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
}
