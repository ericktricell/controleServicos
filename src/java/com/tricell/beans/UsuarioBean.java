/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Usuario;
import com.tricell.repository.DaoGeneric;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eu
 */
@ManagedBean
@ViewScoped
public class UsuarioBean extends JPAUtil implements Crud, Serializable{

    private Usuario usuario = new Usuario();
    private List<Usuario> lsUsuario = new ArrayList<>();
    private List<Usuario> filterUsuario;
    private DaoGeneric<Usuario> controller = new DaoGeneric<>(getFactory());

     @Override
    public String save() {
        usuario = controller.savemerge(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "Usuário cadastrado"));
        
        return "";
    }

    @Override
    public void getList() {
        lsUsuario = controller.getListEntity(Usuario.class);
    }

    @Override
    public String novo(){
        usuario = new Usuario();
        return "";
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsUsuario.size(); i++) {
            if (Objects.equals(lsUsuario.get(i).getIdUsuario(), id)) {
                usuario = lsUsuario.get(i);
                break;
            }
        }
        return "";
    }

    public List<Usuario> getFilterUsuario() {
        return filterUsuario;
    }

    public void setFilterUsuario(List<Usuario> filterUsuario) {
        this.filterUsuario = filterUsuario;
    }

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

    @Override
    public void getListFilter() {
        
    }

}
