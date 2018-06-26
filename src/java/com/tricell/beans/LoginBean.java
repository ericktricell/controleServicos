/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.model.Usuario;
import com.tricell.repository.LoginDAO;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eu
 */
@ManagedBean
@SessionScoped
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private String login,
            senha;
    private Usuario user = null;

    public void iniciaHibernate(){
        new LoginDAO().inicia();
    }
    
    public String valida() {

        if (login.equals("admin") && senha.equals("tricell")) {
            return "cad-usuario?faces-redirect=true";
        } else {
            user = new LoginDAO().validaLogin(login, senha);

            if (user != null) {

                //adicionar o usuário na sessão usuarioLogado
                FacesContext context = FacesContext.getCurrentInstance();
                ExternalContext externalContext = context.getExternalContext();
                externalContext.getSessionMap().put("usuarioLogado", user);

                return "/inicio?faces-redirect=true";
            }
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Falha", "Login ou senha inválidos"));
        }
        return "";
    }

    public String verificaUser() {
        if (user == null) {
            return "/index?faces-redirect=true";
        }
        return "";
    }

    public String logoff() {
            user = null;
            return "/index?faces-redirect=true";
        
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
