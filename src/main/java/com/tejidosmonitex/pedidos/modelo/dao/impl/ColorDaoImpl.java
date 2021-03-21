package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IColorDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Color;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;


@Stateless
public class ColorDaoImpl extends GenericDaoImpl<Color> implements IColorDao {

    @PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;
	
	@Override
	public List<Color> obtenerColores() {
		Query q = em.createQuery("select c from Color c where c.estado = :estado");
        q.setParameter("estado", 'A');
        return q.getResultList();
	}

	@Override
	public void guardarColor(Color c) {
		em.persist(c);		
	}

	@Override
	public Color obetnerColorPorNombre(String nombre) {
	       Query q = em.createQuery("select c from Color c where c.nombre = :nomColor and c.estado = :estado");
	        q.setParameter("nomColor", nombre) ;
	        q.setParameter("estado", 'A');
	        
	        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
	            return (Color) q.getResultList().get(0);
	        } else {
	            return new Color();
	        } 
	}

	@Override
	public List<Color> obtenerAllColores() {
		Query q = em.createQuery("select c from Color c");
        return q.getResultList();
	}

	@Override
	public void actualizarColor(Color c) {
		em.merge(c);
	}

	@Override
	public Color obetnerColorPorId(Integer idColor) {
		   Query q = em.createQuery("select c from Color c where c.idcolor = :id and c.estado = :estado");
	        q.setParameter("id", idColor) ;
	        q.setParameter("estado", 'A');
	        
	        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
	            return (Color) q.getResultList().get(0);
	        } else {
	            return new Color();
	        } 
	}

}
