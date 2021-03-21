package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Stock;

/**
*
* @author Jenny Luna
*/

@Local
public interface IStockControlador {

	public void guardarStock(Stock s);
	public void actualizarStock(Stock s);
	public List<Stock> obtenerStock();
	public Stock stockPorId(Integer idStock);
	
}
