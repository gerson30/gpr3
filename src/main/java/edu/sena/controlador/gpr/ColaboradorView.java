/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.controlador.gpr;

import edu.sena.entity.gpr.Area;
import edu.sena.entity.gpr.Colaboradores;
import edu.sena.entity.gpr.EstadoCivil;
import edu.sena.entity.gpr.EstadoColaborador;
import edu.sena.entity.gpr.Genero;
import edu.sena.entity.gpr.Inventario;
import edu.sena.entity.gpr.Parentesco;
import edu.sena.entity.gpr.Roles;
import edu.sena.entity.gpr.Telefonos;
import edu.sena.facade.gpr.AreaFacadeLocal;
import edu.sena.facade.gpr.ColaboradoresFacadeLocal;
import edu.sena.facade.gpr.EstadoCivilFacadeLocal;
import edu.sena.facade.gpr.EstadoColaboradorFacadeLocal;
import edu.sena.facade.gpr.GeneroFacadeLocal;
import edu.sena.facade.gpr.InventarioFacadeLocal;
import edu.sena.facade.gpr.ParentescoFacadeLocal;
import edu.sena.facade.gpr.RolesFacadeLocal;
import edu.sena.facade.gpr.TelefonosFacadeLocal;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author gjimenezo
 */
@Named(value = "colaboradorView")
@ViewScoped
public class ColaboradorView implements Serializable {

    @EJB
    ColaboradoresFacadeLocal colaboradoresFacadeLocal;
    @EJB
    EstadoColaboradorFacadeLocal estadoColaboradorFacadeLocal;
    @EJB
    EstadoCivilFacadeLocal estadoCivilFacadeLocal;
    @EJB
    GeneroFacadeLocal generoFacadeLocal;
    @EJB
    TelefonosFacadeLocal telefonosFacadeLocal;
    @EJB
    AreaFacadeLocal areaFacadeLocal;
    @EJB
    ParentescoFacadeLocal parentescoFacadeLocal;
    @EJB
    RolesFacadeLocal rolesFacadeLocal;
    @EJB
    InventarioFacadeLocal inventarioFacadeLocal;
    

    private ArrayList<Inventario> listainventario = new ArrayList<>();
    private ArrayList<Roles> listarol = new ArrayList<>();
    private ArrayList<Parentesco> listaparentesco = new ArrayList<>();
    private ArrayList<Area> listaarea = new ArrayList<>();
    private ArrayList<Telefonos> listatelefonos = new ArrayList<>();
    private ArrayList<Genero> listagenero = new ArrayList<>();
    private ArrayList<EstadoCivil> listadeestadociv = new ArrayList<>();
    private ArrayList<EstadoColaborador> listadeestadoscol = new ArrayList<>();
    private Colaboradores nuevocol = new Colaboradores();
    private int idEstadocolab;
    private int idEstadociv;
    private int idGenero;
    private int idTelefono;
    private int idArea;
    private int idParentesco;
    private int idRol;
    private Date fechaIngreso;
    private Date fechaRetiro;
    private Date fechaNacimiento;
    private int idInventario;

    /**
     * Creates a new instance of ColaboradorView
     */
    public ColaboradorView() {
    }

    @PostConstruct
    public void init2() {
        listadeestadoscol.addAll(estadoColaboradorFacadeLocal.findAll());
        listadeestadociv.addAll(estadoCivilFacadeLocal.findAll());
        listagenero.addAll(generoFacadeLocal.findAll());
        listatelefonos.addAll(telefonosFacadeLocal.findAll());
        listaarea.addAll(areaFacadeLocal.findAll());
        listaparentesco.addAll(parentescoFacadeLocal.findAll());
        listarol.addAll(rolesFacadeLocal.findAll());
        listainventario.addAll(inventarioFacadeLocal.findAll());
    }

    public List<Colaboradores> verCol() {

        return colaboradoresFacadeLocal.verCol();
    }

    public Colaboradores getNuevocol() {
        return nuevocol;
    }

    public void setNuevocol(Colaboradores nuevocol) {
        this.nuevocol = nuevocol;
    }

    public ArrayList<EstadoColaborador> getListadeestadoscol() {
        return listadeestadoscol;
    }

    public void setListadeestadoscol(ArrayList<EstadoColaborador> listadeestadoscol) {
        this.listadeestadoscol = listadeestadoscol;
    }

    public int getIdEstadocolab() {
        return idEstadocolab;
    }

    public void setIdEstadocolab(int idEstadocolab) {
        this.idEstadocolab = idEstadocolab;
    }

    public ArrayList<EstadoCivil> getListadeestadociv() {
        return listadeestadociv;
    }

    public void setListadeestadociv(ArrayList<EstadoCivil> listadeestadociv) {
        this.listadeestadociv = listadeestadociv;
    }

    public int getIdEstadociv() {
        return idEstadociv;
    }

    public void setIdEstadociv(int idEstadociv) {
        this.idEstadociv = idEstadociv;
    }

    public ArrayList<Genero> getListagenero() {
        return listagenero;
    }

    public void setListagenero(ArrayList<Genero> listagenero) {
        this.listagenero = listagenero;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public ArrayList<Parentesco> getListaparentesco() {
        return listaparentesco;
    }

    public void setListaparentesco(ArrayList<Parentesco> listaparentesco) {
        this.listaparentesco = listaparentesco;
    }

    public ArrayList<Area> getListaarea() {
        return listaarea;
    }

    public void setListaarea(ArrayList<Area> listaarea) {
        this.listaarea = listaarea;
    }

    public ArrayList<Telefonos> getListatelefonos() {
        return listatelefonos;
    }

    public void setListatelefonos(ArrayList<Telefonos> listatelefonos) {
        this.listatelefonos = listatelefonos;
    }

    public int getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(int idTelefono) {
        this.idTelefono = idTelefono;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(int idParentesco) {
        this.idParentesco = idParentesco;
    }

    public ArrayList<Roles> getListarol() {
        return listarol;
    }

    public void setListarol(ArrayList<Roles> listarol) {
        this.listarol = listarol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaRetiro() {
        return fechaRetiro;
    }

    public void setFechaRetiro(Date fechaRetiro) {
        this.fechaRetiro = fechaRetiro;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Inventario> getListainventario() {
        return listainventario;
    }

    public void setListainventario(ArrayList<Inventario> listainventario) {
        this.listainventario = listainventario;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

}
