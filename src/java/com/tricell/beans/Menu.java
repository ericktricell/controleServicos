/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Eu
 */
@ManagedBean
@ViewScoped
public class Menu implements Serializable{
    
    public void resumo() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
    }
    
    public void empresa() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("empresa.jsf");
    }
    
    public void usuario() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("usuario.jsf");
    }
    
    public void itens() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("itens.jsf");
    }
    
    public void cliente() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("cliente.jsf");
    }
    
    public void fornecedor() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("fornecedor.jsf");
    }
    
    public void despesas() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().redirect("despesas.jsf");
    }
}
