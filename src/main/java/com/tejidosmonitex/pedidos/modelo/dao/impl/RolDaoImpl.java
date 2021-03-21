/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.modelo.dao.IRolDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jenny Luna
 */
@Stateless
public class RolDaoImpl extends GenericDaoImpl<Rol> implements IRolDao{

    @PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;
    
    @Override
    public Rol buscarRolPorNombre(String nombre) {
        Query q = em.createQuery("select r from Rol r where r.nombre = :nomRol and r.estado = :estado");
        q.setParameter("nomRol", nombre) ;
        q.setParameter("estado", 'A');
        
        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
            return (Rol) q.getResultList().get(0);
        } else {
            return new Rol();
        } 
    }

	@Override
	public List<Rol> obtenerRoles() {
        Query q = em.createQuery("select r from Rol r where r.estado = :estado");
        q.setParameter("estado", 'A');
        return q.getResultList();
	}

	@Override
	public void guardarRol(Rol r) {
		em.persist(r);		
	}

	@Override
	public List<Rol> obtenerRolesInternos() {
        Query q = em.createQuery("select r from Rol r where r.estado = :estado and r.tipo = :tipo");
        q.setParameter("estado", 'A');
        q.setParameter("tipo", 'I');
        return q.getResultList();
	}

	@Override
	public void actualizarRol(Rol r) {
		em.merge(r);	
	}

	@Override
	public List<Rol> obtenerAllRoles() {
        Query q = em.createQuery("select r from Rol r");
        return q.getResultList();
	}
    
}
