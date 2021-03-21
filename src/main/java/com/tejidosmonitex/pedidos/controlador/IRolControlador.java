/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tejidosmonitex.pedidos.controlador;

import java.util.List;

import javax.ejb.Local;
import com.tejidosmonitex.pedidos.modelo.entidades.Rol;

/**
 *
 * @author Jenny Luna
 */

@Local
public interface IRolControlador {
    public Rol buscarRolPorNombre (String nombre);
    
    public List<Rol> obtenerRoles();
    
    public List<Rol> obtenerAllRoles();
    
    public void guardarRol(Rol r);
    
    public List<Rol> obtenerRolesInternos();
    
    public void actualizarRol(Rol r);
}
