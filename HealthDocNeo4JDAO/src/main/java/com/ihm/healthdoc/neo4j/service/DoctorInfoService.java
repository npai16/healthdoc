package com.ihm.healthdoc.neo4j.service;

import java.util.concurrent.CompletableFuture;

import org.neo4j.ogm.model.Result;
import com.ihm.healthdoc.neo4j.valueObjects.SearchVO;

public interface DoctorInfoService {

    	public CompletableFuture<Result>  getDoctorInfo(SearchVO searchVO) throws Exception;	
}