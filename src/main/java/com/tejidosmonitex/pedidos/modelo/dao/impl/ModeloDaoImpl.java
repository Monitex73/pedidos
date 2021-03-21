package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IModeloDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Modelo;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;

@Stateless
public class ModeloDaoImpl extends GenericDaoImpl<Modelo> implements IModeloDao {

    @PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;
	
	@Override
	public List<Modelo> obtenerModelos() {
        Query q = em.createQuery("select m from Modelo m where m.estado = :estado");
        q.setParameter("estado", 'A');
        return q.getResultList();
	}

	@Override
	public void guardarModelo(Modelo m) {
		em.persist(m);
	}

	@Override
	public Modelo buscarModeloPorNombre(String nombreModelo) {
        Query q = em.createQuery("select m from Modelo m where m.nombre = :nomModelo and m.estado = :estado");
        q.setParameter("nomModelo", nombreModelo) ;
        q.setParameter("estado", 'A');
        
        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
            return (Modelo) q.getResultList().get(0);
        } else {
            return new Modelo();
        } 
	}

	@Override
	public void actualizarModelo(Modelo m) {
		em.merge(m);	
	}

	@Override
	public List<Modelo> obtenerAllModelos() {
        Query q = em.createQuery("select m from Modelo m");
        return q.getResultList();
	}
	

}
