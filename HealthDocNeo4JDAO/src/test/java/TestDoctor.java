import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.junit.Test;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;

import com.ihm.healthdoc.neo4j.constants.CommonConstants;
import com.ihm.healthdoc.neo4j.constants.SearchType;
import com.ihm.healthdoc.neo4j.service.DoctorInfoServiceImpl;
import com.ihm.healthdoc.neo4j.session.Neo4jSessionFactory;
import  com.ihm.healthdoc.neo4j.valueObjects.SearchVO;
import com.ihm.healthdoc.nodes.entities.ComplicationsInfo;
import com.ihm.healthdoc.nodes.entities.ConditionsTreated;
import com.ihm.healthdoc.nodes.entities.DoctorInfo;

public class TestDoctor {
    
    	/*
    	@Test    
	public void testCreate() {
		
    	    try {
		   
		    DoctorInfo doctorInfo = getDoctorInfo();		    
		    DoctorInfoServiceImpl doctorInfoServiceImpl = new DoctorInfoServiceImpl();
		    System.out.println("Testing create 1 operation ");
		    doctorInfoServiceImpl.create(doctorInfo);
		    System.out.println("Testing create 2 operation ");
		}
		catch (Exception ex) {
			System.out.println("Exception duing processing -> " + ex.getStackTrace());
		}
	    
	    System.out.println("Done 1 ");
	    System.out.println("Done 2 ");
	}
	*/
    	
    	private DoctorInfo getDoctorInfo() {
    	    DoctorInfo doctorInfo = new DoctorInfo();
    	    doctorInfo.setGivenName("Sushma");
    	    doctorInfo.setAddress("USA");
    	    doctorInfo.setGender("Male");
    	    doctorInfo.setPhoneNumber(Arrays.asList("9900599785", "08041718087"));
    	    
    	    ConditionsTreated conditionsTreated = new ConditionsTreated();
    	    conditionsTreated.setConditions("HeadAche");
    	    doctorInfo.setConditionsTreated(conditionsTreated);
    	
    	    ComplicationsInfo complicationsInfo1 = new ComplicationsInfo();
    	    complicationsInfo1.setDescription("complication desc1 ");
    	    complicationsInfo1.setSurgeryProcedureDescription("surgery procedure 1");
    	    complicationsInfo1.setYear("2001");
    	    
    	    ComplicationsInfo complicationsInfo2 = new ComplicationsInfo();
 	    complicationsInfo2.setDescription("complication desc2 ");
 	    complicationsInfo2.setSurgeryProcedureDescription("surgery procedure 2");
 	    complicationsInfo2.setYear("2011");
 	    
 	    doctorInfo.setComplicationsInfo(Arrays.asList(complicationsInfo1,complicationsInfo2));
    	    
    	    return doctorInfo;
    	}

	@Test
	public void testSearchOperation(){

           DoctorInfoServiceImpl doctorInfoServiceImpl = new DoctorInfoServiceImpl();

           SearchVO searchVO=new SearchVO();
	   // searchVO.setLocation("bangalore");
	   searchVO.setSearchString("Sushma");		
	   searchVO.setSearchType(SearchType.DOCTOR);

           CompletableFuture<Result> resultFutureObject = null;
           try {
               resultFutureObject = doctorInfoServiceImpl.getDoctorInfo(searchVO);
           } catch (Exception e) {
	      System.out.println("Exception duing processing -> " + e.getMessage());              
           } 
           
           logThreadId();
           if (resultFutureObject.isCompletedExceptionally() == true) {               
	      System.out.println("Exception during execution of API getHealthCentersInARegionForAProduct ");
	   }
           
           resultFutureObject.thenAccept(new Consumer<Result>() {
		@Override
		public void accept(Result doctorResult) {
			Iterable<Map<String,Object>> doctorDetails = doctorResult.queryResults();
			doctorDetails.forEach( (mapEntry) -> {				
				System.out.println("Doctor Values -> " + mapEntry.values());
			});
		}
	});
           
	}
	
	public void logThreadId() {
   	    
	    try {
		Thread.sleep(10000);
	    } catch (InterruptedException e) {			
		e.printStackTrace();
	    }
	   
	    System.out.println("Invocation complete. Main ThreadID -> " + Thread.currentThread());
	    
	}
}