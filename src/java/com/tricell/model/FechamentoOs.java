/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Eu
 */
@Entity
@Table(name = "fechamentoos")
public class FechamentoOs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFechamento")
    private Long idFechamento;
    
    @Column(name = "dataFechamento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataFechamento;
    
    @JoinColumn(name = "idOrcamento", referencedColumnName = "idOrcamento")
    @OneToOne(optional = false)
    private Orcamento idOrcamento;
    
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;

    public Long getIdFechamento() {
        return idFechamento;
    }

    public void setIdFechamento(Long idFechamento) {
        this.idFechamento = idFechamento;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public Orcamento getIdOrcamento() {
        return idOrcamento;
    }

    public void setIdOrcamento(Orcamento idOrcamento) {
        this.idOrcamento = idOrcamento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public FechamentoOs() {
    }

    public FechamentoOs(Long idFechamento) {
        this.idFechamento = idFechamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFechamento != null ? idFechamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FechamentoOs)) {
            return false;
        }
        FechamentoOs other = (FechamentoOs) object;
        if ((this.idFechamento == null && other.idFechamento != null) || (this.idFechamento != null && !this.idFechamento.equals(other.idFechamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tricell.model.FechamentoOs[ idFechamento=" + idFechamento + " ]";
    }
    
    
}
