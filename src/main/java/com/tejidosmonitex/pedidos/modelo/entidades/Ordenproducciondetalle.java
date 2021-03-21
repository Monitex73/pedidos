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
@Table(name = "ordenproducciondetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenproducciondetalle.findAll", query = "SELECT o FROM Ordenproducciondetalle o")
    , @NamedQuery(name = "Ordenproducciondetalle.findByIdordenproducciondetalle", query = "SELECT o FROM Ordenproducciondetalle o WHERE o.idordenproducciondetalle = :idordenproducciondetalle")
    , @NamedQuery(name = "Ordenproducciondetalle.findByCantidad", query = "SELECT o FROM Ordenproducciondetalle o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Ordenproducciondetalle.findByEstado", query = "SELECT o FROM Ordenproducciondetalle o WHERE o.estado = :estado")})
public class Ordenproducciondetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idordenproducciondetalle")
    private Integer idordenproducciondetalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @JoinColumn(name = "idordenproduccion", referencedColumnName = "idordenproduccion")
    @ManyToOne(optional = false)
    private Ordenproduccion idordenproduccion;
    @JoinColumn(name = "iddetallepedido", referencedColumnName = "iddetallepedido")
    @ManyToOne
    private Pedidodetalle iddetallepedido;

    public Ordenproducciondetalle() {
    }

    public Ordenproducciondetalle(Integer idordenproducciondetalle) {
        this.idordenproducciondetalle = idordenproducciondetalle;
    }

    public Ordenproducciondetalle(Integer idordenproducciondetalle, int cantidad, Character estado) {
        this.idordenproducciondetalle = idordenproducciondetalle;
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public Integer getIdordenproducciondetalle() {
        return idordenproducciondetalle;
    }

    public void setIdordenproducciondetalle(Integer idordenproducciondetalle) {
        this.idordenproducciondetalle = idordenproducciondetalle;
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

    public Ordenproduccion getIdordenproduccion() {
        return idordenproduccion;
    }

    public void setIdordenproduccion(Ordenproduccion idordenproduccion) {
        this.idordenproduccion = idordenproduccion;
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
        hash += (idordenproducciondetalle != null ? idordenproducciondetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenproducciondetalle)) {
            return false;
        }
        Ordenproducciondetalle other = (Ordenproducciondetalle) object;
        if ((this.idordenproducciondetalle == null && other.idordenproducciondetalle != null) || (this.idordenproducciondetalle != null && !this.idordenproducciondetalle.equals(other.idordenproducciondetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Ordenproducciondetalle[ idordenproducciondetalle=" + idordenproducciondetalle + " ]";
    }
    
}
