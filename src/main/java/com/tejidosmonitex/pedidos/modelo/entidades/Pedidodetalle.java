/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.modelo.entidades;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jenny Luna
 */
@Entity
@Table(name = "pedidodetalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedidodetalle.findAll", query = "SELECT p FROM Pedidodetalle p")
    , @NamedQuery(name = "Pedidodetalle.findByIddetallepedido", query = "SELECT p FROM Pedidodetalle p WHERE p.iddetallepedido = :iddetallepedido")
    , @NamedQuery(name = "Pedidodetalle.findByCantidadsolicitada", query = "SELECT p FROM Pedidodetalle p WHERE p.cantidadsolicitada = :cantidadsolicitada")
    , @NamedQuery(name = "Pedidodetalle.findByEstado", query = "SELECT p FROM Pedidodetalle p WHERE p.estado = :estado")
    , @NamedQuery(name = "Pedidodetalle.findByIdcolor", query = "SELECT p FROM Pedidodetalle p WHERE p.idcolor = :idcolor")})
public class Pedidodetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetallepedido")
    private Integer iddetallepedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidadsolicitada")
    private int cantidadsolicitada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @Column(name = "idcolor")
    private Integer idcolor;
    @JoinColumn(name = "idpedido", referencedColumnName = "idpedido")
    @ManyToOne(optional = false)
    private Pedido idpedido;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;
    @OneToMany(mappedBy = "iddetallepedido")
    private List<Ordenproducciondetalle> ordenproducciondetalleList;
    @OneToMany(mappedBy = "iddetallepedido")
    private List<Ordendespachodetalle> ordendespachodetalleList;

    public Pedidodetalle() {
    }

    public Pedidodetalle(Integer iddetallepedido) {
        this.iddetallepedido = iddetallepedido;
    }

    public Pedidodetalle(Integer iddetallepedido, int cantidadsolicitada, Character estado) {
        this.iddetallepedido = iddetallepedido;
        this.cantidadsolicitada = cantidadsolicitada;
        this.estado = estado;
    }

    public Integer getIddetallepedido() {
        return iddetallepedido;
    }

    public void setIddetallepedido(Integer iddetallepedido) {
        this.iddetallepedido = iddetallepedido;
    }

    public int getCantidadsolicitada() {
        return cantidadsolicitada;
    }

    public void setCantidadsolicitada(int cantidadsolicitada) {
        this.cantidadsolicitada = cantidadsolicitada;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Integer getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(Integer idcolor) {
        this.idcolor = idcolor;
    }

    public Pedido getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Pedido idpedido) {
        this.idpedido = idpedido;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @XmlTransient
    public List<Ordenproducciondetalle> getOrdenproducciondetalleList() {
        return ordenproducciondetalleList;
    }

    public void setOrdenproducciondetalleList(List<Ordenproducciondetalle> ordenproducciondetalleList) {
        this.ordenproducciondetalleList = ordenproducciondetalleList;
    }

    @XmlTransient
    public List<Ordendespachodetalle> getOrdendespachodetalleList() {
        return ordendespachodetalleList;
    }

    public void setOrdendespachodetalleList(List<Ordendespachodetalle> ordendespachodetalleList) {
        this.ordendespachodetalleList = ordendespachodetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetallepedido != null ? iddetallepedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedidodetalle)) {
            return false;
        }
        Pedidodetalle other = (Pedidodetalle) object;
        if ((this.iddetallepedido == null && other.iddetallepedido != null) || (this.iddetallepedido != null && !this.iddetallepedido.equals(other.iddetallepedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Pedidodetalle[ iddetallepedido=" + iddetallepedido + " ]";
    }
    
}
