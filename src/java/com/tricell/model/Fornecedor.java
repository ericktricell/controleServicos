/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eu
 */
@Entity
@Table(name = "fornecedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fornecedor.findAll", query = "SELECT f FROM Fornecedor f")
    , @NamedQuery(name = "Fornecedor.findByIdFornecedor", query = "SELECT f FROM Fornecedor f WHERE f.idFornecedor = :idFornecedor")
    , @NamedQuery(name = "Fornecedor.findByBairro", query = "SELECT f FROM Fornecedor f WHERE f.bairro = :bairro")
    , @NamedQuery(name = "Fornecedor.findByCep", query = "SELECT f FROM Fornecedor f WHERE f.cep = :cep")
    , @NamedQuery(name = "Fornecedor.findByCidade", query = "SELECT f FROM Fornecedor f WHERE f.cidade = :cidade")
    , @NamedQuery(name = "Fornecedor.findByCnpjCpf", query = "SELECT f FROM Fornecedor f WHERE f.cnpjCpf = :cnpjCpf")
    , @NamedQuery(name = "Fornecedor.findByInativo", query = "SELECT f FROM Fornecedor f WHERE f.inativo = :inativo")
    , @NamedQuery(name = "Fornecedor.findByInscricaoEstadual", query = "SELECT f FROM Fornecedor f WHERE f.inscricaoEstadual = :inscricaoEstadual")
    , @NamedQuery(name = "Fornecedor.findByLogradouro", query = "SELECT f FROM Fornecedor f WHERE f.logradouro = :logradouro")
    , @NamedQuery(name = "Fornecedor.findByNomeFantasia", query = "SELECT f FROM Fornecedor f WHERE f.nomeFantasia = :nomeFantasia")
    , @NamedQuery(name = "Fornecedor.findByNum", query = "SELECT f FROM Fornecedor f WHERE f.num = :num")
    , @NamedQuery(name = "Fornecedor.findByRazaoSocial", query = "SELECT f FROM Fornecedor f WHERE f.razaoSocial = :razaoSocial")
    , @NamedQuery(name = "Fornecedor.findBySite", query = "SELECT f FROM Fornecedor f WHERE f.site = :site")})
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFornecedor")
    private Long idFornecedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "bairro")
    private String bairro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cep")
    private String cep;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cidade")
    private String cidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cnpjCpf")
    private String cnpjCpf;
    @Column(name = "inativo")
    private Boolean inativo;
    @Size(max = 255)
    @Column(name = "inscricaoEstadual")
    private String inscricaoEstadual;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "logradouro")
    private String logradouro;
    @Size(max = 255)
    @Column(name = "nomeFantasia")
    private String nomeFantasia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "num")
    private int num;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "razaoSocial")
    private String razaoSocial;
    @Size(max = 255)
    @Column(name = "site")
    private String site;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFornecedor")
    private List<Despesas> despesasList;

    public Fornecedor() {
    }

    public Fornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Fornecedor(Long idFornecedor, String bairro, String cep, String cidade, String cnpjCpf, String logradouro, int num, String razaoSocial) {
        this.idFornecedor = idFornecedor;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.cnpjCpf = cnpjCpf;
        this.logradouro = logradouro;
        this.num = num;
        this.razaoSocial = razaoSocial;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public Boolean getInativo() {
        return inativo;
    }

    public void setInativo(Boolean inativo) {
        this.inativo = inativo;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    @XmlTransient
    public List<Despesas> getDespesasList() {
        return despesasList;
    }

    public void setDespesasList(List<Despesas> despesasList) {
        this.despesasList = despesasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tricell.model.Fornecedor[ idFornecedor=" + idFornecedor + " ]";
    }
    
}
