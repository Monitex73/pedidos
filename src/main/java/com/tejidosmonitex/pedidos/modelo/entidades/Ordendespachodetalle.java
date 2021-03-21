/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.modelo.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jenny Luna
 */
@Entity
@Table(name = "ordendespachodetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordendespachodetalle.findAll", query = "SELECT o FROM Ordendespachodetalle o")
    , @NamedQuery(name = "Ordendespachodetalle.findByIdordendespachodetalle", query = "SELECT o FROM Ordendespachodetalle o WHERE o.idordendespachodetalle = :idordendespachodetalle")
    , @NamedQuery(name = "Ordendespachodetalle.findByCantidad", query = "SELECT o FROM Ordendespachodetalle o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Ordendespachodetalle.findByEstado", query = "SELECT o FROM Ordendespachodetalle o WHERE o.estado = :estado")})
public class Ordendespachodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idordendespachodetalle")
    private Integer idordendespachodetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "idordendespacho", referencedColumnName = "idordendespacho")
    @ManyToOne(optional = false)
    private Ordendespacho idordendespacho;
    @JoinColumn(name = "iddetallepedido", referencedColumnName = "iddetallepedido")
    @ManyToOne
    private Pedidodetalle iddetallepedido;

    public Ordendespachodetalle() {
    }

    public Ordendespachodetalle(Integer idordendespachodetalle) {
        this.idordendespachodetalle = idordendespachodetalle;
    }

    public Ordendespachodetalle(Integer idordendespachodetalle, int cantidad, Character estado) {
        this.idordendespachodetalle = idordendespachodetalle;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Integer getIdordendespachodetalle() {
        return idordendespachodetalle;
    }

    public void setIdordendespachodetalle(Integer idordendespachodetalle) {
        this.idordendespachodetalle = idordendespachodetalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Ordendespacho getIdordendespacho() {
        return idordendespacho;
    }

    public void setIdordendespacho(Ordendespacho idordendespacho) {
        this.idordendespacho = idordendespacho;
    }

    public Pedidodetalle getIddetallepedido() {
        return iddetallepedido;
    }

    public void setIddetallepedido(Pedidodetalle iddetallepedido) {
        this.iddetallepedido = iddetallepedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordendespachodetalle != null ? idordendespachodetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordendespachodetalle)) {
            return false;
        }
        Ordendespachodetalle other = (Ordendespachodetalle) object;
        if ((this.idordendespachodetalle == null && other.idordendespachodetalle != null) || (this.idordendespachodetalle != null && !this.idordendespachodetalle.equals(other.idordendespachodetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Ordendespachodetalle[ idordendespachodetalle=" + idordendespachodetalle + " ]";
    }
    
}
