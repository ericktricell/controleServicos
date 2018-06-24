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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eu
 */
@Entity
@Table(name = "itensorc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itensorc.findAll", query = "SELECT i FROM Itensorc i")
    , @NamedQuery(name = "Itensorc.findByNum", query = "SELECT i FROM Itensorc i WHERE i.num = :num")})
public class Itensorc implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    private String idOrcamento;
    
    @Id
    private long idItem;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private double num;
    @JoinColumn(name = "idItem", referencedColumnName = "idItem", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Item item;
    @JoinColumn(name = "idOrcamento", referencedColumnName = "idOrcamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Orcamento orcamento;

    public Itensorc() {
    }

    public String getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(String idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public long getIdItem() {
        return idItem;
    }

    public void setIdItem(long idItem) {
        this.idItem = idItem;
    }
    
    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.idOrcamento);
        hash = 67 * hash + (int) (this.idItem ^ (this.idItem >>> 32));
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
        final Itensorc other = (Itensorc) obj;
        if (this.idItem != other.idItem) {
            return false;
        }
        if (!Objects.equals(this.idOrcamento, other.idOrcamento)) {
            return false;
        }
        return true;
    }

}
