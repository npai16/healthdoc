package com.ihm.healthdoc.neo4j.session;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4jSessionFactory {

    	private static Configuration configuration;
    	
	private static Neo4jSessionFactory factory = null;
	
	private static SessionFactory sessionFactory = null; // new SessionFactory("com.ihm.customer.nodes.entities");
	
	public synchronized static Neo4jSessionFactory getInstance () {
	    	if (factory == null) {
	    	    configuration = new Configuration();
	    	    configuration.driverConfiguration().setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
	    	    .setURI("http://localhost:7474")
	            .setCredentials("neo4j", "jECrumezu8-#");
	    	    sessionFactory = new SessionFactory(configuration, "com.ihm.healthdoc.nodes.entities");	    	    
	    	    factory = new Neo4jSessionFactory();
	    	}
		return factory;
	}
	
	private Neo4jSessionFactory() {
	}
	
	public Session getNeo4jSession() {
		return sessionFactory.openSession();
	}
	
}