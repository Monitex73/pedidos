package com.tejidosmonitex.pedidos.modelo.dao;

import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespachodetalle;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

/**
*
* @author Jenny Luna
*/
@Local
public interface IOrdenDespachoDetalleDao {
	
	public List<Ordendespachodetalle> obtenerDespachoDetalle();
	
	public void guardarDespachoDetalle (Ordendespachodetalle od);
	
	public List<Ordendespachodetalle> despachoDetallePorId(Integer idDespacho);
	
	public void actualizarDespachoDetalle (Ordendespachodetalle od);
	
	
}
