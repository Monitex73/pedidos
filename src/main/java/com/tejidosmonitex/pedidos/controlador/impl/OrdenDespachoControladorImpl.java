package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IOrdenDespachoControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IOrdenDespachoDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespacho;

@Stateless
public class OrdenDespachoControladorImpl implements IOrdenDespachoControlador {

	@EJB
	private IOrdenDespachoDao ordenDespachoDao;
	
	@Override
	public List<Ordendespacho> obtenerOrdenesDespacho() {
		return ordenDespachoDao.obtenerOrdenesDespacho();
	}

	@Override
	public void guardarOrdenDespacho(Ordendespacho OD) {
		ordenDespachoDao.guardarOrdenDespacho(OD);
	}

	@Override
	public void actualizarOrdenDespacho(Ordendespacho OD) {
		ordenDespachoDao.actualizarOrdenDespacho(OD);
	}

}
