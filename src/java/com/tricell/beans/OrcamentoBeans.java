/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.model.Cliente;
import com.tricell.model.Empresa;
import com.tricell.model.Item;
import com.tricell.model.Itensorc;
import com.tricell.model.Orcamento;
import com.tricell.model.Usuario;
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
public class OrcamentoBeans implements Crud, Serializable {

    private static final long serialVersionUID = 1L;

    private Orcamento orcamento = new Orcamento();
    private Usuario usuarioLogado = new Usuario();
    private List<Orcamento> lsOrcamento = new ArrayList<>();
    private DaoGeneric<Orcamento> dao = new DaoGeneric<>();
    private List<Itensorc> lsItensOrc = new ArrayList<>();
    private Itensorc itensorc = new Itensorc();
    private List<Item> lsItens = new ArrayList<>();
    private List<Cliente> lsCli = new ArrayList<>();
    private OrcamentoController controller = new OrcamentoController();
    private boolean skip;
    private Empresa empresa = new Empresa();
    private Double vlrTotal = new Double(0.0);
    private Double vlrTotalOrc = new Double(0.0);

    public void addItem() {
        itensorc.setIdItem(itensorc.getItem().getIdItem());
        itensorc.setIdOrcamento(orcamento.getIdOrcamento());
        vlrTotalOrc += itensorc.getNum() * itensorc.getItem().getVlrUnit();
        lsItensOrc.add(itensorc);
        itensorc = new Itensorc();
    }

    @Override
    public void save() {
        orcamento.setIdEmpresa(empresa);
        orcamento.setIdUsuario(usuarioLogado);
        orcamento.setItensorcList(lsItensOrc);
        orcamento.setVlrTotal(vlrTotalOrc);
        dao.savemerge(orcamento);
    }

    @Override
    public void novo() {
        orcamento = new Orcamento();

    }

    @Override
    public void getList() {
        lsOrcamento = dao.getListEntity(Orcamento.class);
    }

    @Override
    public void getListFilter() {
        lsOrcamento = controller.getListEntity();
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsOrcamento.size(); i++) {
            if (Objects.equals(lsOrcamento.get(i).getIdOrcamento(), id)) {
                orcamento = lsOrcamento.get(i);
                orcamento.setItensorcList(controller.findItOrc(orcamento.getIdOrcamento()));
                break;
            }
        }
        return "aprovacao?redirect=true";
    }

    public void aprov(Orcamento o) {
        orcamento = o;
        orcamento.setAprovado(true);
        dao.savemerge(orcamento);
        lsOrcamento = controller.getListEntity();
    }

    public void calculaTotal() {
        vlrTotal = itensorc.getItem().getVlrUnit() * itensorc.getNum();
    }

    public void getComponentes() {
        lsCli = controller.findCliente();
        lsItens = controller.findItens();
        empresa = controller.findEmpresa();
        orcamento.setNumDoc(usuarioLogado.getNome().substring(0, 2) + controller.getIdOrcamento());
        orcamento.setIdOrcamento(orcamento.getNumDoc());
    }

    public Double getVlrTotalOrc() {
        return vlrTotalOrc;
    }

    public void setVlrTotalOrc(Double vlrTotalOrc) {
        this.vlrTotalOrc = vlrTotalOrc;
    }

    public Double getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(Double vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Itensorc getItensorc() {
        return itensorc;
    }

    public void setItensorc(Itensorc itensorc) {
        this.itensorc = itensorc;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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

    public List<Itensorc> getLsItensOrc() {
        return lsItensOrc;
    }

    public void setLsItensOrc(List<Itensorc> lsItensOrc) {
        this.lsItensOrc = lsItensOrc;
    }

    public List<Item> getLsItens() {
        return lsItens;
    }

    public void setLsItens(List<Item> lsItens) {
        this.lsItens = lsItens;
    }

    public List<Cliente> getLsCli() {
        return lsCli;
    }

    public void setLsCli(List<Cliente> lsCli) {
        this.lsCli = lsCli;
    }

}
