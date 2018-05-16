/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tricell.beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Eu
 */
public class NewClass {
    
    private static EntityManagerFactory factory = null;
    
    static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("controleServicosPU");
		}
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
	
	public static Object getPrimaryKey(Object entity){
		return factory.getPersistenceUnitUtil().getIdentifier(entity);
	}
        
    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory("controleServicosPU");
    }
}
