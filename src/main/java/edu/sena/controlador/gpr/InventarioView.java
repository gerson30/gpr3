/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.Colaboradores_;
import edu.sena.entity.gpr.Inventario;
import edu.sena.facade.gpr.InventarioFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author gjimenezo
 */
@Named(value = "inventarioView")
@ViewScoped
public class InventarioView implements Serializable {

    @EJB
    InventarioFacadeLocal inventarioFacadeLocal;

    Inventario invnue = new Inventario();

    public Inventario getInvnue() {
        return invnue;
    }

    public void setInvnue(Inventario invnue) {
        this.invnue = invnue;
    }

    /**
     * Creates a new instance of InventarioView
     */
    public InventarioView() {
    }

    public List<Inventario> verInv() {

        return inventarioFacadeLocal.verInv();
    }

    /*leerTodo agregar inventario*/
    public void ingresarInventario() {
        
        /* se debe hacer el binding para llamar  gett and setter y se llama invnue */
        
        if(inventarioFacadeLocal.ingresarInventario(invnue)){
            System.out.println("Usuario Creado");
        }else{
            System.out.println("Error al crear usuario");
        }
        
        

    }

}
