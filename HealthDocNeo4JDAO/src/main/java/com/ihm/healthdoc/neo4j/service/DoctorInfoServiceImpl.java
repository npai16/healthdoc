package com.ihm.healthdoc.neo4j.service;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import org.neo4j.ogm.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ihm.healthdoc.neo4j.valueObjects.SearchVO;
import com.ihm.healthdoc.nodes.entities.DoctorInfo;

public class DoctorInfoServiceImpl extends GenericService<DoctorInfo> implements DoctorInfoService {
    
    	private static final Logger logger = LoggerFactory.getLogger(DoctorInfoServiceImpl.class);
    	
    	private static final String GET_DOCTOR_INFO_WITH_LOCATION = "MATCH (d:DOCTOR_INFO) WHERE d.givenName =~ '(?i).*%s.*' AND d.location = '%s' RETURN d";   
    	
    	private static final String GET_DOCTOR_INFO = "MATCH (d:DOCTOR_INFO) WHERE d.givenName =~ '(?i).*%s.*' RETURN d";
    
	public Class<DoctorInfo> getEntityType() {		
		return DoctorInfo.class;
	}
	
	@Override
	public void deleteAll() {
		session.deleteAll(DoctorInfo.class);
	}
	
	@Override
	public CompletableFuture<Result>  getDoctorInfo(SearchVO searchVO) throws Exception {
	    
	    logger.info("IN getDoctorInfo ");
	    
	    CompletableFuture<Result> doctorInfoFutureObject = CompletableFuture.supplyAsync(
	                () -> {
	                    Result doctorResult;
	                    String queryStr;
	                    try {
	                	if (null != searchVO.getLocation())
	                	   queryStr = String.format(GET_DOCTOR_INFO_WITH_LOCATION,searchVO.getSearchString(),searchVO.getLocation());
	                	else 
	                	   queryStr = String.format(GET_DOCTOR_INFO,searchVO.getSearchString());
	                	
	                        logger.info("Query -> "+queryStr);

	                        doctorResult = session.query(queryStr, Collections.emptyMap());
	                    }
	                    catch (Exception ex) {
	                        System.out.println("Exception during Neo4j database operation -> " + ex.getMessage());
	                        throw new CompletionException(ex);
	                    }
	                    	                  
	                    return doctorResult;
	                }
	        );
	   return doctorInfoFutureObject;
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