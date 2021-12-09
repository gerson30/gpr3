/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.entity.gpr;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "tbl_comentarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentarios.findAll", query = "SELECT c FROM Comentarios c"),
    @NamedQuery(name = "Comentarios.findByIdComentario", query = "SELECT c FROM Comentarios c WHERE c.idComentario = :idComentario"),
    @NamedQuery(name = "Comentarios.findByFechaComentario", query = "SELECT c FROM Comentarios c WHERE c.fechaComentario = :fechaComentario"),
    @NamedQuery(name = "Comentarios.findByIdInventario", query = "SELECT c FROM Comentarios c WHERE c.idInventario = :idInventario"),
    @NamedQuery(name = "Comentarios.findByIdColabComent", query = "SELECT c FROM Comentarios c WHERE c.idColabComent = :idColabComent")})
public class Comentarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_comentario")
    private Integer idComentario;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha comentario")
    @Temporal(TemporalType.DATE)
    private Date fechaComentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Inventario")
    private int idInventario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ColabComent")
    private int idColabComent;
    @JoinColumn(name = "id_Ticket", referencedColumnName = "id_Ticket")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Incidente idTicket;

    public Comentarios() {
    }

    public Comentarios(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentarios(Integer idComentario, String comentario, Date fechaComentario, int idInventario, int idColabComent) {
        this.idComentario = idComentario;
        this.comentario = comentario;
        this.fechaComentario = fechaComentario;
        this.idInventario = idInventario;
        this.idColabComent = idColabComent;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdColabComent() {
        return idColabComent;
    }

    public void setIdColabComent(int idColabComent) {
        this.idColabComent = idColabComent;
    }

    public Incidente getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Incidente idTicket) {
        this.idTicket = idTicket;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentarios)) {
            return false;
        }
        Comentarios other = (Comentarios) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.Comentarios[ idComentario=" + idComentario + " ]";
    }
    
}
