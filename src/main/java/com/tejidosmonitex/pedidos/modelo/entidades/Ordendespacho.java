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
@Table(name = "ordendespacho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordendespacho.findAll", query = "SELECT o FROM Ordendespacho o")
    , @NamedQuery(name = "Ordendespacho.findByIdordendespacho", query = "SELECT o FROM Ordendespacho o WHERE o.idordendespacho = :idordendespacho")
    , @NamedQuery(name = "Ordendespacho.findByFecha", query = "SELECT o FROM Ordendespacho o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Ordendespacho.findByEstado", query = "SELECT o FROM Ordendespacho o WHERE o.estado = :estado")})
public class Ordendespacho implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idordendespacho")
    private Integer idordendespacho;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idordendespacho")
    private List<Ordendespachodetalle> ordendespachodetalleList;

    public Ordendespacho() {
    }

    public Ordendespacho(Integer idordendespacho) {
        this.idordendespacho = idordendespacho;
    }

    public Ordendespacho(Integer idordendespacho, Date fecha, Character estado) {
        this.idordendespacho = idordendespacho;
        this.fecha = fecha;
        this.estado = estado;
    }

    public Integer getIdordendespacho() {
        return idordendespacho;
    }

    public void setIdordendespacho(Integer idordendespacho) {
        this.idordendespacho = idordendespacho;
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
    public List<Ordendespachodetalle> getOrdendespachodetalleList() {
        return ordendespachodetalleList;
    }

    public void setOrdendespachodetalleList(List<Ordendespachodetalle> ordendespachodetalleList) {
        this.ordendespachodetalleList = ordendespachodetalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idordendespacho != null ? idordendespacho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordendespacho)) {
            return false;
        }
        Ordendespacho other = (Ordendespacho) object;
        if ((this.idordendespacho == null && other.idordendespacho != null) || (this.idordendespacho != null && !this.idordendespacho.equals(other.idordendespacho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tejidosmonitex.pedidos.modelo.entidades.Ordendespacho[ idordendespacho=" + idordendespacho + " ]";
    }
    
}
