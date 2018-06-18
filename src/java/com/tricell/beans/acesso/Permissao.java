/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans.acesso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Eu
 */
public enum Permissao {
    ADMIN("ADMIN", "Administrador"),
    USER("USER", "Usuário padrão"),
    FECHAR_OS("FECHAR_OS", "Fechamento de OS"),
    FINANCEIRO_ACESSAR("FINANCEIRO_ACESSAR", "Financeiro Acessar");
    
    private String valor = "";
    private String descricao = "";

    private Permissao(){
        
    }
    
    private Permissao(String valor, String descricao){
        this.valor = valor;
        this.descricao = descricao;
    }
    
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return getValor();
    }
    
   public static List<Permissao> getListPermissao() {
		List<Permissao> permissoes = new ArrayList<Permissao>();
		for (Permissao permissao : Permissao.values()) {
			permissoes.add(permissao);
		}
		Collections.sort(permissoes, new Comparator<Permissao>() {

			@Override
			public int compare(Permissao o1, Permissao o2) {
				return new Integer(o1.ordinal()).compareTo(new Integer(o2.ordinal()));
			}
		});
		return permissoes;
	} 
}
