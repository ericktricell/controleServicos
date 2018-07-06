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
import com.tricell.model.Itensorc;
import com.tricell.model.Orcamento;
import com.tricell.model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
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
    
    public List<Usuario> findUsuario(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return sessao.createCriteria(Usuario.class).list();
        }catch(Exception e){
            return null;
        }finally{
            sessao.close();
        }
    }
    
    public List<Itensorc> findItOrc(String id){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return sessao.createCriteria(Itensorc.class).add(Restrictions.eq("idOrcamento", id)).list();
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
    
    public List<Orcamento> findOrcamento(Long id){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            System.out.println("\n\n" + id + "\n\n");
            return sessao.createQuery("SELECT o FROM Orcamento o, Designacao d WHERE d.idUsuario = "+ id +" and d.idOrcamento = o.idOrcamento").list();
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
    
    public Usuario findUsuario(Long idUsuario){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{ 
            return (Usuario) sessao.createCriteria(Usuario.class).add(Restrictions.eq("idUsuario", idUsuario)).uniqueResult();
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
        } finally{
            sessao.close();
        }
    }
    
    public List<Orcamento> getListEntity(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        List<Orcamento> retorno = new ArrayList<>();
        try{
            
            retorno = sessao.createCriteria(Orcamento.class).add(Restrictions.eqOrIsNull("aprovado", false)).list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return retorno;
    }
    
    public List<Orcamento> getListEntity1(){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        List<Orcamento> retorno = new ArrayList<>();
        try{
            
            retorno = sessao.createCriteria(Orcamento.class).add(Restrictions.eqOrIsNull("aprovado", true)).list();
        }catch(Exception e){
            e.printStackTrace();
            retorno = null;
        }finally{
            sessao.close();
        }
        return retorno;
    }
    
    public Double getSomaCusto(String idOrcamento){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        try{
           return (Double) sessao.createQuery("SELECT sum(d.valor * d.quantidade) FROM despesas d, orcamento o WHERE o.idOrcamento = " + idOrcamento + " and d.idOrcamento = o.idOrcamento").uniqueResult();
        }catch(Exception e){
           return new Double("0.0");
        }finally{
            sessao.close();
        }
    }
}
