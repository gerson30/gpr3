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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author gjimenezo
 */
@Entity
@Table(name = "tbl_telefonos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefonos.findAll", query = "SELECT t FROM Telefonos t"),
    @NamedQuery(name = "Telefonos.findByIdTelefono", query = "SELECT t FROM Telefonos t WHERE t.idTelefono = :idTelefono"),
    @NamedQuery(name = "Telefonos.findByTelFijo", query = "SELECT t FROM Telefonos t WHERE t.telFijo = :telFijo"),
    @NamedQuery(name = "Telefonos.findByTelCel", query = "SELECT t FROM Telefonos t WHERE t.telCel = :telCel"),
    @NamedQuery(name = "Telefonos.findByTelContactFijo", query = "SELECT t FROM Telefonos t WHERE t.telContactFijo = :telContactFijo"),
    @NamedQuery(name = "Telefonos.findByTelContactCel", query = "SELECT t FROM Telefonos t WHERE t.telContactCel = :telContactCel")})
public class Telefonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Telefono")
    private Integer idTelefono;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telFijo")
    private double telFijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telCel")
    private double telCel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telContactFijo")
    private double telContactFijo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telContactCel")
    private double telContactCel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTelefono", fetch = FetchType.LAZY)
    private Collection<Colaboradores> colaboradoresCollection;

    public Telefonos() {
    }

    public Telefonos(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public Telefonos(Integer idTelefono, double telFijo, double telCel, double telContactFijo, double telContactCel) {
        this.idTelefono = idTelefono;
        this.telFijo = telFijo;
        this.telCel = telCel;
        this.telContactFijo = telContactFijo;
        this.telContactCel = telContactCel;
    }

    public Integer getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Integer idTelefono) {
        this.idTelefono = idTelefono;
    }

    public double getTelFijo() {
        return telFijo;
    }

    public void setTelFijo(double telFijo) {
        this.telFijo = telFijo;
    }

    public double getTelCel() {
        return telCel;
    }

    public void setTelCel(double telCel) {
        this.telCel = telCel;
    }

    public double getTelContactFijo() {
        return telContactFijo;
    }

    public void setTelContactFijo(double telContactFijo) {
        this.telContactFijo = telContactFijo;
    }

    public double getTelContactCel() {
        return telContactCel;
    }

    public void setTelContactCel(double telContactCel) {
        this.telContactCel = telContactCel;
    }

    @XmlTransient
    public Collection<Colaboradores> getColaboradoresCollection() {
        return colaboradoresCollection;
    }

    public void setColaboradoresCollection(Collection<Colaboradores> colaboradoresCollection) {
        this.colaboradoresCollection = colaboradoresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTelefono != null ? idTelefono.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefonos)) {
            return false;
        }
        Telefonos other = (Telefonos) object;
        if ((this.idTelefono == null && other.idTelefono != null) || (this.idTelefono != null && !this.idTelefono.equals(other.idTelefono))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.Telefonos[ idTelefono=" + idTelefono + " ]";
    }
    
}
