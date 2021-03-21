package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IPedidoDetalleDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedidodetalle;

@Stateless
public class PedidoDetalleDaoImpl implements IPedidoDetalleDao {

	 @PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
	    private EntityManager em;
	
	@Override
	public List<Pedidodetalle> obtenerPedidoDetalle() {
		Query q = em.createQuery("select p from Pedidodetalle p where p.estado = :estado");
		q.setParameter("estado", 'A');
		return q.getResultList();
	}

	@Override
	public void guardarPedidoDetalle(Pedidodetalle pd) {
		em.persist(pd);
	}

	@Override
	public List<Pedidodetalle> pedidoDetallePorId(Pedido p) {
		Query q = em.createQuery("select p from Pedidodetalle p where p.estado = :estado and p.idpedido.idpedido = :idPedido");
		q.setParameter("estado", 'A');
		q.setParameter("idPedido", p.getIdpedido().intValue());
		return q.getResultList();
	}

}
