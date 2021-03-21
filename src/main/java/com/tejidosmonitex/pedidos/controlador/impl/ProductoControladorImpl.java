package com.tejidosmonitex.pedidos.controlador.impl;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.tejidosmonitex.pedidos.controlador.IProductoControlador;
import com.tejidosmonitex.pedidos.modelo.dao.IProductoDao;
import com.tejidosmonitex.pedidos.modelo.dto.ProductoDto;
import com.tejidosmonitex.pedidos.modelo.entidades.Producto;

@Stateless
public class ProductoControladorImpl implements IProductoControlador {

	@EJB
	private IProductoDao productoDao;

	@Override
	public List<Producto> obtenerProductos() {
		return productoDao.obtenerProductos();
	}

	@Override
	public void guardarProducto(Producto p) {
		productoDao.guardarProducto(p);
	}

	@Override
	public void actualizarProducto(Producto p) {
		productoDao.actualizarProducto(p);
	}

	@Override
	public List<Producto> obtenerAllProductos() {
		return productoDao.obtenerAllProductos();
	}

	@Override
	public List<ProductoDto> productosDisponibles() {
		return productoDao.productosDisponibles();
	}

	@Override
	public Producto productoPorID(Integer idProducto) {
		return productoDao.productoPorID(idProducto);
	}

	@Override
	public List<ProductoDto> productosActivos() {
		return productoDao.productosActivos();
	}

	@Override
	public void guardarImagen(InputStream inputStream, File file) {
		productoDao.guardarImagen(inputStream, file);	
	}

}
