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
@Table(name = "tbl_tipopc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipopc.findAll", query = "SELECT t FROM Tipopc t"),
    @NamedQuery(name = "Tipopc.findByIdTipoPc", query = "SELECT t FROM Tipopc t WHERE t.idTipoPc = :idTipoPc"),
    @NamedQuery(name = "Tipopc.findByNombreTipoPc", query = "SELECT t FROM Tipopc t WHERE t.nombreTipoPc = :nombreTipoPc")})
public class Tipopc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_TipoPc")
    private Integer idTipoPc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "nombreTipoPc")
    private String nombreTipoPc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPc", fetch = FetchType.LAZY)
    private Collection<Equipos> equiposCollection;

    public Tipopc() {
    }

    public Tipopc(Integer idTipoPc) {
        this.idTipoPc = idTipoPc;
    }

    public Tipopc(Integer idTipoPc, String nombreTipoPc) {
        this.idTipoPc = idTipoPc;
        this.nombreTipoPc = nombreTipoPc;
    }

    public Integer getIdTipoPc() {
        return idTipoPc;
    }

    public void setIdTipoPc(Integer idTipoPc) {
        this.idTipoPc = idTipoPc;
    }

    public String getNombreTipoPc() {
        return nombreTipoPc;
    }

    public void setNombreTipoPc(String nombreTipoPc) {
        this.nombreTipoPc = nombreTipoPc;
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
        hash += (idTipoPc != null ? idTipoPc.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipopc)) {
            return false;
        }
        Tipopc other = (Tipopc) object;
        if ((this.idTipoPc == null && other.idTipoPc != null) || (this.idTipoPc != null && !this.idTipoPc.equals(other.idTipoPc))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.Tipopc[ idTipoPc=" + idTipoPc + " ]";
    }
    
}
