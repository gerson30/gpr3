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
 * @author usuario
 */
@Entity
@Table(name = "tbl_estado_equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoEquipo.findAll", query = "SELECT e FROM EstadoEquipo e"),
    @NamedQuery(name = "EstadoEquipo.findByIdEstadoEquipo", query = "SELECT e FROM EstadoEquipo e WHERE e.idEstadoEquipo = :idEstadoEquipo"),
    @NamedQuery(name = "EstadoEquipo.findByNombreEstadoEquipo", query = "SELECT e FROM EstadoEquipo e WHERE e.nombreEstadoEquipo = :nombreEstadoEquipo")})
public class EstadoEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_EstadoEquipo")
    private Integer idEstadoEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombreEstadoEquipo")
    private String nombreEstadoEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoEquipo", fetch = FetchType.LAZY)
    private Collection<Inventario> inventarioCollection;

    public EstadoEquipo() {
    }

    public EstadoEquipo(Integer idEstadoEquipo) {
        this.idEstadoEquipo = idEstadoEquipo;
    }

    public EstadoEquipo(Integer idEstadoEquipo, String nombreEstadoEquipo) {
        this.idEstadoEquipo = idEstadoEquipo;
        this.nombreEstadoEquipo = nombreEstadoEquipo;
    }

    public Integer getIdEstadoEquipo() {
        return idEstadoEquipo;
    }

    public void setIdEstadoEquipo(Integer idEstadoEquipo) {
        this.idEstadoEquipo = idEstadoEquipo;
    }

    public String getNombreEstadoEquipo() {
        return nombreEstadoEquipo;
    }

    public void setNombreEstadoEquipo(String nombreEstadoEquipo) {
        this.nombreEstadoEquipo = nombreEstadoEquipo;
    }

    @XmlTransient
    public Collection<Inventario> getInventarioCollection() {
        return inventarioCollection;
    }

    public void setInventarioCollection(Collection<Inventario> inventarioCollection) {
        this.inventarioCollection = inventarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoEquipo != null ? idEstadoEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoEquipo)) {
            return false;
        }
        EstadoEquipo other = (EstadoEquipo) object;
        if ((this.idEstadoEquipo == null && other.idEstadoEquipo != null) || (this.idEstadoEquipo != null && !this.idEstadoEquipo.equals(other.idEstadoEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.EstadoEquipo[ idEstadoEquipo=" + idEstadoEquipo + " ]";
    }
    
}
