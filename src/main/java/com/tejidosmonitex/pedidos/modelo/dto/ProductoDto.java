package com.tejidosmonitex.pedidos.modelo.dto;

import java.io.Serializable;

public class ProductoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idProducto;
	private String nombre;
	private String modelo;
	private String talla;
	private Integer cantidad;
	private Double precio;
	private String estado;
	private String imagen;

	public ProductoDto() {

	}

	public ProductoDto(Integer idProducto, String nombre, String modelo, String talla, Integer cantidad, Double precio,
			String estado, String imagen) {
		this.setIdProducto(idProducto);
		this.setNombre(nombre);
		this.setModelo(modelo);
		this.setTalla(talla);
		this.setCantidad(cantidad);
		this.setPrecio(precio);
		this.setEstado(estado);
		this.setImagen(imagen);
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTalla() {
		return talla;
	}

	public void setTalla(String talla) {
		this.talla = talla;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}



}
