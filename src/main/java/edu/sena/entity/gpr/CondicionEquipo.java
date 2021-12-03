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
@Table(name = "tbl_condicion-equipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CondicionEquipo.findAll", query = "SELECT c FROM CondicionEquipo c"),
    @NamedQuery(name = "CondicionEquipo.findByIdCondicionEquipo", query = "SELECT c FROM CondicionEquipo c WHERE c.idCondicionEquipo = :idCondicionEquipo"),
    @NamedQuery(name = "CondicionEquipo.findByNombreCondicionEquipo", query = "SELECT c FROM CondicionEquipo c WHERE c.nombreCondicionEquipo = :nombreCondicionEquipo")})
public class CondicionEquipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_CondicionEquipo")
    private Integer idCondicionEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "nombreCondicionEquipo")
    private String nombreCondicionEquipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCondicionEquipo", fetch = FetchType.LAZY)
    private Collection<Equipos> equiposCollection;

    public CondicionEquipo() {
    }

    public CondicionEquipo(Integer idCondicionEquipo) {
        this.idCondicionEquipo = idCondicionEquipo;
    }

    public CondicionEquipo(Integer idCondicionEquipo, String nombreCondicionEquipo) {
        this.idCondicionEquipo = idCondicionEquipo;
        this.nombreCondicionEquipo = nombreCondicionEquipo;
    }

    public Integer getIdCondicionEquipo() {
        return idCondicionEquipo;
    }

    public void setIdCondicionEquipo(Integer idCondicionEquipo) {
        this.idCondicionEquipo = idCondicionEquipo;
    }

    public String getNombreCondicionEquipo() {
        return nombreCondicionEquipo;
    }

    public void setNombreCondicionEquipo(String nombreCondicionEquipo) {
        this.nombreCondicionEquipo = nombreCondicionEquipo;
    }

    @XmlTransient
    public Collection<Equipos> getEquiposCollection() {
        return equiposCollection;
    }

    public void setEquiposCollection(Collection<Equipos> equiposCollection) {
        this.equiposCollection = equiposCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCondicionEquipo != null ? idCondicionEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CondicionEquipo)) {
            return false;
        }
        CondicionEquipo other = (CondicionEquipo) object;
        if ((this.idCondicionEquipo == null && other.idCondicionEquipo != null) || (this.idCondicionEquipo != null && !this.idCondicionEquipo.equals(other.idCondicionEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.CondicionEquipo[ idCondicionEquipo=" + idCondicionEquipo + " ]";
    }
    
}
