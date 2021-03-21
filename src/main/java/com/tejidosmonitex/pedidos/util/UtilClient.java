package com.tejidosmonitex.pedidos.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UtilClient {

	public static String NUMEROS = "0123456789";

	public static String MAYUSCULAS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static String MINUSCULAS = "abcdefghijklmnopqrstuvwxyz";

	public static String ESPECIALES = "@*!?{}[]()";

	public static int Longitud = 8;

	public static int LongitudToken = 15;

	public static String getPassword() {
		return getPassword(Longitud);
	}

	public static String getPassword(int length) {
		return getPassword(NUMEROS + MAYUSCULAS + MINUSCULAS + ESPECIALES, length);
	}

	public static String getPassword(String key, int length) {
		String pswd = "";

		for (int i = 0; i < length; i++) {
			pswd += key.charAt((int) (Math.random() * key.length()));
		}
		return pswd;
	}

	public static String getToken() {
		return getToken(LongitudToken);
	}

	public static String getToken(int tamano) {
		return getToken(NUMEROS + MAYUSCULAS + MINUSCULAS, tamano);
	}

	public static String getToken(String key, int length) {
		String token = "";

		for (int i = 0; i < length; i++) {
			token += key.charAt((int) (Math.random() * key.length()));
		}
		return token;
	}

	public static HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}

	public static String getUsario() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		return session.getAttribute("usuario").toString();
	}

	public static String getUserId() {
		HttpSession session = getSession();
		if (session != null)
			return (String) session.getAttribute("userid");
		else
			return null;
	}

	/*
	 * devuelve el path de la aplicacion
	 */
	public static String getPath() {
		try {
			ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			return ctx.getRealPath("/");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	/*
	 * devuelve un hashmap con la ruta de fotos productos y el url para las imagenes
	 */
	public static HashMap<String, String> getMapPathFotosProducto() {
		try {
			HashMap<String, String> map = new HashMap<String, String>();

			String path = getPath() + "/resources/fotos/productos/";
			map.put("path", path);
			map.put("url", "/resources/fotos/productos/");
			return map;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * devuelve un hashmap con la ruta de fotos productos y el url para las imagenes
	 */
	public static String getPathFotosProducto() {
		try {

			String path = getPath() + "resources/fotos/productos/";
			return path;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}
	
	/*
    copia un archivo generalmente cuando se usa el fileupload
    fileName: nombre del archivo a copiar
    in: Es el InputStream
    destination: ruta donde se guardara el archivo
    */
   public static Boolean copyFile(String fileName, InputStream in, String destination) {
       try {

           // write the inputStream to a FileOutputStream
           OutputStream out = new FileOutputStream(new File(destination + fileName));
           int read = 0;
           byte[] bytes = new byte[1024];

           while ((read = in.read(bytes)) != -1) {
               out.write(bytes, 0, read);
           }

           in.close();
           out.flush();
           out.close();

           return true;
       } catch (IOException e) {
    	   e.printStackTrace();
       }
       return false;
   }

}
