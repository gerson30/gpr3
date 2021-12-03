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
import javax.persistence.JoinColumns;
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
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gjimenezo
 */
@Entity
@Table(name = "tbl_incidente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Incidente.findAll", query = "SELECT i FROM Incidente i"),
    @NamedQuery(name = "Incidente.findByIdTicket", query = "SELECT i FROM Incidente i WHERE i.idTicket = :idTicket"),
    @NamedQuery(name = "Incidente.findByAsunto", query = "SELECT i FROM Incidente i WHERE i.asunto = :asunto"),
    @NamedQuery(name = "Incidente.findByFechaCreacion", query = "SELECT i FROM Incidente i WHERE i.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Incidente.findByFechaAsignacion", query = "SELECT i FROM Incidente i WHERE i.fechaAsignacion = :fechaAsignacion"),
    @NamedQuery(name = "Incidente.findByFechaSolucion", query = "SELECT i FROM Incidente i WHERE i.fechaSolucion = :fechaSolucion")})
public class Incidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Ticket")
    private Integer idTicket;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "asunto")
    private String asunto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaCreacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_Asignacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAsignacion;
    @Column(name = "fecha_Solucion")
    @Temporal(TemporalType.DATE)
    private Date fechaSolucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTicket", fetch = FetchType.LAZY)
    private Collection<Comentarios> comentariosCollection;
    @JoinColumn(name = "id_Cat", referencedColumnName = "id_Cat")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CategoriaPrioridad idCat;
    @JoinColumns({
        @JoinColumn(name = "fk_colabAsigna", referencedColumnName = "id_Colab"),
        @JoinColumn(name = "fk_colabAsigna", referencedColumnName = "id_Colab")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Colaboradores colaboradores;
    @JoinColumns({
        @JoinColumn(name = "fk_colabCrea", referencedColumnName = "id_Colab"),
        @JoinColumn(name = "fk_colabCrea", referencedColumnName = "id_Colab")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Colaboradores colaboradores1;
    @JoinColumns({
        @JoinColumn(name = "fk_colabSoluciona", referencedColumnName = "id_Colab"),
        @JoinColumn(name = "fk_colabSoluciona", referencedColumnName = "id_Colab")})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Colaboradores colaboradores2;
    @JoinColumn(name = "id_EstadoInc", referencedColumnName = "id_EstadoInc")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoIncidente idEstadoInc;

    public Incidente() {
    }

    public Incidente(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public Incidente(Integer idTicket, String asunto, Date fechaCreacion) {
        this.idTicket = idTicket;
        this.asunto = asunto;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Integer idTicket) {
        this.idTicket = idTicket;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(Date fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public Date getFechaSolucion() {
        return fechaSolucion;
    }

    public void setFechaSolucion(Date fechaSolucion) {
        this.fechaSolucion = fechaSolucion;
    }

    @XmlTransient
    public Collection<Comentarios> getComentariosCollection() {
        return comentariosCollection;
    }

    public void setComentariosCollection(Collection<Comentarios> comentariosCollection) {
        this.comentariosCollection = comentariosCollection;
    }

    public CategoriaPrioridad getIdCat() {
        return idCat;
    }

    public void setIdCat(CategoriaPrioridad idCat) {
        this.idCat = idCat;
    }

    public Colaboradores getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(Colaboradores colaboradores) {
        this.colaboradores = colaboradores;
    }

    public Colaboradores getColaboradores1() {
        return colaboradores1;
    }

    public void setColaboradores1(Colaboradores colaboradores1) {
        this.colaboradores1 = colaboradores1;
    }

    public Colaboradores getColaboradores2() {
        return colaboradores2;
    }

    public void setColaboradores2(Colaboradores colaboradores2) {
        this.colaboradores2 = colaboradores2;
    }

    public EstadoIncidente getIdEstadoInc() {
        return idEstadoInc;
    }

    public void setIdEstadoInc(EstadoIncidente idEstadoInc) {
        this.idEstadoInc = idEstadoInc;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTicket != null ? idTicket.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Incidente)) {
            return false;
        }
        Incidente other = (Incidente) object;
        if ((this.idTicket == null && other.idTicket != null) || (this.idTicket != null && !this.idTicket.equals(other.idTicket))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.Incidente[ idTicket=" + idTicket + " ]";
    }
    
}
