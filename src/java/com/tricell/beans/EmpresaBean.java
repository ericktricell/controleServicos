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
public class EmpresaBean implements Serializable{
    
    private Empresa empresa = new Empresa();
    private DaoGeneric<Empresa> con = new DaoGeneric<>();
    
    public void salvar(){
        con.savemerge(empresa);
    }
    
    public void empresaSalva(){
        this.empresa = con.getEntidade(Empresa.class);
        if(empresa == null)
            empresa = new Empresa();
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    
}
