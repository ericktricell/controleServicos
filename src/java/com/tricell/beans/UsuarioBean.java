/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Usuario;
import com.tricell.repository.DaoGeneric;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Eu
 */
@ManagedBean
@SessionScoped
public class UsuarioBean extends JPAUtil {

    private Usuario usuario = new Usuario();
    private List<Usuario> lsUsuario = new ArrayList<>();
    private DaoGeneric<Usuario> controller = new DaoGeneric<>(getFactory());

    public void pegaUsuarios() {
        lsUsuario = controller.getListEntity(Usuario.class);
    }

    public String salvar() {
        controller.merge(usuario);
        usuario = new Usuario();
        return "";
    }

    public String onRowSelected(Long id) {
        for (int i = 0; i < lsUsuario.size(); i++) {
            if (Objects.equals(lsUsuario.get(i).getIdUsuario(), id)) {
                usuario = lsUsuario.get(i);
                break;
            }
        }
        return "";
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

}
