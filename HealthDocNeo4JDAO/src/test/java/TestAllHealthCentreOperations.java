import com.ihm.customer.neo4j.callbacks.HealthCentreCallbackTask;
import com.ihm.customer.neo4j.service.GenericService;
import com.ihm.customer.neo4j.service.HealthCentreServiceImpl;
import com.ihm.customer.nodes.entities.HealthCentre;
import org.junit.Test;

import java.util.List;

public class TestAllHealthCentreOperations {

    	@Test
	public void testfindHCAsync() { 
		GenericService<DoctorInfo> healthCentreService = new HealthCentreServiceImpl();
		
		// Create Test data
		// ===createHealthCentres(healthCentreService);
						
		List<DoctorInfo> healthCentre = null;
		DoctorDetailsCallbackTask healthCentreCallbackTask= new DoctorDetailsCallbackTask();
		
		try {
			// healthCentre1 = (List<HealthCentre>) healthCentreService.findNodeByName("ApolloHC Bangalore");	
			// System.out.println("Received Value " + healthCentre1.toString());
		    healthCentreService.findNodeByName("Bioterra Diagnostic Centre Indiranagar", healthCentreCallbackTask);
		    logThreadId();
		}
		catch (Exception ex) {
			System.out.println("Exception Received " + ex.getStackTrace().toString());
			System.out.println("Exception Received " + ex.getMessage());
			// System.out.println(ex.printStackTrace());
		}
		
		// System.out.println("HC City -> " + healthCentre.get(0).getCity());
		// System.out.println("HC Image URL -> " + healthCentre.get(0).getImage_url());
		
		// healthCentre1.forEach(healthCentre -> System.out.println(healthCentre));
	    
		 System.out.println("Control returned ");
	}
    
    	
    	public void logThreadId() {
	    System.out.println("Invocation complete. Main ThreadID -> " + Thread.currentThread());
	    
	    
	    try {
		Thread.sleep(5000);
	    } catch (InterruptedException e) {			
		e.printStackTrace();
	    }
	    
	}
    
    	/*
	@Test
	public void testCreate() { 
		GenericService<HealthCentre> healthCentreService = new HealthCentreServiceImpl();
		
		// Create Test data
		createHealthCentres(healthCentreService);
				
		// HealthCentre healthCentre = null;
		List<HealthCentre> healthCentre1 = null;
		try {
			healthCentre1 = (List<HealthCentre>) healthCentreService.findHCByNameSync("ApolloHC Bangalore");	
			// System.out.println("Received Value " + healthCentre1.toString());
		}
		catch (Exception ex) {
			System.out.println("Exception Received " + ex.getStackTrace().toString());
			System.out.println("Exception Received " + ex.getMessage());
			// System.out.println(ex.printStackTrace());
		}
		
		healthCentre1.forEach(healthCentre -> System.out.println(healthCentre.getName()));
	
	    
	  }
	  */
	
	private void createHealthCentres(GenericService<DoctorInfo> healthCentreService) {
		
		// Create test data
		DoctorInfo apolloHealthCentre = new DoctorInfo();
		apolloHealthCentre.setName("ApolloHC Bangalore");		
		healthCentreService.create(apolloHealthCentre);
		
		DoctorInfo rxdxHealthCentre = new DoctorInfo();
		rxdxHealthCentre.setName("RXDX Bangalore");
		healthCentreService.create(rxdxHealthCentre);
	}
	
	private void cleanUp(GenericService<DoctorInfo> healthCentreService) {
		healthCentreService.deleteAll();
	}
}