package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IPedidoDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;

@Stateless
public class PedidoDaoImpl extends GenericDaoImpl<Pedido> implements IPedidoDao {

    @PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;
	
	@Override
	public List<Pedido> obtenerPedidos() {
        Query q = em.createQuery("select p from Pedido p where p.estado = :estado");
        q.setParameter("estado", 'A');
        return q.getResultList();
	}

	@Override
	public void guardarPedido(Pedido p) {
		em.persist(p);
	}

}
