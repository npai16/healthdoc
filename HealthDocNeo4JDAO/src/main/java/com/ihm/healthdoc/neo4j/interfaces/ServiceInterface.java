package com.ihm.healthdoc.neo4j.interfaces;

public interface ServiceInterface<T> {
		
    T find(Long id);

    void delete(Long id);
    
    void create(T object);   
    
    void deleteAll();
}
