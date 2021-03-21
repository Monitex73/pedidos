package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Stock;

/**
*
* @author Jenny Luna
*/
@Local
public interface IStockDao {

	public void guardarStock(Stock s);
	public void actualizarStock(Stock s);
	public List<Stock> obtenerStock();
	public Stock stockPorId(Integer idStock);
	
}
