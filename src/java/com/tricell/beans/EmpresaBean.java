/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Empresa;
import com.tricell.repository.DaoGeneric;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Eu
 */
@ManagedBean
@SessionScoped
public class EmpresaBean extends JPAUtil implements Serializable{
    
    private Empresa empresa = new Empresa();
    private DaoGeneric<Empresa> con = new DaoGeneric<>(getFactory());
    
    public String salvar(){
        empresa = con.savemerge(empresa);
        return "";
    }
    
    public String empresaSalva(){
        this.empresa = con.getEntidade(Empresa.class);
        return "";
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
