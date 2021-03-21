package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IStockControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IStockDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Stock;

/**
*
* @author Jenny Luna
*/
@Stateless
public class StockControladorImpl implements IStockControlador {

	
	@EJB
	private IStockDao stockDao;
	
	@Override
	public void guardarStock(Stock s) {
		stockDao.guardarStock(s);

	}

	@Override
	public void actualizarStock(Stock s) {
		stockDao.actualizarStock(s);

	}

	@Override
	public List<Stock> obtenerStock() {
		return stockDao.obtenerStock();
	}

	@Override
	public Stock stockPorId(Integer idStock) {
		return stockDao.stockPorId(idStock);
	}

}
