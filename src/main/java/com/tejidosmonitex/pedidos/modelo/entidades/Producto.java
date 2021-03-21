/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.modelo.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jenny Luna
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdproducto", query = "SELECT p FROM Producto p WHERE p.idproducto = :idproducto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Producto.findByImagen", query = "SELECT p FROM Producto p WHERE p.imagen = :imagen")
    , @NamedQuery(name = "Producto.findByIdstock", query = "SELECT p FROM Producto p WHERE p.idstock = :idstock")
    , @NamedQuery(name = "Producto.findByIdprecio", query = "SELECT p FROM Producto p WHERE p.idprecio = :idprecio")
    , @NamedQuery(name = "Producto.findByEstado", query = "SELECT p FROM Producto p WHERE p.estado = :estado")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 200)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstock")
    private int idstock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idprecio")
    private int idprecio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto")
    private List<Pedidodetalle> pedidodetalleList;
    @JoinColumn(name = "idmodelo", referencedColumnName = "idmodelo")
    @ManyToOne(optional = false)
    private Modelo idmodelo;
    @JoinColumn(name = "idtalla", referencedColumnName = "idtalla")
    @ManyToOne(optional = false)
    private Talla idtalla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto")
    private List<Precio> precioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto")
    private List<Productosolicitado> productosolicitadoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idproducto")
    private List<Stock> stockList;

    public Producto() {
    }

    public Producto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Producto(Integer idproducto, String nombre, String descripcion, int idstock, int idprecio, Character estado) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idstock = idstock;
        this.idprecio = idprecio;
        this.estado = estado;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdstock() {
        return idstock;
    }

    public void setIdstock(int idstock) {
        this.idstock = idstock;
    }

    public int getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(int idprecio) {
        this.idprecio = idprecio;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Pedidodetalle> getPedidodetalleList() {
        return pedidodetalleList;
    }

    public void setPedidodetalleList(List<Pedidodetalle> pedidodetalleList) {
        this.pedidodetalleList = pedidodetalleList;
    }

    public Modelo getIdmodelo() {
        return idmodelo;
    }

    public void setIdmodelo(Modelo idmodelo) {
        this.idmodelo = idmodelo;
    }

    public Talla getIdtalla() {
        return idtalla;
    }

    public void setIdtalla(Talla idtalla) {
        this.idtalla = idtalla;
    }

    @XmlTransient
    public List<Precio> getPrecioList() {
        return precioList;
    }

    public void setPrecioList(List<Precio> precioList) {
        this.precioList = precioList;
    }

    @XmlTransient
    public List<Productosolicitado> getProductosolicitadoList() {
        return productosolicitadoList;
    }

    public void setProductosolicitadoList(List<Productosolicitado> productosolicitadoList) {
        this.productosolicitadoList = productosolicitadoList;
    }

    @XmlTransient
    public List<Stock> getStockList() {
        return stockList;
    }

    public void setStockList(List<Stock> stockList) {
        this.stockList = stockList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Producto[ idproducto=" + idproducto + " ]";
    }
    
}
