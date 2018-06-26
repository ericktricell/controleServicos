/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.repository;

import com.tricell.jpautil.HibernateUtil;
import com.tricell.model.Cliente;
import com.tricell.model.Empresa;
import com.tricell.model.Fornecedor;
import com.tricell.model.Item;
import com.tricell.model.Orcamento;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Eu
 */
public class OrcamentoController implements Serializable{
    
    public Cliente findCliente(Long id){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        Cliente c = new Cliente();
        try{
            c = (Cliente) sessao.createCriteria(Cliente.class).add(Restrictions.eq("idCliente", id)).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return c;
    }
    
    public Empresa findEmpresa(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{
            return (Empresa) sessao.getNamedQuery("Empresa.findAll").uniqueResult();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public Item findItem(Long id){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{
            return (Item) sessao.createCriteria(Item.class).add(Restrictions.eq("idItem", id)).uniqueResult();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public List<Cliente> findCliente(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return sessao.createCriteria(Cliente.class).list();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public List<Item> findItens(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return sessao.createCriteria(Item.class).list();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public List<Orcamento> findOrcamento(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return sessao.createCriteria(Orcamento.class).list();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public Orcamento findOrcamento(String idOrcamento){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return (Orcamento) sessao.createCriteria(Orcamento.class).add(Restrictions.eq("idOrcamento", idOrcamento)).uniqueResult();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public List<Fornecedor> findFornecedor(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return sessao.createCriteria(Fornecedor.class).list();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public Fornecedor findFornecedor(Long idFornecedor){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return (Fornecedor) sessao.createCriteria(Fornecedor.class).add(Restrictions.eq("idFornecedor", idFornecedor)).uniqueResult();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public Long getIdOrcamento(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{
            return ((Long) sessao.getNamedQuery("orcamento.pegaid").uniqueResult()) + 1;
        }catch(Exception e){
            return new Long("1");
        }
    }
}
