package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IPedidoControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IPedidoDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;

@Stateless
public class PedidoControladorImpl implements IPedidoControlador {

	@EJB
	private IPedidoDao pedidoDao;
	
	@Override
	public List<Pedido> obtenerPedidos() {
		return pedidoDao.obtenerPedidos();
	}

	@Override
	public void guardarPedido(Pedido p) {
		pedidoDao.guardarPedido(p);
	}

}
