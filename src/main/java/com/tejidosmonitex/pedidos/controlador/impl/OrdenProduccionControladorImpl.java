package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IOrdenProduccionControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IOrdenProduccionDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproduccion;

@Stateless
public class OrdenProduccionControladorImpl implements IOrdenProduccionControlador {

	@EJB
	private IOrdenProduccionDao ordenProduccionDao;
	
	@Override
	public List<Ordenproduccion> obtenerOrdenesProduccion() {
		return ordenProduccionDao.obtenerOrdenesProduccion();
	}

	@Override
	public void guardarOrdenProduccion(Ordenproduccion OP) {
		ordenProduccionDao.guardarOrdenProduccion(OP);
	}

	@Override
	public void actualizarOrdenProduccion(Ordenproduccion OP) {
		ordenProduccionDao.actualizarOrdenProduccion(OP);
	}

}
