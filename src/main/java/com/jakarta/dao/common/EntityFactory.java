package com.jakarta.dao.common;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@ApplicationScoped
public class EntityFactory {

    @PersistenceContext(unitName = "jakarta")
    private EntityManager em;
	
	public EntityFactory() {
		// TODO Auto-generated constructor stub
	}
	
    @Produces
    @RequestScoped
    public EntityManager getEntityManager() {
        return em;
    }

}
