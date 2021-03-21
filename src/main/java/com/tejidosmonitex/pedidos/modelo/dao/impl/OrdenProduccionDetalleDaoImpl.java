package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IOrdenProduccionDetalleDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproducciondetalle;

@Stateless
public class OrdenProduccionDetalleDaoImpl implements IOrdenProduccionDetalleDao {

	@PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;
	
	@Override
	public void guardarProduccionDetalle(Ordenproducciondetalle op) {
		em.persist(op);
	}

	@Override
	public List<Ordenproducciondetalle> obtenerProduccionDetalle() {
		Query q = em.createQuery("select od from Ordenproducciondetalle od where od.estado = :estado");
        q.setParameter("estado", 'A');
        return q.getResultList();
	}

	@Override
	public List<Ordenproducciondetalle> produccionDetallePorId(Integer idProduccion) {
		Query q = em.createQuery("select od from Ordenproducciondetalle od where od.estado <> :estado and od.idordenproduccion.idordenproduccion = :idProduccion");
        q.setParameter("estado", 'X');
        q.setParameter("idProduccion", idProduccion);
        return q.getResultList();
	}

	@Override
	public void actualizarProduccionDetalle(Ordenproducciondetalle op) {
		em.merge(op);
	}

}
