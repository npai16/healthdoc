package com.ihm.healthdoc.neo4j.service;

import org.neo4j.ogm.session.Session;
import com.ihm.healthdoc.neo4j.interfaces.ServiceInterface;
import com.ihm.healthdoc.neo4j.session.Neo4jSessionFactory;

public abstract class GenericService<T> implements ServiceInterface<T> {

	 private static final int DEPTH_LIST = 0;
	 protected static final int DEPTH_ENTITY = 1;
	 protected Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();
	 
	 @Override
	 public T find(Long id) {
	     return session.load(getEntityType(), id, DEPTH_ENTITY);
	 }

	 @Override
	 public void delete(Long id) {
	     session.delete(session.load(getEntityType(), id));
	 }
	 
	 public void create(T entity) {
		 session.save(entity, DEPTH_ENTITY);		 
	 }
	 
	 public abstract Class<T> getEntityType();
	 
}