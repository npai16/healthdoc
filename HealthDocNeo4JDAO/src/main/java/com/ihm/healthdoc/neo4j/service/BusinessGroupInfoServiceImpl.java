package com.ihm.healthdoc.neo4j.service;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.neo4j.ogm.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ihm.healthdoc.neo4j.valueObjects.SearchVO;
import com.ihm.healthdoc.nodes.entities.BusinessGroup;


public class BusinessGroupInfoServiceImpl extends GenericService<BusinessGroup> implements BusinessGroupInfoService {
    
	private static final Logger logger = LoggerFactory.getLogger(DoctorInfoServiceImpl.class);   
	
	private static final String GET_BUSINESS_GROUP_INFO = "MATCH (d:BUSINESS_GROUP) WHERE d.name =~ '(?i).*%s.*' RETURN d";

	public Class<BusinessGroup> getEntityType() {		
		return BusinessGroup.class;
	}
	
	@Override
	public void deleteAll() {
		session.deleteAll(BusinessGroup.class);
	}
	
	@Override
	public CompletableFuture<Result> getBusinessGroupInfo(SearchVO searchVO) throws CompletionException {
	    
	    logger.info("IN getBusinessGroupInfo ");
	    
	    CompletableFuture<Result> businessInfoFutureObject = CompletableFuture.supplyAsync(
	                () -> {
	                    Result businessResult;
	                    String queryStr;
	                    try {
	                	
	                	queryStr = String.format(GET_BUSINESS_GROUP_INFO,searchVO.getSearchString());
	                	
	                        logger.info("Query -> "+queryStr);

	                        businessResult = session.query(queryStr, Collections.emptyMap());
	                    }
	                    catch (Exception ex) {
	                        System.out.println("Exception during Neo4j database operation -> " + ex.getMessage());
	                        throw new CompletionException(ex);
	                    }
	                    	                  
	                    return businessResult;
	                }
	        );
	   return businessInfoFutureObject;
	}
				
	public void logThreadId() {
	    System.out.println("Invocation complete. ThreadID -> " + Thread.currentThread());
	    
	    try {
		Thread.sleep(5000);
	    } catch (InterruptedException e) {			
		e.printStackTrace();
	    }	    
	}
}