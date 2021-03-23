package com.tejidosmonitex.pedidos.vista;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.tejidosmonitex.pedidos.controlador.IColorControlador;
import com.tejidosmonitex.pedidos.controlador.IPedidoControlador;
import com.tejidosmonitex.pedidos.controlador.IPedidoDetalleControlador;
import com.tejidosmonitex.pedidos.controlador.IProductoSolicitadoControlador;
import com.tejidosmonitex.pedidos.modelo.dto.ProductoDto;
import com.tejidosmonitex.pedidos.modelo.entidades.Color;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedidodetalle;
import com.tejidosmonitex.pedidos.modelo.entidades.Producto;
import com.tejidosmonitex.pedidos.modelo.entidades.Productosolicitado;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

@Named
@ViewScoped
@Stateful
public class ProductoSolicitadoVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IProductoSolicitadoControlador productoSolicitadoControlador;
	
	@EJB
	private IColorControlador colorControlador;
	
	@EJB
	private IPedidoControlador pedidoControlador;
	
	@EJB
	private IPedidoDetalleControlador pedidoDetalleControlador;
	
	private List<Productosolicitado> listaProductosSolicitados;
	
	private List<Productosolicitado> listaProductosSeleccionados;
	
	private List<Color> listaColores;
	
	private Productosolicitado productoSolicitado;
	
	private Usuario us;
	
	private Pedido pedido;
	
	private Pedidodetalle pedidoDetalle;
	
	private String nombreColor;
	
	private Color colorSeleccionado;
	
	private Integer cantidadSolicitada;
	
	@PostConstruct
	public void init() {
		us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogin");
		listaColores = colorControlador.obtenerColores();
		listaProductosSolicitados = productoSolicitadoControlador.obtenerProductosSolicitadosPorUsuario(us.getIdusuario());
	}
	
	
	
	public Pedido getPedido() {
		return pedido;
	}



	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}



	public Pedidodetalle getPedidoDetalle() {
		return pedidoDetalle;
	}



	public void setPedidoDetalle(Pedidodetalle pedidoDetalle) {
		this.pedidoDetalle = pedidoDetalle;
	}



	public List<Productosolicitado> getListaProductosSeleccionados() {
		return listaProductosSeleccionados;
	}



	public void setListaProductosSeleccionados(List<Productosolicitado> listaProductosSeleccionados) {
		this.listaProductosSeleccionados = listaProductosSeleccionados;
	}



	public List<Color> getListaColores() {
		return listaColores;
	}



	public void setListaColores(List<Color> listaColores) {
		this.listaColores = listaColores;
	}



	public List<Productosolicitado> getListaProductosSolicitados() {
		return listaProductosSolicitados;
	}

	public void setListaProductosSolicitados(List<Productosolicitado> listaProductosSolicitados) {
		this.listaProductosSolicitados = listaProductosSolicitados;
	}

	public Productosolicitado getProductoSolicitado() {
		return productoSolicitado;
	}

	public void setProductoSolicitado(Productosolicitado productoSolicitado) {
		this.productoSolicitado = productoSolicitado;
	}

	public Usuario getUs() {
		return us;
	}

	public void setUs(Usuario us) {
		this.us = us;
	}

	public String getNombreColor() {
		return nombreColor;
	}

	public void setNombreColor(String nombreColor) {
		this.nombreColor = nombreColor;
	}
	
	public Color getColorSeleccionado() {
		return colorSeleccionado;
	}

	public void setColorSeleccionado(Color colorSeleccionado) {
		this.colorSeleccionado = colorSeleccionado;
	}

	public Integer getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(Integer cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public void editarProducto(Productosolicitado ps) {
		this.setProductoSolicitado(ps);
		nombreColor = ps.getIdcolor().getNombre();
	}
	
	public void guardarProducto() {
		FacesContext context = FacesContext.getCurrentInstance();
		colorSeleccionado = colorControlador.obetnerColorPorNombre(nombreColor);
				
		productoSolicitado.setIdcolor(colorSeleccionado);
		
		productoSolicitadoControlador.actualizarProductoSolicitado(productoSolicitado);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Producto Actualizado"));
		
		PrimeFaces.current().executeScript("PF('solicitudProducto').hide()");
        PrimeFaces.current().ajax().update("mensajes", "form:tblProductos");
		
	}
	
	public void generarPedido() {
		FacesContext context = FacesContext.getCurrentInstance();
		productoSolicitado = listaProductosSeleccionados.get(0);
		
		pedido = new Pedido();
		pedido.setIdusuario(us);
		pedido.setFecha(new Date());
		pedido.setEstado('A');
		
		pedidoControlador.guardarPedido(pedido);
		
		for(Productosolicitado prdSolicitado  : listaProductosSeleccionados)
		{
		    pedidoDetalle = new Pedidodetalle();
		    colorSeleccionado = prdSolicitado.getIdcolor();
		    pedidoDetalle.setCantidadsolicitada(prdSolicitado.getCantidad());
		    pedidoDetalle.setEstado('A');
		    pedidoDetalle.setIdcolor(colorSeleccionado.getIdcolor());
		    pedidoDetalle.setIdpedido(pedido);
		    pedidoDetalle.setIdproducto(prdSolicitado.getIdproducto());
		    pedidoDetalleControlador.guardarPedidoDetalle(pedidoDetalle);
		    prdSolicitado.setEstado('P');
		    productoSolicitadoControlador.actualizarProductoSolicitado(prdSolicitado);
		}
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Pedido Generado"));
		
		listaProductosSolicitados = productoSolicitadoControlador.obtenerProductosSolicitadosPorUsuario(us.getIdusuario());
		
	}
	
	public void cambiarEstadoProducto(Productosolicitado prd) {	
		FacesContext context = FacesContext.getCurrentInstance();
		//Productosolicitado prd = productoSolicitadoControlador.productoPorID(p.getIdProducto());
		if (prd.getEstado() == 'A') {
			prd.setEstado('X');
		} else {
			prd.setEstado('A');
		}

		productoSolicitadoControlador.actualizarProductoSolicitado(prd);
		
		listaProductosSolicitados = productoSolicitadoControlador.obtenerProductosSolicitadosPorUsuario(us.getIdusuario());

		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Producto Eliminado"));
	}
	
	
	
}
