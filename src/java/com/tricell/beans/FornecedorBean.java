/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Fornecedor;
import com.tricell.repository.DaoGeneric;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Eu
 */
@SessionScoped
@ManagedBean
public class FornecedorBean extends JPAUtil implements Crud, Serializable{

    private Fornecedor fornecedor = new Fornecedor();
    private List<Fornecedor> lsFornecedor = new ArrayList<>();
    private DaoGeneric<Fornecedor> dao = new DaoGeneric<>(getFactory());
    
    @Override
    public String save() {
        fornecedor = dao.savemerge(fornecedor);
        
        return "fornecedor?faces-redirect=true";
    }

    @Override
    public String novo() {
        fornecedor = new Fornecedor();
        
        return "";
    }

    @Override
    public void getList() {
        lsFornecedor = dao.getListEntity(Fornecedor.class);
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsFornecedor.size(); i++) {
            if (Objects.equals(lsFornecedor.get(i).getIdFornecedor(), id)) {
                fornecedor = lsFornecedor.get(i);
                break;
            }
        }
        return "";
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public List<Fornecedor> getLsFornecedor() {
        return lsFornecedor;
    }

    public void setLsFornecedor(List<Fornecedor> lsFornecedor) {
        this.lsFornecedor = lsFornecedor;
    }

    @Override
    public void getListFilter() {
        
    }
    
    
}
