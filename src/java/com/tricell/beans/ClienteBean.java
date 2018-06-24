/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import com.tricell.interfac.crud.Crud;
import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Cliente;
import com.tricell.repository.DaoGeneric;
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
@SessionScoped
@ManagedBean
public class ClienteBean implements Crud, Serializable{
    
    private Cliente cliente = new Cliente();
    private List<Cliente> lsCliente = new ArrayList<>();
    private DaoGeneric<Cliente> dao = new DaoGeneric<>();

    @Override
    public void save(){
        dao.savemerge(cliente);
        
    }
    
    @Override
    public void novo() {
        cliente = new Cliente();
        
    }

    @Override
    public void getList() {
        lsCliente = dao.getListEntity(Cliente.class);
    }

    @Override
    public String onRowSelected(Long id) {
        for (int i = 0; i < lsCliente.size(); i++) {
            if (Objects.equals(lsCliente.get(i).getIdCliente(), id)) {
                cliente = lsCliente.get(i);
                break;
            }
        }
        return "";
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getLsCliente() {
        return lsCliente;
    }

    public void setLsCliente(List<Cliente> lsCliente) {
        this.lsCliente = lsCliente;
    }

    @Override
    public void getListFilter() {
        
    }
}
