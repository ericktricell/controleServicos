/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans.geral;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author Eu
 */
public class ObjetoCampoConsulta implements Serializable, Comparator<ObjetoCampoConsulta> {

    private String descricao;
    private String campoBanco;
    private Object tipoClass;
    private Integer principal;

    @Override
    public int compare(ObjetoCampoConsulta o1, ObjetoCampoConsulta o2) {
        return ((ObjetoCampoConsulta) o1).getPrincipal().compareTo(((ObjetoCampoConsulta) o2).getPrincipal());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCampoBanco() {
        return campoBanco;
    }

    public void setCampoBanco(String campoBanco) {
        this.campoBanco = campoBanco;
    }

    public Object getTipoClass() {
        return tipoClass;
    }

    public void setTipoClass(Object tipoClass) {
        this.tipoClass = tipoClass;
    }

    public Integer getPrincipal() {
        return principal;
    }

    public void setPrincipal(Integer principal) {
        this.principal = principal;
    }

    @Override
    public String toString() {
        return getDescricao();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.campoBanco);
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
        final ObjetoCampoConsulta other = (ObjetoCampoConsulta) obj;
        if (!Objects.equals(this.campoBanco, other.campoBanco)) {
            return false;
        }
        return true;
    }

}
