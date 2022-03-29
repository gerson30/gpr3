/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.facade.gpr;
import edu.sena.entity.gpr.Inventario;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gjimenezo
 */
@Local
public interface InventarioFacadeLocal {

    void create(Inventario inventario);

    void edit(Inventario inventario);

    void remove(Inventario inventario);

    Inventario find(Object id);

    List<Inventario> findAll();

    List<Inventario> findRange(int[] range);

    int count();

    public List<Inventario> verInv();
/*leerTodo es para consulta agregar inventario*/
    public List<Inventario> leerTodo();

    public boolean agregarinvtbl(Date fechaIngreso, int idEstadoEquipo);
    
    public List<Inventario> leerporId(int Id);

    public List<Inventario> verInv(Date fechaingreso, int idCondicion, int idEstadoequipo, int idMarca, int idMarca0, int idTipoPc);

    
    

}
