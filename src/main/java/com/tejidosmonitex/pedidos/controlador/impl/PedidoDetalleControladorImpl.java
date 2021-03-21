package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IPedidoDetalleControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IPedidoDetalleDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedidodetalle;

@Stateless
public class PedidoDetalleControladorImpl implements IPedidoDetalleControlador {

	@EJB
	private IPedidoDetalleDao pedidoDetalleDao;
	
	
	@Override
	public List<Pedidodetalle> obtenerPedidoDetalle() {
		return pedidoDetalleDao.obtenerPedidoDetalle();
	}

	@Override
	public void guardarPedidoDetalle(Pedidodetalle pd) {
		pedidoDetalleDao.guardarPedidoDetalle(pd);
	}

	@Override
	public List<Pedidodetalle> pedidoDetallePorId(Pedido p) {
		return pedidoDetalleDao.pedidoDetallePorId(p);
	}

}
