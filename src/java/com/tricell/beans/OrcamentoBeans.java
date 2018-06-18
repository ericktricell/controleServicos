/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Empresa;
import com.tricell.model.Orcamento;
import com.tricell.model.Usuario;
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
@ManagedBean
@SessionScoped
public class OrcamentoBeans extends JPAUtil implements Crud,Serializable{
    
    private Orcamento orcamento = new Orcamento();
    private Usuario usuarioLogado = new Usuario();
    private List<Orcamento> lsOrcamento = new ArrayList<>();
    private DaoGeneric<Orcamento> dao = new DaoGeneric<>(getFactory());

    @Override
    public String save() {
        orcamento = dao.savemerge(orcamento);
        
        return "";
    }

    @Override
    public String novo() {
        orcamento = new Orcamento();
        return "";
    }

    @Override
    public void getList() {
        lsOrcamento = dao.getListEntity(Orcamento.class);
    }

    @Override
    public void getListFilter() {
        
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsOrcamento.size(); i++) {
            if (Objects.equals(lsOrcamento.get(i).getIdOrcamento(), id)) {
                orcamento = lsOrcamento.get(i);
                break;
            }
        }
        return "";
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(Usuario usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public List<Orcamento> getLsOrcamento() {
        return lsOrcamento;
    }

    public void setLsOrcamento(List<Orcamento> lsOrcamento) {
        this.lsOrcamento = lsOrcamento;
    }
    
    
}
