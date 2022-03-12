/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Inventario;
import java.util.Date;
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
public class InventarioFacade extends AbstractFacade<Inventario> implements InventarioFacadeLocal {

    @PersistenceContext(unitName = "up_gpr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }

    @Override
    public List<Inventario> verInv() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query coninv = em.createQuery("SELECT c FROM Inventario c");
        return coninv.getResultList();
    }

    @Override
    public List<Inventario> leerTodo() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query qi = em.createQuery("SELECT obj FROM Inventario obj ");
        return qi.getResultList();
    }

    

    
    @Override
    public boolean agregarinvtbl(Date fechaIngreso, int idEstadoEquipo) {

        /*se debe controlar el error con try catch (bloque de codigo por try y por catch */
 /*en los cambos "?" la informacion debe cambiar por tal movio se debe dejar "?"  */
        try {
            Query qi = em.createNativeQuery("INSERT INTO tbl_inventario (id_Equipo, fechaIngreso, id_EstadoEquipo) VALUES ((SELECT max(id_Equipo)  from tbl_equipos), ?,?);");
            qi.setParameter(1, fechaIngreso);
            qi.setParameter(2, idEstadoEquipo);

            /* executeUpdate ejecuta el entity manager*/
            qi.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    @Override
    public List<Inventario> leerporId(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
