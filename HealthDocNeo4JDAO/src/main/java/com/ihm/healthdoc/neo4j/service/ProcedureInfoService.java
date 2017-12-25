package com.ihm.healthdoc.neo4j.service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import org.neo4j.ogm.model.Result;
import com.ihm.healthdoc.neo4j.valueObjects.SearchVO;

public interface ProcedureInfoService {

	public CompletableFuture<Result> getProcedureInfo(SearchVO searchVO) throws CompletionException;	
	
}