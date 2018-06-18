/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.repository;

import com.tricell.jpautil.JPAUtil;
import com.tricell.model.Usuario;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

/**
 *
 * @author Eu
 */
public class LoginDAO extends JPAUtil implements Serializable{

    public Usuario validaLogin(String login, String senha){
        EntityManager em = getEntityManager();
        Usuario u = null;
        try{
            Query q = em.createNamedQuery("Usuario.valida");
            q.setParameter("login", login);
            q.setParameter("senha", senha);
            
            u = (Usuario) q.getSingleResult();
        }catch(NoResultException e){
            u = null;
        }finally{
            em.close();
        }
        return u;
    }
}
