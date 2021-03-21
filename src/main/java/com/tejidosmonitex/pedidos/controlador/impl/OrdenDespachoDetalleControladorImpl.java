package com.tejidosmonitex.pedidos.controlador.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IOrdenDespachoDetalleControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IOrdenDespachoDetalleDao;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespachodetalle;

@Stateless
public class OrdenDespachoDetalleControladorImpl implements IOrdenDespachoDetalleControlador {

	@EJB
	private IOrdenDespachoDetalleDao despachoDao;
	
	@Override
	public List<Ordendespachodetalle> obtenerDespachoDetalle() {
		return despachoDao.obtenerDespachoDetalle();
	}

	@Override
	public void guardarDespachoDetalle(Ordendespachodetalle od) {
		despachoDao.guardarDespachoDetalle(od);
	}

	@Override
	public List<Ordendespachodetalle> despachoDetallePorId(Integer idDespacho) {
		return despachoDao.despachoDetallePorId(idDespacho);
	}

	@Override
	public void actualizarDespachoDetalle(Ordendespachodetalle od) {
		despachoDao.actualizarDespachoDetalle(od);
	}

}
