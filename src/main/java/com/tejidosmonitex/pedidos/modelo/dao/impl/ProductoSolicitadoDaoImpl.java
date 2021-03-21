package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IProductoSolicitadoDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Productosolicitado;

@Stateless
public class ProductoSolicitadoDaoImpl implements IProductoSolicitadoDao {

	@PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
	private EntityManager em;

	@Override
	public List<Productosolicitado> obtenerProductosSolicitados() {
		Query q = em.createQuery("select p from Productosolicitado p where p.estado = :estado");
		q.setParameter("estado", 'A');
		return q.getResultList();
	}

	@Override
	public void guardarProductoSolicitado(Productosolicitado ps) {
		em.persist(ps);
	}

	@Override
	public List<Productosolicitado> obtenerProductosSolicitadosPorUsuario(Integer idUsuario) {
		Query q = em
				.createQuery("select p from Productosolicitado p where p.idusuario.idusuario = :usuario and p.estado = :estado");
		q.setParameter("usuario", idUsuario);
		q.setParameter("estado", 'A');
		return q.getResultList();
	}

	@Override
	public void actualizarProductoSolicitado(Productosolicitado ps) {
		em.merge(ps);
	}

}
