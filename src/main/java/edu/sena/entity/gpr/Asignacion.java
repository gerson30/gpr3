/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.gpr;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PC
 */

@Entity
@Table(name = "tbl_asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a")
    //@NamedQuery(name = "Colaboradores.findByFechaIngreso", query = "SELECT c FROM Colaboradores c WHERE c.fechaIngreso = :fechaIngreso"),
    //@NamedQuery(name = "Colaboradores.findByColabFechaRetiro", query = "SELECT c FROM Colaboradores c WHERE c.colabFechaRetiro = :colabFechaRetiro"),
    //@NamedQuery(name = "Colaboradores.findByNombre", query = "SELECT c FROM Colaboradores c WHERE c.nombre = :nombre"),
    //@NamedQuery(name = "Colaboradores.findByApellido", query = "SELECT c FROM Colaboradores c WHERE c.apellido = :apellido"),
    //@NamedQuery(name = "Colaboradores.findByFechaNacim", query = "SELECT c FROM Colaboradores c WHERE c.fechaNacim = :fechaNacim"),
    //@NamedQuery(name = "Colaboradores.findByDireccion", query = "SELECT c FROM Colaboradores c WHERE c.direccion = :direccion"),
    //@NamedQuery(name = "Colaboradores.findByBarrio", query = "SELECT c FROM Colaboradores c WHERE c.barrio = :barrio"),
    //@NamedQuery(name = "Colaboradores.findByCiudad", query = "SELECT c FROM Colaboradores c WHERE c.ciudad = :ciudad"),
    //@NamedQuery(name = "Colaboradores.findByNombreContacto", query = "SELECT c FROM Colaboradores c WHERE c.nombreContacto = :nombreContacto"),
    //@NamedQuery(name = "Colaboradores.findByApellidoContacto", query = "SELECT c FROM Colaboradores c WHERE c.apellidoContacto = :apellidoContacto"),
    //@NamedQuery(name = "Colaboradores.findByUsuarioDominio", query = "SELECT c FROM Colaboradores c WHERE c.usuarioDominio = :usuarioDominio"),
    //@NamedQuery(name = "Colaboradores.findByContrasenaDominio", query = "SELECT c FROM Colaboradores c WHERE c.contrasenaDominio = :contrasenaDominio"),
    //@NamedQuery(name = "Colaboradores.findByCorreo", query = "SELECT c FROM Colaboradores c WHERE c.correo = :correo")
})
public class Asignacion implements Serializable {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Asignacion")
    private Integer idAsignacion;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "numero_activo")
    private String numeroActivo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidad")
    private Integer unidad;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "comentario")
    private String comentario;
    
    @JoinColumn(name = "id_Equipo", referencedColumnName = "id_Equipo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Equipos idEquipoo;
    
 
    @JoinColumn(name = "id_Colab", referencedColumnName = "id_Colab")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Colaboradores id_Colab;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;

    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    
    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsginacion(Integer idAsginacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getNumeroActivo() {
        return numeroActivo;
    }

    public void setNumeroActivo(String numeroActivo) {
        this.numeroActivo = numeroActivo;
    }

    public Integer getUnidad() {
        return unidad;
    }

    public void setUnidad(Integer unidad) {
        this.unidad = unidad;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Equipos getIdEquipoo() {
        return idEquipoo;
    }

    public void setIdEquipoo(Equipos idEquipoo) {
        this.idEquipoo = idEquipoo;
    }

    public Colaboradores getId_Colab() {
        return id_Colab;
    }

    public void setId_Colab(Colaboradores id_Colab) {
        this.id_Colab = id_Colab;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
    
    
}