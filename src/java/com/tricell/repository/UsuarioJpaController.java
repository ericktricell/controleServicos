/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.repository;

import com.tricell.model.Usuario;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author Eu
 */
public class UsuarioJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void edit(Usuario usuario){
        EntityManager em = getEntityManager();
        
        try{
            Query q = em.createNamedQuery("Usuario.update");
            q.setParameter("email", usuario.getEmail());
            q.setParameter("login", usuario.getLogin());
            q.setParameter("nome", usuario.getNome());
            q.setParameter("senha", usuario.getSenha());
            q.setParameter("tel", usuario.getTelefone());
            q.setParameter("id", usuario.getIdUsuario());
            q.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            em.close();
        }finally{
            em.close();
        }
    }
}
