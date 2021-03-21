package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespacho;

@Local
public interface IOrdenDespachoControlador {
	public List<Ordendespacho> obtenerOrdenesDespacho();
	public void guardarOrdenDespacho(Ordendespacho OD);
	public void actualizarOrdenDespacho(Ordendespacho OD);
}
