package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespachodetalle;

/**
*
* @author Jenny Luna
*/
@Local
public interface IOrdenDespachoDetalleControlador {

	public List<Ordendespachodetalle> obtenerDespachoDetalle();
	
	public void guardarDespachoDetalle (Ordendespachodetalle od);
	
	public List<Ordendespachodetalle> despachoDetallePorId(Integer idDespacho);
	
	public void actualizarDespachoDetalle (Ordendespachodetalle od);
	
}
