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

import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.tejidosmonitex.pedidos.controlador.IColorControlador;
import com.tejidosmonitex.pedidos.controlador.IOrdenDespachoControlador;
import com.tejidosmonitex.pedidos.controlador.IOrdenDespachoDetalleControlador;
import com.tejidosmonitex.pedidos.controlador.IOrdenProduccionControlador;
import com.tejidosmonitex.pedidos.controlador.IOrdenProduccionDetalleControlador;
import com.tejidosmonitex.pedidos.controlador.IPedidoControlador;
import com.tejidosmonitex.pedidos.controlador.IPedidoDetalleControlador;
import com.tejidosmonitex.pedidos.controlador.IPrecioControlador;
import com.tejidosmonitex.pedidos.controlador.IStockControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Color;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespacho;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespachodetalle;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproduccion;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproducciondetalle;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedido;
import com.tejidosmonitex.pedidos.modelo.entidades.Pedidodetalle;
import com.tejidosmonitex.pedidos.modelo.entidades.Stock;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

@Named
@ViewScoped
@Stateful
public class PedidoVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IColorControlador colorControlador;

	@EJB
	private IPedidoControlador pedidoControlador;

	@EJB
	private IPedidoDetalleControlador pedidoDetalleControlador;
	
	@EJB
	private IOrdenDespachoControlador despachoControlador;
	
	@EJB
	private IOrdenDespachoDetalleControlador despachoDetalleControlador;
	
	@EJB
	private IOrdenProduccionControlador produccionControlador;
	
	@EJB
	private IOrdenProduccionDetalleControlador producionDetalleControlador;
	
	@EJB
	private IStockControlador stockControlador;
	
	@EJB
	private IPrecioControlador precioControlador;
	

	private List<Pedido> listaPedidos;
	
	private List<Pedido> listaPedidosFiltrado;

	private List<Pedidodetalle> listaPedidoDetalle;

	private List<Pedidodetalle> seleccionPedido;

	private Usuario us;

	private Pedido pedido;

	private Pedidodetalle pedidoDetalle;

	private String nombreColor;

	private Color colorSeleccionado;

	private Ordendespacho ordenDespacho;

	private Ordendespachodetalle ordenDespachoDetalle;

	private Ordenproduccion ordenProduccion;

	private Ordenproducciondetalle ordenProduccionDetalle;
	
	private Stock stock;
	
	private Color color;

	@PostConstruct
	public void init() {
		listaPedidos = pedidoControlador.obtenerPedidos();
	}

	public List<Pedido> getListaPedidosFiltrado() {
		return listaPedidosFiltrado;
	}

	public void setListaPedidosFiltrado(List<Pedido> listaPedidosFiltrado) {
		this.listaPedidosFiltrado = listaPedidosFiltrado;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Ordendespacho getOrdenDespacho() {
		return ordenDespacho;
	}

	public void setOrdenDespacho(Ordendespacho ordenDespacho) {
		this.ordenDespacho = ordenDespacho;
	}

	public Ordendespachodetalle getOrdenDespachoDetalle() {
		return ordenDespachoDetalle;
	}

	public void setOrdenDespachoDetalle(Ordendespachodetalle ordenDespachoDetalle) {
		this.ordenDespachoDetalle = ordenDespachoDetalle;
	}

	public Ordenproduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(Ordenproduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public Ordenproducciondetalle getOrdenProduccionDetalle() {
		return ordenProduccionDetalle;
	}

	public void setOrdenProduccionDetalle(Ordenproducciondetalle ordenProduccionDetalle) {
		this.ordenProduccionDetalle = ordenProduccionDetalle;
	}

	public List<Pedidodetalle> getSeleccionPedido() {
		return seleccionPedido;
	}

	public void setSeleccionPedido(List<Pedidodetalle> seleccionPedido) {
		this.seleccionPedido = seleccionPedido;
	}

	public Usuario getUs() {
		return us;
	}

	public void setUs(Usuario us) {
		this.us = us;
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

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}

	public List<Pedidodetalle> getListaPedidoDetalle() {
		return listaPedidoDetalle;
	}

	public void setListaPedidoDetalle(List<Pedidodetalle> listaPedidoDetalle) {
		this.listaPedidoDetalle = listaPedidoDetalle;
	}

	public void verPedidoDetalle(Pedido p) {
		this.setPedido(p);
		listaPedidoDetalle = pedidoDetalleControlador.pedidoDetallePorId(p);
	}

	public void generarDespacho() {
		FacesContext context = FacesContext.getCurrentInstance();
		pedidoDetalle = seleccionPedido.get(0);

		ordenDespacho = new Ordendespacho();
		ordenDespacho.setIdpedido(pedidoDetalle.getIdpedido());
		ordenDespacho.setEstado('A');
		ordenDespacho.setFecha(new Date());
		
		despachoControlador.guardarOrdenDespacho(ordenDespacho);
		
		for(Pedidodetalle pedidoDetalle : seleccionPedido) {
			ordenDespachoDetalle = new Ordendespachodetalle();
			ordenDespachoDetalle.setCantidad(pedidoDetalle.getCantidadsolicitada());
			ordenDespachoDetalle.setEstado('A');
			ordenDespachoDetalle.setIdordendespacho(ordenDespacho);
			ordenDespachoDetalle.setIddetallepedido(pedidoDetalle);
			despachoDetalleControlador.guardarDespachoDetalle(ordenDespachoDetalle);
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Despacho Generado"));
	}
	
	public void generarProduccion() {
		FacesContext context = FacesContext.getCurrentInstance();
		pedidoDetalle = seleccionPedido.get(0);
		
		ordenProduccion = new Ordenproduccion();
		ordenProduccion.setIdpedido(pedidoDetalle.getIdpedido());
		ordenProduccion.setFecha(new Date());
		ordenProduccion.setEstado('A');
		produccionControlador.guardarOrdenProduccion(ordenProduccion);
		
		for(Pedidodetalle pedidoDetalle : seleccionPedido) {
			ordenProduccionDetalle = new Ordenproducciondetalle();
			ordenProduccionDetalle.setCantidad(pedidoDetalle.getCantidadsolicitada());
			ordenProduccionDetalle.setEstado('A');
			ordenProduccionDetalle.setIddetallepedido(pedidoDetalle);
			ordenProduccionDetalle.setIdordenproduccion(ordenProduccion);
			producionDetalleControlador.guardarProduccionDetalle(ordenProduccionDetalle);
		}
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Produccion Generado"));
	}
	
	public Integer consultaStock(Integer idStock) {
		stock = stockControlador.stockPorId(idStock);
		return stock.getCantidad();
	}
	
	public String nombreColor(Integer idColor) {
		color=colorControlador.obetnerColorPorId(idColor);
		return color.getNombre();
	}
	
	public void procesarPDF(Object document) {
	      Document pdf = (Document) document;
	      Phrase datosPedido = new Paragraph("Lista de Pedidos");
	      datosPedido.add(new Paragraph("\n"));
	      datosPedido.add(new Paragraph("Fecha: " + new Date().toString()));
	      //datosOrdenDespacho.setFont(FontFactory.getFont(FontFactory.COURIER, 14,Font.BOLD));
	      HeaderFooter header = new HeaderFooter(datosPedido, true);
	      pdf.setHeader(header);
	      pdf.setPageSize(PageSize.A4.rotate());
	      pdf.open();
	    }

}
