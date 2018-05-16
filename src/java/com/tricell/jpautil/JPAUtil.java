/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eu
 */
public class JPAUtil {

    private EntityManagerFactory factory = null;

    public JPAUtil() {
        if (factory == null) {
            factory = Persistence.createEntityManagerFactory("controleServicosPU");
        }
    }

    public EntityManagerFactory getFactory() {
        return factory;
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public Object getPrimaryKey(Object entity) {
        return factory.getPersistenceUnitUtil().getIdentifier(entity);
    }
}
