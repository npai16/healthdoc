import com.ihm.customer.neo4j.service.HealthCentreService;
import com.ihm.customer.neo4j.service.HealthCentreServiceImpl;
import com.ihm.customer.neo4j.session.Neo4jSessionFactory;
import com.ihm.customer.nodes.entities.HealthCentre;
import org.junit.Test;
import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class TestHealthCenterOperations {

	@Test
	public void test() {
		
		Neo4jSessionFactory neo4jSessionFactory = Neo4jSessionFactory.getInstance();
		
		try {
		    Session session = neo4jSessionFactory.getNeo4jSession();		
		    DoctorInfo apolloHealthCentre = new DoctorInfo();
		    apolloHealthCentre.setName("Apollo HC 123");
		    session.save(apolloHealthCentre);
		}
		catch (Exception ex) {
			System.out.println("Exception duing processing -> " + ex.getStackTrace());
		}
	    
	    System.out.println("Done ");
	}

	@Test
	public void testsellerinfo(){

		HealthCentreService healthCentreService = new HealthCentreServiceImpl();

		CompletableFuture<Result> resultFutureObject = healthCentreService.getHealthCenterById("140");
		if (resultFutureObject.isCompletedExceptionally() == true) {
			System.out.println("Exception during execution of API getHealthCentersInARegionForAProduct ");
		}

		resultFutureObject.thenAccept(new Consumer<Result>() {
			@Override
			public void accept(Result healthCenterResult) {
				Iterable<Map<String,Object>> healthCentersDetails = healthCenterResult.queryResults();
				healthCentersDetails.forEach( (mapEntry) -> {
					DoctorInfo hcNode = (DoctorInfo) mapEntry.get("hc");
					System.out.println("HC Name -> " + hcNode.getName());

					List<String> products = (List<String>) mapEntry.get("products");
					System.out.println("HC Name -> " + products);
				});
			}
		});

		logThreadId();


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
