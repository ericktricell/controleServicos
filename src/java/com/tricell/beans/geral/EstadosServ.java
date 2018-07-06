/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans.geral;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Eu
 */
@ManagedBean
public class EstadosServ {
    
    private List<Estados> lsEstados;
    
    @PostConstruct
    public void init(){
    lsEstados = new ArrayList<>();
    lsEstados.add(new Estados("AC", "Acre"));
    lsEstados.add(new Estados("AL", "Alagoas"));
    lsEstados.add(new Estados("AP", "Amapá"));
    lsEstados.add(new Estados("AM", "Amazonas"));
    lsEstados.add(new Estados("BA", "Bahia"));
    lsEstados.add(new Estados("CE", "Ceará"));
    lsEstados.add(new Estados("DF", "Distrito Federal"));
    lsEstados.add(new Estados("ES", "Espírito Santo"));
    lsEstados.add(new Estados("GO", "Goiás"));
    lsEstados.add(new Estados("MA", "Maranhão"));
    lsEstados.add(new Estados("MT", "Mato Grosso"));
    lsEstados.add(new Estados("MS", "Mato Grosso do Sul"));
    lsEstados.add(new Estados("MG", "Minas Gerais"));
    lsEstados.add(new Estados("PA", "Pará"));
    lsEstados.add(new Estados("PB", "Paraíba"));
    lsEstados.add(new Estados("PR", "Paraná"));
    lsEstados.add(new Estados("PE", "Pernambuco"));
    lsEstados.add(new Estados("PI", "Piauí"));
    lsEstados.add(new Estados("RJ", "Rio de Janeiro"));
    lsEstados.add(new Estados("RN", "Rio Grande do Norte"));
    lsEstados.add(new Estados("RS", "Rio Grande do Sul"));
    lsEstados.add(new Estados("RO", "Rondônia"));
    lsEstados.add(new Estados("RR", "Roraima"));
    lsEstados.add(new Estados("SC", "Santa Catarina"));
    lsEstados.add(new Estados("SP", "São Paulo"));
    lsEstados.add(new Estados("SE", "Sergipe"));
    lsEstados.add(new Estados("TO", "Tocantins"));
    }

    public List<Estados> getLsEstados() {
        return lsEstados;
    }

}
