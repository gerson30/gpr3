/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Comentarios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gjimenezo
 */
@Stateless
public class ComentariosFacade extends AbstractFacade<Comentarios> implements ComentariosFacadeLocal {

    @PersistenceContext(unitName = "up_gpr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ComentariosFacade() {
        super(Comentarios.class);
    }

    @Override
    public boolean eliminarPorIncidente(Integer idIncidente) {
        
        try { 
           System.out.println("idIncidente: "+ idIncidente);
            Query qi = em.createNativeQuery("DELETE FROM tbl_comentarios where id_Ticket=? ");
            qi.setParameter(1, idIncidente);

            qi.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }
    
    }
    
}
