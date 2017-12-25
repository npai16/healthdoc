package com.ihm.healthdoc.neo4j.service;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

import org.neo4j.ogm.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ihm.healthdoc.neo4j.valueObjects.SearchVO;
import com.ihm.healthdoc.nodes.entities.Hospital;

public class HospitalInfoServiceImpl extends GenericService<Hospital> implements HospitalInfoService {
   
    private static final Logger logger = LoggerFactory.getLogger(HospitalInfoServiceImpl.class);
        
    private static final String GET_HOSPITAL_INFO_WITH_LOCATION = "MATCH (d:HOSPITAL) WHERE d.name =~ '(?i).*%s.*' AND d.location = '%s' RETURN d";   
	
    private static final String GET_HOSPITAL_INFO = "MATCH (d:HOSPITAL) WHERE d.name =~ '(?i).*%s.*' RETURN d";
    
    @Override
    public CompletableFuture<Result> getHospitalInfo(SearchVO searchVO) throws CompletionException {
	
	CompletableFuture<Result> hospitalDetailsList = CompletableFuture.supplyAsync(
		
                () -> {
                    Result hospitalList;
                    String queryStr;
                    try {
                        logger.info("IN getHospitalInfo");
                        if (null != searchVO.getLocation())
                           queryStr = String.format(GET_HOSPITAL_INFO_WITH_LOCATION,searchVO.getSearchString(),searchVO.getLocation());
                        else 
                           queryStr = String.format(GET_HOSPITAL_INFO,searchVO.getSearchString());

                        logger.info("Query -> " + queryStr);

                        hospitalList = session.query(queryStr, Collections.emptyMap());
                    }
                    catch (Exception ex) {
                        logger.error("Exception in the API HospitalInfoServiceImpl::getHospitalInfo -> " + ex.getMessage());
                        throw new CompletionException(ex);
                    }
                    return hospitalList;
                }
        );

        return hospitalDetailsList;
    }

    @Override
    public Class<Hospital> getEntityType() {
	return Hospital.class;
    }

    @Override
    public void deleteAll() {
	session.deleteAll(Hospital.class);	
    }
}