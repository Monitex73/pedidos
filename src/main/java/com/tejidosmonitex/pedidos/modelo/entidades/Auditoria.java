/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author Jenny Luna
 */
@Entity
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByIdauditoria", query = "SELECT a FROM Auditoria a WHERE a.idauditoria = :idauditoria")
    , @NamedQuery(name = "Auditoria.findByAccion", query = "SELECT a FROM Auditoria a WHERE a.accion = :accion")
    , @NamedQuery(name = "Auditoria.findByNombretabla", query = "SELECT a FROM Auditoria a WHERE a.nombretabla = :nombretabla")
    , @NamedQuery(name = "Auditoria.findByNombrecampo", query = "SELECT a FROM Auditoria a WHERE a.nombrecampo = :nombrecampo")
    , @NamedQuery(name = "Auditoria.findByFechaactualiza", query = "SELECT a FROM Auditoria a WHERE a.fechaactualiza = :fechaactualiza")
    , @NamedQuery(name = "Auditoria.findByUsuarioactualiza", query = "SELECT a FROM Auditoria a WHERE a.usuarioactualiza = :usuarioactualiza")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idauditoria")
    private Integer idauditoria;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accion")
    private Character accion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nombretabla")
    private String nombretabla;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "nombrecampo")
    private String nombrecampo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaactualiza")
    @Temporal(TemporalType.DATE)
    private Date fechaactualiza;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "usuarioactualiza")
    private String usuarioactualiza;

    public Auditoria() {
    }

    public Auditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Auditoria(Integer idauditoria, Character accion, String nombretabla, String nombrecampo, Date fechaactualiza, String usuarioactualiza) {
        this.idauditoria = idauditoria;
        this.accion = accion;
        this.nombretabla = nombretabla;
        this.nombrecampo = nombrecampo;
        this.fechaactualiza = fechaactualiza;
        this.usuarioactualiza = usuarioactualiza;
    }

    public Integer getIdauditoria() {
        return idauditoria;
    }

    public void setIdauditoria(Integer idauditoria) {
        this.idauditoria = idauditoria;
    }

    public Character getAccion() {
        return accion;
    }

    public void setAccion(Character accion) {
        this.accion = accion;
    }

    public String getNombretabla() {
        return nombretabla;
    }

    public void setNombretabla(String nombretabla) {
        this.nombretabla = nombretabla;
    }

    public String getNombrecampo() {
        return nombrecampo;
    }

    public void setNombrecampo(String nombrecampo) {
        this.nombrecampo = nombrecampo;
    }

    public Date getFechaactualiza() {
        return fechaactualiza;
    }

    public void setFechaactualiza(Date fechaactualiza) {
        this.fechaactualiza = fechaactualiza;
    }

    public String getUsuarioactualiza() {
        return usuarioactualiza;
    }

    public void setUsuarioactualiza(String usuarioactualiza) {
        this.usuarioactualiza = usuarioactualiza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idauditoria != null ? idauditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idauditoria == null && other.idauditoria != null) || (this.idauditoria != null && !this.idauditoria.equals(other.idauditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Auditoria[ idauditoria=" + idauditoria + " ]";
    }
    
}
