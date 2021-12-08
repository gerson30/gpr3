/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Inventario;
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
    public List<Inventario> leerTodo(){
        em.getEntityManagerFactory().getCache().evictAll();
        Query qi = em.createQuery("SELECT obj FROM Inventario obj ");
                return qi.getResultList();
    }
    /* REALIZAR CONSULTA*/
    
    @Override
    public boolean ingresarInventario(Inventario inv){
        
        /*se debe controlar el error con try catch (bloque de codigo por try y por catch */
        /*en los cambos "?" la informacion debe cambiar por tal movio se debe dejar "?"  */
        try {
           Query  qi = em.createNativeQuery("INSERT INTO tbl_inventario (fechaIngreso,fechaSalida,id_Inventario,id_EstadoEquipo,id_Equipo)VALUE ('?','?','?','?','?'); ");
           /* p asignaciones se realizar a nivel posicional posicion1...posicion2.posicion3....
            se debe realizar una asignacion de parametros*/
           qi.setParameter(1, inv.getFechaIngreso());
           qi.setParameter(2, inv.getFechaSalida());
           qi.setParameter(3, inv.getIdInventario());
           qi.setParameter(4, inv.getIdEstadoEquipo());
           qi.setParameter(5, inv.getIdEquipo());
           
           /* executeUpdate ejecuta el entity manager*/
           qi.executeUpdate();
           return true;
        } catch (Exception e) {
            return false;
        
        }
        

    
    }
}
