package com.ihm.healthdoc.neo4j.service;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.neo4j.ogm.model.Result;

import com.ihm.healthdoc.neo4j.valueObjects.SearchVO;
import com.ihm.healthdoc.nodes.entities.Procedure;

public class ProcedureInfoServiceImpl extends GenericService<Procedure> implements ProcedureInfoService {

    private static final String GET_PROCEDURE_INFO_WITH_LOCATION = "MATCH (p:PROCEDURE) WHERE p.name =~ '(?i).*%s.*' AND p.location = '%s' RETURN d";    	
    
    private static final String GET_PROCEDURE_INFO = "MATCH (p:PROCEDURE) WHERE p.name =~ '(?i).*%s.*' RETURN d";    	
    
    
	public Class<Procedure> getEntityType() {		
		return Procedure.class;
	}
	
	@Override
	public void deleteAll() {
		session.deleteAll(Procedure.class);
	}
		
	@Override
	public CompletableFuture<Result> getProcedureInfo(SearchVO searchVO) throws CompletionException {
	    
	    CompletableFuture<Result> procedureDetailsList = CompletableFuture.supplyAsync(
	                () -> {
	                    Result procedureList;
	                    String queryStr;
	                    try {
	                	if (null != searchVO.getLocation()) 
	                	    queryStr = String.format(GET_PROCEDURE_INFO_WITH_LOCATION,searchVO.getSearchString(),searchVO.getLocation());
	                	else 
	                	    queryStr = String.format(GET_PROCEDURE_INFO,searchVO.getSearchString());
	                	
	                        procedureList = session.query(queryStr, Collections.emptyMap());
	                    }
	                    catch (Exception ex) {
	                        System.out.println("Exception during Neo4j database operation -> " + ex.getMessage());
	                        throw new CompletionException(ex);
	                    }

	                    return procedureList;
	                }
	        );
	    
	    return procedureDetailsList;
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