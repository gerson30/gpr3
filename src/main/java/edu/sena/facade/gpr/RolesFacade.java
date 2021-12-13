/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;


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
public class RolesFacade extends AbstractFacade<Roles> implements RolesFacadeLocal {

    @PersistenceContext(unitName = "up_gpr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolesFacade() {
        super(Roles.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Roles> verRoles() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query vr = em.createQuery("SELECT r FROM Roles r");
        return vr.getResultList();
    } 
    
    @Override
    public Roles ponerRoles(String tipoRol) {
        try {
            Query q = em.createQuery("SELECT r FROM Roles r WHERE r.tipoRol = :tipoRol");
            q.setParameter("tipoRol", tipoRol);
            return (Roles) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }

    }
    
    
}
