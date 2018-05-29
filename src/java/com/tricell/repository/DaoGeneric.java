/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Eu
 */
public class DaoGeneric<E> implements Serializable{
    
    private EntityManagerFactory emf = null;

    public DaoGeneric(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void save(E entidade){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            em.persist(entidade);
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }
    
    public void savemerge(E entidade){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            em.merge(entidade);
            
            em.getTransaction().commit();
        } catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
        }finally{
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<E> getListEntity(Class<E> entidade){
        EntityManager em = null;
        List<E> retorno = new ArrayList<>();
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            
            retorno = em.createQuery("from " + entidade.getName()).getResultList();
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if (em != null) {
                em.close();
            }
        }
        return retorno;
    }
}
