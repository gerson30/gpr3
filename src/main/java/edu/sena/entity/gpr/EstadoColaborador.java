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
@Table(name = "tbl_estado_colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoColaborador.findAll", query = "SELECT e FROM EstadoColaborador e"),
    @NamedQuery(name = "EstadoColaborador.findByIdEstadocolab", query = "SELECT e FROM EstadoColaborador e WHERE e.idEstadocolab = :idEstadocolab"),
    @NamedQuery(name = "EstadoColaborador.findByNombreEstadoColab", query = "SELECT e FROM EstadoColaborador e WHERE e.nombreEstadoColab = :nombreEstadoColab")})
public class EstadoColaborador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_estadocolab")
    private Integer idEstadocolab;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreEstadoColab")
    private String nombreEstadoColab;
    
    /*@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEstadoColab", fetch = FetchType.LAZY)
    private Collection<Colaboradores> colaboradoresCollection;*/

    public EstadoColaborador() {
    }

    public EstadoColaborador(Integer idEstadocolab) {
        this.idEstadocolab = idEstadocolab;
    }

    public EstadoColaborador(Integer idEstadocolab, String nombreEstadoColab) {
        this.idEstadocolab = idEstadocolab;
        this.nombreEstadoColab = nombreEstadoColab;
    }

    public Integer getIdEstadocolab() {
        return idEstadocolab;
    }

    public void setIdEstadocolab(Integer idEstadocolab) {
        this.idEstadocolab = idEstadocolab;
    }

    public String getNombreEstadoColab() {
        return nombreEstadoColab;
    }

    public void setNombreEstadoColab(String nombreEstadoColab) {
        this.nombreEstadoColab = nombreEstadoColab;
    }

    /*@XmlTransient
    public Collection<Colaboradores> getColaboradoresCollection() {
        return colaboradoresCollection;
    }

    public void setColaboradoresCollection(Collection<Colaboradores> colaboradoresCollection) {
        this.colaboradoresCollection = colaboradoresCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadocolab != null ? idEstadocolab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoColaborador)) {
            return false;
        }
        EstadoColaborador other = (EstadoColaborador) object;
        if ((this.idEstadocolab == null && other.idEstadocolab != null) || (this.idEstadocolab != null && !this.idEstadocolab.equals(other.idEstadocolab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.EstadoColaborador[ idEstadocolab=" + idEstadocolab + " ]";
    }
    
}
