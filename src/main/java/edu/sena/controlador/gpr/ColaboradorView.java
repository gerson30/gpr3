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
import edu.sena.entity.gpr.Parentesco;
import edu.sena.entity.gpr.Telefonos;
import edu.sena.facade.gpr.AreaFacadeLocal;
import edu.sena.facade.gpr.ColaboradoresFacadeLocal;
import edu.sena.facade.gpr.EstadoCivilFacadeLocal;
import edu.sena.facade.gpr.EstadoColaboradorFacadeLocal;
import edu.sena.facade.gpr.GeneroFacadeLocal;
import edu.sena.facade.gpr.InventarioFacadeLocal;
import edu.sena.facade.gpr.ParentescoFacadeLocal;
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
   
    private ArrayList<Parentesco> listaparentesco = new ArrayList<>();
    private ArrayList<Area> listaarea = new ArrayList<>();
    private ArrayList<Telefonos> listatelefonos = new ArrayList<>();
    private ArrayList<Genero> listagenero = new ArrayList<>();
    private ArrayList<EstadoCivil> listaestadocivil = new ArrayList<>();
    private ArrayList<EstadoColaborador> listadeestadocol = new ArrayList<>();
    private Colaboradores nuevocolaborador = new Colaboradores();

    private int idEstadocolab;
    private int idEstadocivil;
    private int idGenero;
    private int idTelefonos;
    private int idArea;
    private int idParentesco;
    private Date fechaingreso;
    private Date fecharetiro;
    private Date fechanacimiento;
   

    /**
     * Creates a new instance of ColaboradorView
     */
    public ColaboradorView() {
    }

    @PostConstruct
    public void cargainicialcol() {
        listadeestadocol = (ArrayList<EstadoColaborador>) estadoColaboradorFacadeLocal.findAll();
        listaestadocivil = (ArrayList<EstadoCivil>) estadoCivilFacadeLocal.findAll();
        listagenero = (ArrayList<Genero>) generoFacadeLocal.findAll();
        listatelefonos = (ArrayList<Telefonos>) telefonosFacadeLocal.findAll();
        listaarea = (ArrayList<Area>) areaFacadeLocal.findAll();
        listaparentesco = (ArrayList<Parentesco>) parentescoFacadeLocal.findAll();
    }

    public List<Colaboradores> verCol() {

        return colaboradoresFacadeLocal.verCol();
    }

    public Colaboradores getNuevocolaborador() {
        return nuevocolaborador;
    }

    public void setNuevocolaborador(Colaboradores nuevocolaborador) {
        this.nuevocolaborador = nuevocolaborador;
    }

    public ArrayList<EstadoColaborador> getListadeestadocol() {
        return listadeestadocol;
    }

    public void setListadeestadocol(ArrayList<EstadoColaborador> listadeestadocol) {
        this.listadeestadocol = listadeestadocol;
    }

    public int getIdEstadocolab() {
        return idEstadocolab;
    }

    public void setIdEstadocolab(int idEstadocolab) {
        this.idEstadocolab = idEstadocolab;
    }

    public ArrayList<EstadoCivil> getListaestadocivil() {
        return listaestadocivil;
    }

    public void setListaestadocivil(ArrayList<EstadoCivil> listaestadocivil) {
        this.listaestadocivil = listaestadocivil;
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

    public ArrayList<Genero> getListagenero() {
        return listagenero;
    }

    public void setListagenero(ArrayList<Genero> listagenero) {
        this.listagenero = listagenero;
    }

    public int getIdEstadocivil() {
        return idEstadocivil;
    }

    public void setIdEstadocivil(int idEstadocivil) {
        this.idEstadocivil = idEstadocivil;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdTelefonos() {
        return idTelefonos;
    }

    public void setIdTelefonos(int idTelefonos) {
        this.idTelefonos = idTelefonos;
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

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFecharetiro() {
        return fecharetiro;
    }

    public void setFecharetiro(Date fecharetiro) {
        this.fecharetiro = fecharetiro;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }
}