package com.tejidosmonitex.pedidos.modelo.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.tejidosmonitex.pedidos.modelo.dao.IStockDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Producto;
import com.tejidosmonitex.pedidos.modelo.entidades.Stock;


/**
*
* @author Jenny Luna
*/
@Stateless
public class StockDaoImpl implements IStockDao {

	@PersistenceContext(unitName = "com.tejidosmonitex_pedidos_PU")
	private EntityManager em;
	
	@Override
	public void guardarStock(Stock s) {
		em.persist(s);
	}

	@Override
	public void actualizarStock(Stock s) {
		em.merge(s);
	}

	@Override
	public List<Stock> obtenerStock() {
		Query q = em.createQuery("select s from Stock s where s.estado = :estado");
		q.setParameter("estado", 'A');
		return q.getResultList();
	}

	@Override
	public Stock stockPorId(Integer idStock) {
	       Query q = em.createQuery("select s from Stock s where s.idstock = :id");
	        q.setParameter("id", idStock) ;
	        
	        if ((q.getResultList() != null) && (q.getResultList().size() == 1)) {
	            return (Stock) q.getResultList().get(0);
	        } else {
	            return new Stock();
	        } 
	}

}
