package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IOrdenProduccionDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproduccion;

@Stateless
public class OrdenProduccionDaoImpl extends GenericDaoImpl<Ordenproduccion> implements IOrdenProduccionDao {

    @PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;
	
	@Override
	public List<Ordenproduccion> obtenerOrdenesProduccion() {
        Query q = em.createQuery("select op from Ordenproduccion op where op.estado <> :estado");
        q.setParameter("estado", 'X');
        return q.getResultList();
	}

	@Override
	public void guardarOrdenProduccion(Ordenproduccion OP) {
		em.persist(OP);
	}

	@Override
	public void actualizarOrdenProduccion(Ordenproduccion OP) {
		em.merge(OP);
	}

}
