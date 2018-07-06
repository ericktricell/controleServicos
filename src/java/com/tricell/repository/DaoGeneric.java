/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.repository;

import com.tricell.jpautil.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

/**
 *
 * @author Eu
 */
public class DaoGeneric<E> implements Serializable{

    public void save(E entidade){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        Transaction t = null;
        try {
            t = sessao.beginTransaction();
            sessao.save(entidade);
            t.commit();
        } catch (Exception e){
            e.printStackTrace();
            t.rollback();
        }finally{
            sessao.close();
        }
    }
    
    public void savemerge(E entidade){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        Transaction t = null;
        try {
            t = sessao.beginTransaction();
            sessao.saveOrUpdate(entidade);
            t.commit();
        } catch (Exception e){
            e.printStackTrace();
            t.rollback();
            
        }finally{
           sessao.close();
        }
    }
    
    public E getEntidade(Class<E> entidade){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        E retorno = null;
        
        try{
            
            retorno = (E) sessao.createCriteria(entidade).uniqueResult();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        
        return retorno;
    }
    
    public List<E> getListEntity(Class<E> entidade){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        List<E> retorno = new ArrayList<>();
        try{
            
            retorno = sessao.createCriteria(entidade).addOrder(Order.desc("idFechamento")).list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return retorno;
    }
    
    public List<E> getListEntity1(Class<E> entidade){
        Session sessao = HibernateUtil.getSessionfactory().openSession();
        List<E> retorno = new ArrayList<>();
        try{
            
            retorno = sessao.createCriteria(entidade).addOrder(Order.desc("idFechamento")).list();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            sessao.close();
        }
        return retorno;
    }
}
