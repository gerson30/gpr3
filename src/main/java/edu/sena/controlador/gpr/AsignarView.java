/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.Asignacion;
import edu.sena.entity.gpr.Colaboradores;
import edu.sena.entity.gpr.Equipos;
import edu.sena.facade.gpr.AsignacionFacadeLocal;
import edu.sena.facade.gpr.ColaboradoresFacadeLocal;
import edu.sena.facade.gpr.EquiposFacadeLocal;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.PrimeFaces;

/**
 *
 * @author PC
 */
@Named(value = "asignarView")
@ViewScoped
public class AsignarView implements Serializable {
    
    @EJB
    ColaboradoresFacadeLocal colaboradoresFacadeLocal;
    
    @EJB
    EquiposFacadeLocal equiposFacadeLocal;
    
    @EJB
    AsignacionFacadeLocal asignacionFacadeLocal;
    
    List<Colaboradores> listaColaboradores = new ArrayList<>();
    List<Equipos> listaEquipos = new ArrayList<>();
    Asignacion nuevoAsignacion = new Asignacion();
    Asignacion selectedAsignacion;
    
    Integer idColaborador;
    Integer idEquipo;
    
    @PostConstruct
    public void init() {
        obtenerEquipos();
        obtenerColaboradores();
    }
    
    public void obtenerColaboradores(){
        List<Colaboradores> listAux = colaboradoresFacadeLocal.findAll();
        List<Asignacion> listaAsignacion = asignacionFacadeLocal.findAll();
        
        if(listaAsignacion!= null && !listaAsignacion.isEmpty()){
            
            for(Colaboradores col : listAux){
                boolean existeColaborador = false;
                for(Asignacion asi : listaAsignacion){
                    
                    if(asi.getId_Colab().getIdColab() == col.getIdColab() && asi.getEstado().equals("ASIGNADO")){
                        existeColaborador = true;
                    }
                }
                if(!existeColaborador){
                    listaColaboradores.add(col);
                }
            }
            
            
        } else {
            listaColaboradores.addAll(listAux);
        }
    }
    
    
    public void obtenerEquipos(){
        
        List<Equipos> listAux = equiposFacadeLocal.findAll();
        List<Asignacion> listaAsignacion = asignacionFacadeLocal.findAll();
        
        if(listaAsignacion!= null && !listaAsignacion.isEmpty()){
            
            for(Equipos equ : listAux){
                boolean existeEquipo = false;
                for(Asignacion asi : listaAsignacion){
                    
                    if(asi.getIdEquipoo().getIdEquipo()== equ.getIdEquipo() && asi.getEstado().equals("ASIGNADO")){
                        existeEquipo = true;
                    }
                }
                if(!existeEquipo){
                    listaEquipos.add(equ);
                }
            }
            
            
        } else {
            listaEquipos.addAll(listAux);
        }
    }
    
    public void ingresarAsignacion() throws IOException {
        
        nuevoAsignacion.setFechaAsignacion(new Date());
        nuevoAsignacion.setEstado("ASIGNADO");
        asignacionFacadeLocal.agregarAsignacion(nuevoAsignacion, idColaborador, idEquipo);
        
        obtenerColaboradores();
        obtenerEquipos();
        limpiarDatos();
        
        PrimeFaces.current().executeScript("Swal.fire("
            + "  'Asignacion',"
            + "  'Creado con Exito !!!',"
            + "  'success'"
            + ")");
        
        
    }
    
    public List<Asignacion> verAsignacion() {
        List<Asignacion> listaAux = asignacionFacadeLocal.verAsignacion();
        List<Asignacion> listaAsignacion = new ArrayList<>();
        
        if(listaAux!=null && !listaAux.isEmpty()){
            for(Asignacion a : listaAux){
                if(a.getEstado().equals("ASIGNADO")){
                    listaAsignacion.add(a);
                }
            }
        }
                
        return listaAsignacion;
    }
   
    public void liberarActivo() {
        System.out.println("liberar activo");
        System.out.println("id asignacion:" + selectedAsignacion.getIdAsignacion());
        asignacionFacadeLocal.actualizarEstado(selectedAsignacion.getIdAsignacion());
        
        PrimeFaces.current().executeScript("Swal.fire("
                + "  'Activo',"
                + "  'Se libero activo',"
                + "  'error'"
                + ")");

    }
    
    public void limpiarDatos(){
        nuevoAsignacion = new Asignacion();
        idColaborador=1;
        idEquipo=1;
    }

    public List<Colaboradores> getListaColaboradores() {
        return listaColaboradores;
    }

    public void setListaColaboradores(List<Colaboradores> listaColaboradores) {
        this.listaColaboradores = listaColaboradores;
    }

    public Integer getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Integer idColaborador) {
        this.idColaborador = idColaborador;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public List<Equipos> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(List<Equipos> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public Asignacion getNuevoAsignacion() {
        return nuevoAsignacion;
    }

    public void setNuevoAsignacion(Asignacion nuevoAsignacion) {
        this.nuevoAsignacion = nuevoAsignacion;
    }

    public Asignacion getSelectedAsignacion() {
        return selectedAsignacion;
    }

    public void setSelectedAsignacion(Asignacion selectedAsignacion) {
        this.selectedAsignacion = selectedAsignacion;
    }  

}