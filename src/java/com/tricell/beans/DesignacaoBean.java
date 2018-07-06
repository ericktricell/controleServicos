/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.model.Designacao;
import com.tricell.model.Orcamento;
import com.tricell.model.Usuario;
import com.tricell.repository.DaoGeneric;
import com.tricell.repository.OrcamentoController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Eu
 */
@ManagedBean
@SessionScoped
public class DesignacaoBean implements Crud,Serializable{
    
    private Designacao designacao = new Designacao();
    private List<Designacao> lsDesignacao = new ArrayList<>();
    private List<Usuario> lsUsuario = new ArrayList<>();
    private List<Orcamento> lsOrcamento = new ArrayList<>();
    private DaoGeneric<Designacao> dao = new DaoGeneric<>();
    private OrcamentoController controller = new OrcamentoController();

    @Override
    public void save() {
        dao.savemerge(designacao);
        this.getList();
    }

    @Override
    public void novo() {
        designacao = new Designacao();
    }

    @Override
    public void getList() {
        lsDesignacao = dao.getListEntity(Designacao.class);
        lsOrcamento = controller.getListEntity1();
        lsUsuario = controller.findUsuario();
    }

    @Override
    public void getListFilter() {
        
    }

    public List<Usuario> getLsUsuario() {
        return lsUsuario;
    }

    public void setLsUsuario(List<Usuario> lsUsuario) {
        this.lsUsuario = lsUsuario;
    }

    public List<Orcamento> getLsOrcamento() {
        return lsOrcamento;
    }

    public void setLsOrcamento(List<Orcamento> lsOrcamento) {
        this.lsOrcamento = lsOrcamento;
    }

    public Designacao getDesignacao() {
        return designacao;
    }

    public void setDesignacao(Designacao designacao) {
        this.designacao = designacao;
    }

    public List<Designacao> getLsDesignacao() {
        return lsDesignacao;
    }

    public void setLsDesignacao(List<Designacao> lsDesignacao) {
        this.lsDesignacao = lsDesignacao;
    }

    @Override
    public String onRowSelected(Long id) {
        return "";
    }
}
