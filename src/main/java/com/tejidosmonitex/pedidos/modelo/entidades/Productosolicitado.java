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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jenny Luna
 */
@Entity
@Table(name = "productosolicitado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productosolicitado.findAll", query = "SELECT p FROM Productosolicitado p")
    , @NamedQuery(name = "Productosolicitado.findByIdproductosolicitado", query = "SELECT p FROM Productosolicitado p WHERE p.idproductosolicitado = :idproductosolicitado")
    , @NamedQuery(name = "Productosolicitado.findByCantidad", query = "SELECT p FROM Productosolicitado p WHERE p.cantidad = :cantidad")
    , @NamedQuery(name = "Productosolicitado.findByEstado", query = "SELECT p FROM Productosolicitado p WHERE p.estado = :estado")
    , @NamedQuery(name = "Productosolicitado.findByFecha", query = "SELECT p FROM Productosolicitado p WHERE p.fecha = :fecha")})
public class Productosolicitado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproductosolicitado")
    private Integer idproductosolicitado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idcolor", referencedColumnName = "idcolor")
    @ManyToOne(optional = false)
    private Color idcolor;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false)
    private Producto idproducto;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @ManyToOne(optional = false)
    private Usuario idusuario;

    public Productosolicitado() {
    }

    public Productosolicitado(Integer idproductosolicitado) {
        this.idproductosolicitado = idproductosolicitado;
    }

    public Productosolicitado(Integer idproductosolicitado, int cantidad, Character estado, Date fecha) {
        this.idproductosolicitado = idproductosolicitado;
        this.cantidad = cantidad;
        this.estado = estado;
        this.fecha = fecha;
    }

    public Integer getIdproductosolicitado() {
        return idproductosolicitado;
    }

    public void setIdproductosolicitado(Integer idproductosolicitado) {
        this.idproductosolicitado = idproductosolicitado;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Color getIdcolor() {
        return idcolor;
    }

    public void setIdcolor(Color idcolor) {
        this.idcolor = idcolor;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproductosolicitado != null ? idproductosolicitado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productosolicitado)) {
            return false;
        }
        Productosolicitado other = (Productosolicitado) object;
        if ((this.idproductosolicitado == null && other.idproductosolicitado != null) || (this.idproductosolicitado != null && !this.idproductosolicitado.equals(other.idproductosolicitado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Productosolicitado[ idproductosolicitado=" + idproductosolicitado + " ]";
    }
    
}
