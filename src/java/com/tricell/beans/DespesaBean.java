/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.model.Despesas;
import com.tricell.model.Fornecedor;
import com.tricell.model.Item;
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
public class DespesaBean implements Crud,Serializable{
    
    private Despesas despesas = new Despesas();
    private List<Despesas> lsDespesa = new ArrayList<>();
    private DaoGeneric<Despesas> dao = new DaoGeneric();
    private List<Item> lsItem = new ArrayList<>();
    private List<Orcamento> lsOrcamento = new ArrayList<>();
    private List<Fornecedor> lsFornecedor = new ArrayList<>();
    private OrcamentoController controller = new OrcamentoController();

    public Despesas getDespesas() {
        return despesas;
    }

    public void setDespesas(Despesas despesas) {
        this.despesas = despesas;
    }

    public List<Despesas> getLsDespesa() {
        return lsDespesa;
    }

    public void setLsDespesa(List<Despesas> lsDespesa) {
        this.lsDespesa = lsDespesa;
    }

    public List<Item> getLsItem() {
        return lsItem;
    }

    public void setLsItem(List<Item> lsItem) {
        this.lsItem = lsItem;
    }

    public List<Orcamento> getLsOrcamento() {
        return lsOrcamento;
    }

    public void setLsOrcamento(List<Orcamento> lsOrcamento) {
        this.lsOrcamento = lsOrcamento;
    }

    public List<Fornecedor> getLsFornecedor() {
        return lsFornecedor;
    }

    public void setLsFornecedor(List<Fornecedor> lsFornecedor) {
        this.lsFornecedor = lsFornecedor;
    }

    @Override
    public void save() {
        dao.savemerge(despesas);
    }

    @Override
    public void novo() {
        despesas = new Despesas();
    }

    @Override
    public void getList() {
        lsDespesa = dao.getListEntity(Despesas.class);
        lsItem = controller.findItens();
        lsOrcamento = controller.findOrcamento();
        lsFornecedor = controller.findFornecedor();
    }

    @Override
    public void getListFilter() {
        
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsDespesa.size(); i++) {
            if (Objects.equals(lsDespesa.get(i).getIdDespesa(), id)) {
                despesas = lsDespesa.get(i);
                break;
            }
        }
        return "";
    }
    
    
}
