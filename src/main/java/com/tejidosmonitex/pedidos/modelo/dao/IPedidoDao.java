package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;

/**
*
* @author Jenny Luna
*/
@Local
public interface IPedidoDao {
	
	public List<Pedido> obtenerPedidos();
	public void guardarPedido(Pedido p);

}
