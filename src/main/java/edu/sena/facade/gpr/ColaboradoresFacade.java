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
    public List<Colaboradores> verCol(){
        em.getEntityManagerFactory().getCache().evictAll();
        Query con=em.createQuery("SELECT c FROM Colaboradores c");
        return con.getResultList();
    }
}
