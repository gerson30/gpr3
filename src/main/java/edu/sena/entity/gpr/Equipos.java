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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tbl_equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipos.findAll", query = "SELECT e FROM Equipos e"),
    @NamedQuery(name = "Equipos.findByIdEquipo", query = "SELECT e FROM Equipos e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipos.findByModelo", query = "SELECT e FROM Equipos e WHERE e.modelo = :modelo"),
    @NamedQuery(name = "Equipos.findBySerial", query = "SELECT e FROM Equipos e WHERE e.serial = :serial"),
    @NamedQuery(name = "Equipos.findBySistemaOperativo", query = "SELECT e FROM Equipos e WHERE e.sistemaOperativo = :sistemaOperativo"),
    @NamedQuery(name = "Equipos.findByMicrossoftOffice", query = "SELECT e FROM Equipos e WHERE e.microssoftOffice = :microssoftOffice"),
    @NamedQuery(name = "Equipos.findByProcesador", query = "SELECT e FROM Equipos e WHERE e.procesador = :procesador"),
    @NamedQuery(name = "Equipos.findByMemoriaRam", query = "SELECT e FROM Equipos e WHERE e.memoriaRam = :memoriaRam"),
    @NamedQuery(name = "Equipos.findByCapacidadDiscoDuro", query = "SELECT e FROM Equipos e WHERE e.capacidadDiscoDuro = :capacidadDiscoDuro"),
    @NamedQuery(name = "Equipos.findByComentarios", query = "SELECT e FROM Equipos e WHERE e.comentarios = :comentarios")})
public class Equipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "modelo")
    private String modelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "serial")
    private String serial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "sistemaOperativo")
    private String sistemaOperativo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "microssoftOffice")
    private String microssoftOffice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "procesador")
    private String procesador;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "memoriaRam")
    private String memoriaRam;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "capacidadDiscoDuro")
    private String capacidadDiscoDuro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "comentarios")
    private String comentarios;
    @JoinColumn(name = "id_CondicionEquipo", referencedColumnName = "id_CondicionEquipo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private CondicionEquipo idCondicionEquipo;
    @JoinColumn(name = "id_Marca", referencedColumnName = "id_Marca")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Marca idMarca;
    @JoinColumn(name = "id_TipoPc", referencedColumnName = "id_TipoPc")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tipopc idTipoPc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEquipo", fetch = FetchType.LAZY)
    private Collection<Inventario> inventarioCollection;

    public Equipos() {
    }

    public Equipos(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipos(Integer idEquipo, String modelo, String serial, String sistemaOperativo, String microssoftOffice, String procesador, String memoriaRam, String capacidadDiscoDuro, String comentarios) {
        this.idEquipo = idEquipo;
        this.modelo = modelo;
        this.serial = serial;
        this.sistemaOperativo = sistemaOperativo;
        this.microssoftOffice = microssoftOffice;
        this.procesador = procesador;
        this.memoriaRam = memoriaRam;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.comentarios = comentarios;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getMicrossoftOffice() {
        return microssoftOffice;
    }

    public void setMicrossoftOffice(String microssoftOffice) {
        this.microssoftOffice = microssoftOffice;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(String memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public String getCapacidadDiscoDuro() {
        return capacidadDiscoDuro;
    }

    public void setCapacidadDiscoDuro(String capacidadDiscoDuro) {
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public CondicionEquipo getIdCondicionEquipo() {
        return idCondicionEquipo;
    }

    public void setIdCondicionEquipo(CondicionEquipo idCondicionEquipo) {
        this.idCondicionEquipo = idCondicionEquipo;
    }

    public Marca getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Marca idMarca) {
        this.idMarca = idMarca;
    }

    public Tipopc getIdTipoPc() {
        return idTipoPc;
    }

    public void setIdTipoPc(Tipopc idTipoPc) {
        this.idTipoPc = idTipoPc;
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
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipos)) {
            return false;
        }
        Equipos other = (Equipos) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.Equipos[ idEquipo=" + idEquipo + " ]";
    }
    
}
