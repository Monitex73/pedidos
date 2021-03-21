package com.tejidosmonitex.pedidos.vista;

import com.tejidosmonitex.pedidos.controlador.ILoginControlador;
import com.tejidosmonitex.pedidos.controlador.IRolControlador;
import com.tejidosmonitex.pedidos.controlador.IUsuarioControlador;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.webbeans.util.StringUtil;
import org.primefaces.PrimeFaces;

import com.tejidosmonitex.pedidos.modelo.entidades.Usuario;
import com.tejidosmonitex.pedidos.util.EnvioMail;
import com.tejidosmonitex.pedidos.util.UtilClient;

import antlr.StringUtils;

@Named
@ViewScoped
@Stateful
public class LoginVista implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private ILoginControlador loginControlador;

	@EJB
	private IUsuarioControlador usuarioControlador;

	@EJB
	private IRolControlador rolControlador;


	private Usuario usuario;
	private Usuario usuarioNuevo = new Usuario();
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String email;
	private String identificacion;
	private String clave;
	private String rol;
	private String usuarioLogin;
	private String rolLogin;
	private String token;
	private String valorCaptcha;
	private Boolean deshabilitarBoton=true;
	private Boolean terminos;
		
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		limpiarCampos();
	}

	public Boolean getTerminos() {
		return terminos;
	}

	public void setTerminos(Boolean terminos) {
		this.terminos = terminos;
	}

	public Boolean getDeshabilitarBoton() {
		return deshabilitarBoton;
	}

	public void setDeshabilitarBoton(Boolean deshabilitarBoton) {
		this.deshabilitarBoton = deshabilitarBoton;
	}

	public String getValorCaptcha() {
		return valorCaptcha;
	}

	public void setValorCaptcha(String valorCaptcha) {
		this.valorCaptcha = valorCaptcha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public Usuario getUsuarioNuevo() {
		return usuarioNuevo;
	}

	public void setUsuarioNuevo(Usuario usuarioNuevo) {
		this.usuarioNuevo = usuarioNuevo;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getUsuarioLogin() {
		return usuarioLogin;
	}

	public void setUsuarioLogin(String usuarioLogin) {
		this.usuarioLogin = usuarioLogin;
	}

	public String getRolLogin() {
		return rolLogin;
	}

	public void setRolLogin(String rolLogin) {
		this.rolLogin = rolLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void enviarMensaje() {
		EnvioMail.envioMail("manisito_17@hotmail.com", "Test", "Test");
	}

	public String iniciarSesion() {
		Usuario us;
		FacesContext context = FacesContext.getCurrentInstance();
		String redireccion = null;
		try {
			us = loginControlador.iniciarSesion(usuario);
			if (us.getIdusuario() != null) {
				context.getExternalContext().getSessionMap().put("usuarioLogin", us);
				redireccion = "/administracion/principal?faces-redirect=true";
			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario/Contraseña Incorrecta"));
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error..."));
		}

		return redireccion;
	}

	public void guardarUsuario(){   	
		
		FacesContext context = FacesContext.getCurrentInstance();
		Usuario us = new Usuario();
		
		us = usuarioControlador.buscarUsuarioCorreo(email);
		
		if(us.getIdusuario()==null) {
			Rol rol;
			rol = rolControlador.buscarRolPorNombre("CLIENTE");
			
			String claveEncriptada = DigestUtils.sha256Hex(clave);
			
			us.setNombre(nombre);
			us.setApellido(apellido);
			us.setIdentificacion(identificacion);
			us.setDireccion(direccion);
			us.setTelefono(telefono);
			us.setCorreoelectronico(email);
			//us.setContrasena(claveEncriptada);
			us.setContrasena(clave);
			us.setIdrol(rol);
			us.setEstado('A');
			
			usuarioControlador.guardarUsuario(us);
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Registrado Correctamente"));
			limpiarCampos();
			
			PrimeFaces current = PrimeFaces.current();
			current.executeScript("PF('registroUsuario').hide();");
		}else {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario con el correo electrónico: " + email + " se encuentra registrado previamente."));
		}
		
	}

	public void resetearClave() {
		Usuario us;
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			us = usuarioControlador.buscarUsuarioCorreo(email);
			if (us.getIdusuario() != null) {
				final String password = UtilClient.getToken();
				us.setContrasena(password);
				us.setEstado('X');
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Contraseña Reseteada. Por favor revise su correo electrónico."));
				EnvioMail.envioMail(us.getCorreoelectronico(), "Reseteo Contraseña - Sistema de Pedidos - Tejidos Monitex", "Usuario: " + us.getCorreoelectronico() + "\n\nAcceso Sistema: http://localhost:8080/pedidos/cambio_clave.xhtml?token=" + password);

			} else {
				context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario no existe!"));
			}
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error..."));
		}

		limpiarCampos();
	}
	
	public void cerrarResetearClave() {
		limpiarCampos();
		PrimeFaces current = PrimeFaces.current();
		current.executeScript("PF('recuperarContrasena').hide();");
	}

	public void verificarSesion() {
		FacesContext context = FacesContext.getCurrentInstance();

		try {
			Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuarioLogin");
			if (us == null) {
				context.getExternalContext().redirect("./../access-denied.xhtml");
			}else {
				this.setUsuarioLogin(us.getNombre() + " " + us.getApellido());
				this.setRolLogin(us.getIdrol().getNombre());
			}

		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error..."));
		}
	}

	public void salirSistema() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			context.getExternalContext().getSessionMap().clear();
			this.setUsuarioLogin("");
			this.setRolLogin("");
		}catch(Exception e) {
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Error..."));
		}
	}
	
	public void refresh() {
	    FacesContext context = FacesContext.getCurrentInstance();
	    Application application = context.getApplication();
	    ViewHandler viewHandler = application.getViewHandler();
	    UIViewRoot viewRoot = viewHandler.createView(context, context
	     .getViewRoot().getViewId());
	    context.setViewRoot(viewRoot);
	    context.renderResponse(); 
	 }
	
	public void limpiarCampos() {
		setNombre(null);
		setApellido(null);
		setIdentificacion(null);
		setDireccion(null);
		setTelefono(null);
		setEmail(null);
		setClave(null);
	}
	
	public void valCaptcha() {
		if(terminos) {
			deshabilitarBoton=false;
		}else {
			deshabilitarBoton=true;
		}
	}
	

}
