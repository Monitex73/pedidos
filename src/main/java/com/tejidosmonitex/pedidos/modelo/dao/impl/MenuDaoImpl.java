package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IMenuDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Menu;

@Stateless
public class MenuDaoImpl implements IMenuDao {

	@PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
	private EntityManager em;

	@Override
	public List<Menu> obtenerMenus() {
		Query q = em.createQuery("select m from Menu m where m.estado = :estado");
		q.setParameter("estado", 'A');
		return q.getResultList();
	}

	@Override
	public void guardarMenu(Menu m) {
		em.persist(m);
	}

}
