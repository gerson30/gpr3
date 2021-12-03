/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.gpr;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gjimenezo
 */
@Entity
@Table(name = "tbl_estado_incidente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoIncidente.findAll", query = "SELECT e FROM EstadoIncidente e"),
    @NamedQuery(name = "EstadoIncidente.findByIdEstadoInc", query = "SELECT e FROM EstadoIncidente e WHERE e.idEstadoInc = :idEstadoInc"),
    @NamedQuery(name = "EstadoIncidente.findByNombreEstado", query = "SELECT e FROM EstadoIncidente e WHERE e.nombreEstado = :nombreEstado")})
public class EstadoIncidente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_EstadoInc")
    private Integer idEstadoInc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombreEstado")
    private String nombreEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoInc", fetch = FetchType.LAZY)
    private Collection<Incidente> incidenteCollection;

    public EstadoIncidente() {
    }

    public EstadoIncidente(Integer idEstadoInc) {
        this.idEstadoInc = idEstadoInc;
    }

    public EstadoIncidente(Integer idEstadoInc, String nombreEstado) {
        this.idEstadoInc = idEstadoInc;
        this.nombreEstado = nombreEstado;
    }

    public Integer getIdEstadoInc() {
        return idEstadoInc;
    }

    public void setIdEstadoInc(Integer idEstadoInc) {
        this.idEstadoInc = idEstadoInc;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @XmlTransient
    public Collection<Incidente> getIncidenteCollection() {
        return incidenteCollection;
    }

    public void setIncidenteCollection(Collection<Incidente> incidenteCollection) {
        this.incidenteCollection = incidenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoInc != null ? idEstadoInc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoIncidente)) {
            return false;
        }
        EstadoIncidente other = (EstadoIncidente) object;
        if ((this.idEstadoInc == null && other.idEstadoInc != null) || (this.idEstadoInc != null && !this.idEstadoInc.equals(other.idEstadoInc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.EstadoIncidente[ idEstadoInc=" + idEstadoInc + " ]";
    }
    
}
