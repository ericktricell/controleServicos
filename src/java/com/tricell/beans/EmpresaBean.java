/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Empresa;
import com.tricell.repository.EmpresaJpaController;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Eu
 */
@ManagedBean
@SessionScoped
public class EmpresaBean extends JPAUtil{
    
    private Empresa empresa = new Empresa();
    private EmpresaJpaController controller = new EmpresaJpaController(getFactory());
    
    public String salvar(){
        controller.create(empresa);
        
        return "";
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

}
