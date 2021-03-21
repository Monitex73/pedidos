package com.tejidosmonitex.pedidos.controlador;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.ejb.Local;

import com.tejidosmonitex.pedidos.modelo.dto.ProductoDto;
import com.tejidosmonitex.pedidos.modelo.entidades.Producto;

@Local
public interface IProductoControlador {
	public List<Producto> obtenerProductos();
	public void guardarProducto(Producto p);
	public void actualizarProducto(Producto p);
	public List<Producto> obtenerAllProductos();
	public List<ProductoDto> productosDisponibles();
	public List<ProductoDto> productosActivos();
	public Producto productoPorID(Integer idProducto);
	public void guardarImagen(InputStream inputStream, File file);
}
