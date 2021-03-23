package com.tejidosmonitex.pedidos.vista;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.lowagie.text.Document;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.tejidosmonitex.pedidos.controlador.IColorControlador;
import com.tejidosmonitex.pedidos.controlador.IOrdenProduccionControlador;
import com.tejidosmonitex.pedidos.controlador.IOrdenProduccionDetalleControlador;
import com.tejidosmonitex.pedidos.controlador.IStockControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Color;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproduccion;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordenproducciondetalle;
import com.tejidosmonitex.pedidos.modelo.entidades.Stock;

@Named
@ViewScoped
@Stateful
public class OrdenProduccionVista implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IOrdenProduccionControlador produccionControlador;
	
	@EJB
	private IOrdenProduccionDetalleControlador produccionDetalleControlador;
	
	@EJB
	private IColorControlador colorControlador;
	
	@EJB
	private IStockControlador stockControlador;
	
	private List<Ordenproduccion> listaProducion;
	
	private List<Ordenproduccion> listaProducionFiltrado;
	
	private Ordenproduccion ordenProduccion;
	
	private List<Ordenproducciondetalle> listaProduccionDetalle;
	
	private Ordenproducciondetalle produccionDetalle;
	
	private Color color;
	
	@PostConstruct
	public void init() {
		listaProducion = produccionControlador.obtenerOrdenesProduccion();
	}

	public List<Ordenproduccion> getListaProducionFiltrado() {
		return listaProducionFiltrado;
	}

	public void setListaProducionFiltrado(List<Ordenproduccion> listaProducionFiltrado) {
		this.listaProducionFiltrado = listaProducionFiltrado;
	}

	public List<Ordenproduccion> getListaProducion() {
		return listaProducion;
	}

	public void setListaProducion(List<Ordenproduccion> listaProducion) {
		this.listaProducion = listaProducion;
	}

	public Ordenproduccion getOrdenProduccion() {
		return ordenProduccion;
	}

	public void setOrdenProduccion(Ordenproduccion ordenProduccion) {
		this.ordenProduccion = ordenProduccion;
	}

	public List<Ordenproducciondetalle> getListaProduccionDetalle() {
		return listaProduccionDetalle;
	}

	public void setListaProduccionDetalle(List<Ordenproducciondetalle> listaProduccionDetalle) {
		this.listaProduccionDetalle = listaProduccionDetalle;
	}

	public Ordenproducciondetalle getProduccionDetalle() {
		return produccionDetalle;
	}

	public void setProduccionDetalle(Ordenproducciondetalle produccionDetalle) {
		this.produccionDetalle = produccionDetalle;
	}
	
	public void verProduccionDetalle(Ordenproduccion op) {
		this.setOrdenProduccion(op);
		listaProduccionDetalle = produccionDetalleControlador.produccionDetallePorId(op.getIdordenproduccion());
	}
	
	public String nombreColor(Integer idColor) {
		color=colorControlador.obetnerColorPorId(idColor);
		return color.getNombre();
	}
	
	public void procesarPDF(Object document) {
	      Document pdf = (Document) document;
	      Phrase datosOrden = new Paragraph("Orden de Producción No. " + ordenProduccion.getIdordenproduccion().toString());
	      datosOrden.add(new Paragraph("\n"));
	      datosOrden.add(new Paragraph("Fecha: " + ordenProduccion.getFecha().toString()));
	      //datosOrden.setFont(FontFactory.getFont(FontFactory.COURIER, 14,Font.BOLD));
	      HeaderFooter header = new HeaderFooter(datosOrden, true);
	      pdf.setHeader(header);
	      pdf.setPageSize(PageSize.A4.rotate());
	      pdf.open();
	    }
	
	public void procesarPDFReporte(Object document) {
	      Document pdf = (Document) document;
	      Phrase datosProduccion = new Paragraph("Lista Ordenes de Producción");
	      datosProduccion.add(new Paragraph("\n"));
	      datosProduccion.add(new Paragraph("Fecha: " + new Date().toString()));
	      //datosOrdenDespacho.setFont(FontFactory.getFont(FontFactory.COURIER, 14,Font.BOLD));
	      HeaderFooter header = new HeaderFooter(datosProduccion, true);
	      pdf.setHeader(header);
	      pdf.setPageSize(PageSize.A4.rotate());
	      pdf.open();
	    }
	
	public void cambiarEstadoProduccion() {
		
		for(Ordenproducciondetalle ordenDetalle : listaProduccionDetalle) {
			if (ordenDetalle.getEstado() == 'A') {
				ordenDetalle.setEstado('T');
			}
			produccionDetalleControlador.actualizarProduccionDetalle(ordenDetalle);
			
			Stock stockDetalle = stockControlador.stockPorId(ordenDetalle.getIddetallepedido().getIdproducto().getIdstock());
			stockDetalle.setCantidad(ordenDetalle.getCantidad() + stockDetalle.getCantidad());
			stockControlador.actualizarStock(stockDetalle);
		}
		
		if (ordenProduccion.getEstado() == 'A') {
			ordenProduccion.setEstado('T');
		}
		
		produccionControlador.actualizarOrdenProduccion(ordenProduccion);
		
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('detalleProduccion').hide();");
		
	}
	
}
