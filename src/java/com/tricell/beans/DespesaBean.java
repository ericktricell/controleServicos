/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Despesas;
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
public class DespesaBean extends JPAUtil implements Crud, Serializable{

    private Despesas despesas = new Despesas();
    private List<Despesas> lsDespesas = new ArrayList<>();
    private DaoGeneric<Despesas> dao = new DaoGeneric<>(getFactory());
    
    @Override
    public String save() {
        dao.savemerge(despesas);
        
        return "";
    }

    @Override
    public String novo() {
        
        despesas = new Despesas();
        
        return "";
    }

    @Override
    public void getList() {
        lsDespesas = dao.getListEntity(Despesas.class);
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsDespesas.size(); i++) {
            if (Objects.equals(lsDespesas.get(i).getIdDespesa(), id)) {
                despesas = lsDespesas.get(i);
                break;
            }
        }
        return "";
    }

    public Despesas getDespesas() {
        return despesas;
    }

    public void setDespesas(Despesas despesas) {
        this.despesas = despesas;
    }

    public List<Despesas> getLsDespesas() {
        return lsDespesas;
    }

    public void setLsDespesas(List<Despesas> lsDespesas) {
        this.lsDespesas = lsDespesas;
    }

    @Override
    public void getListFilter() {
        
    }
    
    
}
