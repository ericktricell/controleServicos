/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.model.FechamentoOs;
import com.tricell.model.Orcamento;
import com.tricell.repository.DaoGeneric;
import com.tricell.repository.OrcamentoController;
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
public class FechamentoBean implements Crud, Serializable{

    private FechamentoOs fechamentoOs = new FechamentoOs();
    private List<FechamentoOs> lsFechamento = new ArrayList<>();
    private List<Orcamento> lsOrcamento = new ArrayList<>();
    private OrcamentoController controller = new OrcamentoController();
    private DaoGeneric<FechamentoOs> dao = new DaoGeneric<>();
    private Double sumCusto;
    
    public void somaCusto(String id){
        sumCusto = controller.getSomaCusto(id);
    }
    
    @Override
    public void save() {
        dao.savemerge(fechamentoOs);
        this.getList();
    }

    @Override
    public void novo() {
        fechamentoOs = new FechamentoOs();
    }

    @Override
    public void getList() {
        lsFechamento = dao.getListEntity1(FechamentoOs.class);
        lsOrcamento = controller.findOrcamento();
    }

    @Override
    public void getListFilter() {
        
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsFechamento.size(); i++) {
            if (Objects.equals(lsFechamento.get(i).getIdFechamento(), id)) {
                fechamentoOs = lsFechamento.get(i);
                break;
            }
        }
        return "";
    }

    public Double getSumCusto() {
        return sumCusto;
    }

    public void setSumCusto(Double sumCusto) {
        this.sumCusto = sumCusto;
    }

    public List<Orcamento> getLsOrcamento() {
        return lsOrcamento;
    }

    public void setLsOrcamento(List<Orcamento> lsOrcamento) {
        this.lsOrcamento = lsOrcamento;
    }

    public FechamentoOs getFechamentoOs() {
        return fechamentoOs;
    }

    public void setFechamentoOs(FechamentoOs fechamentoOs) {
        this.fechamentoOs = fechamentoOs;
    }

    public List<FechamentoOs> getLsFechamento() {
        return lsFechamento;
    }

    public void setLsFechamento(List<FechamentoOs> lsFechamento) {
        this.lsFechamento = lsFechamento;
    }
    
    
}
