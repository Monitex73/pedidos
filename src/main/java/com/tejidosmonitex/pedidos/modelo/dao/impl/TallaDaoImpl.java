package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.ITallaDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;
import com.tejidosmonitex.pedidos.modelo.entidades.Talla;

@Stateless
public class TallaDaoImpl implements ITallaDao {

    @PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;
	
	@Override
	public List<Talla> obtenerTallas() {
		Query q = em.createQuery("select t from Talla t where t.estado = :estado");
        q.setParameter("estado", 'A');
        return q.getResultList();
	}

	@Override
	public void guardarTalla(Talla t) {
		em.persist(t);
	}

	@Override
	public Talla buscarTallaPorNombre(String nombreTalla) {
        Query q = em.createQuery("select t from Talla t where t.nombre = :nomTalla and t.estado = :estado");
        q.setParameter("nomTalla", nombreTalla) ;
        q.setParameter("estado", 'A');
        
        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
            return (Talla) q.getResultList().get(0);
        } else {
            return new Talla();
        } 
	}

	@Override
	public void actualizarTalla(Talla t) {
		em.merge(t);
	}

	@Override
	public List<Talla> obtenerAllTallas() {
		Query q = em.createQuery("select t from Talla t");
        return q.getResultList();
	}

}
