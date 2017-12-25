import com.ihm.customer.neo4j.callbacks.HealthCentreCallbackTask;
import com.ihm.customer.neo4j.service.HealthCentreService;
import com.ihm.customer.neo4j.service.HealthCentreServiceImpl;
import com.ihm.customer.neo4j.valueObjects.SearchVO;
import com.ihm.customer.nodes.entities.HealthCentre;
import com.ihm.customer.nodes.entities.Product;
import com.ihm.healthdoc.neo4j.constants.CommonConstants;

import org.junit.Test;
import org.neo4j.ogm.model.Result;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TestHCProducts {
	
        
	@Test
	public void testGetHCforProductsAsync() { 
		
		HealthCentreService healthCentreService = new HealthCentreServiceImpl();


		String product1 = "[\"RDC00205\",";
		String product2 = "\"RDC00206\"]";


		product1 = product1.concat(product2);


		SearchVO searchVO=new SearchVO();


		searchVO.setProductName(product1);
		searchVO.setLatitude("12.9719");
		searchVO.setLongitude("77.6412");

		searchVO.setDoorStepCollection("Y");
		searchVO.setNablCertified("N");
		searchVO.setCapCertified("N");
		searchVO.setIsoCertified("N");

		searchVO.setBrandList("N");
		searchVO.setCustomerRating(1);

		
		System.out.println("First Invoking NEO-4j API getHealthCenterNamesInARegionForAProduct. Caller Thread ID -> " + Thread.currentThread());

		DoctorDetailsCallbackTask healthCentreCallbackTask= new DoctorDetailsCallbackTask();
		
		try {
	           healthCentreService.getHealthCentersInARegionForAProduct(searchVO,healthCentreCallbackTask,"DEFAULT");
		}
		catch (Exception ex) {
		   System.out.println("Exception Received " + ex.getMessage());
		   System.out.println("Exception Received " + ex.getStackTrace());
		}
		
		logThreadId();								
	}

	@Test
	public void testGetHCforProductsAsyncWithOutCallback(){

		HealthCentreService healthCentreService = new HealthCentreServiceImpl();

		String product1 = "[\"RDC00205)\",";
		String product2 = "\"RDC00206\"]";

		product1= product1.concat(product2);


		SearchVO searchVO=new SearchVO();
		searchVO.setProductName(product1);
		searchVO.setLatitude("12.9719");
		searchVO.setLongitude("77.6412");

		searchVO.setDoorStepCollection("Y");
		searchVO.setNablCertified("N");
		searchVO.setCapCertified("N");
		searchVO.setIsoCertified("N");

		searchVO.setBrandList("[\"IHM\",\"THY\"]");

                System.out.println("Second Invoking NEO-4j API getHealthCemnterNamesInARegionForAProduct");
                
                CompletableFuture<Result> resultFutureObject = healthCentreService.getHealthCentersInARegionForAProduct(searchVO,"DEFAULT");
                if (resultFutureObject.isCompletedExceptionally() == true) {
                    System.out.println("Exception during execution of API getHealthCentersInARegionForAProduct ");
                }
        
                resultFutureObject.thenAccept(new Consumer<Result>() {
                    @Override
                    public void accept(Result healthCenterResult) {
                	Iterable<Map<String,Object>> healthCentersDetails = healthCenterResult.queryResults();
                	healthCentersDetails.forEach( (mapEntry) -> {        	            	   
                           DoctorInfo hcNode = (DoctorInfo) mapEntry.get(CommonConstants.HC_NODE);
                           System.out.println("HC Name -> " + hcNode.getName());                	
                           Double distance = (Double) mapEntry.get(CommonConstants.DISTANCE);
                           System.out.println("Distance -> " + distance);
						Product product = (Product) mapEntry.get(CommonConstants.PRODUCT);
                	   System.out.println("Price -> " + product.getPrice());
                	});        	
                    }
                });
        
                logThreadId();
	}

	@Test
	public void testGetHCforProductsAsyncWithOutCallbackAndLocality(){

		HealthCentreService healthCentreService = new HealthCentreServiceImpl();

		String product1 = "[\"H0805)\",";
		String product2 = "\"RDC00206\"]";

		product1= product1.concat(product2);


		SearchVO searchVO=new SearchVO();
		searchVO.setProductName(product1);
		searchVO.setLatitude("12.9719");
		searchVO.setLongitude("77.6412");

		searchVO.setDoorStepCollection("Y");
		searchVO.setNablCertified("N");
		searchVO.setCapCertified("N");
		searchVO.setIsoCertified("N");

		searchVO.setBrandList("[\"IHM\",\"THY\"]");
		searchVO.setLocality("[\"Harlur\",\"Jayanagar\"]");

		System.out.println("Inside testGetHCforProductsAsyncWithOutCallbackAndLocality");

		CompletableFuture<Result> resultFutureObject = healthCentreService.getHealthCentersInARegionForAProduct(searchVO,"DEFAULT");
		if (resultFutureObject.isCompletedExceptionally() == true) {
			System.out.println("Exception during execution of API getHealthCentersInARegionForAProduct ");
		}

		resultFutureObject.thenAccept(new Consumer<Result>() {
			@Override
			public void accept(Result healthCenterResult) {
				Iterable<Map<String,Object>> healthCentersDetails = healthCenterResult.queryResults();
				healthCentersDetails.forEach( (mapEntry) -> {
					DoctorInfo hcNode = (DoctorInfo) mapEntry.get(CommonConstants.HC_NODE);
					System.out.println("HC Name -> " + hcNode.getName());
					Double distance = (Double) mapEntry.get(CommonConstants.DISTANCE);
					System.out.println("Distance -> " + distance);
					Product product = (Product) mapEntry.get(CommonConstants.PRODUCT);
					System.out.println("Price -> " + product.getPrice());
				});
			}
		});

		logThreadId();
	}





	
	@Test
	public void testGetHCforProductsSync() { 
		DoctorInfo healthCentre = null;
		HealthCentreService healthCentreService = new HealthCentreServiceImpl();
		List<String> healthCentreNames = null;


		String product1 = "[\"RDC00205\",";
		String product2 = "\"RDC00206\"]";

		product1= product1.concat(product2);

		SearchVO searchVO=new SearchVO();
		searchVO.setProductName(product1);
		searchVO.setLatitude("12.9719");
		searchVO.setLongitude("77.6412");
		searchVO.setRadius(10);
		searchVO.setPagaNumber(1);
		searchVO.setNumberOfRecords(10);


		searchVO.setDoorStepCollection("Y");
		searchVO.setNablCertified("N");
		searchVO.setCapCertified("N");
		searchVO.setIsoCertified("N");

		searchVO.setBrandList("[\"IHM\",\"THY\"]");

		System.out.println("Second Invoking NEO-4j API getHealthCenterNamesInARegionForAProduct. Caller Thread ID -> " + Thread.currentThread());
		
		Result healthCenterResult = null;
		try {
		   healthCenterResult = healthCentreService.getHealthCentersInARegionForAProductRunSync(searchVO,"DEFAULT");
		}
		catch (Exception ex) {
			System.out.println("Exception Received " + ex.getMessage());
			System.out.println("Exception Received " + ex.getStackTrace());
		}
		
		Iterable<Map<String,Object>> healthCentersDetails = healthCenterResult.queryResults();
		healthCentersDetails.forEach( (mapEntry) -> {        	            	   
                   DoctorInfo hcNode = (DoctorInfo) mapEntry.get(CommonConstants.HC_NODE);
                   System.out.println("HC Name -> " + hcNode.getName());                	
                   Double distance = (Double) mapEntry.get(CommonConstants.DISTANCE);
                   System.out.println("Distance -> " + distance);
			Product product = (Product) mapEntry.get(CommonConstants.PRODUCT);
			System.out.println("Price -> " + product.getPrice());
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