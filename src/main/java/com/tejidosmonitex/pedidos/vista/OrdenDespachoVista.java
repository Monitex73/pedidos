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

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.tejidosmonitex.pedidos.controlador.IColorControlador;
import com.tejidosmonitex.pedidos.controlador.IOrdenDespachoControlador;
import com.tejidosmonitex.pedidos.controlador.IOrdenDespachoDetalleControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Color;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespacho;
import com.tejidosmonitex.pedidos.modelo.entidades.Ordendespachodetalle;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

@Named
@ViewScoped
@Stateful
public class OrdenDespachoVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IOrdenDespachoControlador despachoControlador;
	
	@EJB
	private IOrdenDespachoDetalleControlador despachoDetalleControlador;
	
	@EJB
	private IColorControlador colorControlador;
	
	private List<Ordendespacho> listaOrdenDespacho;
	
	private List<Ordendespacho> listaOrdenDespachoFiltrado;
	
	private Ordendespacho ordenDespacho;
	
	private List<Ordendespachodetalle> listaDespachoDetalle;
	
	private Ordendespachodetalle despachoDetalle;
	
	private Color color;
	
	@PostConstruct
	public void init() {
		listaOrdenDespacho = despachoControlador.obtenerOrdenesDespacho();
	}

	public List<Ordendespacho> getListaOrdenDespachoFiltrado() {
		return listaOrdenDespachoFiltrado;
	}

	public void setListaOrdenDespachoFiltrado(List<Ordendespacho> listaOrdenDespachoFiltrado) {
		this.listaOrdenDespachoFiltrado = listaOrdenDespachoFiltrado;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public List<Ordendespacho> getListaOrdenDespacho() {
		return listaOrdenDespacho;
	}

	public void setListaOrdenDespacho(List<Ordendespacho> listaOrdenDespacho) {
		this.listaOrdenDespacho = listaOrdenDespacho;
	}

	public Ordendespacho getOrdenDespacho() {
		return ordenDespacho;
	}

	public void setOrdenDespacho(Ordendespacho ordenDespacho) {
		this.ordenDespacho = ordenDespacho;
	}

	public List<Ordendespachodetalle> getListaDespachoDetalle() {
		return listaDespachoDetalle;
	}

	public void setListaDespachoDetalle(List<Ordendespachodetalle> listaDespachoDetalle) {
		this.listaDespachoDetalle = listaDespachoDetalle;
	}

	public Ordendespachodetalle getDespachoDetalle() {
		return despachoDetalle;
	}

	public void setDespachoDetalle(Ordendespachodetalle despachoDetalle) {
		this.despachoDetalle = despachoDetalle;
	}
	
	public void verDespachoDetalle(Ordendespacho od) {
		this.setOrdenDespacho(od);
		listaDespachoDetalle = despachoDetalleControlador.despachoDetallePorId(od.getIdordendespacho());
	}
	
	public String nombreColor(Integer idColor) {
		color=colorControlador.obetnerColorPorId(idColor);
		return color.getNombre();
	}
	
	public void procesarPDF(Object document) {
	      Document pdf = (Document) document;
	      Phrase datosOrdenDespacho = new Paragraph("Orden de Despacho No. " + ordenDespacho.getIdordendespacho().toString());
	      datosOrdenDespacho.add(new Paragraph("\n"));
	      datosOrdenDespacho.add(new Paragraph("Fecha: " + ordenDespacho.getFecha().toString()));
	      //datosOrdenDespacho.setFont(FontFactory.getFont(FontFactory.COURIER, 14,Font.BOLD));
	      HeaderFooter header = new HeaderFooter(datosOrdenDespacho, true);
	      pdf.setHeader(header);
	      pdf.setPageSize(PageSize.A4.rotate());
	      pdf.open();
	    }
	
	public void procesarPDFReporte(Object document) {
	      Document pdf = (Document) document;
	      Phrase datosDespacho = new Paragraph("Lista Ordenes de Despacho");
	      datosDespacho.add(new Paragraph("\n"));
	      datosDespacho.add(new Paragraph("Fecha: " + new Date().toString()));
	      //datosOrdenDespacho.setFont(FontFactory.getFont(FontFactory.COURIER, 14,Font.BOLD));
	      HeaderFooter header = new HeaderFooter(datosDespacho, true);
	      pdf.setHeader(header);
	      pdf.setPageSize(PageSize.A4.rotate());
	      pdf.open();
	    }
	
	public void cambiarEstadoDespacho() {

		FacesContext context = FacesContext.getCurrentInstance();
		
		for(Ordendespachodetalle ordenDetalle : listaDespachoDetalle) {
			if (ordenDetalle.getEstado() == 'A') {
				ordenDetalle.setEstado('T');
			}

			despachoDetalleControlador.actualizarDespachoDetalle(ordenDetalle);
		}
		
		if (ordenDespacho.getEstado() == 'A') {
			ordenDespacho.setEstado('T');
		}

		despachoControlador.actualizarOrdenDespacho(ordenDespacho);
		
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('detalleDespacho').hide();");
		

		//context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Actualizado"));
	}
	
}
