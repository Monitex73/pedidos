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
@Table(name = "talla")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Talla.findAll", query = "SELECT t FROM Talla t")
    , @NamedQuery(name = "Talla.findByIdtalla", query = "SELECT t FROM Talla t WHERE t.idtalla = :idtalla")
    , @NamedQuery(name = "Talla.findByNombre", query = "SELECT t FROM Talla t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "Talla.findByDescripcion", query = "SELECT t FROM Talla t WHERE t.descripcion = :descripcion")
    , @NamedQuery(name = "Talla.findByEstado", query = "SELECT t FROM Talla t WHERE t.estado = :estado")})
public class Talla implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtalla")
    private Integer idtalla;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtalla")
    private List<Producto> productoList;

    public Talla() {
    }

    public Talla(Integer idtalla) {
        this.idtalla = idtalla;
    }

    public Talla(Integer idtalla, String nombre, String descripcion, Character estado) {
        this.idtalla = idtalla;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public Integer getIdtalla() {
        return idtalla;
    }

    public void setIdtalla(Integer idtalla) {
        this.idtalla = idtalla;
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtalla != null ? idtalla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Talla)) {
            return false;
        }
        Talla other = (Talla) object;
        if ((this.idtalla == null && other.idtalla != null) || (this.idtalla != null && !this.idtalla.equals(other.idtalla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Talla[ idtalla=" + idtalla + " ]";
    }
    
}
