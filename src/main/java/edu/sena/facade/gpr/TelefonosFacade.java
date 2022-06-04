/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Telefonos;
import java.math.BigInteger;
import java.sql.ResultSet;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gjimenezo
 */
@Stateless
public class TelefonosFacade extends AbstractFacade<Telefonos> implements TelefonosFacadeLocal {

    @PersistenceContext(unitName = "up_gpr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TelefonosFacade() {
        super(Telefonos.class);
    }

    @Override
    public boolean ingresarTelefono(Telefonos telefonos) {
       
        
        try {
            Query qi = em.createNativeQuery("INSERT INTO tbl_telefonos ( telFijo, telCel, telContactFijo, telContactCel) "
                    + "VALUES (? , ?, ?, ?);");
            qi.setParameter(1, telefonos.getTelFijo());
            qi.setParameter(2, telefonos.getTelCel());
            qi.setParameter(3, telefonos.getTelContactFijo());
            qi.setParameter(4, telefonos.getTelContactCel());

            qi.executeUpdate();
                    
            
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    @Override
    public Integer obtenerUltimoId() {
        
        Integer identificador = 0;
        Query findQuery = em.createQuery("SELECT t FROM Telefonos t ORDER BY t.idTelefono DESC").setMaxResults(1);

        Telefonos telefonos = (Telefonos) findQuery.getSingleResult();
        
        if(telefonos!=null){
            identificador = telefonos.getIdTelefono();
        }
        
        return  identificador;
        
    }
    
}