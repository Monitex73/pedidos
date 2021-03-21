package com.tejidosmonitex.pedidos.modelo.dao;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.dto.ProductoDto;
import com.tejidosmonitex.pedidos.modelo.entidades.Producto;

/**
*
* @author Jenny Luna
*/
@Local
public interface IProductoDao {

	public List<Producto> obtenerProductos();
	public List<Producto> obtenerAllProductos();
	public void guardarProducto(Producto p);
	public void actualizarProducto(Producto p);
	public List<ProductoDto> productosDisponibles();
	public List<ProductoDto> productosActivos();
	public Producto productoPorID(Integer idProducto);
	public void guardarImagen(InputStream inputStream, File file);
}
