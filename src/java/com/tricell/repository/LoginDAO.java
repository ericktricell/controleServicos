/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.repository;

import com.tricell.jpautil.HibernateUtil;
import com.tricell.model.Usuario;
import java.io.Serializable;
import javax.persistence.NoResultException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Eu
 */
public class LoginDAO implements Serializable{

    public Usuario validaLogin(String login, String senha){
        Session s = HibernateUtil.getSessionfactory().openSession();
        Usuario u = null;
        try{
            Query q = s.getNamedQuery("Usuario.valida");
            q.setParameter("login", login);
            q.setParameter("senha", senha);
            
            u = (Usuario) q.uniqueResult();
        }catch(NoResultException e){
            u = null;
        }finally{
            s.close();
        }
        return u;
    }
    
    public void inicia(){
        Session s = HibernateUtil.getSessionfactory().openSession();
    }
}
