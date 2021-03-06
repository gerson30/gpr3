/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;

import edu.sena.entity.gpr.Equipos;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gjimenezo
 */
@Stateless
public class EquiposFacade extends AbstractFacade<Equipos> implements EquiposFacadeLocal {
        
    @EJB
    EquiposFacadeLocal equiposFacadeLocal;
    
    Equipos nuequi = new Equipos();
    
    @Override
    public List<Equipos> leerTodo() {
        em.getEntityManagerFactory().getCache().evictAll();
        Query qt = em.createQuery("SELECT e FROM Equipos e");
        return qt.getResultList();
    }
   
    @PersistenceContext(unitName = "up_gpr")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EquiposFacade() {
        super(Equipos.class);
    }
    
    
    
    @Override
    public boolean ingresarEquipo(Equipos nuequi,int idTipopc, int idMarca,int idCondicion) {

        
        try {
            Query qi = em.createNativeQuery("INSERT INTO tbl_equipos ( id_TipoPc,"
                    + " id_CondicionEquipo, id_Marca,"
                    + " modelo, serial,"
                    + " sistemaOperativo, microssoftOffice,"
                    + " procesador, memoriaRam,"
                    + " capacidadDiscoDuro, comentarios) "
                    + "VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            qi.setParameter(1, idTipopc);
            qi.setParameter(2, idCondicion);
            qi.setParameter(3, idMarca);
            qi.setParameter(4, nuequi.getModelo());
            qi.setParameter(5, nuequi.getSerial());
            qi.setParameter(6, nuequi.getSistemaOperativo());
            qi.setParameter(7, nuequi.getMicrossoftOffice());
            qi.setParameter(8, nuequi.getProcesador());
            qi.setParameter(9, nuequi.getMemoriaRam());
            qi.setParameter(10, nuequi.getCapacidadDiscoDuro());
            qi.setParameter(11, nuequi.getComentarios());

            qi.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }

    }

    @Override
    public boolean actualizar(Equipos equipo) {
        
        try {
            Query qi = em.createNativeQuery("UPDATE tbl_equipos SET id_TipoPc=?,"
                    + " id_CondicionEquipo=?, id_Marca=?,"
                    + " modelo=?, serial=?,"
                    + " sistemaOperativo=?, microssoftOffice=?,"
                    + " procesador=?, memoriaRam=?,"
                    + " capacidadDiscoDuro=?, comentarios=? where id_Equipo=? ");
            qi.setParameter(1, equipo.getIdTipoPc().getIdTipoPc());
            qi.setParameter(2, equipo.getIdCondicionEquipo().getIdCondicionEquipo());
            qi.setParameter(3, equipo.getIdMarca().getIdMarca());
            qi.setParameter(4, equipo.getModelo());
            qi.setParameter(5, equipo.getSerial());
            qi.setParameter(6, equipo.getSistemaOperativo());
            qi.setParameter(7, equipo.getMicrossoftOffice());
            qi.setParameter(8, equipo.getProcesador());
            qi.setParameter(9, equipo.getMemoriaRam());
            qi.setParameter(10, equipo.getCapacidadDiscoDuro());
            qi.setParameter(11, equipo.getComentarios());
            qi.setParameter(12, equipo.getIdEquipo());

            qi.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }
    
    }

    @Override
    public boolean eliminar(Integer idEquipo) {
       try {
           System.out.println("idEquipo: "+ idEquipo);
            Query qi = em.createNativeQuery("DELETE FROM tbl_equipos where id_Equipo=? ");
            qi.setParameter(1, idEquipo);

            qi.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;

        }
    }
    
}
