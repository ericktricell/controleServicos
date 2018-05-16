/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Eu
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
    
    private Usuario usuario = new Usuario();
    private List<Usuario> lsUsuario = new ArrayList<>();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLsUsuario() {
        return lsUsuario;
    }

    public void setLsUsuario(List<Usuario> lsUsuario) {
        this.lsUsuario = lsUsuario;
    }
    
    
}
