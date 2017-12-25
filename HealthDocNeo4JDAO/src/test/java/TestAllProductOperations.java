import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ihm.customer.neo4j.service.GenericService;
import com.ihm.customer.neo4j.service.HealthCentreServiceImpl;
import com.ihm.customer.nodes.entities.HealthCentre;
import com.ihm.customer.nodes.entities.Product;

public class TestAllProductOperations {

    /*
	@Test
	public void testCreateAsync() { 
		GenericService<Product> healthCentreService = new HealthCentreServiceImpl();
		
		// Create Test data
		createHealthCentres(healthCentreService);
				
		// HealthCentre healthCentre = null;
		List<HealthCentre> healthCentre1 = null;
		try {
			healthCentre1 = (List<HealthCentre>) healthCentreService.findHCByName("ApolloHC Bangalore");	
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
