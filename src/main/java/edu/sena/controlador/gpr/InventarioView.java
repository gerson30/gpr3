/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.CondicionEquipo;
import edu.sena.entity.gpr.Equipos;
import edu.sena.entity.gpr.EstadoEquipo;
import edu.sena.entity.gpr.Inventario;
import edu.sena.entity.gpr.Marca;
import edu.sena.entity.gpr.Tipopc;
import edu.sena.facade.gpr.CondicionEquipoFacadeLocal;
import edu.sena.facade.gpr.EquiposFacadeLocal;
import edu.sena.facade.gpr.EstadoEquipoFacadeLocal;
import edu.sena.facade.gpr.InventarioFacadeLocal;
import edu.sena.facade.gpr.MarcaFacadeLocal;
import edu.sena.facade.gpr.TipopcFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.PrimeFaces;

/**
 *
 * @author gjimenezo
 */
@Named(value = "inventarioView")
@ViewScoped
public class InventarioView implements Serializable {

    @EJB
    InventarioFacadeLocal inventarioFacadeLocal;

    @EJB
    TipopcFacadeLocal tipopcFacadeLocal;

    @EJB
    MarcaFacadeLocal marcaFacadeLocal;

    @EJB
    CondicionEquipoFacadeLocal condicionEquipoFacadeLocal;

    @EJB
    EstadoEquipoFacadeLocal estadoEquipoFacadeLocal;

    @EJB
    EquiposFacadeLocal equiposFacadeLocal;

    /*alerta */
    private String alerta = "";

    private ArrayList<CondicionEquipo> listacondiciones = new ArrayList<>();
    private ArrayList<Marca> listademarcas = new ArrayList<>();
    private ArrayList<Tipopc> listadetipos = new ArrayList<>();
    private ArrayList<EstadoEquipo> listadeestados = new ArrayList<>();
    private Equipos nuevoequipo = new Equipos();
    Inventario invnue = new Inventario();
    private int idTipoPc;
    private int idMarca;
    private int idCondicion;
    private Date fechaingreso;
    private int idEstadoequipo;

    /**
     * Creates a new instance of InventarioView
     */
    public InventarioView() {
    }

    @PostConstruct
    public void init() {
        listadetipos.addAll(tipopcFacadeLocal.findAll());
        listademarcas.addAll(marcaFacadeLocal.findAll());
        listacondiciones.addAll(condicionEquipoFacadeLocal.findAll());
        listadeestados.addAll(estadoEquipoFacadeLocal.findAll());
    }

    public List<Inventario> verInv() {

        return inventarioFacadeLocal.verInv();
    }

    /*leerTodo agregar inventario*/
    public void ingresarEquipo() {

        /* se debe hacer el binding para llamar  gett and setter y se llama invnue */
        if (equiposFacadeLocal.ingresarEquipo(nuevoequipo, idTipoPc, idMarca, idCondicion)) {
            inventarioFacadeLocal.agregarinvtbl(fechaingreso, idEstadoequipo);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Equipo',"
                    + "  'Creado con Exito !!!',"
                    + "  'success'"
                    + ")");
            nuevoequipo = new Equipos();
        } else {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Equipo',"
                    + "  'No se puede registrar, Intente de nuevo',"
                    + "  'error'"
                    + ")");
            alerta = "ok";
            invnue = new Inventario();
        } 

    }

    /*

    public String editarEquipo() {
        try {
            equiposFacadeLocal.edit(nuevoequipo);
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Equipo',"
                    + "  'Actualizado, Exitosamente !!!',"
                    + "  'success'"
                    + ")");
        } catch (Exception e) {
            PrimeFaces.current().executeScript("Swal.fire("
                    + "  'Equipo',"
                    + "  'No se puede actualizar, Intente de nuevo',"
                    + "  'error'"
                    + ")");
        }
    }
*/
    public Equipos getNuevoequipo() {
        return nuevoequipo;
    }

    public void setNuevoequipo(Equipos nuevoequipo) {
        this.nuevoequipo = nuevoequipo;
    }

    public Inventario getInvnue() {
        return invnue;
    }

    public void setInvnue(Inventario invnue) {
        this.invnue = invnue;
    }

    public ArrayList<Tipopc> getListadetipos() {
        return listadetipos;
    }

    public void setListadetipos(ArrayList<Tipopc> listadetipos) {
        this.listadetipos = listadetipos;
    }

    public int getIdTipoPc() {
        return idTipoPc;
    }

    public void setIdTipoPc(int idTipoPc) {
        this.idTipoPc = idTipoPc;
    }

    public ArrayList<Marca> getListademarcas() {
        return listademarcas;
    }

    public void setListademarcas(ArrayList<Marca> listademarcas) {
        this.listademarcas = listademarcas;
    }

    public int getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(int idMarca) {
        this.idMarca = idMarca;
    }

    public ArrayList<CondicionEquipo> getListacondiciones() {
        return listacondiciones;
    }

    public void setListacondiciones(ArrayList<CondicionEquipo> listacondiciones) {
        this.listacondiciones = listacondiciones;
    }

    public int getIdCondicion() {
        return idCondicion;
    }

    public void setIdCondicion(int idCondicion) {
        this.idCondicion = idCondicion;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public ArrayList<EstadoEquipo> getListadeestados() {
        return listadeestados;
    }

    public void setListadeestados(ArrayList<EstadoEquipo> listadeestados) {
        this.listadeestados = listadeestados;
    }

    public int getIdEstadoequipo() {
        return idEstadoequipo;
    }

    public void setIdEstadoequipo(int idEstadoequipo) {
        this.idEstadoequipo = idEstadoequipo;
    }

    public String getAlerta() {
        return alerta;
    }

    public void setAlerta(String alerta) {
        this.alerta = alerta;
    }

    
    /*
    public Equipos getEquipoTemporal() {
        return equipoTemporal;
    }

    public void setEquipoTemporal(Equipos equipoTemporal) {
        this.equipoTemporal = equipoTemporal;
    }   */
}
