package com.tejidosmonitex.pedidos.vista;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.tejidosmonitex.pedidos.controlador.IColorControlador;
import com.tejidosmonitex.pedidos.controlador.IModeloControlador;
import com.tejidosmonitex.pedidos.controlador.IPrecioControlador;
import com.tejidosmonitex.pedidos.controlador.IProductoControlador;
import com.tejidosmonitex.pedidos.controlador.IProductoSolicitadoControlador;
import com.tejidosmonitex.pedidos.controlador.IStockControlador;
import com.tejidosmonitex.pedidos.controlador.ITallaControlador;
import com.tejidosmonitex.pedidos.modelo.dto.ProductoDto;
import com.tejidosmonitex.pedidos.modelo.entidades.Color;
import com.tejidosmonitex.pedidos.modelo.entidades.Modelo;
import com.tejidosmonitex.pedidos.modelo.entidades.Precio;
import com.tejidosmonitex.pedidos.modelo.entidades.Producto;
import com.tejidosmonitex.pedidos.modelo.entidades.Productosolicitado;
import com.tejidosmonitex.pedidos.modelo.entidades.Stock;
import com.tejidosmonitex.pedidos.modelo.entidades.Talla;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;
import com.tejidosmonitex.pedidos.util.UtilClient;

@Named
@ViewScoped
@Stateful
public class ProductoVista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IProductoControlador productoControlador;
	
	@EJB
	private IModeloControlador modeloControlador;
	
	@EJB
	private ITallaControlador tallaControlador;
	
	@EJB
	private IColorControlador colorControlador;
	
	@EJB
	private IProductoSolicitadoControlador productoSolicitadoControlador;
	
	@EJB
	private IStockControlador stockControlador;
	
	@EJB
	private IPrecioControlador precioControlador;
	
	private List<Producto> listaProductos;
	private List<Producto> listaProductosFiltrados;
	private List<Producto> listaAllProductos;
	private List<ProductoDto> listaProductosDisponibles;
	private List<ProductoDto> listaProductosActivos;
	private List<Modelo> listaModelos;
	private List<Talla> listaTallas;
	private List<Color> listaColores;
	
	private Producto producto;
	private Productosolicitado productoSolicitado;
	private Modelo modeloSeleccionado;
	private Talla tallaSeleccionada;
	private Color colorSeleccionado;
	private Producto productoSeleccionado;
	private String nombreModelo;
	private String nombreTalla;
	private String nombreColor;
	private Integer cantidadDisponible;
	private Double precio;
	private Integer cantidadSolicitada;
	private UploadedFile file;
	private String imagenURL ="/resources/fotos/clinicas/sin_imagen.jpg";
	private String imagen="sin_imagen.jpg";
	
	@PostConstruct
	public void init() {
		listaProductos = productoControlador.obtenerProductos();
		listaAllProductos = productoControlador.obtenerAllProductos();
		listaProductosDisponibles = productoControlador.productosDisponibles();
		listaProductosActivos = productoControlador.productosActivos();
		listaModelos = modeloControlador.obtenerModelos();
		listaTallas = tallaControlador.obtenerTallas();
		listaColores = colorControlador.obtenerColores();
	}
	
	public String getImagenURL() {
		return imagenURL;
	}

	public void setImagenURL(String imagenURL) {
		this.imagenURL = imagenURL;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<Producto> getListaProductosFiltrados() {
		return listaProductosFiltrados;
	}

	public void setListaProductosFiltrados(List<Producto> listaProductosFiltrados) {
		this.listaProductosFiltrados = listaProductosFiltrados;
	}

	public List<ProductoDto> getListaProductosActivos() {
		return listaProductosActivos;
	}

	public void setListaProductosActivos(List<ProductoDto> listaProductosActivos) {
		this.listaProductosActivos = listaProductosActivos;
	}

	public Productosolicitado getProductoSolicitado() {
		return productoSolicitado;
	}

	public List<ProductoDto> getListaProductosDisponibles() {
		return listaProductosDisponibles;
	}

	public void setListaProductosDisponibles(List<ProductoDto> listaProductosDisponibles) {
		this.listaProductosDisponibles = listaProductosDisponibles;
	}

	public Color getColorSeleccionado() {
		return colorSeleccionado;
	}

	public void setColorSeleccionado(Color colorSeleccionado) {
		this.colorSeleccionado = colorSeleccionado;
	}

	public void setProductoSolicitado(Productosolicitado productoSolicitado) {
		this.productoSolicitado = productoSolicitado;
	}


	public List<Producto> getListaAllProductos() {
		return listaAllProductos;
	}

	public void setListaAllProductos(List<Producto> listaAllProductos) {
		this.listaAllProductos = listaAllProductos;
	}

	public Integer getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(Integer cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Modelo getModeloSeleccionado() {
		return modeloSeleccionado;
	}

	public void setModeloSeleccionado(Modelo modeloSeleccionado) {
		this.modeloSeleccionado = modeloSeleccionado;
	}

	public Talla getTallaSeleccionada() {
		return tallaSeleccionada;
	}

	public void setTallaSeleccionada(Talla tallaSeleccionada) {
		this.tallaSeleccionada = tallaSeleccionada;
	}

	public String getNombreModelo() {
		return nombreModelo;
	}

	public void setNombreModelo(String nombreModelo) {
		this.nombreModelo = nombreModelo;
	}

	public String getNombreTalla() {
		return nombreTalla;
	}

	public void setNombreTalla(String nombreTalla) {
		this.nombreTalla = nombreTalla;
	}

	public Producto getProductoSeleccionado() {
		return productoSeleccionado;
	}

	public void setProductoSeleccionado(Producto productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
	}

	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<Modelo> getListaModelos() {
		return listaModelos;
	}

	public void setListaModelos(List<Modelo> listaModelos) {
		this.listaModelos = listaModelos;
	}

	public List<Talla> getListaTallas() {
		return listaTallas;
	}

	public void setListaTallas(List<Talla> listaTallas) {
		this.listaTallas = listaTallas;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	public List<Color> getListaColores() {
		return listaColores;
	}

	public void setListaColores(List<Color> listaColores) {
		this.listaColores = listaColores;
	}
	
	public String getNombreColor() {
		return nombreColor;
	}

	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}
	
	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public void nuevoProducto() {
		this.productoSeleccionado = new Producto();
	}
	
	public void editarProducto(ProductoDto p) {
		Producto prd = productoControlador.productoPorID(p.getIdProducto());

		this.setProductoSeleccionado(prd);
		nombreModelo = prd.getIdmodelo().getNombre();
		nombreTalla = prd.getIdtalla().getNombre();
		cantidadDisponible = p.getCantidad();
		precio = p.getPrecio();
		imagen = p.getImagen();
	}
	
	public void guardarProducto() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		modeloSeleccionado = modeloControlador.buscarModeloPorNombre(nombreModelo);
		tallaSeleccionada = tallaControlador.buscarTallaPorNombre(nombreTalla);
		
		productoSeleccionado.setIdmodelo(modeloSeleccionado);
		productoSeleccionado.setIdtalla(tallaSeleccionada);
		productoSeleccionado.setImagen(imagen);
		
		if(productoSeleccionado.getIdproducto() == null) {
			
			Stock stockProducto = new Stock();
			Precio precioProducto = new Precio();
			
			productoSeleccionado.setIdstock(0);
			productoSeleccionado.setIdprecio(0);
			productoSeleccionado.setEstado('A');
					
			//Guarda Stock del Producto Ingresado
			stockProducto.setCantidad(cantidadDisponible);
			stockProducto.setFecha(new Date());
			stockProducto.setMovimiento("Registro Nuevo Producto");
			stockProducto.setTipo("Incremento");
			stockProducto.setEstado('A');
			stockProducto.setIdproducto(productoSeleccionado);
			
			//Guarda Precio del Producto Ingresado
			precioProducto.setFecha(new Date());
			precioProducto.setValor(precio);
			precioProducto.setEstado('A');
			precioProducto.setIdproducto(productoSeleccionado);
			
			productoSeleccionado.setPrecioList(Arrays.asList(precioProducto));
			productoSeleccionado.setStockList(Arrays.asList(stockProducto));
			productoControlador.guardarProducto(productoSeleccionado);
			
			productoSeleccionado.setIdstock(stockProducto.getIdstock());
			productoSeleccionado.setIdprecio(precioProducto.getIdprecio());			
			
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Producto Registrado"));
				
		}else {
			Stock stockProducto = stockControlador.stockPorId(productoSeleccionado.getIdstock());
			if(!cantidadDisponible.equals(stockProducto.getCantidad())){
				stockProducto.setEstado('X');
				stockControlador.actualizarStock(stockProducto);
				Stock stockProductoNew = new Stock();
				//Guarda Stock del Producto Ingresado
				stockProductoNew.setCantidad(cantidadDisponible);
				stockProductoNew.setFecha(new Date());
				stockProductoNew.setMovimiento("Actualizo Producto");
				stockProductoNew.setTipo("Modifico");
				stockProductoNew.setEstado('A');
				stockProductoNew.setIdproducto(productoSeleccionado);
				stockControlador.guardarStock(stockProductoNew);
				productoSeleccionado.setIdstock(stockProductoNew.getIdstock());
			}
			
			Precio precioProducto = precioControlador.precioPorId(productoSeleccionado.getIdprecio());
			if(!precio.equals(precioProducto.getValor())) {
				precioProducto.setEstado('A');
				precioControlador.actualizarPrecio(precioProducto);
				Precio precioProductoNew = new Precio();
				//Guarda Precio del Producto Ingresado
				precioProductoNew.setFecha(new Date());
				precioProductoNew.setValor(precio);
				precioProductoNew.setEstado('A');
				precioProductoNew.setIdproducto(productoSeleccionado);
				precioControlador.guardarPrecio(precioProductoNew);
				productoSeleccionado.setIdprecio(precioProductoNew.getIdprecio());
				
			}			
			productoControlador.actualizarProducto(productoSeleccionado);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Producto Actualizado"));
		}
		
		listaProductosDisponibles = productoControlador.productosDisponibles();
		imagen="sin_imagen.jpg";
		
		PrimeFaces.current().executeScript("PF('manejoProducto').hide()");
        PrimeFaces.current().ajax().update("mensajes", "form:tblProductos");
	}
	
	public void guardarFileUpload(FileUploadEvent event) {
        try {
        	FacesContext context = FacesContext.getCurrentInstance();
            file = event.getFile();
            String destination;
            HashMap<String, String> map = UtilClient.getMapPathFotosProducto();

            destination = map.get("path");
            if (destination == null) {
            	context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Path Destino Error"));
            } else {
                imagenURL = map.get("url") + file.getFileName();
                imagen = file.getFileName();
                if (UtilClient.copyFile(file.getFileName(), file.getInputstream(), destination)) {                  
                } 
            }

        } catch (Exception e) {
        	e.printStackTrace();
        }

    }
	
	public void cambiarEstadoProducto(ProductoDto p) {	
		FacesContext context = FacesContext.getCurrentInstance();
		Producto prd = productoControlador.productoPorID(p.getIdProducto());
		if (prd.getEstado() == 'A') {
			prd.setEstado('X');
		} else {
			prd.setEstado('A');
		}

		productoControlador.actualizarProducto(prd);
		
		listaProductosDisponibles = productoControlador.productosDisponibles();

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Producto Actualizado"));
	}
	
	public void guardarProductoSolicitado() {
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogin");

		productoSolicitado = new Productosolicitado();
		colorSeleccionado = colorControlador.obetnerColorPorNombre(nombreColor);
				
		productoSolicitado.setCantidad(cantidadSolicitada);
		productoSolicitado.setFecha(new Date());
		productoSolicitado.setEstado('A');
		productoSolicitado.setIdcolor(colorSeleccionado);
		productoSolicitado.setIdproducto(productoSeleccionado);
		productoSolicitado.setIdusuario(us);
		
		productoSolicitadoControlador.guardarProductoSolicitado(productoSolicitado);
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Producto Registrado"));
		PrimeFaces.current().executeScript("PF('solicitudProducto').hide()");
        PrimeFaces.current().ajax().update("mensajes", "form:tblProductos");
		
	}
	
}
