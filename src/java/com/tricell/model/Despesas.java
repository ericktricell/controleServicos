/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Eu
 */
@Entity
@Table(name = "despesas")
@NamedQueries({
    @NamedQuery(name = "despesas.findAll", query = "SELECT d FROM Despesas d")
}
)
public class Despesas implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long idDespesa;
    
    @JoinColumn(name = "idItem", referencedColumnName = "idItem", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    
    @JoinColumn(name = "idOrcamento", referencedColumnName = "idOrcamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orcamento orcamento;
    
    @JoinColumn(name = "idFornecedor", referencedColumnName = "idFornecedor", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Fornecedor fornecedor;
    
    @Column
    @Basic(optional = false)
    private Double valor;
    
    @Column
    @Basic(optional = true)
    private Double quantidade;

    public Long getIdDespesa() {
        return idDespesa;
    }

    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.idDespesa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Despesas other = (Despesas) obj;
        if (!Objects.equals(this.idDespesa, other.idDespesa)) {
            return false;
        }
        return true;
    }
    
    
}
