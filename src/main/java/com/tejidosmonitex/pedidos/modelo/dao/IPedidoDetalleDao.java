package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedidodetalle;

/**
*
* @author Jenny Luna
*/
@Local
public interface IPedidoDetalleDao {

	public List<Pedidodetalle> obtenerPedidoDetalle();
	
	public void guardarPedidoDetalle(Pedidodetalle pd);
	
	public List<Pedidodetalle> pedidoDetallePorId(Pedido p);
	
}
