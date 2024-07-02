package com.jakarta.dao.common;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaQuery;

import com.jakarta.models.GenericEntity;

@Stateless
public class GenericDAO implements Serializable {
	
	private static final long serialVersionUID = -8867507279541187826L;
	
	@Inject
	protected EntityManager entityManager;
	
	public <T extends GenericEntity> void persist(T entity) {
		entityManager.persist(entity);
	}
	
    public <T extends GenericEntity> void remove(T entity) {
        entityManager.remove(entity);
    }
    
    public <T extends GenericEntity> void remove(Class<T> clazz, Object primaryKey) {
    	T entity = entityManager.find(clazz, primaryKey);
    	entityManager.remove(entity);
    }
	
	public <T extends GenericEntity> T merge(T entity) {
		return entityManager.merge(entity);
	}
	
	public <E> List<E> listAll(Class<E> clazz, Integer startPosition, Integer maxResult) {
        TypedQuery<E> findAllQuery = entityManager.createQuery(MessageFormat.format("SELECT DISTINCT e FROM {0} e", clazz.getName()), clazz);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        return findAllQuery.getResultList();
    }
	
	public <E> List<E> listAll(Class<E> clazz) {
		CriteriaQuery<E> query = entityManager.getCriteriaBuilder().createQuery(clazz);
		query.select(query.from(clazz));
		
		List<E> lista = entityManager.createQuery(query).getResultList();
		
		return lista;
	}

}
