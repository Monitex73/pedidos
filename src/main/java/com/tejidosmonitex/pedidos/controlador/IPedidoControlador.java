package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;

@Local
public interface IPedidoControlador {
	public List<Pedido> obtenerPedidos();
	public void guardarPedido(Pedido p);

}
