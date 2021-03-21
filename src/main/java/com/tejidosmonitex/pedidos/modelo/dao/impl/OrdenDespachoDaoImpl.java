package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IOrdenDespachoDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespacho;

@Stateless
public class OrdenDespachoDaoImpl extends GenericDaoImpl<Ordendespacho> implements IOrdenDespachoDao {

	@PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
	private EntityManager em;

	@Override
	public List<Ordendespacho> obtenerOrdenesDespacho() {
		Query q = em.createQuery("select od from Ordendespacho od where od.estado <> :estado");
		q.setParameter("estado", 'X');
		return q.getResultList();
	}

	@Override
	public void guardarOrdenDespacho(Ordendespacho OD) {
		em.persist(OD);

	}

	@Override
	public void actualizarOrdenDespacho(Ordendespacho OD) {
		em.merge(OD);
	}

}
