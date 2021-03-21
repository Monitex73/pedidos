/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.modelo.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jenny Luna
 */
@Entity
@Table(name = "ordenproduccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenproduccion.findAll", query = "SELECT o FROM Ordenproduccion o")
    , @NamedQuery(name = "Ordenproduccion.findByIdordenproduccion", query = "SELECT o FROM Ordenproduccion o WHERE o.idordenproduccion = :idordenproduccion")
    , @NamedQuery(name = "Ordenproduccion.findByFecha", query = "SELECT o FROM Ordenproduccion o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Ordenproduccion.findByEstado", query = "SELECT o FROM Ordenproduccion o WHERE o.estado = :estado")})
public class Ordenproduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idordenproduccion")
    private Integer idordenproduccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @ManyToOne(optional = false)
    private Pedido idpedido;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idordenproduccion")
    private List<Ordenproducciondetalle> ordenproducciondetalleList;

    public Ordenproduccion() {
    }

    public Ordenproduccion(Integer idordenproduccion) {
        this.idordenproduccion = idordenproduccion;
    }

    public Ordenproduccion(Integer idordenproduccion, Date fecha, Character estado) {
        this.idordenproduccion = idordenproduccion;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdordenproduccion() {
        return idordenproduccion;
    }

    public void setIdordenproduccion(Integer idordenproduccion) {
        this.idordenproduccion = idordenproduccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
        this.idpedido = idpedido;
    }

    @XmlTransient
    public List<Ordenproducciondetalle> getOrdenproducciondetalleList() {
        return ordenproducciondetalleList;
    }

    public void setOrdenproducciondetalleList(List<Ordenproducciondetalle> ordenproducciondetalleList) {
        this.ordenproducciondetalleList = ordenproducciondetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordenproduccion != null ? idordenproduccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenproduccion)) {
            return false;
        }
        Ordenproduccion other = (Ordenproduccion) object;
        if ((this.idordenproduccion == null && other.idordenproduccion != null) || (this.idordenproduccion != null && !this.idordenproduccion.equals(other.idordenproduccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Ordenproduccion[ idordenproduccion=" + idordenproduccion + " ]";
    }
    
}
