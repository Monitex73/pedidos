package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IPrecioDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Precio;
import com.tejidosmonitex.pedidos.modelo.entidades.Stock;

/**
*
* @author Jenny Luna
*/
@Stateless
public class PrecioDaoImpl implements IPrecioDao {

	@PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
	private EntityManager em;
	
	@Override
	public void guardarPrecio(Precio p) {
		em.persist(p);

	}

	@Override
	public void actualizarPrecio(Precio p) {
		em.merge(p);

	}

	@Override
	public List<Precio> obtenerPrecio() {
		Query q = em.createQuery("select p from Precio p where p.estado = :estado");
		q.setParameter("estado", 'A');
		return q.getResultList();
	}

	@Override
	public Precio precioPorId(Integer idPrecio) {
	       Query q = em.createQuery("select p from Precio p where p.idprecio = :id and p.estado = :estado");
	        q.setParameter("id", idPrecio) ;
	        q.setParameter("estado", 'A');
	        
	        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
	            return (Precio) q.getResultList().get(0);
	        } else {
	            return new Precio();
	        } 
	}

}
