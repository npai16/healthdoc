import com.ihm.customer.neo4j.service.HealthCentreService;
import com.ihm.customer.neo4j.service.HealthCentreServiceImpl;
import com.ihm.customer.neo4j.valueObjects.SearchVO;
import com.ihm.healthdoc.neo4j.constants.CommonConstants;

import org.junit.Test;
import org.neo4j.ogm.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * Created by prasad on 12/7/2016.
 */
public class TestZHCProductsCounts {

    private static final Logger logger = LoggerFactory.getLogger(TestZHCProductsCounts.class);

    @Test
    public void testGetHealthCenterByCity(){

        HealthCentreService healthCentreService = new HealthCentreServiceImpl();

        String city = "amravati";

        CompletableFuture<Result> resultFutureObject = healthCentreService.getHealthCenterByCity(city,"PATHOLOGY","SLR");

        logThreadId();

        resultFutureObject.thenAccept(new Consumer<Result>() {
            @Override
            public void accept(Result healthCenterResult) {
                Iterable<Map<String,Object>> healthCentersDetails = healthCenterResult.queryResults();
                healthCentersDetails.forEach( (mapEntry) -> {


                    String seller_id = (String) mapEntry.get("seller_id");
                    System.out.println("seller_id" + seller_id);

                    String seller_name = (String) mapEntry.get("seller_name");
                    System.out.println("seller_name"+"---"+seller_name);
                });
            }
        });

    }

    @Test
    public void testGetHealthCenterByCityCategoryType(){

        HealthCentreService healthCentreService = new HealthCentreServiceImpl();

        String city = "amravati";

        CompletableFuture<Result> resultFutureObject = healthCentreService.getHealthCenterByCity(city,"PATHOLOGY","PROD");

        logThreadId();

        resultFutureObject.thenAccept(new Consumer<Result>() {
            @Override
            public void accept(Result healthCenterResult) {
                Iterable<Map<String,Object>> healthCentersDetails = healthCenterResult.queryResults();
                healthCentersDetails.forEach( (mapEntry) -> {


                    String seller_id = (String) mapEntry.get("seller_id");
                    System.out.println("seller_id" + seller_id);

                    String seller_name = (String) mapEntry.get("seller_name");
                    System.out.println("seller_name"+"---"+seller_name);
                });
            }
        });

    }


    @Test
    public void testGetHCforProductsAsyncWithOutCallbackLocalityCount(){

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

        searchVO.setCustomerRating(1);

        logger.info("Getting Search Product Counts Locality Wise");

        CompletableFuture<Result> resultFutureObject = healthCentreService.getHealthCentersInARegionForAProduct(searchVO, CommonConstants.SEARCH_CNT_AGGR_BY_LOCALITY);
        if (resultFutureObject.isCompletedExceptionally() == true) {

            logger.info("Exception during Getting Search Product Counts Locality Wise ");

        }

        logThreadId();

        resultFutureObject.thenAccept(new Consumer<Result>() {
            @Override
            public void accept(Result healthCenterResult) {
                Iterable<Map<String,Object>> healthCentersDetails = healthCenterResult.queryResults();
                healthCentersDetails.forEach( (mapEntry) -> {


                    String kount = (String) mapEntry.get("kount");
                    System.out.println("Kount" + kount);

                    String locality = (String) mapEntry.get("locality");
                    System.out.println("Kount"+"---"+kount+"locality"+"---"+locality);
                });
            }
        });


    }





    public void logThreadId() {

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Invocation complete. Main ThreadID -> " + Thread.currentThread());

    }

}
