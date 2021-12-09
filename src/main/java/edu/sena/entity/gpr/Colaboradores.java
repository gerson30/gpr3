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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * @author usuario
 */
@Entity
@Table(name = "tbl_colaboradores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaboradores.findAll", query = "SELECT c FROM Colaboradores c"),
    @NamedQuery(name = "Colaboradores.findByIdColab", query = "SELECT c FROM Colaboradores c WHERE c.idColab = :idColab"),
    @NamedQuery(name = "Colaboradores.findByCedula", query = "SELECT c FROM Colaboradores c WHERE c.cedula = :cedula"),
    @NamedQuery(name = "Colaboradores.findByFechaIngreso", query = "SELECT c FROM Colaboradores c WHERE c.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "Colaboradores.findByColabFechaRetiro", query = "SELECT c FROM Colaboradores c WHERE c.colabFechaRetiro = :colabFechaRetiro"),
    @NamedQuery(name = "Colaboradores.findByNombre", query = "SELECT c FROM Colaboradores c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Colaboradores.findByApellido", query = "SELECT c FROM Colaboradores c WHERE c.apellido = :apellido"),
    @NamedQuery(name = "Colaboradores.findByFechaNacim", query = "SELECT c FROM Colaboradores c WHERE c.fechaNacim = :fechaNacim"),
    @NamedQuery(name = "Colaboradores.findByDireccion", query = "SELECT c FROM Colaboradores c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Colaboradores.findByBarrio", query = "SELECT c FROM Colaboradores c WHERE c.barrio = :barrio"),
    @NamedQuery(name = "Colaboradores.findByCiudad", query = "SELECT c FROM Colaboradores c WHERE c.ciudad = :ciudad"),
    @NamedQuery(name = "Colaboradores.findByNombreContacto", query = "SELECT c FROM Colaboradores c WHERE c.nombreContacto = :nombreContacto"),
    @NamedQuery(name = "Colaboradores.findByApellidoContacto", query = "SELECT c FROM Colaboradores c WHERE c.apellidoContacto = :apellidoContacto"),
    @NamedQuery(name = "Colaboradores.findByUsuarioDominio", query = "SELECT c FROM Colaboradores c WHERE c.usuarioDominio = :usuarioDominio"),
    @NamedQuery(name = "Colaboradores.findByContrasenaDominio", query = "SELECT c FROM Colaboradores c WHERE c.contrasenaDominio = :contrasenaDominio"),
    @NamedQuery(name = "Colaboradores.findByCorreo", query = "SELECT c FROM Colaboradores c WHERE c.correo = :correo")})
public class Colaboradores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_Colab")
    private Integer idColab;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cedula")
    private double cedula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "colab_FechaRetiro")
    @Temporal(TemporalType.DATE)
    private Date colabFechaRetiro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaNacim")
    @Temporal(TemporalType.DATE)
    private Date fechaNacim;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "barrio")
    private String barrio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombreContacto")
    private String nombreContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "apellidoContacto")
    private String apellidoContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "usuarioDominio")
    private String usuarioDominio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "contrasenaDominio")
    private int contrasenaDominio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @JoinTable(name = "tbl_colaboradores_roles", joinColumns = {
        @JoinColumn(name = "fk_id_Colab", referencedColumnName = "id_Colab"),
        @JoinColumn(name = "fk_id_Colab", referencedColumnName = "id_Colab")}, inverseJoinColumns = {
        @JoinColumn(name = "fk_id_Rol", referencedColumnName = "id_Rol")})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Roles> rolesCollection;
    @OneToMany(mappedBy = "colaboradores", fetch = FetchType.LAZY)
    private Collection<Incidente> incidenteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradores1", fetch = FetchType.LAZY)
    private Collection<Incidente> incidenteCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradores2", fetch = FetchType.LAZY)
    private Collection<Incidente> incidenteCollection2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "colaboradores3", fetch = FetchType.LAZY)
    private Collection<Incidente> incidenteCollection3;
    @JoinColumn(name = "id_Area", referencedColumnName = "id_Area")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Area idArea;
    @JoinColumn(name = "id_EstadoCivil", referencedColumnName = "id_EstadoCivil")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoCivil idEstadoCivil;
    @JoinColumn(name = "id_EstadoColab", referencedColumnName = "id_estadocolab")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstadoColaborador idEstadoColab;
    @JoinColumn(name = "id_Genero", referencedColumnName = "id_Genero")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Genero idGenero;
    @JoinColumn(name = "id_Inventario", referencedColumnName = "id_Inventario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Inventario idInventario;
    @JoinColumn(name = "id_Parentesco", referencedColumnName = "id_Parentesco")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Parentesco idParentesco;
    @JoinColumn(name = "id_Telefono", referencedColumnName = "id_Telefono")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Telefonos idTelefono;

    public Colaboradores() {
    }

    public Colaboradores(Integer idColab) {
        this.idColab = idColab;
    }

    public Colaboradores(Integer idColab, double cedula, Date fechaIngreso, String nombre, String apellido, Date fechaNacim, String direccion, String barrio, String ciudad, String nombreContacto, String apellidoContacto, String usuarioDominio, int contrasenaDominio, String correo) {
        this.idColab = idColab;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacim = fechaNacim;
        this.direccion = direccion;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.usuarioDominio = usuarioDominio;
        this.contrasenaDominio = contrasenaDominio;
        this.correo = correo;
    }

    public Integer getIdColab() {
        return idColab;
    }

    public void setIdColab(Integer idColab) {
        this.idColab = idColab;
    }

    public double getCedula() {
        return cedula;
    }

    public void setCedula(double cedula) {
        this.cedula = cedula;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getColabFechaRetiro() {
        return colabFechaRetiro;
    }

    public void setColabFechaRetiro(Date colabFechaRetiro) {
        this.colabFechaRetiro = colabFechaRetiro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaNacim() {
        return fechaNacim;
    }

    public void setFechaNacim(Date fechaNacim) {
        this.fechaNacim = fechaNacim;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getApellidoContacto() {
        return apellidoContacto;
    }

    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }

    public String getUsuarioDominio() {
        return usuarioDominio;
    }

    public void setUsuarioDominio(String usuarioDominio) {
        this.usuarioDominio = usuarioDominio;
    }

    public int getContrasenaDominio() {
        return contrasenaDominio;
    }

    public void setContrasenaDominio(int contrasenaDominio) {
        this.contrasenaDominio = contrasenaDominio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<Roles> getRolesCollection() {
        return rolesCollection;
    }

    public void setRolesCollection(Collection<Roles> rolesCollection) {
        this.rolesCollection = rolesCollection;
    }

    @XmlTransient
    public Collection<Incidente> getIncidenteCollection() {
        return incidenteCollection;
    }

    public void setIncidenteCollection(Collection<Incidente> incidenteCollection) {
        this.incidenteCollection = incidenteCollection;
    }

    @XmlTransient
    public Collection<Incidente> getIncidenteCollection1() {
        return incidenteCollection1;
    }

    public void setIncidenteCollection1(Collection<Incidente> incidenteCollection1) {
        this.incidenteCollection1 = incidenteCollection1;
    }

    @XmlTransient
    public Collection<Incidente> getIncidenteCollection2() {
        return incidenteCollection2;
    }

    public void setIncidenteCollection2(Collection<Incidente> incidenteCollection2) {
        this.incidenteCollection2 = incidenteCollection2;
    }

    @XmlTransient
    public Collection<Incidente> getIncidenteCollection3() {
        return incidenteCollection3;
    }

    public void setIncidenteCollection3(Collection<Incidente> incidenteCollection3) {
        this.incidenteCollection3 = incidenteCollection3;
    }

    public Area getIdArea() {
        return idArea;
    }

    public void setIdArea(Area idArea) {
        this.idArea = idArea;
    }

    public EstadoCivil getIdEstadoCivil() {
        return idEstadoCivil;
    }

    public void setIdEstadoCivil(EstadoCivil idEstadoCivil) {
        this.idEstadoCivil = idEstadoCivil;
    }

    public EstadoColaborador getIdEstadoColab() {
        return idEstadoColab;
    }

    public void setIdEstadoColab(EstadoColaborador idEstadoColab) {
        this.idEstadoColab = idEstadoColab;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public Inventario getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Inventario idInventario) {
        this.idInventario = idInventario;
    }

    public Parentesco getIdParentesco() {
        return idParentesco;
    }

    public void setIdParentesco(Parentesco idParentesco) {
        this.idParentesco = idParentesco;
    }

    public Telefonos getIdTelefono() {
        return idTelefono;
    }

    public void setIdTelefono(Telefonos idTelefono) {
        this.idTelefono = idTelefono;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idColab != null ? idColab.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colaboradores)) {
            return false;
        }
        Colaboradores other = (Colaboradores) object;
        if ((this.idColab == null && other.idColab != null) || (this.idColab != null && !this.idColab.equals(other.idColab))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.sena.entity.gpr.Colaboradores[ idColab=" + idColab + " ]";
    }
    
}
