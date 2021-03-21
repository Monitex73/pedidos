package com.tejidosmonitex.pedidos.vista;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.tejidosmonitex.pedidos.controlador.IMenuControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Menu;
import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;

@Named
@ViewScoped
@Stateful
public class MenuVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private IMenuControlador menuControlador;

	private List<Menu> listaMenu;
	private MenuModel model;

	@PostConstruct
	public void init() {
		this.listarMenus();
		model = new DefaultMenuModel();
		this.establecerPermisos();
	}

	public void listarMenus() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			listaMenu = menuControlador.obtenerMenus();
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error..."));
		}
	}

	public void establecerPermisos() {
		Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogin");
		for (Menu m : listaMenu) {
			if (m.getTipo().equals('S') && m.getIdrol().equals(us.getIdrol())) {
				DefaultSubMenu firstSubmenu = new DefaultSubMenu(m.getNombre());
				for (Menu i : listaMenu) {
					Menu subMenu = i.getIdsubmenu();
					if (subMenu != null) {
						if (subMenu.getIdmenu() == m.getIdmenu()) {
							DefaultMenuItem item = new DefaultMenuItem(i.getNombre());
							item.setOutcome(i.getLink());
							item.setIcon(i.getIcono());
							firstSubmenu.addElement(item);
						}
					}
				}
				model.addElement(firstSubmenu);
			} else {
				if (m.getIdsubmenu() == null && m.getIdrol().equals(us.getIdrol())) {
					DefaultMenuItem item = new DefaultMenuItem(m.getNombre());
					item.setOutcome(m.getLink());
					model.addElement(item);
				}

			}
		}
	}

	public List<Menu> getListaMenu() {
		return listaMenu;
	}

	public void setListaMenu(List<Menu> listaMenu) {
		this.listaMenu = listaMenu;
	}

	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}

}
