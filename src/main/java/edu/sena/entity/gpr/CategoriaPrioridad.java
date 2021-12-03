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
@Table(name = "tbl_categoria_prioridad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaPrioridad.findAll", query = "SELECT c FROM CategoriaPrioridad c"),
    @NamedQuery(name = "CategoriaPrioridad.findByIdCat", query = "SELECT c FROM CategoriaPrioridad c WHERE c.idCat = :idCat"),
    @NamedQuery(name = "CategoriaPrioridad.findByNombreCategoria", query = "SELECT c FROM CategoriaPrioridad c WHERE c.nombreCategoria = :nombreCategoria")})
public class CategoriaPrioridad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Cat")
    private Integer idCat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombreCategoria")
    private String nombreCategoria;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCat", fetch = FetchType.LAZY)
    private Collection<Incidente> incidenteCollection;

    public CategoriaPrioridad() {
    }

    public CategoriaPrioridad(Integer idCat) {
        this.idCat = idCat;
    }

    public CategoriaPrioridad(Integer idCat, String nombreCategoria) {
        this.idCat = idCat;
        this.nombreCategoria = nombreCategoria;
    }

    public Integer getIdCat() {
        return idCat;
    }

    public void setIdCat(Integer idCat) {
        this.idCat = idCat;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
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
        hash += (idCat != null ? idCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaPrioridad)) {
            return false;
        }
        CategoriaPrioridad other = (CategoriaPrioridad) object;
        if ((this.idCat == null && other.idCat != null) || (this.idCat != null && !this.idCat.equals(other.idCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.CategoriaPrioridad[ idCat=" + idCat + " ]";
    }
    
}
