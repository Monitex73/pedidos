package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IOrdenDespachoDetalleDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespachodetalle;

@Stateless
public class OrdenDespachoDetalleDaoImpl implements IOrdenDespachoDetalleDao {

	@PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
    private EntityManager em;
	
	@Override
	public List<Ordendespachodetalle> obtenerDespachoDetalle() {
		Query q = em.createQuery("select od from Ordendespachodetalle od where od.estado = :estado");
        q.setParameter("estado", 'A');
        return q.getResultList();
	}

	@Override
	public void guardarDespachoDetalle(Ordendespachodetalle od) {
		em.persist(od);
	}

	@Override
	public List<Ordendespachodetalle> despachoDetallePorId(Integer idDespacho) {
		Query q = em.createQuery("select od from Ordendespachodetalle od where od.estado != :estado and od.idordendespacho.idordendespacho = :idDespacho");
        q.setParameter("estado", 'X');
        q.setParameter("idDespacho", idDespacho);
        return q.getResultList();
	}

	@Override
	public void actualizarDespachoDetalle(Ordendespachodetalle od) {
		em.merge(od);
	}

}
